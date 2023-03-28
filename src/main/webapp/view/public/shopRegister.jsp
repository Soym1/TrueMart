<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/public/inc/header.jsp"%>



<!-- Shop Details Start -->

<div class="container backgroundbody">

        <form action="/register?actionUser=addshop" method="post" class="sinuo borderform" enctype="multipart/form-data">
        <h3>Shop details</h3>
            <c:set value="${err}" var="error"></c:set>
            <c:if test="${error == 5}">
                <p style="color: red">Please register shop to continue selling</p>
            </c:if>
        <div class="user-details">
            <div class="input-box">
                <label for="shop_name">Shop Name</label>
                <input type="text" id="shop_name" name="shop_name" placeholder="enter your shop name" required>
            </div>
            <div class="input-box">
                <label for="address">Address</label>
                <input type="text" id="address" name="address" placeholder="enter your address" required>
            </div>
            <div class="input-box">
                <label for="email">Email</label>
                <input type="text" id="email" name="email" placeholder="enter your email"  required>
            </div>
            <div class="input-box">
                <label for="phonenumber">Phone Number</label>
                <input type="text" id="phonenumber" name="phonenumber" placeholder="enter your number" required>
            </div>
            <div class="input-box">
                <label for="category">Category</label>
                <input type="text" id="category" name="category" placeholder="enter your desired category" required>
            </div>
            <div class="input-box">
                <label for="quantity">Quantity available of items</label>
                <input type="number" id="quantity" name="quantitys" placeholder="enter your numbers of items" required>
            </div>
            <div class="input-box">
                <label for="image">Logo image</label>
                <input type="file" id="image" name="image" placeholder="enter your image" required>
            </div>
        </div>
        <div class="button">
            <input type="submit" value="Enter" class="return-customer-btn">
        </div>
    </form>
</div>

<!-- Shop Details End -->


<!-- Support Area Start Here -->

<%@include file="/templates/public/inc/footer.jsp"%>