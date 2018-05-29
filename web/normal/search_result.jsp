<%@ page import="java.util.List" %>
<%@ page import="com.czdpzc.entity.Books" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/29
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索结果</title>


    <link rel="stylesheet" href="/css/borrow_back.css">
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


<%
    List<Books> list = (List<Books>) (request.getSession().getAttribute("search_book_info"));

//    Iterator test = list.iterator();
//    while (test.hasNext()) {
//        out.println(((Books) (test.next())).getId());
//        test.next();
//    }
%>

<ul>
    <li><a href="<%= request.getContextPath()%>/normal/index_right.jsp"  target = "index_right">返回首页</a></li>
</ul>
<br>

<table id="customers">
    <tr>
        <th colspan="6">搜索图书结果</th>
    </tr>
    <tr>
        <th>book id</th>
        <th>图书名称</th>
        <th>分类</th>
        <th>出版社</th>
        <th>作者</th>
        <th>是否可借</th>
    </tr>

    <%
        if (list.isEmpty()) {
    %>
    <tr>
        <td>无</td>
        <td>无</td>
        <td>无</td>
        <td>无</td>
        <td>无</td>
        <td>无</td>
    </tr>
    <%
    } else {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Books help = (Books) (it.next());
    %>
    <tr>
        <td><%= help.getId()%>
        </td>
        <td><%= help.getBookName()%>
        </td>
        <td><%= help.getBookClass()%>
        </td>
        <td><%= help.getBookPub()%>
        </td>
        <td>
            <%= help.getBookWriter()%>
        </td>
        <td><%
            if (help.isIfBorrow()) {
        %>
            <%= "√"%>
            <%
            } else {
            %>
            <%= "×"%>
            <%
                }
            %>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
