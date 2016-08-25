<%@page language="java" pageEncoding="utf-8" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/25
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<ul class="v-menu subdown block-shadow-impact min-size-required myheight" style="border-top:0px !important;">
    <li><a href="#"><span class="mif-home"></span>  主页</a></li>
    <li class="divider"></li>
    <li class="active"><a href="#"><span class="mif-users"></span> 用户管理</a></li>
    <li><a href="#"><span class="mif-truck"></span> 订单管理</a></li>
    <li class="divider"></li>
    <li class="">
        <a href="#" class="dropdown-toggle"><span class="mif-shop"></span> 商品管理</a>
        <ul class="d-menu" data-role="dropdown" style="display: none;">
            <li><a href="#">子1</a></li>
            <li><a href="#">子2</a></li>
        </ul>
    </li>
    <li class="">
        <a href="#" class="dropdown-toggle"><span class="mif-shop"></span> 商品管理</a>
        <ul class="d-menu" data-role="dropdown" style="display: none;">
            <li><a href="#">子1</a></li>
            <li><a href="#">子2</a></li>
        </ul>
    </li>
    <li><a href="#"><span class="mif-bubble"></span> 关于我们</a></li>
</ul>
