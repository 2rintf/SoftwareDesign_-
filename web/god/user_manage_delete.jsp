<%@ page import="com.czdpzc.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/28
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/borrow_back.css"/>

    <script type="text/javascript">
        function checkDeleteUserId(form) {
            if (document.forms.delete_user_form.delete_user_id.value==""||document.forms.delete_user_form.borrow_user_id.value<=1000||document.forms.delete_user_form.delete_user_id.value>3000){
                alert("请输入图书ID！请输入图书ID！范围在1000~2999");
                document.forms.delete_user_form.delete_user_id.focus();
                return false;
            }else if (document.forms.delete_user_form.delete_user_id.value == <%= ((Users)(request.getSession().getAttribute("user_login"))).getId()%>){
                alert("QAQ你正在删除你自己...");
                document.forms.delete_user_form.delete_user_id.focus();
                return false;
            }else
                return true;
        }
    </script>
</head>
<body bgcolor="#CEE490">

<form action="<%= request.getContextPath()%>/DeleteUserServlet" name = "delete_user_form">

    <table  id="borrowT"  border = "1" bordercolor = "silver" cellpadding = "5" cellspacing = "0">
        <tr align="center">
            <th colspan="2">删除旧用户</th>
        </tr>
        <tr>
            <td align="left">用户ID：</td>
            <td>
                <input type="number" name="delete_user_id"  />
                <input type="hidden" name="this_id" value="<%= ((Users)(request.getSession().getAttribute("user_login"))).getId()%>">
            </td>
        </tr>
        <tr>
            <td  colspan="2" align="center">

                <input type="submit" value="删除" onclick = "return checkDeleteUserId(this)" />

            </td>
        </tr>
    </table>

</form>


</body>
</html>
