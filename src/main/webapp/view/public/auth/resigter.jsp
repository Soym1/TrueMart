<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/public/inc/header.jsp"%>



<!-- Register Account Start -->

<div class="container">

    <form action="" method="post" class="sinuo">
        <h3>Register</h3>
        <div class="user-details">
            <div class="input-box">
                <label for="username">User Name</label>
                <input type="text" id="username" name="username" placeholder="Enter your username" value="${users.username}" required>
            </div>
            <div class="input-box">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" placeholder="Enter your password" value="${users.password}" required>
            </div>
            <div class="input-box">
                <label for="firstname">First Name</label>
                <input type="text" id="firstname" name="firstname" placeholder="Enter your first name" value="${users.fistname}" required>
            </div>
            <div class="input-box">
                <label for="lastname">Last Name</label>
                <input type="text" id="lastname" name="lastname" placeholder="Enter your last name" value="${users.lastname}" required>
            </div>
            <div class="input-box">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Enter your email" value="${users.email}" required>
            </div>
            <div class="input-box">
                <label for="phonenumber">Phone Number</label>
                <input type="text" id="phonenumber" name="phonenumber" placeholder="Enter your number" value="${users.phonenumber}" required>
            </div>
            <div class="input-box">
                <label for="address">Address</label>
                <input type="text" id="address" name="address" placeholder="Enter your address" value="${users.address}" required>
            </div>
            <div class="input-box">
                <label>Role</label>
                <div >
                    <div class="flexbox">
                        <input type="radio" id="customer" name="role" value="Customer" class="style-role" <c:if test="${users.role == 'Customer'}">selected</c:if> required><label for="customer">Customer</label>
                    </div>
                    <div class="flexbox">
                        <input type="radio" id="producter" name="role" value="Producter" class="style-role" <c:if test="${users.role == 'Producter'}">selected</c:if> required><label for="producter">Producter</label>
                    </div>
                </div>
            </div>
        </div>
        <div class="button">
            <input type="submit" value="Sign Up" class="return-customer-btn">
        </div>
    </form>
</div>

<!-- Register Account End -->


<!-- Support Area Start Here -->






<%@include file="/templates/public/inc/footer.jsp"%>