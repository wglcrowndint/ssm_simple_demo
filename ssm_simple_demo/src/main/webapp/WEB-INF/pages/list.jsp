<%--
  Created by IntelliJ IDEA.
  User: crowndint
  Date: 2018/11/4
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table width="300" align="center">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>money</th>
                <th>修改</th>
                <th>删除</th>
            </tr>
            <c:forEach items="${list}" var="account">
                <tr>
                    <td>${account.id}</td>
                    <td>${account.name}</td>
                    <td>${account.money}</td>
                    <td><a href="/accountList/findById?id=${account.id}">修改</a></td>
                    <td><a href="/accountList/delete?id=${account.id}">删除</a></td>
                </tr>
            </c:forEach>
    </table>

    <hr/>

    <a href="/add.jsp">添加</a>

    <hr/>

    <a href="/index.jsp">返回首页</a>

</body>
</html>
