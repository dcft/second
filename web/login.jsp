<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/9/19
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Cookie[] cookie = request.getCookies();
    Cookie error = null;
    for (Cookie cookie1:cookie){
        if (cookie1.getName().equals("pass")&&cookie1.getValue().equals("yes")){
            response.sendRedirect("/LoginServlet");
            break;
        }
        if (cookie1.getName().equals("error")){
            error=cookie1;
        }
    }
    response.addCookie(error);
%>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form action=${pageContext.request.contextPath}/LoginServlet method="post">
    <p align="center">姓名<input type="text" name="username"></p>
    <p align="center">密码<input type="password" name="password"></p>
    <p align="center">免登陆<input type="checkbox" name="pass"></p>
    <p align="center"><input type="submit"></p>
    <span id="error"></span>
</form>
</body>
</html>
