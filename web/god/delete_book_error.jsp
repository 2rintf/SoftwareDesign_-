<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/29
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
删除失败！库中没有这本书的记录！<br>
<ul>
    <li><a href="<%= request.getContextPath()%>/god/book_manage_delete.jsp"  target = "index_right">继续旧书退库</a><br/></li>
    <li><a href="<%= request.getContextPath()%>/god/index_right.jsp"  target = "index_right">返回首页</a><br/></li>
</ul>

</body>
</html>
