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


<%
    String flag="";
    Object obj = session.getAttribute("flag");

    if (obj != null){
        flag = obj.toString();
    }
    if (flag.equals("login_success_god")){
%>

<%--<frameset rows = "20%,*">--%>
    <%--<frame src = "/god/index_top.jsp">--%>
    <%--<frameset cols="10%,*">--%>
        <%--<frame src = "/god/index_left.jsp">--%>
        <%--<frame src = "/god/index_right.jsp" name="index_right">--%>
    <%--</frameset>--%>
<%--</frameset>--%>

<frameset cols="10%,*,10%" frameborder = "no">

    <frame>
    <frameset rows = "20%,*">
        <frame src="/god/index_top.jsp" noresize="noresize" >
        <frameset cols="10%,*">
            <frame src="/god/index_left.jsp">
            <frame src="/god/index_right.jsp" name="index_right" noresize="noresize">
        </frameset>

    </frameset>

    <frame>
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
