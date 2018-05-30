<%--
  Created by IntelliJ IDEA.
  User: 2b
  Date: 2018/5/25
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欠款处理</title>
    <link rel="stylesheet" href="/css/login_layout.css" type="text/css"/>
    <style type="text/css">
        body{
            font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
            font-size: 20px;
            /*align-items: center;*/
        }
        #bbT{
            position: relative;
            left:+20px;
            top: +20px;
            box-shadow: 2px 2px 9px 0px black;
            font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
            font-size:15px;
            border:1px solid #98bf21;
            padding:3px 7px 2px 7px;
        }

    </style>

    <script type="text/javascript">
        function check(form) {
            if (document.forms.getBillInfoForm.bill_id.value==""){
                alert("请输入用户ID！");
                document.forms.getBillInfoForm.bill_id.focus();
                return false;
            }else{
                if (document.forms.getBillInfoForm.bill_id.value<"2018010000" || document.forms.getBillInfoForm.bill_id.value>"2018109999"){
                    alert("用户ID范围在2018010000~2018109999！");
                    document.forms.getBillInfoForm.bill_id.focus();
                    return false;
                }
            }
        }
    </script>


</head>
<body bgcolor="#CEE490">
这是欠款清零界面
<form action = "<%= request.getContextPath()%>/BillInfoServlet" method = "post" name = "getBillInfoForm">
    <table id = "bbT">
        <tr>
            <td align="left">用户ID：</td>
            <%--限定了输入的学号范围--%>
            <td>
                <input type="number" name="uid" min="2018010000" max="2018109999" />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="确认" value="确认" onclick = "return check(this)" />
                <input type="reset" name="重置" value="重置"/>
            </td>
        </tr>


    </table>

</form>
</body>
</html>
