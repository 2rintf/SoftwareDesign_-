<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/25
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<form action = "<%= request.getContextPath()%>/GetUserInfoServlet" method = "post" name = "getInfoForm">
    <table id = "bbT">
        <tr>
            <td align="left">用户ID：</td>
            <%--限定了输入的学号范围--%>
            <td>
                <input type="number" name="uid" min="2018010000" max="2018109999" />
            </td>
        </tr>
        <tr bgcolor="#faebd7">
            <td colspan="2" align="center">
                <input type="submit" name="确认" value="确认" onclick = "return check(this)" />
                <input type="reset" name="重置" value="重置"/>
            </td>
        </tr>


    </table>

</form>
</body>
</html>
