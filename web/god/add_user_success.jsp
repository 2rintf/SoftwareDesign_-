<%@ page import="com.czdpzc.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/28
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新用户成功</title>
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
        <th rowspan="0">添加新用户情况</th>
        <th>用户Id</th>
        <th>姓名</th>
        <th>身份权限</th>
        <th>密码</th>
    </tr>
    <tr>
        <%
            Users users = new Users();
            users = (Users) (request.getSession().getAttribute("add_user_info"));
        %>

        <td><%= users.getId()%></td>
        <td><%= users.getUserName()%></td>
        <td><%= users.getPermi()%></td>
        <td><%= users.getPassWord()%></td>

    </tr>
</table>
<br>

<ul>
    <li><a href="<%= request.getContextPath()%>/god/user_manage.jsp"  target = "index_right">继续添加</a></li>
    <li><a href="<%= request.getContextPath()%>/god/index_right.jsp"  target = "index_right">返回首页</a></li>
</ul>
</body>
</html>
