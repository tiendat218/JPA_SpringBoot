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
        <a class="navbar-brand" href="#">EMI APPLICATION</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>
<br>
<br>
<div class="container">
    <a class="btn btn-success" href="<%=request.getContextPath()%>/">Back</a><br>
    <div class="col-md-12 col-md-offset-0 mt-2">
        <div class="row ">
            <table class="table table-active">
                <thead class="thead-dark">
                <tr>
                    <th>Name</th>
                    <th>Loan Amount</th>
                    <th>Rate of interest</th>
                    <th>Team of the loan</th>
                    <th>Status</th>
                    <th>Time End</th>
                    <th>Created At</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listEmi}" var="emi">
                    <tr>
                        <td>${emi.customer.fullName}</td>
                        <td>${emi.loan_amount}</td>
                        <td>${emi.rate_of_interest}</td>
                        <td>${emi.team_of_the_loan}</td>
                        <td>${emi.status}</td>
                        <td>${emi.timeEnd}</td>
                        <td>${emi.createdAt}</td>
                        <td>${emi.updateAt}</td>
                        <td>
                            <a class="btn btn-primary" href="<%=request.getContextPath()%>/emi/detail?id=${emi.emi_id}">DETAIL</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>

    </div>
</div>
</body>
</html>
