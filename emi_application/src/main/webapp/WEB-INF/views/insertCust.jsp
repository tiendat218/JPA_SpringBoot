<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enterprise Application</title>
    <link rel="stylesheet" href="${contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="#">EMI APPLICATION</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1> Create New Customer</h1>
            <%--@elvariable id="custNew" type=""--%>
            <form:form action="${pageContext.request.contextPath}/saveCust" method="post" modelAttribute="custNew">
                <div class="form-group">
                    <label > Name</label>
                    <form:input type="text" class="form-control"  path="fullName" placeholder="Enter name" />
                </div>
                <div class="form-group">
                    <label > Address</label>
                    <form:input type="text" class="form-control" path="address" placeholder="Enter address" />
                </div>
                <div class="form-group">
                    <label > Phone</label>
                    <form:input type="text" class="form-control"  path="phoneNumber" placeholder="Enter phone" autofocus="autofocus"/>
                </div>
                <div class="form-group">
                    <label > Identification</label>
                    <form:input type="text" class="form-control" path="identification" placeholder="Enter identification" autofocus="autofocus"/>
                </div>
                <div class="form-group">
                    <label > Amount</label>
                    <form:input type="number" class="form-control"  path="amount" placeholder="Enter amount" autofocus="autofocus"/>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6 ">
                            <input type="submit" name="login-submit" id="Login-submit" class="form-control btn btn-success" value="Submit" >
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
