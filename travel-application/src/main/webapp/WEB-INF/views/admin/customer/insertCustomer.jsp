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
                <h1>Customer Manager</h1>
            </div>
            <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item"><a >Home</a></li>
                    <li class="breadcrumb-item active">Customer Manager</li>
                </ol>
            </div>
        </div>
    </div><!-- /.container-fluid -->
</section>
<f:form action="${pageContext.request.contextPath}/admin/customer/saveCustomer" method="POST" enctype="multipart/form-data" modelAttribute="newCustomer">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-10">
                <div class="card card-info">
                    <div class="card-header">
                        <h3 class="card-title">Add New Customer</h3>
                    </div>
                    <div class="card-body">
                        <div class="col-md-12">
                            <div class="row">
                                <spring:bind path="customerName">
                                    <div class="form-group col-md-6">
                                        <label for="exampleInputEmail1">Customer Name</label>
                                        <f:input path="customerName" type="text"  class="form-control ${status.error ?'border border-danger':''} ${param.errorcommentname !=null ?'border border-danger':''}" placeholder="Enter Customer Name"/>
                                        <f:errors path="customerName" class="text-danger"  ></f:errors>
                                        <p class="text-danger">${param.errorcommentname}</p>
                                    </div>
                                </spring:bind>
                                <spring:bind path="email">
                                    <div class="form-group col-md-6">
                                        <label for="exampleInputEmail1">Comment Infomation</label>
                                        <f:input path="email" type="email"  class="form-control ${status.error ?'border border-danger':''} ${param.erroremail !=null ?'border border-danger':''}" placeholder="Enter Email"/>
                                        <f:errors path="email" class="text-danger"  ></f:errors>
                                        <p class="text-danger">${param.erroremail}</p>
                                    </div>
                                </spring:bind>
                                <spring:bind path="phone">
                                    <div class="form-group col-md-6">
                                        <label for="exampleInputEmail1">Phone</label>
                                        <f:input path="phone" type="text"  class="form-control ${status.error ?'border border-danger':''} ${param.errorphone !=null ?'border border-danger':''}" placeholder="Enter Phone Number"/>
                                        <f:errors path="phone" class="text-danger"  ></f:errors>
                                        <p class="text-danger">${param.errorphone}</p>
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
