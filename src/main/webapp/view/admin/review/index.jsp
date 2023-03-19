<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/admin/inc/header.jsp"%>
	
  <div class="content-wrapper">
    <div class="container-fluid">
     
     

        <c:set var="success" value="${param.msg}"/>
        <c:set var="error" value="${param.err}"/>
        <c:if test="${success == '3'}">
            <p class="success">Delete review successfully.</p>
        </c:if>
        <c:if test="${error == '1'}">
            <p class="errors">Id does not exist!!!</p>
        </c:if>
        <c:if test="${error == '2'}">
            <p class="errors">Delete review failed!!!</p>
        </c:if>
        <c:if test="${ListReview.size() != 0 }">
      <div class="row">
        <div class="col-lg-12">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Review</h5>
			  <div class="table-responsive khoangcach">
               <table class="table table-striped">
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">User Review</th>
                      <th scope="col">Name Product</th>
                      <th scope="col">Rating</th>
                      <th scope="col">Content</th>
                      <th scope="col">Post Date</th>
                      <th scope="col">Function</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="review" items="${ListReview}">
                    <tr>
                      <th scope="row">${review.id}</th>
                      <td>${review.user_review}</td>
                        <td>
                            <c:if test="${review.product.name.length() > 40}">
                                ${review.product.name.substring(0, 40)} ...
                            </c:if>
                            <c:if test="${review.product.name.length() <= 40}">
                                ${review.product.name}
                            </c:if>
                        </td>
                      <td>${review.rating}</td>
                        <td>
                            <c:if test="${review.content.length() > 40}">
                                ${review.content.substring(0, 40)} ...
                            </c:if>
                            <c:if test="${review.content.length() <= 40}">
                                ${review.content}
                            </c:if>
                        </td>
                        <td>${review.date}</td>
                      <td>
                          <a href="/admin/review?actionUser=del&&id=${review.id}" class="xoa" onclick="return confirmDelete();"><i class="zmdi zmdi-block"></i> Delete</a>
                      </td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
            </div>
            </div>
          </div>
        </div>
      </div><!--End Row-->
        </c:if>
        <c:if test="${ListReview.size() == 0 || ListReview == null}">
            <p style="text-align: center; margin-bottom: 520px;">There are no reviews yet</p>
        </c:if>
        <!-- Add Confirm Dialog -->
        <div id="confirm-dialog" class="confirm-dialog">
            <div>
            <p>Are you sure you want to delete this review?</p>
            <button id="confirm-ok" class="confirm-ok">OK</button>
            <button id="confirm-cancel" class="confirm-cancel">Cancel</button>
            </div>
        </div>

        <div class="confirm-dialog-open">

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