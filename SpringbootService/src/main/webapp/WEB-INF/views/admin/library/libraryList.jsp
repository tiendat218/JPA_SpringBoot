<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                        <li class="breadcrumb-item"><a >Home</a></li>
                        <li class="breadcrumb-item active">Library Manager</li>
                    </ol>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="card card-warning collapsed-card">
                    <div class="card-header">
                        <h3 class="card-title">Look Up Library</h3>

                        <div class="card-tools">

                            <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-plus"></i>
                            </button>

                            <button type="button" class="btn btn-tool" data-card-widget="remove"><i class="fas fa-times"></i>
                            </button>
                        </div>
                    </div>
                    <!-- /.card-header -->
                    <div class="card-body" style="display: none; color: #FFF">
                        <div class="col-md-12" style="margin-top: 10px;margin-bottom: 10px;">
                            <div class="row">
                                <div class="col-md-4 col-sm-4 col-4">
                                    <a href="${pageContext.request.contextPath}/admin/library" class="btn btn-block btn-primary">All</a>
                                </div>
                                <div class="col-md-4 col-sm-4 col-4">
                                    <a href="${pageContext.request.contextPath}/admin/library/show" class="btn btn-block btn-success">Show</a>
                                </div>
                                <div class="col-md-4 col-sm-4 col-4">
                                    <a  href="${pageContext.request.contextPath}/admin/library/hidden" class="btn btn-block btn-danger">Hidden</a>
                                </div>

                            </div>
                        </div>
                    </div>
                    <!-- /.card-footer-->
                </div>
            </div>
        </div>
        <!-- /.container-fluid -->
    </section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-7">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Libraries List</h3>

                    </div>
                    <!-- /.card-header -->
                    <div class="card-body">
                        <table class="table table-striped projects">
                            <thead>
                            <tr>
                                <th style="width: 10px">No.</th>
                                <th>Library Name</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listLibraries}" var="library" varStatus="itr">
                                <tr>
                                    <td>${offset+itr.index+1}
                                    </td>
                                    <td><span class="text-bold"> ${library.name}</span><br>
                                        <c:if test="${library.status ==1}">
                                            <span class="text-bold"> </span><span class="badge badge-success">Show</span>
                                        </c:if>
                                        <c:if test="${library.status !=1}">
                                            <span class="text-bold"> </span><span class="badge badge-danger">Hidden</span>
                                        </c:if>
                                    </td>
                                    <td class="project-actions ">
                                        <a href="${pageContext.request.contextPath}/admin/library/editLibrary?id=${library.id}" class="btn  btn-info btn-sm"><i class="fas fa-pencil-alt"> </i> Update</a>
                                        <a href="${pageContext.request.contextPath}/admin/library/deleteLibrary?id=${library.id}" class="btn btn-danger btn-sm"><i class="fas fa-trash"></i> Delete</a>
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
                                    <li class="page-item"><a class="page-link" href="/admin/library/page/${currentPage-1}">«</a></li>
                                </c:if>
                                <c:forEach  end="${totalPages}" begin="1" varStatus="loop">
                                    <c:if test="${currentPage != loop.index}">
                                        <li class="page-item "><a class="page-link" href="/admin/library/page/${loop.index}">${loop.index}</a></li>
                                    </c:if>
                                    <c:if test="${currentPage == loop.index}">
                                        <li class="page-item active"><a class="page-link" href="/admin/library/page/${loop.index}">${loop.index}</a></li>
                                    </c:if>
                                </c:forEach>
                                <c:if test="${currentPage<totalPages}">
                                    <li class="page-item"><a class="page-link" href="/admin/library/page/${currentPage+1}">»</a></li>
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
                        <h3 class="card-title">Create New Library</h3>
                        <div class="card-tools">
                            <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                                <i class="fas fa-minus"></i></button>
                        </div>
                    </div>
                    <div class="card-body" style="display: block;">
                        <!-- /.card-header -->
                        <!-- form start -->
                        <f:form action="${pageContext.request.contextPath}/admin/library/saveLibrary" method="POST" modelAttribute="libraryNew">
                            <spring:bind path="name">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Library Name</label>
                                    <f:input path="name" type="text"  class="form-control  ${status.error ?'border border-danger':''} ${param.errorlibraryname !=null ?'border border-danger':''}" id="exampleInputEmail1"  placeholder="Name"/>
                                    <f:errors path="name" class="text-danger" ></f:errors>
                                    <p class="text-danger">${param.errorlibraryname}</p>
                                </div>
                            </spring:bind>
                            <spring:bind path="status">
                                <div class="form-group">
                                    <label>Status:</label>
                                    <div class="custom-control custom-radio">
                                        <f:radiobutton class="custom-control-input" path="status" value="1" checked="true"  id="customRadio1" />
                                        <label for="customRadio1" class="custom-control-label">Show</label>
                                    </div>
                                    <div class="custom-control custom-radio">
                                        <f:radiobutton class="custom-control-input" path="status" value="2" id="customRadio2" />
                                        <label for="customRadio2" class="custom-control-label">Hidden</label>
                                    </div>
                                    <f:errors path="status" class="text-danger"  ></f:errors>
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
<jsp:include page="../../layout/admin/footer.jsp"/>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>

<%@include file="../../layout/admin/infoActionc.jsp" %>

</body>
</html>
