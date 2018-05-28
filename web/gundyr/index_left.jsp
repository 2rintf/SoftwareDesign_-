<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/25
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/left_layout.css">
</head>
<body bgcolor="#A7C942">
<ul>
    <li><a href="<%= request.getContextPath()%>/gundyr/index_right.jsp"  target = "index_right">首页</a></li>
    <li><a href="<%= request.getContextPath()%>/gundyr/borrowback.jsp" target="index_right">借/还书管理</a></li>
    <li><a href="<%= request.getContextPath()%>/gundyr/bill_manage.jsp" target="index_right">欠款管理</a></li>
    <li><a href="<%= request.getContextPath()%>/LogoutServlet17" target="_top">退出</a></li>
</ul>


</body>
</html>
