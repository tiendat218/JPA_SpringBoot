<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Travel Manager"/>
<%@include file="/WEB-INF/views/layout/admin/header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Image Manager</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a>Home</a></li>
                        <li class="breadcrumb-item active">Image Manager</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Detail Image</h3>

                        <div class="card-tools">
                            <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip"
                                    title="Collapse">
                                <i class="fas fa-minus"></i></button>
                            <button type="button" class="btn btn-tool" data-card-widget="remove" data-toggle="tooltip"
                                    title="Remove">
                                <i class="fas fa-times"></i></button>
                        </div>
                    </div>
                    <div class="card-body" style="display: block;">
                        <div class="row">
                            <div class="col-12 col-md-12 col-lg-8 order-2 order-md-1">
                                <div class="row">
                                    <div class="col-12">
                                        <h4>Image Detail </h4>
                                        <div class="post">
                                            <div class="user-block">
                                                <table class="table">
                                                    <tr>
                                                        <td>ID</td>
                                                        <td>${detailImage.imageId}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Image Name</td>
                                                        <td>${detailImage.imageName}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Image URL</td>
                                                        <td>${detailImage.imageURL}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Status </td>
                                                        <td><c:if test="${detailImage.status ==1}">
                                                            <span class="badge badge-success">Show</span>
                                                        </c:if>
                                                            <c:if test="${detailImage.status ==2}">
                                                                <span class="badge badge-danger">Hidden</span>
                                                            </c:if>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Location</td>
                                                        <td>${detailImage.location.locationName}</td>
                                                    </tr>
                                                </table>
                                                <a href="${pageContext.request.contextPath}/admin/images/editImage?id=${detailImage.imageId}"
                                                   class="btn btn-sm btn-info">Update </a>
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

</div>

<%@include file="/WEB-INF/views/layout/admin/footer.jsp" %>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>

<%@include file="/WEB-INF/views/layout/admin/infoActionc.jsp" %>

</body>
</html>



