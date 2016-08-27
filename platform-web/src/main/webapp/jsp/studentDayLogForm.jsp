<%@page language="java" pageEncoding="utf-8" %>
<script>
    /*验证输入框,表单提交等*/
    function no_submit(){
        studentDayLogFormFunc.saveStudentDayLog();
        return false;//不提交表单
    }

    function notifyOnErrorInput(input){
        var message = input.data('validateHint');
        $.Notify({
            caption: 'Error',
            content: message,
            type: 'alert'
        });
    }
    var studentDayLogFormFunc = {
        dataForm : {
            "studyNo" : 0,
            "pageNo": 1,
            "pageSize" : 10,
            "total" : 0,
            "maxPage" : 1
        },
        saveStudentDayLog : function(){
            var dataForm = {
                "id" : $("#id").val(),
                "studyNo" : studentDayLogFormFunc.dataForm.studyNo,
                "courseName" : $("#courseName").val(),  //表现情况
                "condition" : $("#condition").val(),    //孩子状况
                "remark" : $("#remark").val()  //老师备注
            };
            var data = API.saveStudentDayLog(dataForm);
            if(data && data.result == "100"){
                redirect();
                alert("保存日志成功!");
            }
        },
        remove : function(id){
            var dataForm = {

                "id" : id
            }
            var data = API.removeStudentDayLog(dataForm);
            if(data && data.result == "100"){
                redirect();
                alert("删除日志成功!");
            }
        },
        getList : function(){
            if(this.dataForm.studyNo === 0){ //说明没有查任何学生的日志
                return;
            }
            var data = API.getStudentDayLogList(this.dataForm);
            if(data && data.result == "100"){
                //集合
                var list = data.data.studentDayLogList;

                //总记录数
                this.dataForm.total = data.data.total;
                //总页数
                this.dataForm.maxPage = Math.ceil(this.dataForm.total / this.dataForm.pageSize);

                var i = 0 , html = "";
                for(;list!=null && i<list.length;i++){
                    html += '<tr>'+
                            '        <td>'+
                            '        <label class="input-control checkbox  small-check">'+
                            '        <input type="checkbox" name="c4" value="1">'+
                            '        <span class="check"></span>'+
                            '</label>'+
                            '</td>'+
                            '<td>'+list[i].created+'</td><td class="right">'+list[i].realName+'</td><td class="right">'+list[i].courseName+
                            '</td><td class="right">'+list[i].condition+'</td><td class="right">'+list[i].remark+'</td>'+
                            '<td class="right">'+
                            '        <div data-role="group" data-group-type="one-state">'+
                            '        <button class="button" removeno="'+ list[i].id+'"><span class="mif-bin mif-1x"></span></button>'+
                            '</div>'+
                            '</td>'+
                            '</tr>';
                }

                $(".animal tbody").html(html);
                //装载页码
                preExecuteAny.pagitationFunc._init();
                //设最大
                $("#pageInfo").html( this.dataForm.pageNo+"/"+this.dataForm.maxPage);
                //设置条数
                $("#total").html(this.dataForm.total);
                //关闭显示等待加载ing
                $("#wait_loading").hide();
                //事件
                //编辑事件
                $("button").each(function() {

                    if ($(this).attr("removeno")/*点击删除按钮*/) {
                        $(this).click(function () {
                            //删除
                            studentDayLogFormFunc.remove($(this).attr("removeno"));
                        });
                    }
                });



            }

        }

    }


    $(function(){
       //返回按钮
        $("#back").click(function(){
            jumpToModule("studentList.jsp");
       });
        //处理链接
        var url = "";
        if(location.href.lastIndexOf("?") != -1) {
            url = location.href.substring(location.href.lastIndexOf("?") + 1);
            var studyNo = getTargetUrlParameter(url,"studyNo");
            studentDayLogFormFunc.dataForm.studyNo = studyNo;
        }


        //装配调度器
        preExecuteAny.init(studentDayLogFormFunc);
        //装配分页器
        pagitationFunc.pagitation = studentDayLogFormFunc.dataForm;
        //执行
        preExecuteAny._getList();

    });

</script>
<input type="hidden" id="id" value="0"/>
<div class="row cells8">
    <div class="oriflamme">
        <span class="mif-file-text"></span> 学生日志
    </div>
    <div class="backstage_container">

        <div class="grid">
            <form id="studentForm" data-role="validator" data-on-submit="no_submit" <%--data-on-before-submit="no_submit" --%>data-hint-mode="hint" data-hint-easing="easeOutBounce" novalidate="novalidate" >

                <div class="row cells8">

                    <div class="cell offset3 colspan4">

                        <label>表现情况 :</label>
                        <div class="input-control text required">
                            <input type="text" id="courseName" name="courseName" placeholder="" data-validate-func="required"
                                   data-validate-hint="输入表现情况!"
                                   data-validate-hint-position="right">

                            <span class="input-state-error mif-warning"></span>
                            <span class="input-state-success mif-checkmark"></span>
                        </div>

                    </div>
                </div>
                <div class="row cells8">

                    <div class="cell offset3 colspan4">

                        <label>孩子状况 :</label>
                        <div class="input-control text required">
                            <input type="text" id="condition" name="condition" placeholder="" data-validate-func="required"
                                   data-validate-hint="输入孩子状况!"
                                   data-validate-hint-position="right">

                            <span class="input-state-error mif-warning"></span>
                            <span class="input-state-success mif-checkmark"></span>
                        </div>

                    </div>
                </div>
                <div class="row cells8">

                    <div class="cell offset3 colspan4">

                        <label>老师备注 :</label>
                        <div class="input-control text required">
                            <input type="text" id="remark" name="remark" data-validate-func="required"
                                   data-validate-hint="输入备注信息!"
                                   data-validate-hint-position="right">

                            <span class="input-state-error mif-warning"></span>
                            <span class="input-state-success mif-checkmark"></span>
                        </div>
                    </div>
                </div>
                <div class="row cells8 br">


                    <div class="align-center">

                            <button class="button info"><span class="mif-checkmark"></span>保存</button>
                            <input id="back" type="button" class="button warning" value="返回" >
                    </div>
                </div>


            </form>
        </div><!-- //grid -->
    </div>

</div>

<!-- 内容修改处 -->
<div class="row cells8" style="margin-top:20px;">

    <div class="cell colspan8" style=" overflow-x: scroll;">

        <table class="hovered animal">
            <thead>
            <tr>
                <th></th>
                <th>日期</th>
                <th class="right">学生姓名</th>
                <th class="right">表现情况</th>
                <th class="right">孩子状况</th>
                <th class="right">老师备注</th>
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
                <td>date</td>
                <td class="right">realName</td>
                <td class="right">courseName</td>
                <td class="right">condition</td>
                <td class="right">remark</td>
                <td class="right">
                    <div data-role="group" data-group-type="one-state">
                        <button class="button" editno="1"><span class="mif-file-text mif-1x"></span></button>
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