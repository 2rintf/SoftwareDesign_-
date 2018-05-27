<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/24
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书馆首页</title>
</head>

<%
    String flag="";
    Object obj = session.getAttribute("flag");

    if (obj != null){
        flag = obj.toString();
    }
    if (flag.equals("login_success_normal")){
%>

<frameset rows = "20%,*">
    <frame src = "/normal/index_top.jsp">
    <frameset cols="10%,*">
        <frame src = "/normal/index_left.jsp">
        <frame src = "/normal/index_right.jsp" name="index_right">
    </frameset>
</frameset>




<%
}
else{
%>
<a href="<%= request.getContextPath()%>/15/login.jsp" target="_top">登陆</a><br/>
<%

    }
%>

</html>
