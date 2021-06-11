<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Travel Manager"/>
<%@include file="../../layout/admin/header.jsp" %>

<div class="content-wrapper">
<section class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <div class="col-sm-6">
                <h1>Image Manager</h1>
            </div>
            <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item"><a >Home</a></li>
                    <li class="breadcrumb-item active">Image Manager</li>
                </ol>
            </div>
        </div>
    </div><!-- /.container-fluid -->
</section>
<f:form action="${pageContext.request.contextPath}/admin/image/updateImage" method="POST" enctype="multipart/form-data" modelAttribute="editImage">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-10">
                <div class="card card-info">
                    <div class="card-header">
                        <h3 class="card-title">Edit Image</h3>
                    </div>
                    <div class="card-body">
                        <div class="col-md-12">
                            <div class="row">
                                <spring:bind path="imageName">
                                    <div class="form-group col-md-6">
                                        <label for="exampleInputEmail1">Image Name</label>
                                        <f:input path="imageName" type="text"  class="form-control ${status.error ?'border border-danger':''} ${param.errorimagename !=null ?'border border-danger':''}" placeholder="Enter Image Name"/>
                                        <f:errors path="imageName" class="text-danger"  ></f:errors>
                                        <p class="text-danger">${param.errorimagename}</p>
                                    </div>
                                </spring:bind>
                                <spring:bind path="imageURL">
                                    <div class="form-group col-md-6">
                                        <label for="exampleInputEmail1">Image URL</label>
                                        <f:input path="imageURL" type="text"  class="form-control ${status.error ?'border border-danger':''} ${param.errorimageurl !=null ?'border border-danger':''}" placeholder="Enter Image URL "/>
                                        <f:errors path="imageURL" class="text-danger"  ></f:errors>
                                        <p class="text-danger">${param.errorimageurl}</p>
                                    </div>
                                </spring:bind>
                                <div class="form-group col-md-6">
                                    <label>Location</label>
                                    <f:select class="custom-select" path="location.locationId">
                                        <f:options items="${locations}"  itemLabel="name" itemValue="id" />
                                    </f:select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label for="exampleInputEmail1">Status </label>
                                    <div class="form-check">
                                        <f:radiobutton path="status" value="1"  class="form-check-input" checked="true" id="exampleInputEmail1"/>
                                        <label class="form-check-label" >Show</label>
                                        <br>
                                        <f:radiobutton path="status" value="2"  class="form-check-input" id="exampleInputEmail1"/>
                                        <label class="form-check-label" >Hidden</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <button type="submit" class="btn btn-info">Update</button>
                </div>
            </div>
        </div>
    </div>
    </div>
</f:form>
</div>
<%@include file="/WEB-INF/views/layout/admin/footer.jsp" %>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>

<%@include file="/WEB-INF/views/layout/admin/infoActionc.jsp" %>

<script type="text/javascript">
    $(function () {
        // Summernote
        $('#desId').summernote();
        click();
    })
</script>
</body>
</html>
