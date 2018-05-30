<%@ page import="com.czdpzc.entity.Users" %>
<%@ page import="com.czdpzc.entity.BooksBorrow" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/27
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/borrow_back.css">
    <script type="text/javascript">
        function check(form) {
            if (document.forms.borrow_form.borrow_book_id.value==""||document.forms.borrow_form.borrow_book_id.value<=1000||document.forms.borrow_form.borrow_book_id.value>3000){
                alert("请输入图书ID！请输入图书ID！范围在1000~2999");
                document.forms.borrow_form.borrow_book_id.focus();
                return false;
            }else if (document.forms.back_form.back_book_id.value == ""|| document.forms.back_form.back_book_id.value<=1000||document.forms.back_form.back_book_id.value>3000){
                alert("请输入图书ID！范围在1000~2999");
                document.forms.back_form.back_book_id.focus();
            }
        }
    </script>
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
            <th >bill</th>
            <td colspan="4"><%= us.getBill()%>
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
    <br>

    <ul>
    <li><a href="<%= request.getContextPath()%>/normal/index_right.jsp"  target = "index_right">返回首页</a></li>
    </ul>
</body>
</html>
