<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/25
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <style type="text/css">
        body{
            font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
            font-size: 20px;
            /*align-items: center;*/
        }
    </style>
</head>
<body>
<h1>
<%
    out.println("欢迎你!"+request.getSession().getAttribute("uname")+"<br/>");
%></h1>
<h3>
<%
    out.println("现在时间：");
    out.println(new Date(System.currentTimeMillis()));

%></h3>

</body>
</html>
