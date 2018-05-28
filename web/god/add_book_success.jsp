<%@ page import="com.czdpzc.entity.Books" %><%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/28
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新书入库成功</title>

    <link rel="stylesheet" href="/css/borrow_back.css"/>
    <style type="text/css">
        ul{
            list-style-type:none;
            margin: 0;
            padding:0;
            overflow:hidden;
        }
        li
        {
            float: left;
        }
        a:link,a:visited
        {
            display:block;
            width:120px;
            font-weight:bold;
            color:#FFFFFF;
            background-color:#bebebe;
            text-align:center;
            padding:4px;


            text-decoration:none;
            text-transform:uppercase;
        }
        a:hover,a:active
        {
            background-color:#cc0000;
        }
    </style>
</head>
<body bgcolor="#CEE490">

<table id="customers">
    <tr>
        <th rowspan="0">入库图书情况</th>
        <th>图书Id</th>
        <th>图书名称</th>
        <th>图书分类</th>
        <th>作者</th>
        <th>出版社</th>
    </tr>
    <tr>
        <%
            Books books = new Books();
            books = (Books) (request.getSession().getAttribute("add_book_info"));
        %>

        <td><%= books.getId()%></td>
        <td><%= books.getBookName()%></td>
        <td><%= books.getBookClass()%></td>
        <td><%= books.getBookWriter()%></td>
        <td><%= books.getBookPub()%></td>

    </tr>
</table>
<br>

<ul>
    <li><a href="<%= request.getContextPath()%>/god/book_manage.jsp"  target = "index_right">继续添加</a></li>
    <li><a href="<%= request.getContextPath()%>/god/index_right.jsp"  target = "index_right">返回首页</a></li>
</ul>
</body>
</html>
