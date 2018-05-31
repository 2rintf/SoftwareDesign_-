<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/24
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>柜台管理首页</title>
    <style type="text/css">
        ul{
            list-style-type:none;
            margin: 0;
            padding:0;
            overflow:hidden;
        }
        li
        {
            float: left;
        }
        a:link,a:visited
        {
            display:block;
            width:120px;
            font-weight:bold;
            color:#FFFFFF;
            background-color:#bebebe;
            text-align:center;
            padding:4px;


            text-decoration:none;
            text-transform:uppercase;
        }
        a:hover,a:active
        {
            background-color:#cc0000;
        }
    </style>

</head>
<%--<body>--%>

<%--这是柜台管理首页。<br/>--%>
<%
    String flag="";
    Object obj = session.getAttribute("flag");

    if (obj != null){
        flag = obj.toString();
    }
    if (flag.equals("login_success_gundyr")){
%>

<%--<frameset rows = "20%,*">--%>
    <%--<frame src = "/gundyr/index_top.jsp" noresize="noresize">--%>
    <%--<frameset cols="10%,*">--%>
        <%--<frame src = "/gundyr/index_left.jsp" noresize="noresize">--%>
        <%--<frame src = "/gundyr/index_right.jsp" name="index_right" noresize="noresize">--%>
    <%--</frameset>--%>
<%--</frameset>--%>


<frameset cols="10%,*,10%" frameborder = "no">

    <frame>
    <frameset rows = "25%,*">
        <frame src="/gundyr/index_top.jsp" noresize="noresize" >
        <frameset cols="10%,*">
            <frame src="/gundyr/index_left.jsp">
            <frame src="/gundyr/index_right.jsp" name="index_right" noresize="noresize">
        </frameset>

    </frameset>

    <frame>
</frameset>

<%
}
else{
%>
<ul>
    <li><a href="<%= request.getContextPath()%>/15/login.jsp" target="_top">非对应权限，请重新登陆！！！</a></li>
</ul>
<%

    }
%>
<%--</body>--%>
</html>
