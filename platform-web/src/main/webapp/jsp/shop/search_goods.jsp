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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shop/shopGoods.css">

    <title>第一买手街</title>
<style type="text/css">
	.ljj_container{height:100%;}
</style>
</head>
<body>

<div class="ljj_container">
	<!-- 顶部浮动导航 -->
	<jsp:include page="head_nav.jsp"></jsp:include>
	<!-- //顶部浮动导航 -->
</div><!-- ljj_container -->

	
	
<!-- 重构页面部分 -->
<div id="refactorpage" style="    position: relative;top: 60px;">
	<style>

	</style>
	<!-- 当前位置 -->
	<div class="location_item">
		所有商品 > 共 <span id="goods_num">${total}</span> 件商品
	</div>
	<style>


	</style>

	<!-- 条件搜索栏部分 -->
	<div class="query_item">
		<div class="qi_left">
			女装：
		</div>
		<div class="qi_right">
			<ul>
				<li>男子跑步鞋</li>
				<li>男子跑步鞋</li>
				<li>男子跑步鞋</li>
				<li>男子跑步鞋</li>

			</ul>
		</div>
	</div><!-- //query-item -->
	<!-- 条件搜索栏部分 -->
	<div class="query_item">
		<div class="qi_left">
			女装：
		</div>
		<div class="qi_right">
			<ul>
				<li>男子跑步鞋</li>
				<li>男子跑步鞋</li>
				<li>男子跑步鞋</li>
				<li>男子跑步鞋</li>

			</ul>
		</div>
	</div><!-- //query-item -->
	<!-- 排序条件选择 -->
	<style>

	</style>
	<div class="orderby-item">
		<ul>
			<li>默认排序</li>
		<%--	<li>人气</li>
			<li>价格</li>--%>
		</ul>
	</div>


	<!-- 买手推荐系列 -->
	<div class="mytj">
		<style>

		</style>
		<!-- 推荐内容 -->
		<div class="search-box-result">
            <c:forEach items="${goodsList}" var="i">
			<!-- item begin -->
			<div class="block-search-box">
				<a href="${i.goodsUrl}">
                <div class="shop-pic"><img src="${i.picUrl}"></div>
				<div class="shop-info">
					<div class="content-line">
						<a href="javascript:void(0)" alt="${i.name}">${i.name}</a>
					</div>
					<div class="content-line">
						<div class="fl">
							<span class="yuan">￥</span>
							<span class="integer fw">${fn:split(i.oriPrice,".")[0]}</span>
							<span class="pointer">.</span>
							<span class="decimal">${fn:split(i.oriPrice,".")[1]}</span>
						</div>
						<div class="fr hs">
							月销:${i.sales}
						</div>
					</div>
					<div class="content-line">
						<div class="fl">
							<span class="hs">优惠后</span>
							<span class="yuan jh">￥</span>
							<span class="integer fw cx jh">${fn:split(i.currentPrice,".")[0]}</span>
							<span class="pointer jh">.</span>
							<span class="decimal jh">${fn:split(i.currentPrice,".")[1]}</span>
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
                </a>
			</div><!-- //item-end -->
            </c:forEach>
			<%--<!-- item begin -->
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
--%>

		</div>

        <!-- 分页 -->
        <style>
            .pagination-shop{
                list-style-type: none;
                position:relative;
                margin: 30px auto;
                width: 1000px;
                text-align: center;
            }
            .pagination-shop .item{
                display: inline-block;
                border: 1px solid #eee6e6;
                padding: 5px;
                cursor: pointer;
                min-width: 30px;
                min-height: 25px;
                line-height: 25px;
                color:#5e5c5c;
            }

            .pagination-shop .item:hover{
                background-color:#f46;
                color:#f3f3f3;
            }
            .pagination-shop .cur{
                background-color:#f46;
                color:#f3f3f3 !important;
            }
            .pagination-shop .disabled{
                color:#e8e8e8 !important;
            }
            .pagination-shop .disabled{
                background-color:#ffffff !important;
            }

        </style>
        <div class="pagination-shop">
            <%
                int pageNo = (Integer)request.getAttribute("pageNo");
                int pageSize = (Integer)request.getAttribute("pageSize");
                int max = (Integer)request.getAttribute("max");
            %>
            <%
                if(pageNo <= 1){
            %>
                <a class="item disabled" href="javascript:void(0)">&lt;</a>
            <%
                }else{
            %>
                <a href="${pageContext.request.contextPath}/seachGoodsByName.do?p=${p}&pageNo=${pageNo-1}" class="item">&lt;</a>
            <%
                }
            %>
            <%
                int i = (pageNo - 2) < 1 ? 1 : (pageNo - 2),limit = i + 2;

                for( ;i<=max&&i<limit;i++){
                     if(pageNo == i){
            %>
            <a href="${pageContext.request.contextPath}/seachGoodsByName.do?p=${p}&pageNo=<%=i%>" class="item cur"><%=i%></a>
            <%
                     }else{
            %>
            <a href="${pageContext.request.contextPath}/seachGoodsByName.do?p=${p}&pageNo=<%=i%>" class="item"><%=i%></a>
            <%
                    }
                }

                if( i < max){
            %>
            <a href="javascript:void(0)" class="item disabled"><%=max%></a>
            <a href="${pageContext.request.contextPath}/seachGoodsByName.do?p=${p}&pageNo=<%=max%>" class="item"><%=max%></a>
            <%
                }
            %>

            <%
                if(pageNo >= max){
            %>
            <a href="javascript:void(0)" class="item disabled">&gt;</a>
            <%
                }else{
            %>
            <a href="${pageContext.request.contextPath}/seachGoodsByName.do?p=${p}&pageNo=${pageNo+1}" class="item">&gt;</a>
            <%
                }
            %>

        </ul>
        <!--//分页 -->

	</div><!-- 买手推荐系列end -->



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
	
</body>
</html>