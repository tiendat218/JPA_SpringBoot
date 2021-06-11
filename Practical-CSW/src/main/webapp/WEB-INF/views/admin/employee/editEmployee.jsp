<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="<c:url value="/assets/plugins/fontawesome-free/css/all.min.css" />">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="/src/main/webapp/assets/dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <link rel="stylesheet" href="/src/main/webapp/assets/plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="/src/main/webapp/assets/editor/richtext.min.css">

    <link rel="stylesheet" href="/assets/plugins/summernote/summernote-bs4.css">
</head>
<body>
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
        </div><!-- /.container-fluid -->
    </section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-5">
                <!-- general form elements -->
                <div class="card card-info">
                    <div class="card-header">
                        <h3 class="card-title">Update Employee</h3>
                        <div class="card-tools">
                            <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip"
                                    title="Collapse">
                                <i class="fas fa-minus"></i></button>
                        </div>
                    </div>
                    <div class="card-body" style="display: block;">
                        <!-- /.card-header -->
                        <!-- form start -->
                        <f:form action="${pageContext.request.contextPath}/admin/employee/updateEmployee" method="POST" modelAttribute="editEmployee">
                            <f:input path="id" type="hidden"/>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Employee Name</label>
                                <f:input path="name" type="text" class="form-control ${param.erroremployeename !=null ?'border border-danger':''}"
                                         id="exampleInputEmail1" placeholder="Name"/>
                                <p class="text-danger">${param.erroremployeename}</p>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Salary</label>
                                <f:input path="salary" type="text" class="form-control ${param.errorsalary !=null ?'border border-danger':''}"
                                         id="exampleInputEmail1" placeholder="Salary"/>
                                <p class="text-danger">${param.errorsalary}</p>
                            </div>
                            <!-- /.card-body -->
                            <div class="card-footer">
                                <button type="submit" class="btn btn-info">Update</button>
                            </div>
                        </f:form>
                    </div>
                    <!-- /.card -->
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
