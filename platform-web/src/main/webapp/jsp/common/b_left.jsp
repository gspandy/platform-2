<%@page language="java" pageEncoding="utf-8" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/25
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<ul class="v-menu subdown block-shadow-impact min-size-required myheight" style="border-top:0px !important;">
    <li class="active" to="main.jsp"><a href="javascript:void(0)"><span class="mif-home"></span>  主页</a></li>
    <li class="divider"></li>
    <li to="userList.jsp"><a href="javascript:void(0)"><span class="mif-user"></span> 用户管理</a></li>
    <li to="studentList.jsp"><a href="javascript:void(0)"><span class="mif-users"></span> 学生管理</a></li>
    <li to="orderList.jsp"><a href="javascript:void(0)"><span class="mif-truck"></span> 订单管理</a></li>
    <li class="divider"></li>
    <li class="">
        <a href="javascript:void(0)" class="dropdown-toggle"><span class="mif-shop"></span> 商品管理</a>
        <ul class="d-menu" data-role="dropdown" style="display: none;">
            <li to="goodsList.jsp"><a href="javascript:void(0)">子1</a></li>
            <li><a href="javascript:void(0)">子2</a></li>
        </ul>
    </li>
    <li to="contactUs.jsp"><a href="javascript:void(0)"><span class="mif-bubble"></span> 关于我们</a></li>
</ul>
