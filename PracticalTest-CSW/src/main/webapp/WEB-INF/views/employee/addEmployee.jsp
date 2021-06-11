<%--
  Created by IntelliJ IDEA.
  User: HuyLo
  Date: 5/20/21
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/saveEmployee" method="POST" modelAttribute="newEmployee">
    <input type="text" name="name">
    <input type="text" name="salary">
    <button type="submit">Save</button>
</form>
</body>
</html>
