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
    <link type="text/css" rel="stylesheet" href="<c:url value="webjars/bootstrap/4.3.1/css/bootstrap.css"/> ">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <h1><a class="navbar-brand" href="#">EMI APPLICATION</a></h1>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>
<br>
<br>
<div class="container">
    <a class="btn btn-success" href="<%=request.getContextPath()%>/emi/">Create New EMI</a><br>
    <div class="col-md-12 col-md-offset-0 mt-2">
        <div class="row ">
            <table class="table table-active">
                <thead class="thead-dark">
                <tr>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>Identification</th>
                    <th>Amount</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="customer">
                    <tr>
                        <td>${customer.fullName}</td>
                        <td>${customer.address}</td>
                        <td>${customer.phoneNumber}</td>
                        <td>${customer.identification}</td>
                        <td>${customer.amount}</td>
                        <td>
                            <a class="btn btn-primary" href="<%=request.getContextPath()%>/customer/edit?id=${customer.cust_id}">EDIT</a>
                            <a class="btn btn-danger" href="<%=request.getContextPath()%>/customer/delete?id=${customer.cust_id}">DELETE</a>
                            <a class="btn btn-primary" href="<%=request.getContextPath()%>/customer/detail?id=${customer.cust_id}">DETAIL</a>
                            <a class="btn btn-primary" href="<%=request.getContextPath()%>/emi?id=${customer.cust_id}">EMI</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>

    </div>
    <a class="btn btn-success" href="<%=request.getContextPath()%>/add">Create New Customer</a>
</div>

<script type="text/javascript" src="<c:url value="webjars/jquery/1.9.1/jquery.min.js"/> "></script>
<script>
    $(function () {
        <c:if test="${param.success != null}">
        alert('${param.success}');
        </c:if>
        <c:if test="${param.error != null}">
        alert('${param.error}');
        </c:if>
    })
</script>


</body>
</html>
