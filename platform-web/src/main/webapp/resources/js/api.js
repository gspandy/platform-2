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
        "tagStudent_url" : "/platform/tagStudent"
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
        init : function(){

        },
        _init : function(){
            this.loadForm();
        },
        nextPage : function(obj){
            if(pagitation.pageNo + 1 > pagitation.maxPage){
                return;
            }
            pagitation.pageNo += 1;
            preExecuteAny._getList();
        },
        prePage : function(obj){
            if(pagitation.pageNo - 1 <= 0){
                return;
            }
            pagitation.pageNo -= 1;
            preExecuteAny._getList();
        },
        to : function(page){ //跳转到指定页面
            pagitation.pageNo = parseInt(page);
            preExecuteAny._getList();
        },
        loadForm : function(){
            var html = "";
            html += '<span class="item" type="pre">上一页</span>';
            var i = (pagitation.pageNo - 3) <= 0 ? 1 : (pagitation.pageNo - 3);
            if( pagitation.pageNo >= 5){
                html += '<span class="item" to="1">1</span>'
                    + '<span class="item spaces">...</span>';
            }
            for(; i <= pagitation.maxPage && i<= pagitation.pageNo + 3; i ++){
                if( i == pagitation.pageNo){
                    html += '<span class="item active">'+i+'</span>';
                }else{
                    html += '<span class="item" to='+i+'>'+i+'</span>';
                }
            }
            if( pagitation.maxPage - pagitation.pageNo >= 4){
                html += '<span class="item spaces">...</span>'
                    + '<span class="item" to='+pagitation.maxPage+'>'+pagitation.maxPage+'</span>';
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

