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
</head>
<body>
<%
    out.println("欢迎你!"+request.getSession().getAttribute("uname")+"<br/>");
    out.println("现在时间：");
    out.println(new Date(System.currentTimeMillis()));

%>

</body>
</html>
