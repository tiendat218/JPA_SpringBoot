<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Library Manager"/>
<%@include file="/WEB-INF/views/layout/admin/header.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Library Manager</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a>Home</a></li>
                        <li class="breadcrumb-item active">Library Manager</li>
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
                        <h3 class="card-title">Update Library</h3>
                        <div class="card-tools">
                            <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip"
                                    title="Collapse">
                                <i class="fas fa-minus"></i></button>
                        </div>
                    </div>
                    <div class="card-body" style="display: block;">
                        <!-- /.card-header -->
                        <!-- form start -->
                        <f:form action="${pageContext.request.contextPath}/admin/library/updateLibrary" method="POST" modelAttribute="libraryEdit">
                            <f:input path="id" type="hidden"/>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Library Name</label>
                                <f:input path="name" type="text" class="form-control ${param.errorlibraryname !=null ?'border border-danger':''}"
                                         id="exampleInputEmail1" placeholder="Name"/>
                                <p class="text-danger">${param.errorlibraryname}</p>
                            </div>
                            <div class="form-group">
                                <label>Status:</label>
                                <div class="custom-control custom-radio">
                                    <f:radiobutton class="custom-control-input" path="status" value="1" checked="true"
                                                   id="customRadio1"/>
                                    <label for="customRadio1" class="custom-control-label">Show</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <f:radiobutton class="custom-control-input" path="status" value="2"
                                                   id="customRadio2"/>
                                    <label for="customRadio2" class="custom-control-label">Hidden</label>
                                </div>
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


<jsp:include page="../../layout/admin/footer.jsp"/>
<%@include file="/WEB-INF/views/layout/admin/footer.jsp" %>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<%@include file="/WEB-INF/views/layout/admin/infoActionc.jsp" %>

</body>
</html>
