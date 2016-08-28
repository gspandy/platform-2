<%@page language="java" pageEncoding="utf-8" %>
<script>
    var institutionFunc = {

        init : function(){
            this.getList();
        },
        getList : function(){
            //构建参数
            var dataForm = {
                "pageNo" : pagitation.pageNo,
                "pageSize" : pagitation.pageSize
            }
            //机构搜索
            if($("#institution").val().trim() != ""){
                dataForm.institution = $("#institution").val().trim();
            }
            //用户名搜索
            if($("#username").val().trim() != ""){
                dataForm.username = $("#username").val().trim();
            }
            //状态搜索
            if($("#status").val() != -1){
                dataForm.status = $("#status").val();
            }
            //调用服务
            var data = API.getInstitutionList(dataForm);

            //装载数据
            this.loadForm(data);
        },
        loadForm : function(data){
            //集合
            var list = data.data.institutionList;
            //总记录数
            pagitation.total = data.data.total;
            //总页数
            pagitation.maxPage = Math.ceil(pagitation.total / pagitation.pageSize);

            var i = 0 , html = "";
            for(;list!=null && i<list.length;i++){
                html += '<tr>'+
                        '        <td>'+
                        '        <label class="input-control checkbox  small-check">'+
                        '        <input type="checkbox" name="c4" value="1">'+
                        '        <span class="check"></span>'+
                        '</label>'+
                        '</td>'+
                        '<td>'+list[i].institution+'</td><td class="right">'+list[i].preNo+'</td><td class="right">'+list[i].username+
                        '</td><td class="right">'+list[i].owner+'</td><td class="right">'+list[i].phone+'</td>'+
                        '<td class="right">'+list[i].created+'</td>'+
                        '<td class="right">'+(list[i].status)+'</td>'+
                        '<td class="right">'+
                        '        <div data-role="group" data-group-type="one-state">'+
                        '        <button class="button" editno="'+ list[i].id+'"><span data-role="hint" data-hint="修改" data-hint-position="top" data-hint-timeout="2000"><span class="mif-tools mif-1x"></span></span></button>'+
                        ' <button class="button" lockno="'+list[i].id+'" ><span data-role="hint" data-hint="锁定" data-hint-position="top" data-hint-timeout="2000"><span class="mif-lock mif-1x"></span></span></button>'+
                        '</div>'+
                        '</td>'+
                        '</tr>';
            }

            $(".animal tbody").html(html);
            //装载页码
            preExecuteAny.pagitationFunc._init();
            //设最大
            $("#pageInfo").html( pagitation.pageNo+"/"+pagitation.maxPage);
            //设置条数
            $("#total").html(pagitation.total);
            //关闭显示等待加载ing
            $("#wait_loading").hide();
            //编辑事件
            $("button").each(function() {

                if ($(this).attr("editno")/*点击编辑按钮*/) {
                    $(this).click(function () {
                         if (location.href.indexOf("#") == -1) {
                             location.href = location.href + "#" + "userForm.jsp?id="
                             + $(this).attr("editno");
                             window.redirect();//跳转到链接
                         }else{
                             location.href = location.href.substring(0,location.href.indexOf("#")) + "#" + "userForm.jsp?id="
                                     + $(this).attr("editno");
                             window.redirect();//跳转到链接
                         }
                    });
                }
                if ($(this).attr("lockno")/*点击开关(锁定)按钮*/) {
                    $(this).click(function () {
                        $(this).attr("lockno");
                        institutionFunc.switchInstitution($(this).attr("lockno"));
                    });
                }
            });


        },
        switchInstitution : function(id){
            var dataForm = {
                "id" : id
            };
            var data = API.switchInstitution(dataForm);
            if(data && data.result == "100"){
                redirect();
            }
        }
    }


    $(function(){
        //装配调度器
        preExecuteAny.init(institutionFunc);
        //装配分页器
        pagitationFunc.pagitation = pagitation;
        //开始执行
        preExecuteAny._init();
    })

    //其他事件
    $(function(){
        //添加学生信息
        $("#addInfo").click(function(){
            $("#context_main").load("userForm.jsp");
        });
        //搜索事件
        $("#searchInfo").click(function(){
            preExecuteAny._init();
        });



    })



</script>
<!-- 内容修改处 -->
<div class="row cells8">
    <div class="oriflamme">
        <span class="mif-file-text"></span> 信息查询
        <div class="right-button-group" >

            <button id="addInfo" class="button success small-button"><span class="mif-profile mif-lg"></span> 添加</button>
            <button class="button warning small-button"><span class="mif-download2 mif-lg"></span> 导出</button>

        </div>

    </div>
    <div class="backstage_container">
        <div class="row cells8">
            <div class="fields">
                机构名称 :
                <div class="input-control text ">
                    <input type="text" id="institution" placeholder="机构名称">
                </div>
            </div>
            <div class="fields">
                用户名 :
                <div class="input-control text ">
                    <input type="text" id="username" placeholder="用户名">
                </div>
            </div>
            <div class="fields">
                状态 :
                <div class="input-control select">
                    <select id="status">
                        <option selected value="-1">全部</option>
                        <option value="1">正常</option>
                        <option value="0">停用</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row cells8">
            <button id="searchInfo" class="button primary small-button"><span class="mif-search"></span> 搜索</button>
        </div>

    </div>
</div>
<div class="row cells8" style="margin-top:20px;">

    <div class="cell colspan8" style=" overflow-x: scroll;">

        <table class="hovered animal">
            <thead>
            <tr>
                <th></th>
                <th class="right">机构名称</th>
                <th class="right">前缀标识</th>
                <th>用户名</th>
                <th class="right">拥有人</th>
                <th class="right">电话</th>
                <th class="right">加入时间</th>
                <th class="right">状态</th>
                <th class="right">操作</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>
                    <label class="input-control checkbox  small-check">
                        <input type="checkbox" name="c4" value="1">
                        <span class="check"></span>
                    </label>

                </td>
                <td>Bing</td>
                <td class="right">0:00:01</td>
                <td class="right">0,1 Mb</td>
                <td class="right">0 Mb</td>
                <td class="right">0,1 Mb</td>
                <td class="right">0,1 Mb</td>
                <td class="right"></td>
                <td class="right">
                    <div data-role="group" data-group-type="one-state">
                        <button class="button" editno="1"><span class="mif-file-text mif-1x"></span></button>
                        <button class="button"><span class="mif-bin mif-1x"></span></button>
                        <button class="button"><span class="mif-tags mif-1x"></span></button>
                        <button class="button"><span class="mif-pencil mif-1x"></span></button>
                    </div>
                </td>
            </tr>

            </tbody>

            <tfoot></tfoot>
        </table>


    </div>
    <!-- pagination -->
    <div class="cell colspan8">
        <div class="oriflamme">
            <div class="flex-grid">
                <div class="left-button-group">
                    <div class="item" style="margin:0;">每页显示
                        <div class="input-control" data-template-result="fmtState" data-role="select">
                            <select>
                                <option value="10">10</option>
                            </select>
                        </div>
                        条 共<span id="total">14</span>条 当前页 <span id="pageInfo"> 1 </span>
                    </div>

                </div>
                <div class="row flex-just-end ">
                    <div class="pagination">
                        <span class="item" type="pre">上一页</span>

                        <span class="item">1</span>
                        <span class="item current">2</span>
                        <!-- <span class="item disabled">5</span>
                        <span class="item spaces">...</span>
                        <span class="item">7</span>
                        <span class="item">8</span> -->

                        <span class="item" type="next">下一页</span>
                    </div>
                </div>
            </div>
        </div>
    </div><!-- //pagination -->

</div>
