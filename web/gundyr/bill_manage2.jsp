<%@ page import="com.czdpzc.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/30
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/borrow_back.css">
    <%--<link rel="stylesheet" href="/css/body_color.css">--%>
</head>
<body bgcolor="#CEE490">

    <%
    Users us = (Users) request.getSession().getAttribute("bill_us_info");


%>

    <form action="<%= request.getContextPath()%>/BillServlet" name="borrow_form">
        <table id="customers">
            <tr>
                <th>姓名</th>
                <td colspan="4"><%= us.getUserName()%>
                </td>
            </tr>
            <tr>
                <th>id</th>
                <td colspan="4"><%= us.getId()%>
                </td>
            </tr>
            <tr>
                <th>身份</th>
                <td colspan="4"><%= us.getPermi()%>
                </td>
            </tr>
            <tr>
                <th>欠款</th>
                <td colspan="4"><%= us.getBill()%>
                </td>
            </tr>
            <%
                request.getSession().setAttribute("bill_us_info", us);
            %>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="欠款清零"/>
                </td>
            </tr>

        </table>
    </form>

</html>
