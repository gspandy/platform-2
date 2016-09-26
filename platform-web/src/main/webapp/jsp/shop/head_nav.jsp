<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="top_nav">
    <div class="top_nav1">
        <ul>
            <li style="color:#FF3300;">
                <a href="javascript:void(0)">待惠购,欢迎您!</a>
            </li>
        </ul>
    </div>
    <div style="clear:both;"></div>
</div>


<!-- 搜索框 -->
<div id="search_bg" onclick="searchBg(this)" style="position:absolute;z-index:1;left:0px;top:0px;height:1000px;width:1360px;display:none;">
</div>
<div style="clear:both;"></div>
<!-- logo图 -->
<div class="head_search">
    <center>
        <div id="h_search" class = "h_search">
            <div id="searchout" class = "search">
                <input type = "text" class = "s_text" id="searchInput" value ="" placeholder="搜索下你感兴趣的东西吧"  />
                <a id="searchA" href="">
                    <i></i>
                </a>
                <!-- 模仿百度提示框搜索 -->
                <div id="search_box" class="search_box">

                </div>
            </div>
        </div>
    </center>
</div>
<!-- 横导航栏 -->
<div class ="head_nav">
    <div class = "wrap">
        <div class = "nav_1">
            <ul>
                <li><a href = "${pageContext.request.contextPath}/index.html" class = "on">天猫购物</a></li>
                <li><a href = "${pageContext.request.contextPath}/index.html" >淘宝购物</a></li>
                <%--<li><a href = "#">服饰</a></li>
                <li><a href = "#">搭配</a></li>
                <li><a href = "#">达人</a></li>
                <li><a href = "#">美装</a></li>
                <li><a href = "#">团购</a></li>
                <li><a href = "#">新款</a></li>
                <li><a href = "#">名店</a></li>--%>
                <div style="clear:both;"></div>
            </ul>
        </div>
    </div>
</div>
<!--//横导航栏 -->
<div style="clear:both"></div>


