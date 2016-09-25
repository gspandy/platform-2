		addEventOnLoad(searchBoxInit);

		function searchBoxInit(){
			//alert("初始化成功");
			document.getElementById("searchInput").onclick=inputKeyDown;
		}
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
		
		function SendSearch(){
			createXmlHttpRequest();
			var value = document.getElementById("searchInput").value;
			xmlHttpReq.open("POST","searchBox",true);
			xmlHttpReq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xmlHttpReq.onreadystatechange = callbackSearch;
			xmlHttpReq.send("value="+value);
			//alert("send");
		}
		
		function callbackSearch(){
			if(xmlHttpReq.readyState == 4){
				if(xmlHttpReq.status == 200){
					var returnstr = xmlHttpReq.responseText;
					returnstr = returnstr.replace(/\s/g,"");
					if(returnstr=="error"){
						
					}else{
						var jsonarr = JSON.parse(returnstr);
						//alert(jsonarr);
						var hand  = document.getElementById("search_box");
						hand.innerHTML="";
						document.getElementById("search_bg").style.display="block";
						document.getElementById("searchout").style.height=48+32*jsonarr.length+"px";
						for(var i=0;i<jsonarr.length;i++){
							var d = document.createElement("div");
							d.className = "search_item";
							d.innerHTML = jsonarr[i].context;
							d.id = "item"+i;
							d.onclick=boxC(i);
							hand.appendChild(d);
						}
					}
				}
			}
		}
		var keyDownEven;
		var oldcontext="",newcontext;
		function inputKeyDown(){
			newcontext = document.getElementById("searchInput").value;
			if(newcontext!=oldcontext){
				//alert("judge");
				oldcontext = newcontext;
				SendSearch();
			}
			keyDownEven = setTimeout(inputKeyDown,400);
		}
		function boxC(i){
			return function(){
				boxClick(i);
			}
		}
		function boxClick(index){
			var val = document.getElementById("item"+index).innerHTML;
			clearTimeout(keyDownEven);
			document.getElementById("searchInput").value=val;
			document.getElementById("searchout").style.height=43+"px";
			document.getElementById("search_box").innerHTML = "";
		}
		
		function inputBlur(){
			 document.getElementById("search_box").innerHTML = "";
		}
		
		function searchBg(obj){
			obj.style.display="none";
			document.getElementById("searchout").style.height=43+"px";
			document.getElementById("search_box").innerHTML = "";
		}
		
		