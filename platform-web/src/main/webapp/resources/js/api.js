/**
 * Created by linjunjie(490456661@qq.com) on 2020/8/25.
 */
//api
;(function($){
    //API的url
    var service_url = {
        "getStudentList_url" : "/platform/getStudentList",
        "saveStudent_url" : "/platform/saveStudent",
        "getStudent_url" : "/platform/getStudent",
        "tagStudent_url" : "/platform/tagStudent",
        "getStudentDayLogList_url" : "/platform/getStudentDayLogList",
        "saveStudentDayLog_url" : "/platform/saveStudentDayLog",
        "removeStudentDayLog_url" : "/platform/removeStudentDayLog",
        "getInstitutionList_url" : "/platform/admin/getInstitutionList",
        "saveInstitution_url" : "/platform/admin/saveInstitution",
        "switchInstitution_url" : "/platform/admin/switchInstitution",
        "getInstitution_url" : "/platform/admin/getInstitution"
    };
    //API
    var API = {
        POST : "POST",
        getStudentList : function(params){
            var data = ajaxMethod(service_url.getStudentList_url,params,this.POST);
            if(data == false){
                alert("连接服务器失败");
            }else{
                if(data && data.result == "100"){

                    return data;
                }else{
                    alert(data.message);
                }
            }
        },
        saveStudent : function(params){
            var data = ajaxMethod(service_url.saveStudent_url,params,this.POST);
            if(data == false){
                alert("连接服务器失败");
            }else{
                if(data && data.result == "100"){

                    return data;
                }else{
                    alert(data.message);
                }
            }
        },
        getStudent : function(params){
            var data = ajaxMethod(service_url.getStudent_url,params,this.POST);
            if(data == false){
                alert("连接服务器失败");
            }else{
                if(data && data.result == "100"){
                    return data;
                }else{
                    alert(data.message);
                }
            }
        },
        tagStudent : function(params){
            //和保存学生一个url
            var data = ajaxMethod(service_url.tagStudent_url,params,this.POST);
            if(data == false){
                alert("连接服务器失败");
            }else{
                if(data && data.result == "100"){
                    return data;
                }else{
                    alert(data.message);
                }
            }
        },
        getStudentDayLogList : function(params){
            var data = ajaxMethod(service_url.getStudentDayLogList_url,params,this.POST);
            if(data == false){
                alert("连接服务器失败");
            }else{
                if(data && data.result == "100"){
                    return data;
                }else{
                    alert(data.message);
                }
            }
        },
        saveStudentDayLog : function(params){
            var data = ajaxMethod(service_url.saveStudentDayLog_url,params,this.POST);
            if(data == false){
                alert("连接服务器失败");
            }else{
                if(data && data.result == "100"){
                    return data;
                }else{
                    alert(data.message);
                }
            }
        },
        removeStudentDayLog : function(params){
            var data = ajaxMethod(service_url.removeStudentDayLog_url,params,this.POST);
            if(data == false){
                alert("连接服务器失败");
            }else{
                if(data && data.result == "100"){
                    return data;
                }else{
                    alert(data.message);
                }
            }
        },
        getInstitutionList : function(params){
            var data = ajaxMethod(service_url.getInstitutionList_url,params,this.POST);
            if(data == false){
                alert("连接服务器失败");
            }else{
                if(data && data.result == "100"){
                    return data;
                }else{
                    alert(data.message);
                }
            }
        },
        switchInstitution : function(params){
            var data = ajaxMethod(service_url.switchInstitution_url,params,this.POST);
            if(data == false){
                alert("连接服务器失败");
            }else{
                if(data && data.result == "100"){
                    return data;
                }else{
                    alert(data.message);
                }
            }
        },
        saveInstitution : function(params){
            var data = ajaxMethod(service_url.saveInstitution_url,params,this.POST);
            if(data == false){
                alert("连接服务器失败");
            }else{
                if(data && data.result == "100"){
                    return data;
                }else{
                    alert(data.message);
                }
            }
        },
        getInstitution : function(params){
            var data = ajaxMethod(service_url.getInstitution_url,params,this.POST);
            if(data == false){
                alert("连接服务器失败");
            }else{
                if(data && data.result == "100"){
                    return data;
                }else{
                    alert(data.message);
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

//统一调度器工厂,执行任何页面主要方法之前,会调用加载旋转等待效果
;(function($){
    var preExecuteAny = {
        func : {},
        pagitationFunc : {},
        init : function(func){
            this.func = func;
        },
        _init : function(){
            //显示加载
            $("#wait_loading").css("display","flex");
            setTimeout("preExecuteAny.func.init()",500);


        },
        _getList : function(){
            //显示加载
            $("#wait_loading").css("display","flex");
            setTimeout("preExecuteAny.func.getList()",500);
        }

    };

    //统一分页方法
    var pagitationFunc = {
        pagitation : {},
        init : function(){

        },
        _init : function(){
            this.loadForm();
        },
        nextPage : function(obj){
            if(this.pagitation.pageNo + 1 > this.pagitation.maxPage){
                return;
            }
            this.pagitation.pageNo += 1;
            preExecuteAny._getList();
        },
        prePage : function(obj){
            if(this.pagitation.pageNo - 1 <= 0){
                return;
            }
            this.pagitation.pageNo -= 1;
            preExecuteAny._getList();
        },
        to : function(page){ //跳转到指定页面
            this.pagitation.pageNo = parseInt(page);
            preExecuteAny._getList();
        },
        loadForm : function(){
            var html = "";
            html += '<span class="item" type="pre">上一页</span>';
            var i = (this.pagitation.pageNo - 3) <= 0 ? 1 : (this.pagitation.pageNo - 3);
            if( this.pagitation.pageNo >= 5){
                html += '<span class="item" to="1">1</span>'
                    + '<span class="item spaces">...</span>';
            }
            for(; i <= this.pagitation.maxPage && i<= this.pagitation.pageNo + 3; i ++){
                if( i == this.pagitation.pageNo){
                    html += '<span class="item active">'+i+'</span>';
                }else{
                    html += '<span class="item" to='+i+'>'+i+'</span>';
                }
            }
            if( this.pagitation.maxPage - this.pagitation.pageNo >= 4){
                html += '<span class="item spaces">...</span>'
                    + '<span class="item" to='+this.pagitation.maxPage+'>'+this.pagitation.maxPage+'</span>';
            }
            html += '<span class="item" type="next">下一页</span>';
            $(".pagination").html(html);
            //为按钮装载事件
            this.loadEvent();
        },
        loadEvent : function(){
            $(".pagination span").each(function(){

                if($(this).attr("type") == "pre"){
                    $(this).click(function(){
                        pagitationFunc.prePage();
                    });
                }else if($(this).attr("type") == "next"){

                    $(this).click(function(){
                        pagitationFunc.nextPage();
                    });
                }else if($(this).attr("to")){

                    $(this).click(function(){
                        pagitationFunc.to($(this).attr("to"));
                    });
                }
            });

        }

    }
    preExecuteAny.pagitationFunc = pagitationFunc;
    window.preExecuteAny = preExecuteAny;
    window.pagitationFunc = pagitationFunc;
})(jQuery)

/**
 * 统一分页器
 * 调用 pagitationFunc.init();
 * @type {{init: init, nextPage: nextPage, prePage: prePage, to: to, loadForm: loadForm, loadEvent: loadEvent}}
 */
;(function($){
    //公共变量记忆体
    var pagitation = {
        "pageNo" : 1,
        "pageSize" : 4,
        "total" : 0,
        "maxPage" : 1
    }

    window.pagitation = pagitation;


})(jQuery)

