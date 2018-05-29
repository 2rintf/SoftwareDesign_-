<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/29
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改成功</title>
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

<h3>修改成功！</h3>
<ul>
    <li><a href="<%= request.getContextPath()%>/normal/index_right.jsp"  target = "index_right">返回首页</a></li>
</ul>
</body>
</html>
