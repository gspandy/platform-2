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
                        '<td class="right"><span style="color:red">'+list[i].train+'</span></td>'+
                        '<td class="right">'+
                        '        <div data-role="group" data-group-type="one-state">'+
                        '        <button class="button"><span class="mif-file-text mif-1x"></span></button>'+
                        '<button class="button"><span class="mif-bin mif-1x"></span></button>'+
                        '<button class="button"><span class="mif-tags mif-1x"></span></button>'+
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

        }
    }
    $(function(){
        //装配调度器
        preExecuteAny.init(studentInfoFunc);
        //开始执行
        preExecuteAny._init();
    })





</script>
<!-- 内容修改处 -->
<div class="row cells8">
    <div class="oriflamme">
        <span class="mif-file-text"></span> 信息查询
        <div class="right-button-group" >

            <button class="button success small-button"><span class="mif-profile mif-lg"></span> 添加</button>
            <button class="button warning small-button"><span class="mif-download2 mif-lg"></span> 导出</button>

        </div>

    </div>
    <div class="backstage_container">
        <div class="row cells8">
            <div class="fields">
                姓名 :
                <div class="input-control text ">
                    <input type="text" placeholder="姓名">
                </div>
            </div>
            <div class="fields">
                身份证号 :
                <div class="input-control text ">
                    <input type="text" placeholder="身份证号">
                </div>
            </div>

            <div class="fields">
                手机 :
                <div class="input-control text ">
                    <input type="text" placeholder="手机">
                </div>
            </div>
        </div>
        <div class="row cells8">
            <div class="fields">
                状态 :
                <div class="input-control select">
                    <select>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row cells8">
            <button class="button primary small-button" onclick="pushMessage('info')"><span class="mif-search"></span> 搜索</button>
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
                        <button class="button"><span class="mif-file-text mif-1x"></span></button>
                        <button class="button"><span class="mif-bin mif-1x"></span></button>
                        <button class="button"><span class="mif-tags mif-1x"></span></button>
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
                                <option value="15">15</option>
                                <option value="20">20</option>
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
