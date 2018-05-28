<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/28
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/borrow_back.css">
</head>
<body>
<form action="">
    <table id="customers" align="center">
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
                <input type="checkbox" name="class_choose" value="文学"/>文学
                <input type="checkbox" name="class_choose" value="计算机"/>计算机
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

    </table>
</form>

</body>
</html>
