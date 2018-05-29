<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/29
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link rel="stylesheet" href="/css/borrow_back.css">
    <%--<link rel="stylesheet" href="/css/body_color.css">--%>
    <script type="text/javascript">
        function checkPassword(form) {
            if (document.forms.getPasswordForm.new_password_1.value == document.forms.getPasswordForm.new_password_2.value) {

                return true;
            }else{
                alert("再次输入的新密码不同！！！");
                return false;
            }
        }

    </script>
    <link rel="stylesheet" href="/css/borrow_back.css">



</head>
<body bgcolor="#CEE490">
<form action = "<%= request.getContextPath()%>/ModifyPasswordServlet" method = "post" name = "getPasswordForm">
    <table id = "borrowT">
        <tr>
            <th colspan="2" align="center">
                密码修改
            </th>
        </tr>
        <%--<tr>--%>
            <%--<td align="left">旧密码：</td>--%>
            <%--&lt;%&ndash;限定了输入的学号范围&ndash;%&gt;--%>
            <%--<td>--%>
                <%--<input type="password" name="old_password"  />--%>
            <%--</td>--%>
        <%--</tr>--%>
        <tr>
            <th align="left">新密码：</th>
            <td>
                <input type="password" name="new_password_1"  />
            </td>
        </tr>
        <tr>
            <th align="left">再次确认新密码：</th>
            <td>
                <input type="password" name="new_password_2"  />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="确认" value="确认" onclick = "return checkPassword(this)" />
                <input type="reset" name="重置" value="重置"/>
            </td>
        </tr>


    </table>

</form>
</body>
</html>
