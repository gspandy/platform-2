<%@page language="java" pageEncoding="utf-8" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/25
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<ul class="m-menu block-shadow-impact">
    <li class="place-right" style="width:100px;">
        <a href="#" class="dropdown-toggle"><span class="mif-exit mif-2x"></span></a>
        <ul class="d-menu" data-role="dropdown" style="display: none;right:0px;width:100px;">
            <li><a href="${pageContext.request.contextPath}/busness/logout">注销</a></li>
        </ul>
    </li>
</ul>
