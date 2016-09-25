/**
 * Created by Administrator on 2015/8/2.
 */
$(function () {
    $(".loginshow").find(".fr").hover(function () {
        $(".showlogin").slideDown(500);
    },function(){
        $(".showlogin").mouseover(function () {
            $(this).show();
        });
        $(".showlogin").mouseout(function () {
            $(this).hide();
        });
    });
    $(".shopcar").find(".fr").hover(function () {
    $(".shopcar_show").slideDown(500);
    },function(){
    $(".shopcar_show").mouseover(function () {
    $(this).show();
    });
    $(".shopcar_show").mouseout(function () {
    $(this).hide();
    });
    });
    $(".intro").hover(function(){
    $(".shopintro").slideDown(500);
    },function(){
    $(".shopintro").mouseover(function () {
    $(this).show();
    });
    $(".shopintro").mouseout(function () {
    $(this).hide();
    });
    });
    $(".pic_min").find("li").mouseover(function(){
    var _index=$(this).index();
//            alert(_index);
    $(".pic_box").find("img").eq(_index).show().siblings().hide();
    })
    });
	
	//µÇÂ½¿ò
	var loginflag = 0;
	function loginShow(){
		if(loginflag==1){
			return;
		}
		loginflag=1;
		$("#login_contains").css({"left":"90px","top":"0px","width":"0px","height":"0px"});
		$("#login_contains").show();
		$("#login_contains").animate({"left":"519px","top":"200px","width":"308px","height":"230px"},1000,function(){loginflag=0;});
	}
	
	function loginClose(){
		$("#login_contains").hide(1000);
	}

	
