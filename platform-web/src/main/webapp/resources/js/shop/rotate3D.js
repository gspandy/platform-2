var xita1 = 150, xita2 = 30, xita3 = 90;
var xitac1 = 150, xitac2 = 30, xitac3 = 90;
var width_div, height_div;// 三棱柱每一面的宽和高
var half_width;// 一半的宽
var zhi;
var xOffset;
var zOffset;

var handh3;
var handh4;
var handh5;
var idh1;// 事件

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

function rotechange(f) {

	var handh3 = document.getElementById("rote_in");
	var handh4 = document.getElementById("rote_in2");
	var handh5 = document.getElementById("rote_in3");

	xitac1 = (xita1 + parseInt(f)) % 360;
	xitac2 = (xita2 + parseInt(f)) % 360;
	xitac3 = (xita3 + parseInt(f)) % 360;
	if (xitac3 >= 83 && xitac3 <= 277) {
		handh5.style.zIndex = 0;
	} else {
		handh5.style.zIndex = 5;
	}
	if (xitac1 >= 90 && xitac1 <= 270) {
		handh3.style.zIndex = 5;
	} else {
		handh3.style.zIndex = 0;
	}

	if (xitac2 >= 90 && xitac2 <= 270) {
		handh4.style.zIndex = 5;
	} else {
		handh4.style.zIndex = 0;
	}

	handh3.style.webkitTransform = "rotateY(" + (xitac1) + "deg) translateX("
			+ (-0) + "px) translateZ(" + (-zhi) + "px)";
	handh4.style.webkitTransform = "rotateY(" + (xitac2) + "deg) translateX("
			+ 0 + "px) translateZ(" + (-zhi) + "px)";
	handh5.style.webkitTransform = "rotateY(" + (xitac3) + "deg) translateX("
			+ 0 + "px) translateZ(" + zhi + "px) ";

	idh1 = setTimeout("rotechange(" + f + "+1)", 50);
}


function rotate3dinit() {
	// 初始化
	width_div = document.getElementById("rote_in").offsetWidth;
	height_div = document.getElementById("rote_in").offsetHeight;
	half_width = width_div / 2;
	zhi = half_width * Math.sqrt(3) / 3;
	xOffset = half_width;
	zOffset = half_width * 2 * Math.sqrt(3) / 3;

	handh3 = document.getElementById("rote_in");
	handh4 = document.getElementById("rote_in2");
	handh5 = document.getElementById("rote_in3");
	handh3.style.webkitTransform = "rotateY(" + (xitac1) + "deg) translateX("
			+ (-0) + "px) translateZ(" + (-zhi) + "px)";
	handh4.style.webkitTransform = "rotateY(" + (xitac2) + "deg) translateX("
			+ 0 + "px) translateZ(" + (-zhi) + "px)";
	handh5.style.webkitTransform = "rotateY(" + (xitac3) + "deg) translateX("
			+ 0 + "px) translateZ(" + zhi + "px) ";

	handh3.childNodes[0].childNodes[0].style.webkitTransform = "rotateY(180deg)";
	handh4.childNodes[0].childNodes[0].style.webkitTransform = "rotateY(180deg)";
	// 对img设置属性
	var child = document.getElementById("rote_3d");
	for ( var i = 0; i < child.childNodes.length; i++) {
		dfs(child.childNodes[i]);
	}

	// 添加悬浮事件
	document.getElementById("rote_3d").onmouseover = function() {
		xita1 = xitac1, xita2 = xitac2, xita3 = xitac3;
		clearTimeout(idh1);
	};
	document.getElementById("rote_3d").onmouseout = function() {
		rotechange(1);
	};
	rotechange(1);
}

function dfs(k) {

	if (k.tagName == 'IMG') {
		k.style.width = width_div + "px";
		k.style.height = height_div + "px";
	}
	for ( var i = 0; i < k.childNodes.length; i++) {
		if (k.childNodes.length > 0)
			dfs(k.childNodes[i]);
	}
}

addEventOnLoad(rotate3dinit);