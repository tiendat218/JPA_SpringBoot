<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Employee Manager"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${pageTitle}</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<c:url value="/assets/plugins/fontawesome-free/css/all.min.css"/>">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="/assets/dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <link rel="stylesheet" href="/assets/plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="/assets/editor/richtext.min.css">
    <link rel="stylesheet" href="/assets/plugins/summernote/summernote-bs4.css">
</head>
<body>
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Employee Manager</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a>Home</a></li>
                            <li class="breadcrumb-item active">Employee Manager</li>
                        </ol>
                    </div>
                </div>
            </div>
        </section>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-7">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">Employees List</h3>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table class="table table-striped projects">
                                <thead>
                                <tr>
                                    <th style="width: 10px">No.</th>
                                    <th>Employee Name</th>
                                    <th>Salary</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${employees}" var="employee" varStatus="itr">
                                    <tr>
                                        <td>${offset+itr.index+1}
                                        </td>
                                        <td><span class="text-bold"> ${employee.name}</span>
                                        </td>
                                        <td><span class="text-bold"> ${employee.salary}</span>
                                        </td>
                                        <td class="project-actions ">
                                            <a href="${pageContext.request.contextPath}/admin/employee/editEmployee?id=${employee.id}"
                                               class="btn  btn-info btn-sm"><i class="fas fa-pencil-alt"> </i>
                                                Update</a>
                                            <a href="${pageContext.request.contextPath}/admin/employee/deleteEmployee?id=${employee.id}"
                                               class="btn btn-danger btn-sm"><i class="fas fa-trash"></i> Delete</a>
                                                <%--                                        <a href="${pageContext.request.contextPath}/admin/library/detaiLibrary?id=${book.id}" class="btn btn-primary btn-sm"><i class="fas fa-folder"> </i>Detail</a>--%>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="card-footer clearfix">
                            <ul class="pagination pagination-sm m-0 float-right">
                                <c:if test="${totalPages > 1}">
                                    <c:if test="${currentPage>1}">
                                        <li class="page-item"><a class="page-link"
                                                                 href="/admin/library/page/${currentPage-1}">«</a></li>
                                    </c:if>
                                    <c:forEach end="${totalPages}" begin="1" varStatus="loop">
                                        <c:if test="${currentPage != loop.index}">
                                            <li class="page-item "><a class="page-link"
                                                                      href="/admin/library/page/${loop.index}">${loop.index}</a>
                                            </li>
                                        </c:if>
                                        <c:if test="${currentPage == loop.index}">
                                            <li class="page-item active"><a class="page-link"
                                                                            href="/admin/library/page/${loop.index}">${loop.index}</a>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${currentPage<totalPages}">
                                        <li class="page-item"><a class="page-link"
                                                                 href="/admin/library/page/${currentPage+1}">»</a></li>
                                    </c:if>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                    <!-- /.card -->
                </div>
                <div class="col-md-5">
                    <!-- general form elements -->
                    <div class="card card-info">
                        <div class="card-header">
                            <h3 class="card-title">Create New Employee</h3>
                            <div class="card-tools">
                                <button type="button" class="btn btn-tool" data-card-widget="collapse"
                                        data-toggle="tooltip" title="Collapse">
                                    <i class="fas fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="card-body" style="display: block;">
                            <!-- /.card-header -->
                            <!-- form start -->
                            <f:form action="${pageContext.request.contextPath}/admin/employee/saveEmpolyee"
                                    method="POST" modelAttribute="employeeNew">
                                <spring:bind path="name">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Employee Name</label>
                                        <f:input path="name" type="text"
                                                 class="form-control  ${status.error ?'border border-danger':''} ${param.erroremployeename !=null ?'border border-danger':''}"
                                                 id="exampleInputEmail1" placeholder="Employee Name"/>
                                        <f:errors path="name" class="text-danger"></f:errors>
                                        <p class="text-danger">${param.erroremployeename}</p>
                                    </div>
                                </spring:bind>
                                <spring:bind path="salary">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Salary</label>
                                        <f:input path="salary" type="text"
                                                 class="form-control  ${status.error ?'border border-danger':''} ${param.errorsalary!=null ?'border border-danger':''}"
                                                 id="exampleInputEmail1" placeholder="Salary"/>
                                        <f:errors path="salary" class="text-danger"></f:errors>
                                        <p class="text-danger">${param.errorsalary}</p>
                                    </div>
                                </spring:bind>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-info">Submit</button>
                                </div>
                            </f:form>
                        </div>
                        <!-- /.card -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/assets/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<%--<script src="${pageContext.request.contextPath}/assets/dist/js/demo.js"></script>--%>
<script src="${pageContext.request.contextPath}/assets/plugins/summernote/summernote-bs4.min.js"></script>
</body>
</html>
