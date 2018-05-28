<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/25
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>图书后台管理</title>
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
<ul>
<li><a href="<%= request.getContextPath()%>/god/book_manage_add.jsp"  target = "index_right">新书入库</a></li>
<li><a href="<%= request.getContextPath()%>/god/book_manage_delete.jsp"  target = "index_right">旧书退库</a></li>
</ul>

</body>
</html>
