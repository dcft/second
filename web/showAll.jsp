<%@ page import="com.qf.Account.AccountApi" %>
<%@ page import="com.qf.Account.AccountImp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.qf.Account.Account" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/9/20
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询</title>
</head>
<script>
    function del() {
        alert("ok!");
        document.getElementById("id").submit();
    }
</script>
<body>
<%
    AccountApi api = new AccountImp();
    List<Account> list = api.showAllAccount();
    pageContext.setAttribute("list",list);
%>
<form id="id" method="post" action=${pageContext.request.contextPath}/delServlet >
    <table align="center" border="5" cellpadding="0" width="400">
        <tr>
            <th>全删</th>
            <th>id</th>
            <th>username</th>
            <th>password</th>
            <th>操作</th>
        </tr>
        <C:if test="${not empty list}">
            <C:forEach items="${list}" begin="0" end="${list.size()}" step="1" var="account" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="aid" value=${account.id} ></td>
                    <td>${account.id}</td>
                    <td>${account.username}</td>
                    <td>${account.password}</td>
                    <td><input type="button" value="删除" name=${account.id} onclick="del()"/><input type="button" value="编辑" name=${account.id} onclick="del()"/></td>
                </tr>
            </C:forEach>
        </C:if>
        <tr>
            <td colspan="3" align="center"><a href="main.html" >返回</a></td>
        </tr>
    </table>
</form>
</body>
</html>
