<%@ page import="com.czdpzc.entity.Books" %><%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/28
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/borrow_back.css"/>

    <script type="text/javascript">
        function checkAddBook(form) {
            if (document.forms.addBookForm.in_book_name.value==""){
                alert("请完整填写入库图书名称！！！");
                document.forms.addBookForm.in_book_name.focus();

                return false;
            }else  if (document.forms.addBookForm.in_book_writer.value==""){
                alert("请完整填写作者！！！");
                document.forms.addBookForm.in_book_writer.focus();
                return false;

            }else if (document.forms.addBookForm.class_choose.value==""){

                alert("请选择图书分类！！！"+ document.forms.addBookForm.class_choose.value);
                // document.forms.addBookForm.class_choose.focus();
                return false;

            }else if (document.forms.addBookForm.in_book_pub.value==""){
                alert("请完整填写出版社！！！");
                document.forms.addBookForm.in_book_pub.focus();
                return false;
            }else
                return true;

        }
    </script>
</head>
<body bgcolor="#CEE490">

<form action="<%= request.getContextPath()%>/AddBookServlet" method="post" name="addBookForm">


    <table id="customers" align="center">
        <tr align="center" >
            <th  colspan="2">
                新书入库
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
                <input type="submit" name="确认" value="确认" onclick = "return checkAddBook(this)" />
                <input type="reset" name="重置" value="重置"/>
            </td>
        </tr>
    </table>

</form>


</body>
</html>
