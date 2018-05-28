<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/23
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <%--<link href="/css/login_layout.css" rel="stylesheet" type="text/css">--%>

    <script type="text/javascript">
        function check(form) {
            if (document.forms.loginForm.login_id.value==""||document.forms.loginForm.login_id.value<2018010000||document.forms.loginForm.login_id.value>2018109999){
                alert("请输入正确的ID");
                document.forms.loginForm.uname.focus();
                return false;
            }

            if (document.forms.loginForm.upwd.value==""){
                alert("请输入密码");
                document.forms.loginForm.upwd.focus();
                return false;
            }
        }
    </script>
</head>
<body>


<form action="<%= request.getContextPath()%>/CheckServlet" method="post" name="loginForm">

    <table align="center" border = "1" bordercolor = "silver" cellpadding="5" cellspacing="0" >
        <tr>
            <td colspan="2"align="center" bgcolor="#f0ffff">
                用户登陆
            </td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name = "login_id"/> </td>

        </tr>
        <tr >
            <td>密码：</td>
            <td><input type = "password" name = "upwd"/></td>
        </tr>
        <tr bgcolor="#faebd7">
            <td colspan="2"align="center">
                <input type ="submit" name="submit" onclick="return check(this);"/>
                <input type="reset" name="reset" />
            </td>
        </tr>

    </table>

</form>
</body>
</html>
