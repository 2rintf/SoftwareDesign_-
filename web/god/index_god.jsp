<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/24
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
</head>
<body>
这是后台管理员页面。<br/>
<%
    String flag="";
    Object obj = session.getAttribute("flag");

    if (obj != null){
        flag = obj.toString();
    }
    if (flag.equals("login_success_god")){
%>
<a href="<%= request.getContextPath()%>/LogoutServlet17">退出</a>
<%
}
else{
%>
<a href="<%= request.getContextPath()%>/15/login.jsp">登陆</a>
<%

    }
%>
</body>
</html>
