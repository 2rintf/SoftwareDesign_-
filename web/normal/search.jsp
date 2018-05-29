<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/25
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书搜索</title>
    <link rel="stylesheet" href="/css/borrow_back.css"/>


</head>
<body bgcolor="#CEE490">

<form action="<%= request.getContextPath()%>/SearchBookServlet" method="post" name="searchBookForm">


    <table id="customers" align="center">
        <tr align="center" >
            <th  colspan="2">
                图书搜索
            </th>

        </tr>
        <tr>
            <th>
                图书名称：
            </th>
            <td>
                <input type="text" name="in_book_name">
            </td>
        </tr>

        <tr>
            <th>
                作者：
            </th>
            <td>
                <input type="text" name="in_book_writer">
            </td>
        </tr>

        <tr>
            <th>
                图书分类：
            </th>
            <td>
                <input type="radio" name="class_choose" value="文学"/>文学
                <input type="radio" name="class_choose" value="计算机"/>计算机<br>
                <input type="radio" name="class_choose" value="经济"/>经济
                <input type="radio" name="class_choose" value="数理科学&化学"/>数理科学、化学<br>
                <input type="radio" name="class_choose" value="政治&法律"/>政治、法律
                <input type="radio" name="class_choose" value="综合性图书"/>综合性图书
            </td>
        </tr>

        <tr>
            <th>
                出版社：
            </th>
            <td>
                <input type="text" name="in_book_pub">
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" name="确认" value="确认" onclick = "return checkSearchBook(this)" />
                <input type="reset" name="重置" value="重置"/>
            </td>
        </tr>
    </table>

</form>
</body>
</html>
