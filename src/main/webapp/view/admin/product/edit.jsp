<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/admin/inc/header.jsp"%>
	
  <div class="content-wrapper">
    <div class="container-fluid">

        <c:set var="error" value="${param.err}"/>
        <c:if test="${error == '1'}">
            <p class="errors">Edit product failed!!!</p>
        </c:if>
    <div class="row mt-3">
      <div class="col-lg-6 cachle">
         <div class="card">
           <div class="card-body">
           <div class="card-title">Edit Product</div>
           <hr>
            <form action="" method="post" class="addfr" enctype="multipart/form-data">
           <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="Enter the product name" value="${product.name}">
           </div>
           <div class="form-group">
            <label for="image">Image</label>
            <input type="file" class="form-control" name="image" id="image" placeholder="Enter the image">
           </div>
           <div class="form-group">
            <label for="price">Price</label>
            <input type="text" class="form-control" name="price" id="price" placeholder="Enter the price" value="${product.price}">
           </div>
            <div class="form-group">
                <label for="quantity">Quantity</label>
                <input type="number" class="form-control" name="quantity" id="quantity" placeholder="Enter the quantity" value="${product.quantity}">
            </div>
           <div class="form-group">
            <label for="describe">Describe</label>
            <textarea id="describe" name="describe" rows="4" cols="72" placeholder="Enter the describe">${product.decription}</textarea>
           </div>
           <div class="form-group">
            <label for="detail">Detail</label>
            <textarea id="detail" name="detail" rows="8" cols="72" placeholder="Enter the detail">${product.details}</textarea>
           </div>
           <div class="form-group">
            <label for="category">Category</label>
            <select name="category" id="category">
                <c:forEach items="${categoris}" var="ct">
                    <option value="${ct.id}" <c:if test="${ct.id == product.category.id}">selected</c:if>>${ct.category_name}</option>
                </c:forEach>
            </select>
           </div>
           <div class="form-group">
            <button type="submit" class="btn btn-light px-5">Add</button>
          </div>
          </form>
         </div>
         </div>
      </div>
    </div><!--End Row-->

	<!--start overlay-->
		  <div class="overlay toggle-menu"></div>
		<!--end overlay-->

    </div>
    <!-- End container-fluid-->
    
   </div><!--End content-wrapper-->
   <!--Start Back To Top Button-->
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
    <!--End Back To Top Button-->

<%@include file="/templates/admin/inc/footer.jsp"%>