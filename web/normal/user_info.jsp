<%@ page import="com.czdpzc.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/25
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="/css/borrow_back.css"/>

</head>
<body bgcolor="#CEE490">
<form action = "<%= request.getContextPath()%>/GetUserInfoServlet" method = "post" name = "getUserInfoForm">
    <h2>对以下用户进行查询吗？</h2>
    <%--<table id="customers">--%>
        <%--<tr>--%>
            <%--<td><%= ((Users)(request.getSession().getAttribute("user_login"))).getId()%></td>--%>
            <%--<td><%= ((Users)(request.getSession().getAttribute("user_login"))).getUserName()%></td>--%>
        <%--</tr>--%>
        <%--<tr  bgcolor="#faebd7" align="center">--%>
            <%--<td colspan = "2"><input type="submit" value="是的，进行查询" /></td>--%>
        <%--</tr>--%>
    <%--</table>--%>

    <fieldset>
        <legend>查询用户信息</legend>
        ID: <%= ((Users)(request.getSession().getAttribute("user_login"))).getId()%><br>
        姓名：<%= ((Users)(request.getSession().getAttribute("user_login"))).getUserName()%><br>
    </fieldset>
    <input align="center" type="submit" value="是的，进行查询" />


</form>
</body>
</html>
