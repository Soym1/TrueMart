<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/admin/inc/header.jsp"%>
	
  <div class="content-wrapper">
    <div class="container-fluid">

        <c:set var="success" value="${param.msg}"/>
        <c:set var="error" value="${param.err}"/>
        <c:if test="${success == '1'}">
            <p class="success">Add product successfully.</p>
        </c:if>
        <c:if test="${success == '2'}">
            <p class="success">Edit product successfully.</p>
        </c:if>
        <c:if test="${success == '3'}">
            <p class="success">Delete product successfully.</p>
        </c:if>
        <c:if test="${error == '1'}">
            <p class="errors">Id does not exist!!!</p>
        </c:if>
        <c:if test="${error == '2'}">
            <p class="errors">Delete product failed!!!</p>
        </c:if>
        <c:if test="${error == '3'}">
            <p class="errors">You are not granted additional permissions product!!!</p>
        </c:if>
        <c:if test="${error == '4'}">
            <p class="errors">Please create a store before posting products for sale!!!</p>
        </c:if>
        <c:if test="${error == '5'}">
            <p class="errors">You are not authorized to edit the product!!!</p>
        </c:if>
        <c:if test="${error == '5'}">
            <p class="errors">You are not authorized to del the product!!!</p>
        </c:if>


      <div class="row">
        <div class="col-lg-12">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Product</h5>
                <c:if test="${UserLogin.role == 'Producter'}">
                    <a href="/admin/product?actionUser=add" class="them">Add</a>
                </c:if>
			  <div class="table-responsive khoangcach">
               <table class="table table-striped">
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">Name</th>
                      <th scope="col">Image</th>
                      <th scope="col">Price</th>
                      <th scope="col">Category</th>
                      <th scope="col">Shop</th>
                      <th scope="col">Function</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${productList}" var="pr">
                      <c:if test="${pr.shop.id == ShopLogin.id}">
                          <tr>
                          <th scope="row">${pr.id}</th>
                              <td>
                                  <c:if test="${pr.name.length() > 40}">
                                      ${pr.name.substring(0, 40)} ...
                                  </c:if>
                                  <c:if test="${pr.name.length() <= 40}">
                                      ${pr.name}
                                  </c:if>
                              </td>
                         <td><img src="/templates/public/img/total_category/${pr.id}/${pr.image}" alt="${pr.image}" /></td>
                          <td>${pr.price}$</td>
                          <td>${pr.category.category_name}</td>
                          <td>${pr.shop.shop_name}</td>
                          <td>
                            <a href="/admin/product?actionUser=edit&&id=${pr.id}" class="sua"><i class="zmdi zmdi-brush"></i> Edit</a>
                            <a href="/admin/product?actionUser=del&&id=${pr.id}" class="xoa" onclick="return confirmDelete();"><i class="zmdi zmdi-block"></i> Delete</a>
                          </td>
                        </tr>
                      </c:if>
                      <c:if test="${UserLogin.role == 'Admin'}">
                          <tr>
                          <th scope="row">${pr.id}</th>
                              <td>
                                  <c:if test="${pr.name.length() > 40}">
                                      ${pr.name.substring(0, 40)} ...
                                  </c:if>
                                  <c:if test="${pr.name.length() <= 40}">
                                      ${pr.name}
                                  </c:if>
                              </td>

                              <td><img src="/templates/public/img/total_category/${pr.id}/${pr.image}" alt="${pr.image}" /></td>
                              <td>${pr.price} VNĐ</td>
                              <td>${pr.category.category_name}</td>
                              <td>${pr.shop.shop_name}</td>
                              <td>
                                  <a href="/admin/product?actionUser=del&&id=${pr.id}" class="xoa" onclick="return confirmDelete();"><i class="zmdi zmdi-block"></i> Delete</a>
                              </td>
                          </tr>
                      </c:if>
                  </c:forEach>
                  </tbody>
                </table>
            </div>
            </div>
          </div>
        </div>
      </div><!--End Row-->

        <div id="confirm-dialog" class="confirm-dialog">
            <div>
                <p>Are you sure you want to delete this product?</p>
                <button id="confirm-ok" class="confirm-ok">OK</button>
                <button id="confirm-cancel" class="confirm-cancel">Cancel</button>
            </div>
        </div>
	  
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