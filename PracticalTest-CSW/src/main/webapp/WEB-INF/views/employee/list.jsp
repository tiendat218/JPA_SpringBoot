<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-fluid">
    <h1 class="h3 mb-2 text-gray-800">List Employee</h1>
    <a href="${pageContext.request.contextPath}/addEmployee" class="btn btn-primary">Add</a>
        <div class="row">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th style="width: 10px">No.</th>
                            <th>Employee Name</th>
                            <th>Salary</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="employee">
                            <tr>
                                <td>${employee.id}</td>
                                <td><span class="text-bold"> ${employee.id}</span></td>
                                <td><span class="text-bold"> ${employee.salary}</span></td>
                                <td class="project-actions ">
                                    <a href="${pageContext.request.contextPath}/editEmployee?id=${employee.id}"
                                       class="btn  btn-info btn-sm"><i class="fas fa-pencil-alt"> </i>Edit</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

