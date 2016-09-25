 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <!DOCTYPE html>

<html lang="en">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

 <script src="${pageContext.request.contextPath}/js/shop/jquery-1.8.0.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/shop/search.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/shop/searchbox.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/shop/head_nav.js" type="text/javascript"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/shop/rotate3D.js"></script>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shop/maishoujie.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shop/refactorpage.css"/>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shop/head_nav.css"/>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shop/rotate3D.css">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shop/talkabout.css">
 
<title>带恵购，带“恵”就购了！</title>
<script >
	
</script>

<style type="text/css">	

	/*左侧导航*/
	.nav_left_container{
			position:relative;
			width:255px;
			border:1px solid RGB(223,223,223);
			font-family:"微软雅黑";
			
		}
		.nav_left_container>ul{
			list-style:none;
			width:255px;
			background-color:#FFFFFF;
		}
		.nav_left_container>ul>li{
			padding:29px 25px;
			border:1px solid #FFFFFF;
			border-left:2px solid #FFFFFF;
			border-bottom:1px solid RGB(223,223,223);
		}
		.nav_left_container>ul>li:hover{
			border-left-color:#FF9900;
			background-color:RGB(248,248,243);
		}
		.nav_left_container a{
			font-size:13px;    display: inline-block;
			padding:0px 5px;
			text-decoration:none;
			color:RGB(102,102,102);
		}
		.nav_left_container a:hover{
			text-decoration:underline;
			color:RGB(138,181,227);
		}
		.nav_left_container h3{
			font-size:15px;
			color:RGB(73,86,114);
		}
		
		/*下侧图片*/
		.nav_bottom_container{
			position:relative;width:778px;height:143px;left:0px;top:0px;background-color:#000;margin-left:3px;
			margin-top:5px;
		}
		.nav_bottom_container img{
			border:0px;
		}
		.nav_bottom_container>ul{
			list-style:none;
			width:100%;
			height:100%;
			background-color:RGB(239,239,239);
		}
		.nav_bottom_container>ul>li{
			float:left;width:258px;text-align:center;height:100%;
			background-color:RGB(245,245,245);border-left:1px solid RGB(223,223,223);
		}
		.nav_bottom_container>ul>li:after{
			content:'';
			clear:both;
		}
		.nav_bottom_container>ul>li:last-child{
			border-right:1px solid RGB(223,223,223);
		}
		.nav_bottom_container>ul>li:hover{
			opacity:0.6;filter:alpha(opacity=60);
		}
		/*下侧导航和中部banner*/
		.bot_cent_con{
			position:relative;float:left;height:100%;
		}
		/*左侧导航*/
		.lef_con{
			position:relative;float:left;width:258px;
			text-align:left;
		}
		/*ljjcontainer*/
		.ljj_container{
			position:relative;
			width:100%;
			height:865px;
			margin:0px auto;
		}
</style>
</head>
<body>

<div class="ljj_container">

	<%@ include file="head_nav.jsp" %>
	
	
	<!-- 中心超大屏幕!-->
	<div class="cen_big">
		
		<center>
		
            <div style="width:1042px;">
                <!-- 左侧模块 -->
                <div class="lef_con">
                    <!-- 左侧导航 -->
                    <div class="nav_left_container">
                        <ul>
                            <li>
                                <h3>衣服</h3>
                                <a href="#">秋の新品</a>
                                <a href="#">针织衫</a>
                                <a href="#">牛仔裤</a><br/>
                                <a href="#">时尚套装</a>
                                <a href="#">连衣裙</a>
                                <a href="#">风衣</a><br/>
                                <a href="#">T恤</a>
                                <a href="#">韩范美裙</a>
                            </li>
                            <li>
                                <h3>男友</h3>
                                <a href="#">衬衫</a>
                                <a href="#">T恤</a>
                                <a href="#">休闲裤</a>
                                <a href="#">休闲鞋</a>
                                <a href="#">双肩包</a>
                                <a href="#">运动背心</a>
                                <a href="#">帆布鞋</a>
                            </li>
                            <li>
                                <h3>裙子</h3>
                                <a href="#">半身裙</a>
                                <a href="#">包臀裙</a>
                                <a href="#">气质美裙</a>
                                <a href="#">裙子套装</a>
                                <a href="#">连衣裙</a>
                                <a href="#">中袖连衣裙</a>
                            </li>
                            <li>
                                <h3>裤子</h3>
                                <a href="#">显瘦裤子</a>
                                <a href="#">时尚哈伦裤</a>
                                <a href="#">潮流阔腿裤</a>
                                <a href="#">韩版短裤</a>
                                <a href="#">破洞牛仔裤</a>
                            </li>
                            <li>
                                <h3>当季热点</h3>
                                <a href="#">秋季新品</a>
                                <a href="#">人气连衣裙</a>
                                <a href="#">毛衣</a>
                                <a href="#">轻逸雪纺</a>
                                <a href="#">T恤搭配</a>
                                <a href="#">潮范休闲裤</a>
                            </li>
                        </ul>
                    </div>
                    <!-- // -->
                </div><!-- 左侧模块 -->

                <!-- 中心模块 -->
                <div class="bot_cent_con" style="float:left;">

                     <!-- 中心banner图 -->
                      <div class="banner_container1">
                        <a href="#1"><div  id="ban_left1" class="banner_left1"><</div></a>
                        <a href="#1"><div id="ban_right1" class="banner_right1">></div></a>
                        <div class="banner_container21">
                            <ul>
                                <li><a href="#0"><img src="${pageContext.request.contextPath}/images/k0.jpg" onClick="focusePic(0)"/></a></li>
                                <li><a href="#1"><img src="${pageContext.request.contextPath}/images/k1.jpg" onClick="focusePic(0)"/></a></li>
                                <li><a href="#2"><img src="${pageContext.request.contextPath}/images/k2.jpg" onClick="focusePic(0)"/></a></li>
                                <li><a href="#3"><img src="${pageContext.request.contextPath}/images/k3.jpg" onClick="focusePic(0)"/></a></li>
                                <li><a href="#4"><img src="${pageContext.request.contextPath}/images/k4.jpg" onClick="focusePic(0)"/></a></li>
                            </ul>
                        </div>
                        <div class="banner_container31">
                            <ul id="banner_li1">
                                <li><a href="#0"></a></li>
                                <li><a href="#1"></a></li>
                                <li><a href="#2"></a></li>
                                <li><a href="#3"></a></li>
                                <li><a href="#4"></a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- // -->
                    <!-- 下侧图片 -->
                    <div class="nav_bottom_container">
                        <ul>
                            <li>
                                <a href="#"><img src="${pageContext.request.contextPath}/images/upload_iezdimtfgi2tmzjygezdambqmmyde_120x120.jpg"></a>
                            </li>
                            <li>
                                <a href="#"><img src="${pageContext.request.contextPath}/images/2h15i_ieztqmzyga2dmyjwgezdambqgyyde_120x120.jpg"></a>
                            </li>
                            <li>
                                <a href="#"><img src="${pageContext.request.contextPath}/images/2h15i_ie2dqytfmmytmyjwgezdambqgiyde_120x120.jpg"></a>
                            </li>
                            <div style="clear:both;"></div>
                        </ul>
                    </div>
                    <!-- // -->
                </div>

                <div style="clear:both;"></div>
            </div>
	    </center>
	</div><!-- //中心超大屏幕!-->

		<!-- banner关注点 -->
		<div id="bcg_container" style="position:fixed;z-index:100;top:0px;width:100%;">
			<div id="bcg1" class="bcg"></div>
			
		<div id="he_container" class="he_container">
			<span id="close_bcg" class="close_bcg">关闭</span>
			<div id="focPic0" class="he" style="background:url('images/k0.jpg')"><ul><li>天生关爱男友!</li><li>质量超好</li><li>现在就开始抢购!满减不停歇。<br>哈哈哈哈哈哈哈哈哈哈</li><li>你值得拥有 6.18</li></ul>
				<div class="bot"></div><!--下面的字幕背景色-->
			</div>
			<div id="focPic1" class="he" style="background:url('images/k1.jpg')"><ul><li>天生关爱男友!</li><li>质量超好</li><li>现在就开始抢购!满减不停歇。<br>哈哈哈哈哈哈哈哈哈哈</li><li>你值得拥有 6.18</li></ul>
				<div class="bot"></div><!--下面的字幕背景色-->
			</div>
			<div id="focPic2" class="he" style="background:url('images/k2.jpg')"><ul><li>天生关爱男友!</li><li>质量超好</li><li>现在就开始抢购!满减不停歇。<br>哈哈哈哈哈哈哈哈哈哈</li><li>你值得拥有 6.18</li></ul>
				<div class="bot"></div><!--下面的字幕背景色-->
			</div>
			<div id="focPic3" class="he" style="background:url('images/k3.jpg')"><ul><li>天生关爱男友!</li><li>质量超好</li><li>现在就开始抢购!满减不停歇。<br>哈哈哈哈哈哈哈哈哈哈</li><li>你值得拥有 6.18</li></ul>
				<div class="bot"></div><!--下面的字幕背景色-->
			</div>
			<div id="focPic4" class="he" style="background:url('images/k4.jpg')"><ul><li>天生关爱男友!</li><li>质量超好</li><li>现在就开始抢购!满减不停歇。<br>哈哈哈哈哈哈哈哈哈哈</li><li>你值得拥有 6.18</li></ul>
				<div class="bot"></div><!--下面的字幕背景色-->
			</div>
		</div>
		
	</div>
	
</div><!-- ljj_container -->

	
	
	<!-- 重构页面部分 -->
	<div id="refactorpage">
	
		<!-- 图片墙 -->
		<div class="pic_nav">
			<ul>
				<li><a href="#"><img src = "${pageContext.request.contextPath}/images/111.png"/></a></li>
				<li><a href="#"><img src = "${pageContext.request.contextPath}/images/112.png"/></a></li>
				<li><a href="#"><img src = "${pageContext.request.contextPath}/images/113.png"/></a></li>
				<li><a href="#"><img src = "${pageContext.request.contextPath}/images/114.png"/></a></li>
			</ul>
			<div style="clear:both"></div>
		</div>
		
		<!-- 买手推荐系列 -->
		<div class="mytj">
			<!--推荐头部  -->
			<div class="mytj_top">
				<h3>旺季直销</h3>
				<div class="top_link">
					<a href="#">秋季热卖</a>
					<a href="#">秋季热卖</a>
					<a href="#">秋季热卖</a>
					<a href="#">秋季热卖</a>
					<a href="#">秋季热卖</a>
					<a href="#">秋季热卖</a>
					<a href="#">More</a>
				</div>
				<div style="clear:both"></div>
			</div>
            <div style="clear:both"></div>
            <!--推荐头部end -->
			<!-- 推荐内容 -->
            <style>
                .mytj:after{
                    content:".";
                    display:block;
                    height:0;
                    clear:both;
                    visibility:hidden;
                }

                .search-box-result{
                    position:relative;

                }
                .search-box-result:after{
                    content:".";
                    display:block;
                    height:0;
                    clear:both;
                    visibility:hidden;
                }

                .search-box-result a,.search-box-result a:link {
                    color:#8a7777;
                }
                .search-box-result a:hover{
                    color:#f50;
                }
                .search-box-result .block-search-box{
                    float:left;cursor:pointer;
                    border:1px solid #E8E8E8;
                    width: 220px;
                    height: 382px;
                    margin-top:20px;margin-left:37px;
                }
                .search-box-result .block-search-box:hover{
                    border:1px solid #999;
                    box-shadow: 0 2px 4px 0 rgba(32,32,64,.16);
                }
                .search-box-result .block-search-box .shop-pic{

                }
                .search-box-result .block-search-box .shop-pic img{
                    margin:0 auto;
                    width:218px;height:218px;border: 1px solid white;
                }
                .search-box-result .block-search-box .shop-info{
                    width:210px;border:solid 1px white;
                }
                .search-box-result .block-search-box .shop-info .content-line{
                    padding: 0px 8px;
                    line-height: 35px;
                    width: 200px;font-size:13px;
                    white-space:nowrap; overflow:hidden; text-overflow:ellipsis;
                }

                .integer{
                    font-size:16px;
                }
                .fr{
                    float:right;
                }
                .fl{
                    float:left;
                }
                .fw{
                    font-weight:600;
                }
                /*促销*/
                .cx{
                    font-size:36px;
                }
                .jh{
                    color:#f50;
                }
                .hs{
                    color:#8a7777;
                }
                .bt-yhq{
                    cursor: pointer;
                    display: inline-block;
                    width: 100px;
                    height: 35px;
                    text-align: center;
                    line-height: 35px;
                }
                .fh{
                    background-color:rgb(255,228,208);color:#f50;
                }
                .tmbuy{
                    background-color:#f36;color:rgb(254,254,254);
                }
            </style>
            <!-- 推荐内容 -->
                <div class="search-box-result">
                    <!-- item begin -->
                    <div class="block-search-box">
                        <div class="shop-pic"><img src="http://img04.taobaocdn.com/bao/uploaded/i4/TB1u3I6LXXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_220x220_.webp"></div>
                        <div class="shop-info">
                            <div class="content-line">
                                <a href="javascript:void(0)">春夏新品圆领T恤修身短袖上衣百搭打底衫390002</a>
                            </div>
                            <div class="content-line">
                                <div class="fl">
                                    <span class="yuan">￥</span>
                                    <span class="integer fw">199</span>
                                    <span class="pointer">.</span>
                                    <span class="decimal">00</span>
                                </div>
                                <div class="fr hs">
                                    月销:123
                                </div>
                            </div>
                            <div class="content-line">
                                <div class="fl">
                                    <span class="hs">优惠后</span>
                                    <span class="yuan jh">￥</span>
                                    <span class="integer fw cx jh">66</span>
                                    <span class="pointer jh">.</span>
                                    <span class="decimal jh">00</span>
                                </div>
                            </div>
                            <div class="content-line">
                                <div class="bt-yhq fh">
                                    领取优惠券
                                </div>
                                <div class="bt-yhq tmbuy">
                                    去天猫购买
                                </div>
                            </div>
                        </div>
                    </div><!-- //item-end -->
                    <!-- item begin -->
                    <div class="block-search-box">
                        <div class="shop-pic"><img src="http://img04.taobaocdn.com/bao/uploaded/i4/TB1u3I6LXXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_220x220_.webp"></div>
                        <div class="shop-info">
                            <div class="content-line">
                                <a href="javascript:void(0)">春夏新品圆领T恤修身短袖上衣百搭打底衫390002</a>
                            </div>
                            <div class="content-line">
                                <div class="fl">
                                    <span class="yuan">￥</span>
                                    <span class="integer fw">199</span>
                                    <span class="pointer">.</span>
                                    <span class="decimal">00</span>
                                </div>
                                <div class="fr hs">
                                    月销:123
                                </div>
                            </div>
                            <div class="content-line">
                                <div class="fl">
                                    <span class="hs">优惠后</span>
                                    <span class="yuan jh">￥</span>
                                    <span class="integer fw cx jh">66</span>
                                    <span class="pointer jh">.</span>
                                    <span class="decimal jh">00</span>
                                </div>
                            </div>
                            <div class="content-line">
                                <div class="bt-yhq fh">
                                    领取优惠券
                                </div>
                                <div class="bt-yhq tmbuy">
                                    去天猫购买
                                </div>
                            </div>
                        </div>
                    </div><!-- //item-end -->
                    <!-- item begin -->
                    <div class="block-search-box">
                        <div class="shop-pic"><img src="http://img04.taobaocdn.com/bao/uploaded/i4/TB1u3I6LXXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_220x220_.webp"></div>
                        <div class="shop-info">
                            <div class="content-line">
                                <a href="javascript:void(0)">春夏新品圆领T恤修身短袖上衣百搭打底衫390002</a>
                            </div>
                            <div class="content-line">
                                <div class="fl">
                                    <span class="yuan">￥</span>
                                    <span class="integer fw">199</span>
                                    <span class="pointer">.</span>
                                    <span class="decimal">00</span>
                                </div>
                                <div class="fr hs">
                                    月销:123
                                </div>
                            </div>
                            <div class="content-line">
                                <div class="fl">
                                    <span class="hs">优惠后</span>
                                    <span class="yuan jh">￥</span>
                                    <span class="integer fw cx jh">66</span>
                                    <span class="pointer jh">.</span>
                                    <span class="decimal jh">00</span>
                                </div>
                            </div>
                            <div class="content-line">
                                <div class="bt-yhq fh">
                                    领取优惠券
                                </div>
                                <div class="bt-yhq tmbuy">
                                    去天猫购买
                                </div>
                            </div>
                        </div>
                    </div><!-- //item-end -->

                    <!-- item begin -->
                    <div class="block-search-box">
                        <div class="shop-pic"><img src="http://img04.taobaocdn.com/bao/uploaded/i4/TB1u3I6LXXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_220x220_.webp"></div>
                        <div class="shop-info">
                            <div class="content-line">
                                <a href="javascript:void(0)">春夏新品圆领T恤修身短袖上衣百搭打底衫390002</a>
                            </div>
                            <div class="content-line">
                                <div class="fl">
                                    <span class="yuan">￥</span>
                                    <span class="integer fw">199</span>
                                    <span class="pointer">.</span>
                                    <span class="decimal">00</span>
                                </div>
                                <div class="fr hs">
                                    月销:123
                                </div>
                            </div>
                            <div class="content-line">
                                <div class="fl">
                                    <span class="hs">优惠后</span>
                                    <span class="yuan jh">￥</span>
                                    <span class="integer fw cx jh">66</span>
                                    <span class="pointer jh">.</span>
                                    <span class="decimal jh">00</span>
                                </div>
                            </div>
                            <div class="content-line">
                                <div class="bt-yhq fh">
                                    领取优惠券
                                </div>
                                <div class="bt-yhq tmbuy">
                                    去天猫购买
                                </div>
                            </div>
                        </div>
                    </div><!-- //item-end -->

                    <!-- item begin -->
                    <div class="block-search-box">
                        <div class="shop-pic"><img src="http://img04.taobaocdn.com/bao/uploaded/i4/TB1u3I6LXXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_220x220_.webp"></div>
                        <div class="shop-info">
                            <div class="content-line">
                                <a href="javascript:void(0)">春夏新品圆领T恤修身短袖上衣百搭打底衫390002</a>
                            </div>
                            <div class="content-line">
                                <div class="fl">
                                    <span class="yuan">￥</span>
                                    <span class="integer fw">199</span>
                                    <span class="pointer">.</span>
                                    <span class="decimal">00</span>
                                </div>
                                <div class="fr hs">
                                    月销:123
                                </div>
                            </div>
                            <div class="content-line">
                                <div class="fl">
                                    <span class="hs">优惠后</span>
                                    <span class="yuan jh">￥</span>
                                    <span class="integer fw cx jh">66</span>
                                    <span class="pointer jh">.</span>
                                    <span class="decimal jh">00</span>
                                </div>
                            </div>
                            <div class="content-line">
                                <div class="bt-yhq fh">
                                    领取优惠券
                                </div>
                                <div class="bt-yhq tmbuy">
                                    去天猫购买
                                </div>
                            </div>
                        </div>
                    </div><!-- //item-end -->


                </div>
			<!-- 推荐内容end -->
		</div>
		
		<div class="mytj">
			<!--推荐头部  -->
			<div class="mytj_top">
				<h3>买手销量版</h3>
				<div class="top_link">
					<a href="#">秋季热卖</a>
					<a href="#">秋季热卖</a>
					<a href="#">秋季热卖</a>
					<a href="#">秋季热卖</a>
					<a href="#">秋季热卖</a>
					<a href="#">秋季热卖</a>
					<a href="#">More</a>
				</div>
				<div style="clear:both"></div>
			</div>
            <div style="clear:both"></div>
            <!--推荐头部end -->
			<!-- 推荐内容 -->
            <div class="search-box-result">
                <!-- item begin -->
                <div class="block-search-box">
                    <div class="shop-pic"><img src="http://img04.taobaocdn.com/bao/uploaded/i4/TB1u3I6LXXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_220x220_.webp"></div>
                    <div class="shop-info">
                        <div class="content-line">
                            <a href="javascript:void(0)">春夏新品圆领T恤修身短袖上衣百搭打底衫390002</a>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="yuan">￥</span>
                                <span class="integer fw">199</span>
                                <span class="pointer">.</span>
                                <span class="decimal">00</span>
                            </div>
                            <div class="fr hs">
                                月销:123
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="hs">优惠后</span>
                                <span class="yuan jh">￥</span>
                                <span class="integer fw cx jh">66</span>
                                <span class="pointer jh">.</span>
                                <span class="decimal jh">00</span>
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="bt-yhq fh">
                                领取优惠券
                            </div>
                            <div class="bt-yhq tmbuy">
                                去天猫购买
                            </div>
                        </div>
                    </div>
                </div><!-- //item-end -->
                <!-- item begin -->
                <div class="block-search-box">
                    <div class="shop-pic"><img src="http://img04.taobaocdn.com/bao/uploaded/i4/TB1u3I6LXXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_220x220_.webp"></div>
                    <div class="shop-info">
                        <div class="content-line">
                            <a href="javascript:void(0)">春夏新品圆领T恤修身短袖上衣百搭打底衫390002</a>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="yuan">￥</span>
                                <span class="integer fw">199</span>
                                <span class="pointer">.</span>
                                <span class="decimal">00</span>
                            </div>
                            <div class="fr hs">
                                月销:123
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="hs">优惠后</span>
                                <span class="yuan jh">￥</span>
                                <span class="integer fw cx jh">66</span>
                                <span class="pointer jh">.</span>
                                <span class="decimal jh">00</span>
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="bt-yhq fh">
                                领取优惠券
                            </div>
                            <div class="bt-yhq tmbuy">
                                去天猫购买
                            </div>
                        </div>
                    </div>
                </div><!-- //item-end -->
                <!-- item begin -->
                <div class="block-search-box">
                    <div class="shop-pic"><img src="http://img04.taobaocdn.com/bao/uploaded/i4/TB1u3I6LXXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_220x220_.webp"></div>
                    <div class="shop-info">
                        <div class="content-line">
                            <a href="javascript:void(0)">春夏新品圆领T恤修身短袖上衣百搭打底衫390002</a>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="yuan">￥</span>
                                <span class="integer fw">199</span>
                                <span class="pointer">.</span>
                                <span class="decimal">00</span>
                            </div>
                            <div class="fr hs">
                                月销:123
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="hs">优惠后</span>
                                <span class="yuan jh">￥</span>
                                <span class="integer fw cx jh">66</span>
                                <span class="pointer jh">.</span>
                                <span class="decimal jh">00</span>
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="bt-yhq fh">
                                领取优惠券
                            </div>
                            <div class="bt-yhq tmbuy">
                                去天猫购买
                            </div>
                        </div>
                    </div>
                </div><!-- //item-end -->

                <!-- item begin -->
                <div class="block-search-box">
                    <div class="shop-pic"><img src="http://img04.taobaocdn.com/bao/uploaded/i4/TB1u3I6LXXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_220x220_.webp"></div>
                    <div class="shop-info">
                        <div class="content-line">
                            <a href="javascript:void(0)">春夏新品圆领T恤修身短袖上衣百搭打底衫390002</a>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="yuan">￥</span>
                                <span class="integer fw">199</span>
                                <span class="pointer">.</span>
                                <span class="decimal">00</span>
                            </div>
                            <div class="fr hs">
                                月销:123
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="hs">优惠后</span>
                                <span class="yuan jh">￥</span>
                                <span class="integer fw cx jh">66</span>
                                <span class="pointer jh">.</span>
                                <span class="decimal jh">00</span>
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="bt-yhq fh">
                                领取优惠券
                            </div>
                            <div class="bt-yhq tmbuy">
                                去天猫购买
                            </div>
                        </div>
                    </div>
                </div><!-- //item-end -->

                <!-- item begin -->
                <div class="block-search-box">
                    <div class="shop-pic"><img src="http://img04.taobaocdn.com/bao/uploaded/i4/TB1u3I6LXXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_220x220_.webp"></div>
                    <div class="shop-info">
                        <div class="content-line">
                            <a href="javascript:void(0)">春夏新品圆领T恤修身短袖上衣百搭打底衫390002</a>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="yuan">￥</span>
                                <span class="integer fw">199</span>
                                <span class="pointer">.</span>
                                <span class="decimal">00</span>
                            </div>
                            <div class="fr hs">
                                月销:123
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="hs">优惠后</span>
                                <span class="yuan jh">￥</span>
                                <span class="integer fw cx jh">66</span>
                                <span class="pointer jh">.</span>
                                <span class="decimal jh">00</span>
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="bt-yhq fh">
                                领取优惠券
                            </div>
                            <div class="bt-yhq tmbuy">
                                去天猫购买
                            </div>
                        </div>
                    </div>
                </div><!-- //item-end -->

                <!-- item begin -->
                <div class="block-search-box">
                    <div class="shop-pic"><img src="http://img04.taobaocdn.com/bao/uploaded/i4/TB1u3I6LXXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_220x220_.webp"></div>
                    <div class="shop-info">
                        <div class="content-line">
                            <a href="javascript:void(0)">春夏新品圆领T恤修身短袖上衣百搭打底衫390002</a>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="yuan">￥</span>
                                <span class="integer fw">199</span>
                                <span class="pointer">.</span>
                                <span class="decimal">00</span>
                            </div>
                            <div class="fr hs">
                                月销:123
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="hs">优惠后</span>
                                <span class="yuan jh">￥</span>
                                <span class="integer fw cx jh">66</span>
                                <span class="pointer jh">.</span>
                                <span class="decimal jh">00</span>
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="bt-yhq fh">
                                领取优惠券
                            </div>
                            <div class="bt-yhq tmbuy">
                                去天猫购买
                            </div>
                        </div>
                    </div>
                </div><!-- //item-end -->

                <!-- item begin -->
                <div class="block-search-box">
                    <div class="shop-pic"><img src="http://img04.taobaocdn.com/bao/uploaded/i4/TB1u3I6LXXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_220x220_.webp"></div>
                    <div class="shop-info">
                        <div class="content-line">
                            <a href="javascript:void(0)">春夏新品圆领T恤修身短袖上衣百搭打底衫390002</a>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="yuan">￥</span>
                                <span class="integer fw">199</span>
                                <span class="pointer">.</span>
                                <span class="decimal">00</span>
                            </div>
                            <div class="fr hs">
                                月销:123
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="fl">
                                <span class="hs">优惠后</span>
                                <span class="yuan jh">￥</span>
                                <span class="integer fw cx jh">66</span>
                                <span class="pointer jh">.</span>
                                <span class="decimal jh">00</span>
                            </div>
                        </div>
                        <div class="content-line">
                            <div class="bt-yhq fh">
                                领取优惠券
                            </div>
                            <div class="bt-yhq tmbuy">
                                去天猫购买
                            </div>
                        </div>
                    </div>
                </div><!-- //item-end -->

            </div><!-- //推荐内容 -->
		</div><!-- 买手推荐系列 end -->


        <!-- 底部 -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!--底部end  -->

        <!-- 侧栏 -->
		<div id="tools">
			<a href="javascript:inputkeydownInit()" title="聊天室"></a>
			<a href="#"></a>
			<a href="#"></a>
			<a href="#" class="back" title="返回顶部"></a>
		</div>
	</div><!-- 重构页面部分 end -->
	<script>
	    $("#tools .back").click(function () {
	        $("body,html").animate({scrollTop: 0}, 1000)
	        return false;
	    })
	</script>
	
	


	<script>
		//添加搜索事件
			document.getElementById("searchA").href="javascript:void(0)";
			document.getElementById("searchA").onclick = readySearch;

	</script>
   
   
   
 
	


	
  
  
  <script>
	//#F4FFC8 淡黄色
		//中心超大屏幕
			var i1 = 0;
			var t1 = 6500;
			var colorarr=[[216,236,250],[225,46,86],[151,2,226],[0,181,143],[212,12,84]];
			//$(".cen_big").css("background-color","rgb("+colorarr[i1][0]+","+colorarr[i1][1]+","+colorarr[i1][2]+")");
			var len1 = $("#banner_li1 li").length;
            //设置0方块颜色为红色
            $(".banner_container31 ul").find('li').eq(0).css("background-color","red");
            //0的图片为block
			$(".banner_container21 ul li:eq(0)").css("display","block");
            /*//添加banner_rect样式
			$(".banner_container31 ul li:eq(0)").addClass("banner_rect");*/
			var interval_i1=setTimeout("myBanner1()",t1);
			$(".banner_container1").hover(
				function(){
					clearInterval(interval_i1);
				},function(){
					interval_i1=setTimeout("myBanner1()",t1);
				}
			);
			$(".banner_container31 ul li").click(
				function(){
					bannerPre1();
					var k=$(this).index();
					i1=k;
					bannerMove1();
				}
			);
			function myBanner1(){
				//$(".cen_big").hide();
				bannerPre1();
				++i1;
				i1%=len1;
			
				//alert(r);
				//$(".cen_big").css("background-color","rgb("+colorarr[i1][0]+","+colorarr[i1][1]+","+colorarr[i1][2]+")");

					//$(".cen_big").slideDown(500);
				
				
				bannerMove1();
				interval_i1=setTimeout("myBanner1()",t1);
			}
			$("#ban_left1").click(
				function(){
					bannerPre1();
					--i1;
					if(i1<0)
						i1=len1-1;
					bannerMove1();
				}
			);
			$("#ban_right1").click(
				function(){
					bannerPre1();
					++i1;
					i1%=len1;
					bannerMove1();
				}
			);
			$("#ban_left1").hover(
				function(){
					$(this).css("background-color","#000");
				},function(){
					$(this).css("background-color","#666");
				}
			);
			$("#ban_right1").hover(
				function(){
					$(this).css("background-color","#000");
				},function(){
					$(this).css("background-color","#666");
				}
			);
			function bannerPre1(){
				$(".banner_container31 ul").find('li').eq(i1).css("background-color","black");	
			}
			function bannerMove1(){
				$(".banner_container31 ul").find('li').eq(i1).css("background-color","red");	
				$(".banner_container21 ul").find('li').hide().eq(i1).slideDown(0);
			}
		
		
	
	</script>

	
</body>
</html>
