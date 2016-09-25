		function addEventOnLoad(func){
			var oldonload = window.onload;
			if(typeof(window.onload)!="function"){
				window.onload = func;
			}else{
				window.onload = function(){
					oldonload();
					func();
				}
			}
		}
		addEventOnLoad(showWaresInit);
	//window.onload = showWaresInit;
		var mouseX,mouseY;
		function showWaresInit(){
			var hand = document.getElementsByName("pic_wares");
			var sub = document.getElementsByName("img_float");
			for(var i=0;i<hand.length;i++){
				hand[i].index = i;
				hand[i].onmouseover = function(){
					sub[this.index].style.opacity = 0.6;
				}
				hand[i].onmouseout = function(){
					sub[this.index].style.opacity = 0.2;
				}
				
			}
			//alert(document.getElementById("typename").value);
			if(document.getElementById("typename").value==""){
				document.getElementById("typename").value="-1";
			}
			//添加搜索事件
			document.getElementById("searchA").href="javascript:void(0)";
			document.getElementById("searchA").onclick = readySearch;
			
			/*
			 *  搜索初始化
			 */
			 	//衣服类型
			var t = document.getElementById("types").getElementsByTagName("a");
			for(var i=0;i<t.length;i++){
				if(t[i].getElementsByTagName("li")[0].innerHTML=="更多"){
					continue;
				}
				t[i].href="javascript:selectTypes("+i+")";
			}
			document.getElementById("typename").onclick = function(){
				this.innerHTML = "";document.getElementById("typename_input").value="-1";
			}
			    //性别
			t=document.getElementById("csex").getElementsByTagName("a");
			for(var i=0;i<t.length;i++){
				t[i].href="javascript:selectCsex("+i+")";
			}
			document.getElementById("csexname").onclick = function(){
				this.innerHTML = "";
			}
				//季节
			t=document.getElementById("season").getElementsByTagName("a");
			for(var i=0;i<t.length;i++){
				t[i].href="javascript:selectSeason("+i+")";
			}
			
			document.getElementById("seasonname").onclick = function(){
				this.innerHTML = "";
			}
			
				//排序
			t=document.getElementById("sort").getElementsByTagName("a");
			for(var i=0;i<t.length;i++){
				t[i].href="javascript:selectSort("+i+")";
			}
			
			document.getElementById("sortname").onclick = function(){
				this.innerHTML = "";
			}
			
			
			
		}	
		
		function selectTypes(index){
			var t = document.getElementById("types").getElementsByTagName("li");
			
			document.getElementById("typename").innerHTML = t[index].innerHTML;
			document.getElementById("typename").value = t[index].value;
			document.getElementById("typename_input").value = t[index].value;
			
		}
		function selectCsex(index){
			var t = document.getElementById("csex").getElementsByTagName("li");
			
			document.getElementById("csexname").innerHTML = t[index].innerHTML;
			document.getElementById("csexname").value = t[index].value;
		}
		function selectSeason(index){
			var t = document.getElementById("season").getElementsByTagName("li");
			
			document.getElementById("seasonname").innerHTML = t[index].innerHTML;
			document.getElementById("seasonname").value = t[index].value;
		}
		function selectSort(index){
			var t = document.getElementById("sort").getElementsByTagName("li");
			
			document.getElementById("sortname").innerHTML = t[index].innerHTML;
			document.getElementById("sortname").value = t[index].value;
		}
		
		//显示更多类型
		function moreTypes(){
			var h = document.getElementById("types");
			if(h.style.zIndex=="2"){
				document.getElementById("types").style.zIndex = "0";	
				document.getElementById("types").style.backgroundColor="#fafafa";		
			}else{
				document.getElementById("types").style.zIndex = "2";
				document.getElementById("types").style.backgroundColor="RGB(253,244,168)";
				document.getElementById("types").style.border="1px solid #fafafa";
			}
		}
		
		window.onclick = mouseClickPosition;
		//document.body.onclick = mouseClickPosition;
		function mouseClickPosition(event){
			//alert(event.x);
			var e = event||window.event;
			mouseX = e.pageX||e.x;
			mouseY = e.pageY||e.y;
		}
		
//		/*
//		 * 获取层相对窗口的位置
//		 */
//		function getLeft(e){
//			var offsetLeft = e.offsetLeft;
//			alert(offsetLeft);
//			if(e.offsetParent!=null){
//				offsetLeft = offsetLeft + getLeft(e.offsetParent);
//			}
//			return offsetLeft;
//		}
		
		
		/*
		 * 收藏文字显示
		 */
		function addxin(obj){
			$("#collect").show();
			//alert(getLeft(obj));
			var mx = $(obj).offset().left;
			var my = $(obj).offset().top;
			//alert(mx+" "+my);
			$("#collect")[0].style.left = mx+10+"px";
			$("#collect")[0].style.top = my-20+"px";
			var endY = my - 25;
			$("#collect").animate({top:endY+"px"},1000);
			$("#collect").hide(250);
		}
		
		//添加搜索事件
			function readySearch(){
				
				var search = document.getElementById("searchInput").value;
				var pageNo = document.getElementById("pageNo").value;
				pageNo = parseInt(pageNo);
				if(isNaN(pageNo)){
					pageNo = 1;
				}
				var pageSize = document.getElementById("pageSize").value;
				pageSize = parseInt(pageSize);
				if(isNaN(pageSize)){
					pageSize = 20;
				}
				var typename = document.getElementById("typename").innerHTML;
				var season = document.getElementById("seasonname").innerHTML;
				var sex = document.getElementById("csexname").innerHTML;
				var type = document.getElementById("typename_input").value;
				var sortname = document.getElementById("sortname").innerHTML;
				
				location.href="searchWares?search="+search+"&pageNo="+pageNo+"&pageSize="+
				pageSize+"&season="+season+"&sex="+sex+"&type="+type+"&typename="+typename+"&sortname="+sortname+"#h_search";
			}
		
		function pageUp(){
			var pageNo = document.getElementById("pageNo").value;
				pageNo = parseInt(pageNo);
				if(isNaN(pageNo)){
					pageNo = 1;
				}
		    pageNo-=1;
		    document.getElementById("pageNo").value=pageNo;
		    readySearch();
		}
		function pageDown(){
			var pageNo = document.getElementById("pageNo").value;
				pageNo = parseInt(pageNo);
				if(isNaN(pageNo)){
					pageNo = 1;
				}
			pageNo+=1;
			document.getElementById("pageNo").value=pageNo;
			readySearch();
		}
		
		
		/*
		 * 收藏的ajax
		*/
		
		function createXmlHttpRequest(){
			if(window.XMLHttpRequest){//表示是火狐浏览器
				xmlHttpReq = new XMLHttpRequest();
			}else{
				if(window.ActiveXObject){//IE
					try{
						xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
					}catch(e){
						try{
							xmlHttpReq=new ActiveXObject("Microsoft.XMLHTTP");
						}catch(e){
						}
					}
				}
			}
		}
	
		var cllid;
		var cllobj;
		function sendCollection(obj,cid){
			var checkobj = document.getElementById("user_s");
			if(checkobj==null){
				alert("请先登录");
				return;
			}
			createXmlHttpRequest();
			var id = parseInt(cid);
			cllid = id;
			cllobj = obj;
			//alert(id);
			xmlHttpReq.open("POST","collection",true);
			xmlHttpReq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xmlHttpReq.onreadystatechange = callbackCollection;
			xmlHttpReq.send("cid="+id);
		}
		function callbackCollection(){
			if(xmlHttpReq.readyState==4){
				if(xmlHttpReq.status == 200){
					var returnstr = xmlHttpReq.responseText;
					returnstr = returnstr.replace(/\s/g,"");
					if(returnstr == "ok"){
						var old = parseInt(document.getElementById("collect"+cllid).innerHTML);
						//alert(document.getElementById("collect"+cllid).innerHTML);
						document.getElementById("collect"+cllid).innerHTML= old+1;
						addxin(cllobj);
					}else{
						if(returnstr == "usererror"){
							alert("请登录再试");
						}else{
							alert("已收藏");
						}
						
					}				
				}
			}
		}