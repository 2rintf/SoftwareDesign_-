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

    <link rel="stylesheet" href="/css/borrow_back.css">
    <%--<link rel="stylesheet" href="/css/login_layout.css">--%>
    <style type="text/css">
        #login_title{
            font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
            /*width:100%;*/
            border-collapse:collapse;
            font-size:30px;
            margin:auto;
            text-align:-webkit-center;
            color:coral
        }
        #author{
            font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
            /*width:100%;*/
            border-collapse:collapse;
            font-size:15px;
            margin:auto;
            text-align: -webkit-center;
            color:coral

        }

    </style>


    <title>login</title>

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
<body bgcolor="#CEE490">

<br>
<div id="login_title">
    图书管理系统
</div>
<br>

<form action="<%= request.getContextPath()%>/CheckServlet" method="post" name="loginForm">

    <table  id="loginTable" align="center" border = "1" bordercolor = "#E4F2C1" cellpadding = "5" cellspacing = "0">
        <tr>
            <th colspan="2"align="center" bgcolor="#A7C942">
                用户登陆
            </th>
        </tr>
        <tr>
            <th bgcolor="#A7C942">用户名：</th>
            <td><input type="text" name = "login_id"/> </td>

        </tr>
        <tr >
            <th bgcolor="#A7C942">密码：</th>
            <td><input type = "password" name = "upwd"/></td>
        </tr>
        <tr >
            <td colspan="2"align="center" bgcolor="#A7C942">
                <input type ="submit" name="submit" onclick="return check(this);"/>
                <input type="reset" name="reset" />
            </td>
        </tr>

    </table>

</form>

<div id="author">
    by czd B15011925
</div>
</body>
</html>
