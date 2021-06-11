<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Travel Manager"/>
<%@include file="../../layout/admin/header.jsp" %>

<div class="container-fluid">
    <!-- Page Heading -->
    <h1>Customer Manager</h1>
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="row">
            <div class="col-md-12">
                <div class="card card-warning collapsed-card">
                    <!-- /.card-header -->
                    <div class="card-body" style="display: flex; color: #FFF">
                        <div class="col-md-12" style="margin-top: 10px;margin-bottom: 10px;">
                            <div class="row">
                                <div class="col-md-4 col-sm-4 col-4">
                                    <a href="${pageContext.request.contextPath}/admin/customers"
                                       class="btn btn-block btn-primary">All</a>
                                </div>
                                <div class="col-md-4 col-sm-4 col-4">
                                    <a href="${pageContext.request.contextPath}/admin/customers/show"
                                       class="btn btn-block btn-success">Show</a>
                                </div>
                                <div class="col-md-4 col-sm-4 col-4">
                                    <a href="${pageContext.request.contextPath}/admin/customers/hidden"
                                       class="btn btn-block btn-danger">Hidden</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row" style="margin: 20px">
            <div class="col-12">
                <div class="col-3">
                    <a class="btn btn-block btn-info btn-sm"
                       href="${pageContext.request.contextPath}/admin/customers/insertCustomer">Create
                        Customer</a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th style="width: 10px">No.</th>
                            <th>Customer Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${customers}" var="customer" varStatus="itr">
                            <tr>
                                <td>${offset+itr.index+1}</td>
                                <td><span class="text-bold"> ${customer.customerName}</span></td>
                                <td><span class="text-bold"> ${customer.email}</span></td>
                                <td><span class="text-bold"> ${customer.phone}</span></td>
                                <td>
                                    <c:if test="${customer.status ==1}">
                                        <span class="text-bold"> </span><span
                                        class="badge badge-success">Show</span>
                                    </c:if>
                                    <c:if test="${customer.status ==2}">
                                        <span class="text-bold"> </span><span
                                        class="badge badge-danger">Hidden</span>
                                    </c:if>
                                </td>
                                <td class="project-actions ">
                                    <a href="${pageContext.request.contextPath}/admin/customers/editCustomer?id=${comment.commentId}"
                                       class="btn  btn-info btn-sm"><i class="fas fa-pencil-alt"> </i>Update</a>
                                    <a href="${pageContext.request.contextPath}/admin/customers/deleteCustomer?id=${comment.commentId}"
                                       class="btn btn-danger btn-sm"><i class="fas fa-trash"></i> Delete</a>
                                    <a href="${pageContext.request.contextPath}/admin/customers/detailCustomer?id=${comment.commentId}"
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
        <div class="row">
            <div class="col-sm-12 col-md-5">
            </div>
            <div class="col-sm-12 col-md-7">
                <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
                    <ul class="pagination">
                        <c:if test="${totalPages > 1}">
                            <c:if test="${currentPage>1}">
                                <li class="paginate_button page-item previous disabled"
                                    id="dataTable_previous">
                                    <a href="/admin/comments/page/${currentPage-1}"
                                       aria-controls="dataTable"
                                       data-dt-idx="0" tabindex="0" class="page-link">
                                        Previous
                                    </a>
                                </li>
                            </c:if>
                            <c:forEach end="${totalPages}" begin="1" varStatus="loop">
                                <c:if test="${currentPage != loop.index}">
                                    <li class="paginate_button page-item ">
                                        <a href="/admin/comments/page/${loop.index}"
                                           aria-controls="dataTable"
                                           data-dt-idx="2" tabindex="0" class="page-link">
                                                ${loop.index}</a>
                                    </li>
                                </c:if>
                                <c:if test="${currentPage == loop.index}">
                                    <li class="paginate_button page-item active">
                                        <a href="/admin/comments/page/${loop.index}"
                                           aria-controls="dataTable"
                                           data-dt-idx="1" tabindex="0"
                                           class="page-link">${loop.index}</a>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${currentPage<totalPages}">
                                <li class="paginate_button page-item next" id="dataTable_next">
                                    <a href="/admin/book/page/${currentPage+1}" aria-controls="dataTable"
                                       data-dt-idx="7" tabindex="0" class="page-link">Next</a>
                                </li>
                            </c:if>
                        </c:if>


                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /.container-fluid -->
</div>
<!-- End of Main Content -->
</div>
<!-- End of Content Wrapper -->
</div>
<!-- End of Wrapper -->

<%@include file="/WEB-INF/views/layout/admin/footer.jsp" %>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<%@include file="/WEB-INF/views/layout/admin/infoActionc.jsp" %>
