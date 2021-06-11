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
                <h1>Location Manager</h1>
            </div>
            <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item"><a >Home</a></li>
                    <li class="breadcrumb-item active">Location Manager</li>
                </ol>
            </div>
        </div>
    </div><!-- /.container-fluid -->
</section>
<f:form action="${pageContext.request.contextPath}/admin/location/saveLocation" method="POST" enctype="multipart/form-data" modelAttribute="newLocation">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-10">
                <div class="card card-info">
                    <div class="card-header">
                        <h3 class="card-title">Add New Location</h3>
                    </div>
                    <div class="card-body">
                        <div class="col-md-12">
                            <div class="row">
                                <spring:bind path="locationName">
                                    <div class="form-group col-md-6">
                                        <label for="exampleInputEmail1">Location Name</label>
                                        <f:input path="locationName" type="text"  class="form-control ${status.error ?'border border-danger':''} ${param.errorlocationname !=null ?'border border-danger':''}" placeholder="Enter Location Name"/>
                                        <f:errors path="locationName" class="text-danger"  ></f:errors>
                                        <p class="text-danger">${param.errorlocationname}</p>
                                    </div>
                                </spring:bind>
                                <spring:bind path="locationAddress">
                                    <div class="form-group col-md-6">
                                        <label for="exampleInputEmail1">Email</label>
                                        <f:input path="locationAddress" type="text"  class="form-control ${status.error ?'border border-danger':''} ${param.errorlocationaddress !=null ?'border border-danger':''}" placeholder="Enter Location Address "/>
                                        <f:errors path="locationAddress" class="text-danger"  ></f:errors>
                                        <p class="text-danger">${param.errorlocationaddress}</p>
                                    </div>
                                </spring:bind>
                                <spring:bind path="locationInfo">
                                    <div class="form-group col-md-6">
                                        <label for="exampleInputEmail1">Phone</label>
                                        <f:input path="locationInfo" type="text"  class="form-control ${status.error ?'border border-danger':''} ${param.errorlocationinfo !=null ?'border border-danger':''}" placeholder="Enter Location Infomation"/>
                                        <f:errors path="locationInfo" class="text-danger"  ></f:errors>
                                        <p class="text-danger">${param.errorlocationinfo}</p>
                                    </div>
                                </spring:bind>
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
                    <button type="submit" class="btn btn-info">Create</button>
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
