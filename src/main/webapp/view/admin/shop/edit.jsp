<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/admin/inc/header.jsp"%>
<meta charset="UTF-8">
  <div class="content-wrapper">
    <div class="container-fluid">

        <c:set var="error" value="${param.err}"/>
        <c:if test="${error == '1'}">
            <p class="errors">Edit Shop failed!!!</p>
        </c:if>
    <div class="row mt-3">
      <div class="col-lg-6 cachle">
         <div class="card">
           <div class="card-body">
           <div class="card-title">Edit Shop</div>
           <hr>
            <form action="" method="post" class="addfr" name="addfr">
            <div class="form-group">
                <label for="id_user">User</label>
                <select name="id_user" id="id_user" disabled>
                         <option value="${shop.id}">${shop.users.username}</option>
                </select>
            </div>
           <div class="form-group">
            <label for="name">Shop Name</label>
               <c:if test="${error == '2'}">
                   <input type="text" class="form-control" id="name" name="name" style="border: 2px solid red;" placeholder="Enter the shop name" value="${shop.shop_name}" required onclick="removeStyle(this)">
                   <p class="ersssss" id="errorMsg" style="color: red;font-size: 19px;padding-top: 10px;font-weight: bold">Shop name already exists!!!</p>
               </c:if>
               <c:if test="${error == null || error == 1}">
                   <input type="text" class="form-control" id="name" name="name" placeholder="Enter the shop name" value="${shop.shop_name}" required>
               </c:if>

           </div>
           <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" placeholder="Enter the address" value="${shop.address}" required>
           </div>
           <div class="form-group">
            <button type="submit" class="btn btn-light px-5" id="submitadd" >Edit</button>
          </div>
          </form>
         </div>
         </div>
      </div>
    </div><!--End Row-->

<script>
    function removeStyle(element) {
        element.removeAttribute('style');
        document.getElementById('errorMsg').style.display = 'none';
    }

</script>




        <!--start overlay-->
		  <div class="overlay toggle-menu"></div>
		<!--end overlay--

    </div>
    <!-- End container-fluid-->

   </div><!--End content-wrapper-->
   <!--Start Back To Top Button-->
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
    <!--End Back To Top Button-->

<%@include file="/templates/admin/inc/footer.jsp"%>