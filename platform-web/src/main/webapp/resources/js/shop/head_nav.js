	
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