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

    <link rel="stylesheet" href="/css/borrow_back.css">
    <%--<link rel="stylesheet" href="/css/body_color.css">--%>
    <script type="text/javascript">
        function checkBorrow(form) {
            if (document.forms.borrow_form.borrow_book_id.value == "" || document.forms.borrow_form.borrow_book_id.value <= 1000 || document.forms.borrow_form.borrow_book_id.value > 3000) {
                alert("请输入图书ID！请输入图书ID！范围在1000~2999");
                document.forms.borrow_form.borrow_book_id.focus();
                return false;
            }
        }
        function checkBack(form) {
            if (document.forms.back_form.back_book_id.value == ""|| document.forms.back_form.back_book_id.value<=1000||document.forms.back_form.back_book_id.value>3000){
                alert("请输入图书ID！范围在1000~2999");
                document.forms.back_form.back_book_id.focus();
                return false
            }
        }

    </script>
</head>
<body bgcolor="#CEE490">

<%
    Users us = (Users) request.getSession().getAttribute("us_info");
    BooksBorrow bb = (BooksBorrow) request.getSession().getAttribute("borrow_book_info");

//    out.println(us.getUserName());
//    out.println(us.getPermi());
//    out.println(us.getList().isEmpty());
//    List<BooksBorrow> list = us.getList();

//    out.println(list.get(1).getUser_id());
//    Iterator it = list.iterator();
//    while (it.hasNext()) {
//        out.println(((BooksBorrow) (it.next())).getId());
//    }

%>

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
    <tr>
        <td><%= help.getId()%>
        </td>
        <td><%= help.getBook_name()%>
        </td>
        <td><%= help.getBorrow_date()%>
        </td>
        <td><%= help.getBack_date()%>
        </td>
    </tr>
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
        <tr  >
            <td  colspan="2" align="center">

                <input type="submit" value="借书" onclick = "return checkBorrow(this)" />

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
                <input type="number" name="back_book_id"  />
            </td>
        </tr>
        <tr>
            <td  colspan="2" align="center">

                <input type="submit" value="还书" onclick="return checkBack(this)"/>


            </td>
        </tr>
    </table>

</form>
</body>
</html>
