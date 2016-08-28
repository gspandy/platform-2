<%@page language="java" pageEncoding="utf-8" %>
<script>
    var studentInfoFunc = {

        init : function(){
            this.getList();
        },
        getList : function(){
            //构建参数
            var dataForm = {
                "pageNo" : pagitation.pageNo,
                "pageSize" : pagitation.pageSize

            }
            //姓名搜索
            if($("#realName").val().trim() != ""){
                dataForm.realName = $("#realName").val().trim();
            }
            //学号搜索
            if($("#studyNo").val().trim() != ""){
                dataForm.studyNo = $("#studyNo").val().trim();
            }
            //标记状态搜索
            if($("#train").val() != -1){
                dataForm.train = $("#train").val();
            }
            //调用服务
            var data = API.getStudentList(dataForm);

            //装载数据
            this.loadForm(data);
        },
        loadForm : function(data){
            //集合
            var list = data.data.studentList;
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
                        '<td>'+list[i].studyNo+'</td><td class="right">'+list[i].realName+'</td><td class="right">'+list[i].age+
                        '</td><td class="right">'+list[i].sex+'</td><td class="right">'+list[i].address+'</td>'+
                        '<td class="right">'+list[i].phone+'</td>'+
                        '<td class="right">'+list[i].train+'</td>'+
                        '<td class="right">'+
                        '        <div data-role="group" data-group-type="one-state">'+
                        '        <button class="button" editno="'+ list[i].id+'"><span data-role="hint" data-hint="修改" data-hint-position="top" data-hint-timeout="2000"><span class="mif-tools mif-1x"></span></span></button>'+
                        ' <button class="button" removeno="'+list[i].id+'"><span data-role="hint" data-hint="删除" data-hint-position="top" data-hint-timeout="2000"><span class="mif-bin mif-1x"></span></span></button>'+
                        ' <button class="button" tagno="'+list[i].id+'"><span data-role="hint" data-hint="标记训练" data-hint-position="top" data-hint-timeout="2000"><span class="mif-tags mif-1x"></span></span></button>' +
                        ' <button class="button" logno="'+list[i].studyNo+'"><span data-role="hint" data-hint="添加日志" data-hint-position="top" data-hint-timeout="2000"><span class="mif-pencil mif-1x"></span></span></button>'+
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
                             location.href = location.href + "#" + "studentForm.jsp?id="
                             + $(this).attr("editno");
                             window.redirect();//跳转到链接
                         }else{
                             location.href = location.href.substring(0,location.href.indexOf("#")) + "#" + "studentForm.jsp?id="
                                     + $(this).attr("editno");
                             window.redirect();//跳转到链接
                         }
                    });
                }
                if ($(this).attr("tagno")/*标记事件*/) {
                    $(this).click(function(){
                        studentInfoFunc.tagStudent($(this).attr("tagno"));
                    });
                }
                if ($(this).attr("logno")/*日志事件*/) {
                    $(this).click(function(){

                        if (location.href.indexOf("#") == -1) {
                            location.href = location.href + "#" + "studentDayLogForm.jsp?studyNo="
                                    + $(this).attr("logno");
                            window.redirect();//跳转到链接
                        }else{
                            location.href = location.href.substring(0,location.href.indexOf("#")) + "#" + "studentDayLogForm.jsp?studyNo="
                                    + $(this).attr("logno");
                            window.redirect();//跳转到链接
                        }
                    });
                }
                if ($(this).attr("removeno")/*删除事件*/) {
                    $(this).click(function(){
                        studentInfoFunc.remove($(this).attr("removeno"));
                    });
                }
            });


        },
        tagStudent : function(id){
            var dataForm = {
                "id" : id
            };
            var data = API.tagStudent(dataForm);
            if(data && data.result == "100"){
                redirect();
            }
        },
        remove : function(id){
            var dataForm = {
                "id" : id
            }
            var data = API.removeStudent(dataForm);
            if(data && data.result == "100"){
                redirect();
            }
        }
    }
    $(function(){
        //装配调度器
        preExecuteAny.init(studentInfoFunc);
        //装配分页器
        pagitationFunc.pagitation = pagitation;
        //开始执行
        preExecuteAny._init();
    })

    //其他事件
    $(function(){
//      //添加学生信息
        $("#addInfo").click(function(){
            $("#context_main").load("studentForm.jsp");
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
                姓名 :
                <div class="input-control text ">
                    <input type="text" id="realName" placeholder="姓名">
                </div>
            </div>
            <div class="fields">
                学号 :
                <div class="input-control text ">
                    <input type="text" id="studyNo" placeholder="学号">
                </div>
            </div>
            <div class="fields">
                状态 :
                <div class="input-control select">
                    <select id="train">
                        <option selected value="-1">全部</option>
                        <option value="1">标记</option>
                        <option value="0">未标记</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="row cells8">
            <button id="searchInfo" class="button primary small-button" ><span class="mif-search"></span> 搜索</button>
        </div>

    </div>
</div>
<div class="row cells8" style="margin-top:20px;">

    <div class="cell colspan8" style=" overflow-x: scroll;">

        <table class="hovered animal">
            <thead>
            <tr>
                <th></th>
                <th>学生编号</th>
                <th class="right">学生姓名</th>
                <th class="right">年龄</th>
                <th class="right">性别</th>
                <th class="right">家庭住址</th>
                <th class="right">联系电话</th>
                <th class="right">标记</th>
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
                <td>Bing</td><td class="right">0:00:01</td><td class="right">0,1 Mb</td><td class="right">0 Mb</td><td class="right">0,1 Mb</td>
                <td class="right"></td>
                <td class="right"><span style="color:red">已标记</span></td>
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
