<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/23
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login success</title>

    <style type="text/css">
        body{
            color: #000;
            font-size: 14px;
            margin: 20px auto;
        }
        #message{
            text-align: center;
        }
    </style>

</head>
<body>
<div id = "message">
    login success!<BR>
    submit info:<br>
    用户名：<%= request.getParameter("uname")%><br>
    密码：<%= request.getParameter("upwd")%><br>
    <a href="/15/login.jsp">返回登陆界面</a>
</div>


</body>
</html>
