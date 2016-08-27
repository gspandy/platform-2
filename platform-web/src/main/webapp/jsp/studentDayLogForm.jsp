<%@page language="java" pageEncoding="utf-8" %>
<script>
    /*验证输入框,表单提交等*/
    function no_submit(){
        studentFormFunc.addStudent();
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
    var studentFormFunc = {
        dataForm : {
            "id" : 0
        },
        addStudent : function(){
            var dataForm = {
                "id" : $("#id").val(),
                "studyNo" : $("#studyNo").val(),    //学号
                "realName" : $("#realName").val(),  //真实名字
                "sex" : $("input[name = 'sex']:checked").val(),            //性别
                "birthday_" : $("#birthday_").val(),  //生日
                "phone" : $("#phone").val(),        //电话
                "address" : $("#address").val()     //地址
            };
            var data = API.saveStudent(dataForm);
            if(data && data.result == "100"){
                alert("添加/保存成功!");
            }
        },
        getStudent : function(){
            if(this.dataForm.id === 0){
                return;
            }
            var data = API.getStudent(this.dataForm);
            if(data && data.result == "100"){
                var info = data.data;
                $("#id").val(info.id);
                $("#studyNo").val(info.studyNo);    //学号
                $("#realName").val(info.realName); //真实名字
                $("input[name = 'sex']").each(function(){
                    if($(this).val() == info.sex){

                        $(this).attr("checked","checked");
                    }
                }); //性别
                $("#birthday_").val(info.birthday_);  //生日
                $("#phone").val(info.phone);        //电话
                $("#address").val(info.address);     //地址


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
            var id = getTargetUrlParameter(url,"id");
            studentFormFunc.dataForm.id = id;
            studentFormFunc.getStudent();
        }


    });

</script>
<input type="hidden" id="id" value="0"/>
<div class="row cells8">
    <div class="oriflamme">
        <span class="mif-file-text"></span> 添加学生
    </div>
    <div class="backstage_container">

        <div class="grid">
            <form id="studentForm" data-role="validator" data-on-submit="no_submit" <%--data-on-before-submit="no_submit" --%>data-hint-mode="hint" data-hint-easing="easeOutBounce" novalidate="novalidate" >

                <div class="row cells8">

                    <div class="cell offset3 colspan4">

                        <label>孩子姓名 :</label>
                        <div class="input-control text required">
                            <input type="text" id="realName" name="realName" placeholder="例如:张三" data-validate-func="required"
                                   data-validate-hint="输入孩子姓名!"
                                   data-validate-hint-position="right">

                            <span class="input-state-error mif-warning"></span>
                            <span class="input-state-success mif-checkmark"></span>
                        </div>

                    </div>
                </div>
                <div class="row cells8">

                    <div class="cell offset3 colspan4">

                        <label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号 :</label>
                        <div class="input-control text required">
                            <input type="text" id="studyNo" name="studyNo" placeholder="例如:201203120216" data-validate-func="required"
                                   data-validate-hint="输入学号!"
                                   data-validate-hint-position="right">

                            <span class="input-state-error mif-warning"></span>
                            <span class="input-state-success mif-checkmark"></span>
                        </div>

                    </div>
                </div>
                <div class="row cells8">

                    <div class="cell offset3 colspan4">

                        <label>家庭住址 :</label>
                        <div class="input-control text required">
                            <input type="text" id="address" name="address" data-validate-func="required"
                                   data-validate-hint="输入家庭住址!"
                                   data-validate-hint-position="right">

                            <span class="input-state-error mif-warning"></span>
                            <span class="input-state-success mif-checkmark"></span>
                        </div>
                    </div>
                </div>
                <div class="row cells8">

                    <div class="cell offset3 colspan4">
                        生日年月 :
                        <div class="input-control text ">
                            <div class="input-control text" id="datepicker">
                                <input type="text" id="birthday_" name="birthday_" data-validate-func="required"
                                       data-validate-hint="选择出生日期!"
                                       data-validate-hint-position="right">
                                <button class="button"><span class="mif-calendar"></span></button>
                            </div>
                            <script>
                                $(function(){
                                    $("#datepicker").datepicker();
                                });
                            </script>

                        </div>
                    </div>
                </div>
                <div class="row cells8">

                    <div class="cell offset3 colspan4">

                        <label>联系电话 :</label>
                        <div class="input-control text required">
                            <input type="text" id="phone" name="phone" placeholder="例如:1xxxxxxx(11位)" data-validate-func="pattern"
                                   data-validate-arg="^1\d{10}$"
                                   data-validate-hint="输入格式正确的联系电话!"
                                   data-validate-hint-position="right">

                            <span class="input-state-error mif-warning"></span>
                            <span class="input-state-success mif-checkmark"></span>
                        </div>
                    </div>
                </div>
                <div class="row cells8 br">

                    <div class="cell offset3 colspan4">
                        性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别 :
                        <label class="input-control radio small-check">
                            <input type="radio" name="sex" value="男" checked>
                            <span class="check"></span>
                        </label>
                        <span class="leaf">男</span>
                        <label class="input-control radio small-check">
                            <input type="radio" name="sex" value="女">
                            <span class="check"></span>
                        </label>
                        <span class="leaf">女</span>

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