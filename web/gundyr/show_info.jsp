<%@ page import="com.czdpzc.entity.Users" %>
<%@ page import="com.czdpzc.entity.Books" %>
<%@ page import="com.czdpzc.entity.BooksBorrow" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/25
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<%
    Users us = (Users) request.getSession().getAttribute("us_info");
//    BooksBorrow bb = (BooksBorrow) request.getSession().getAttribute("borrow_book_info");

//    out.println(us.getUserName());
//    out.println(us.getPermi());
//    out.println(us.getList().isEmpty());
//    List<BooksBorrow> list = us.getList();
//    Iterator it = list.iterator();
//    while (it.hasNext()) {
//        out.println(((BooksBorrow) (it.next())).getId());
//    }

%>

<table align="center" border = "1" bordercolor = "silver" cellpadding="5" cellspacing="0">
    <tr>
        <td bgcolor="#faebd7">name</td>
        <td colspan="4" align="left"><%= us.getUserName()%>
        </td>
    </tr>
    <tr>
        <td bgcolor="#faebd7">id</td>
        <td colspan="4" align="left"><%= us.getId()%>
        </td>
    </tr>
    <tr>
        <td bgcolor="#faebd7">permission</td>
        <td colspan="4" align="left"><%= us.getPermi()%>
        </td>
    </tr>
    <tr>
        <td rowspan="0">借阅图书情况</td>
        <td>book id</td>
        <td>book name</td>
        <td>借阅日期</td>
        <td>应归还日期</td>
    </tr>

    <%
        if (us.getList().isEmpty()) {
    %>
    <tr>
        <td>无</td>
        <td>无</td>
        <td>无</td>
        <td>无</td>
    </tr>
    <%
    } else {
        Iterator it = us.getList().iterator();
        while (it.hasNext()) {
            BooksBorrow help = (BooksBorrow) (it.next());
    %>
    <td><%= help.getId()%>
    </td>
    <td><%= help.getBook_name()%>
    </td>
    <td><%= help.getBorrow_date()%>
    </td>
    <td><%= help.getBack_date()%>
    </td>
    <%
        }
        }
    %>

</table>

</body>
</html>
