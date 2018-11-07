<%--
  Created by IntelliJ IDEA.
  User: crowndint
  Date: 2018/11/4
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加数据</title>
</head>
<body>

    <form action="/accountList/add" method="get">
        姓名：<input type="text" name="name"/><br/>
        金额：<input type="text" name="money"/><br/>
        <input type="submit" value="提交"/>
    </form>

</body>
</html>
