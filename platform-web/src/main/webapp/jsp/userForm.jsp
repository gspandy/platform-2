<%@page language="java" pageEncoding="utf-8" %>
<script>
    /*验证输入框,表单提交等*/
    function no_submit(){
        userFormFunc.saveInstitution();
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
    var userFormFunc = {
        dataForm : {
            "id" : 0
        },
        saveInstitution : function(){
            var dataForm = {
                "id" : $("#id").val(),
                "institution" : $("#institution").val(),    //机构名
                "preNo" : $("#preNo").val(),                //前缀标识
                "username" : $("#username").val(),          //用户名
                "password" : $("#password").val(),          //密码
                "phone" : $("#phone").val(),                //电话
                "owner" : $("#owner").val()                 //联系人
            };
            var data = API.saveInstitution(dataForm);
            if(data && data.result == "100"){
                alert("添加/保存成功!");
            }
        },
        getInstitution : function(){
            if(this.dataForm.id === 0){
                return;
            }
            var data = API.getInstitution(this.dataForm);
            if(data && data.result == "100"){
                var info = data.data;
                $("#id").val(info.id);
                $("#institution").val(info.institution);    //机构名称
                $("#preNo").val(info.preNo);                //前缀标识
                $("#username").val(info.username);         //用户名
                //密码不需要显示出来
                $("#phone").val(info.phone);                //手机号
                $("#owner").val(info.owner);            //联系人


            }

        }

    }

    $(function(){
       //返回按钮
        $("#back").click(function(){
            jumpToModule("userList.jsp");
       });
        //处理链接
        var url = "";
        if(location.href.lastIndexOf("?") != -1) {
            url = location.href.substring(location.href.lastIndexOf("?") + 1);
            var id = getTargetUrlParameter(url,"id");
            userFormFunc.dataForm.id = id;
            userFormFunc.getInstitution();
            $("#username").attr("disabled","disabled");
        }


    });

</script>
<input type="hidden" id="id" value="0"/>
<div class="row cells8">
    <div class="oriflamme">
        <span class="mif-file-text"></span> 添加/保存用户
    </div>
    <div class="backstage_container">

        <div class="grid">
            <form id="studentForm" method="POST" data-role="validator" data-on-submit="no_submit" <%--data-on-before-submit="no_submit" --%>data-hint-mode="hint" data-hint-easing="easeOutBounce" novalidate="novalidate" >

                <div class="row cells8">

                    <div class="cell offset3 colspan4">

                        <label>机构名称 :</label>
                        <div class="input-control text required">
                            <input type="text" id="institution" name="institution" placeholder="例如:华天幼儿园" data-validate-func="required"
                                   data-validate-hint="输入机构名称!"
                                   data-validate-hint-position="right">

                            <span class="input-state-error mif-warning"></span>
                            <span class="input-state-success mif-checkmark"></span>
                        </div>

                    </div>
                </div>
                <div class="row cells8">

                    <div class="cell offset3 colspan4">

                        <label>前缀标识 :</label>
                        <div class="input-control text required">
                            <input type="text" id="preNo" name="preNo" placeholder="例如:170" data-validate-func="required"
                                   data-validate-hint="输入前缀标识!"
                                   data-validate-hint-position="right">

                            <span class="input-state-error mif-warning"></span>
                            <span class="input-state-success mif-checkmark"></span>
                        </div>

                    </div>
                </div>
                <div class="row cells8">

                    <div class="cell offset3 colspan4">

                        <label>用&nbsp;户&nbsp;名 :</label>
                        <div class="input-control text required">
                            <input type="text" id="username" name="username" data-validate-func="required"
                                   data-validate-hint="输入登陆用户名!"
                                   data-validate-hint-position="right">

                            <span class="input-state-error mif-warning"></span>
                            <span class="input-state-success mif-checkmark"></span>
                        </div>
                    </div>
                </div>
                <div class="row cells8">

                    <div class="cell offset3 colspan4">

                        <label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 :</label>
                        <div class="input-control text required">
                            <input type="text" id="password" name="password"
                                   data-validate-hint="输入密码!"
                                   data-validate-hint-position="right">

                            <span class="input-state-error mif-warning"></span>
                            <span class="input-state-success mif-checkmark"></span>
                        </div>
                    </div>
                </div>
                <div class="row cells8">

                    <div class="cell offset3 colspan4">

                        <label>联&nbsp;系&nbsp;人 :</label>
                        <div class="input-control text required">
                            <input type="text" id="owner" name="owner" placeholder="" data-validate-func="required"
                                   data-validate-hint="输入联系人!"
                                   data-validate-hint-position="right">

                            <span class="input-state-error mif-warning"></span>
                            <span class="input-state-success mif-checkmark"></span>
                        </div>
                    </div>
                </div>
                <div class="row cells8">

                    <div class="cell offset3 colspan4">

                        <label>联系手机 :</label>
                        <div class="input-control text required">
                            <input type="text" id="phone" name="phone" placeholder="例如:1xxxxxxx(11位)" data-validate-func="pattern"
                                   data-validate-arg="^1\d{10}$"
                                   data-validate-hint="输入11位手机号码!"
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