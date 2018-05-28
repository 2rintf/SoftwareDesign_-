<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/28
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="/css/borrow_back.css"/>

    <script type="text/javascript">
        function checkDeleteBookId(form) {
            if (document.forms.delete_form.delete_book_id.value==""||document.forms.borrow_form.borrow_book_id.value<=1000||document.forms.borrow_form.borrow_book_id.value>3000){
                alert("请输入图书ID！请输入图书ID！范围在1000~2999");
                document.forms.borrow_form.borrow_book_id.focus();
                return false;
            }
        }
    </script>
</head>
<body bgcolor="#CEE490">

<form action="<%= request.getContextPath()%>/DeleteBookServlet" name = "delete_form">

    <table  id="borrowT"  border = "1" bordercolor = "silver" cellpadding = "5" cellspacing = "0">
        <tr align="center">
            <th colspan="2">旧书退库</th>
        </tr>
        <tr>
            <td align="left">退库图书ID：</td>
            <td>
                <input type="number" name="delete_book_id"  />
            </td>
        </tr>
        <tr  >
            <td  colspan="2" align="center">

                <input type="submit" value="删除" onclick = "return checkDeleteBookId(this)" />

            </td>
        </tr>
    </table>

</form>


</body>
</html>
