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
    <%--<style type="text/css">--%>
        <%--#customers,#borrowT,#backT--%>
        <%--{--%>
            <%--font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;--%>
            <%--/*width:100%;*/--%>
            <%--border-collapse:collapse;--%>
        <%--}--%>

        <%--#customers td, #customers th, #borrowT th, #backT th--%>
        <%--{--%>
            <%--font-size:1em;--%>
            <%--border:1px solid #98bf21;--%>
            <%--padding:3px 7px 2px 7px;--%>
        <%--}--%>

        <%--#customers th--%>
        <%--{--%>
            <%--font-size:1.1em;--%>
            <%--text-align:left;--%>
            <%--padding-top:5px;--%>
            <%--padding-bottom:4px;--%>
            <%--background-color:#A7C942;--%>
            <%--color:#ffffff;--%>
        <%--}--%>

        <%--#borrowT {--%>
            <%--position: relative;--%>
            <%--left:+20px;--%>
            <%--top: +20px;--%>
            <%--box-shadow: 2px 2px 9px 0px black;--%>
        <%--}--%>
        <%--#backT {--%>
            <%--position: relative;--%>
            <%--left:+20px;--%>
            <%--top: +20px;--%>
            <%--box-shadow: 2px 2px 9px 0px black;--%>
        <%--}--%>



    <%--</style>--%>
    <link rel="stylesheet" href="/css/borrow_back.css">
    <script type="text/javascript">
        function check(form) {
            if (document.forms.borrow_form.borrow_book_id.value==""){
                alert("请输入图书ID！");
                document.forms.borrow_form.borrow_book_id.focus();
                return false;
            }
        }
    </script>
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

<%--<table id="customers"align="center" border = "1" bordercolor = "silver" cellpadding="5" cellspacing="0">--%>
    <%--<tr>--%>
        <%--<td bgcolor="#faebd7">name</td>--%>
        <%--<td colspan="4" align="left"><%= us.getUserName()%>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td bgcolor="#faebd7">id</td>--%>
        <%--<td colspan="4" align="left"><%= us.getId()%>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td bgcolor="#faebd7">permission</td>--%>
        <%--<td colspan="4" align="left"><%= us.getPermi()%>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td rowspan="0">借阅图书情况</td>--%>
        <%--<td>book id</td>--%>
        <%--<td>book name</td>--%>
        <%--<td>借阅日期</td>--%>
        <%--<td>应归还日期</td>--%>
    <%--</tr>--%>
<table id="customers">
    <tr>
        <th >name</th>
        <td colspan="4" ><%= us.getUserName()%>
        </td>
    </tr>
    <tr>
        <th >id</th>
        <td colspan="4"><%= us.getId()%>
        </td>
    </tr>
    <tr>
        <th >permission</th>
        <td colspan="4"><%= us.getPermi()%>
        </td>
    </tr>
    <tr>
        <th rowspan="0">借阅图书情况</th>
        <th>book id</th>
        <th>book name</th>
        <th>借阅日期</th>
        <th>应归还日期</th>
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

<form action="<%= request.getContextPath()%>/BorrowServlet" name = "borrow_form">

 <table  id="borrowT"  border = "1" bordercolor = "silver" cellpadding = "5" cellspacing = "0">
     <tr align="center">
         <th colspan="2">借书</th>
     </tr>
     <tr>
            <td align="left">图书ID：</td>
            <td>
                <input type="number" name="borrow_book_id"  />
            </td>
        </tr>
        <tr  bgcolor="#faebd7">
            <td  colspan="2" align="center">

                <input type="submit" value="借书" onclick = "return check(this)" />

            </td>
        </tr>
    </table>

</form>

<form action="<%= request.getContextPath()%>/BackServlet" name = "back_form">
    <table id="backT"  border = "1" bordercolor = "silver" cellpadding = "5" cellspacing = "0">
        <tr align="center">
            <th colspan="2">还书</th>
        </tr>
        <tr>
            <td align="left">图书ID：</td>
            <td>
                <input type="number" name="book_back_id"  />
            </td>
        </tr>
        <tr  bgcolor="#faebd7">
            <td  colspan="2" align="center">

                <input type="submit" value="还书"/>


            </td>
        </tr>
    </table>

</form>
</body>
</html>
