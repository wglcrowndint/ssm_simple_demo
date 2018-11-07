<%--
  Created by IntelliJ IDEA.
  User: crowndint
  Date: 2018/11/4
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>

    <form action="/accountList/update" method="get">
        <input type="hidden" name="id" value="${account.id}"/>
        姓名：<input type="text" name="name" value="${account.name}"/><br/>
        金额：<input type="text" name="money" value="${account.money}"/><br/>
        <input type="submit" value="提交"/>
    </form>

</body>
</html>
