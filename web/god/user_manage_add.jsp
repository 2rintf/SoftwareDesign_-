<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/28
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息添加</title>
    <link rel="stylesheet" href="/css/borrow_back.css"/>

    <script type="text/javascript">
        function checkAddBook(form) {
            if (document.forms.addUserForm.in_user_name.value==""){
                alert("请完整填写姓名！！！");
                document.forms.addBookForm.in_user_name.focus();

                return false;
            }else  if (document.forms.addUserForm.class_choose.value==""){
                alert("请选择身份权限！！！");
                return false;

            }else
                return true;

        }
    </script>
</head>
<body bgcolor="#CEE490">

<form action="<%= request.getContextPath()%>/AddUserServlet" method="post" name="addUserForm">


    <table id="customers" align="center">
        <tr align="center" >
            <th  colspan="2">
                添加用户
            </th>

        </tr>
        <tr>
            <th>
                姓名：
            </th>
            <td>
                <input type="text" name="in_user_name">
            </td>
        </tr>


        <tr>
            <th>
                身份权限：
            </th>
            <td>
                <input type="radio" name="class_choose" value="stu"/>学生
                <input type="radio" name="class_choose" value="tea"/>老师<br>
                <input type="radio" name="class_choose" value="rcp"/>柜台管理
                <input type="radio" name="class_choose" value="god"/>后台管理<br>
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
