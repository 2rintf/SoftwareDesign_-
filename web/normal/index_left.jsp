<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/25
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<a href="<%= request.getContextPath()%>/normal/index_right.jsp"  target = "index_right">首页</a><br/>
<a href="<%= request.getContextPath()%>/normal/user_info.jsp" target="index_right">用户信息查询</a><br/>
<a href="<%= request.getContextPath()%>/normal/search.jsp" target="index_right">图书搜索</a><br/>
<a href="<%= request.getContextPath()%>/LogoutServlet17" target="_top">退出</a><br/>


</body>
</html>
