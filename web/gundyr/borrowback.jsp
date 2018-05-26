<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/25
  Time: 0:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借/还书管理</title>
    <link rel="stylesheet" href="/css/login_layout.css" type="text/css"/>

    <script type="text/javascript">
        function check(form) {
            if (document.forms.getInfoForm.uid.value==""){
                alert("请输入用户ID！");
                document.forms.getInfoForm.uid.focus();
                return false;
            }else{
                if (document.forms.getInfoForm.uid.value<"2018010000" || document.forms.getInfoForm.uid.value>"2018109999"){
                    alert("用户ID范围在2018010000~2018109999！");
                    document.forms.getInfoForm.uid.focus();
                    return false;
                }
            }
        }
    </script>
</head>
<body>
这是借还书页面


<form action = "<%= request.getContextPath()%>/GetInfoServlet" method = "post" name = "getInfoForm">
    <table  align = "center" border = "1" bordercolor = "silver" cellpadding = "5" cellspacing = "0">
        <tr>
            <td align="left">用户ID：</td>
            <%--限定了输入的学号范围--%>
            <td>
                <input type="number" name="uid" min="2018010000" max="2018109999" />
            </td>
        </tr>
        <tr bgcolor="#faebd7">
            <td colspan="2" align="center">
                <input type="submit" name="确认" onclick = "return check(this)" />
                <input type="reset" name="重置"/>
            </td>
        </tr>


    </table>

</form>
</body>
</html>
