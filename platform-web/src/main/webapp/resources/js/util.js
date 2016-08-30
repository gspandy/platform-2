/**
 * Created by linjunjie(490456661@qq.com) on 2020/8/25.
 */
/**
 * 获取参数
 * @param name
 */
var getUrlParameter = function(name){
    var href = location.href;
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");//取(^&)除了&以外的所有字符
    href = window.location.search.substr(1).match(reg);
    return decodeURI(href[2]);
}

var getTargetUrlParameter = function(url,name){
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");//取(^&)除了&以外的所有字符
    var href = url.match(reg);
    return decodeURI(href[2]);
}

/**
 * 跳转到指定 “模块”
 */
var jumpToModule = function(module){
    location.href = location.href.substring(0,location.href.indexOf("#")) + "#" + module;
    window.redirect();//跳转到链接
}

function redirect(){
    //处理链接
    var url = "";
    if(location.href.indexOf("#") != -1) {
        var arr = location.href.substring(location.href.indexOf("#") + 1).split("?");
        //url
        url = arr[0];
    }

    if(url == ""){
        //初始化内容页面
        $("#context_main").load("main.jsp");
    }else{
        $("#context_main").load(url);
    }
}