/**
 * Created by linjunjie(490456661@qq.com) on 2020/8/25.
 */
//api
;(function($){
    //API的url
    var service_url = {
        "getStudentList_url" : "/platform/getStudentList"
    };
    //API
    var API = {
        POST : "POST",
        getStudentList : function(params){
            var data = ajaxMethod(service_url.getStudentList_url,params,this.POST);
            if(data == false){
                alert("连接服务器失败");
            }else{
                if(data && data.data){
                    if(data.result != "100"){
                        alert(data.message);
                    }
                    return data;
                }else{
                    alert("服务异常");
                }
            }
        }

    };
    //ajax的封装请求
    var ajaxMethod = function(url,params,method){
        var data;
        $.ajax({
            method:method,
            dataType:'json',
            data:params,
            url:url,
            async:false,
            success:function(result){
                data = result;
            },
            error:function(){
                data = false;
            }
        });
        return data;
    }

    window.API = API;

})(jQuery)