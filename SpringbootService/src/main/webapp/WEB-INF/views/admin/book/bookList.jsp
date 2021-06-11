<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Book Manager"/>
<%@include file="/WEB-INF/views/layout/admin/header.jsp" %>


<div class="container-scroller">
    <!-- Navbar -->
    <%@include file="/WEB-INF/views/layout/admin/navbar.jsp" %>
    <div class="container-fluid page-body-wrapper">
        <!-- /.navbar -->
        <%@include file="/WEB-INF/views/layout/admin/navleft.jsp" %>
        <div class="main-panel">
            <div class="content-wrapper">
                <section class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1>Book Manager</h1>
                            </div>
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a>Home</a></li>
                                    <li class="breadcrumb-item active">Book Manager</li>
                                </ol>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card card-warning collapsed-card">
                                    <div class="card-header">
                                        <h3 class="card-title">Look Up Book</h3>
                                        <div class="card-tools">
                                            <button type="button" class="btn btn-tool" data-card-widget="collapse"><i
                                                class="fas fa-plus"></i>
                                            </button>

                                            <button type="button" class="btn btn-tool" data-card-widget="remove"><i
                                                class="fas fa-times"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <!-- /.card-header -->
                                    <div class="card-body" style="display: none; color: #FFF">
                                        <div class="col-md-12" style="margin-top: 10px;margin-bottom: 10px;">
                                            <div class="row">
                                                <div class="col-md-4 col-sm-4 col-4">
                                                    <a href="${pageContext.request.contextPath}/admin/book"
                                                       class="btn btn-block btn-primary">All</a>
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-4">
                                                    <a href="${pageContext.request.contextPath}/admin/book/show"
                                                       class="btn btn-block btn-success">Show</a>
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-4">
                                                    <a href="${pageContext.request.contextPath}/admin/book/hidden"
                                                       class="btn btn-block btn-danger">Hidden</a>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.card-footer-->
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="row">
                                    <div class="col-1">
                                        <a class="btn btn-block btn-info btn-sm"
                                           href="${pageContext.request.contextPath}/admin/book/insertBook">Create
                                            Book</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!-- /.container-fluid -->
                </section>
                <div class="container-fluid">
                    <div class="row">
                        <div class="row">
                            <div class="col-lg-6 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Book List</h4>
                                        <p class="card-description">
                                        </p>
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                <tr>
                                                    <th style="width: 10px">No.</th>
                                                    <th>Book Name</th>
                                                    <th>Library</th>
                                                    <th>Actions</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${listBooks}" var="book" varStatus="itr">
                                                    <tr>
                                                        <td>${offset+itr.index+1}
                                                        </td>
                                                        <td><span class="text-bold"> ${book.name}</span><br>
                                                            <c:if test="${book.status ==1}">
                                                                <span class="text-bold"> </span><span
                                                                class="badge badge-success">Show</span>
                                                            </c:if>
                                                            <c:if test="${book.status !=1}">
                                                                <span class="text-bold"> </span><span
                                                                class="badge badge-danger">Hidden</span>
                                                            </c:if>
                                                        </td>
                                                        <td>${book.library.name}</td>
                                                        <td class="project-actions ">
                                                            <a href="${pageContext.request.contextPath}/admin/book/editBook?id=${book.id}"
                                                               class="btn  btn-info btn-sm"><i
                                                                class="fas fa-pencil-alt"> </i>
                                                                Update</a>
                                                            <a href="${pageContext.request.contextPath}/admin/book/deleteBook?id=${book.id}"
                                                               class="btn btn-danger btn-sm"><i
                                                                class="fas fa-trash"></i>
                                                                Delete</a>
                                                            <a href="${pageContext.request.contextPath}/admin/book/detailBook?id=${book.id}"
                                                               class="btn btn-primary btn-sm"><i
                                                                class="fas fa-folder"> </i>Detail</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/layout/admin/footer.jsp" %>
</body>
</html>



