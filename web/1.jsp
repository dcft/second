<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.qf.Account.Account" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/9/20
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="2.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List list = new ArrayList<>();
    list.add(new Account(1,"1","123"));
    list.add(new Account(2,"2","123"));
    list.add(new Account(3,"3","123"));
    request.setAttribute("list",list);
%>
<table border="5" align="center">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>password</th>
    </tr>
    <c:forEach begin="1" end="${list.size}" step="1" var="i" items="${list}" >
        <tr>
            <td>${list.get(i).getId()}</td>
            <td>${list.get(i).getUsername()}</td>
            <td>${list.get(i).getPassword()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
