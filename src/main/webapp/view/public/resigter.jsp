<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/public/inc/header.jsp"%>



<!-- Register Account Start -->

<div class="container backgroundbody">

    <form action="" method="post" class="sinuo borderform">
        <h3>Register</h3>
        <div class="user-details">
            <div class="input-box">
                <label for="username">User Name</label>
                <input type="text" id="username" name="username" placeholder="Enter your username" value="${users.username}" required>
            </div>
            <div class="input-box">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" value="${users.password}" placeholder="Enter your password" required>
            </div>
            <div class="input-box">
                <label for="firstname">First Name</label>
                <input type="text" id="firstname" name="firstname" placeholder="Enter your first name" value="${users.firstname}" required>
            </div>
            <div class="input-box">
                <label for="lastname">Last Name</label>
                <input type="text" id="lastname" name="lastname" placeholder="Enter your last name" value="${users.lastname}" required>
            </div>
            <div class="input-box">
                <label for="email">Email</label>
                <input type="text" id="email" name="email" placeholder="Enter your email" value="${users.email}" required>
            </div>
            <div class="input-box">
                <label for="phonenumber">Phone Number</label>
                <input type="text" id="phonenumber" name="phonenumber" placeholder="Enter your number" value="${users.phonenumber}" required>
            </div>
            <div class="input-box">
                <label for="address">Address</label>
                <input type="text" id="address" name="address" placeholder="Enter your address" value="${users.address}" required>
            </div>
            <div class="">
                <label>Role</label>
                <div class="flexbox">
                    <div >
                        <input type="radio" id="customer" name="role" value="Customer" class="style-role" <c:if test="${users.role == 'Customer'}">selected</c:if> required><label for="customer" class="labelbutton">Customer</label>
                    </div>
                    <div>
                        <input type="radio" id="producter" name="role" value="Producter" class="style-role" <c:if test="${users.role == 'Producter'}">selected</c:if> required><label for="producter" class="labelbutton">Producter</label>
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


<style>
    .headerthree{
        margin-bottom: 50px;
    }
    .sinuo{
        width: 60%;
        margin: 100px 0 100px 20% ;
    }
    .sinuo h3{
        text-align: center;
        font-size: 30px;
    }
    .sinuo div div input {
        width: 100%;
        margin: 5px 0 0px 0;
        padding: 0.375rem 0.75rem;
        background-color: rgba( 247, 247, 247, 1);
        border: 0px;
        outline:none;
    }
    .sinuo div div input:focus {
        width: 100%;
        margin: 5px 0 0px 0;
        padding: 0.375rem 0.75rem;
        background-color: rgba( 247, 247, 247, 1);
        border: 0px;
        outline:none;
    }
    label {
        font-size: 20px;
        font-family: Montserrat;
        font-weight: normal !important;
    }

    .return-customer-btn {
        background: #e62e04 none repeat scroll 0 0;
        border: medium none;
        color: #ffffff;
        display: inline-block;
        font-weight: 500;
        font-size: 15px;
        margin-top: 20px;
        padding: 10px 30px;
        text-align: center;
        text-transform: uppercase;
        -webkit-transition: all 300ms ease-in 0s;
        transition: all 300ms ease-in 0s;
        cursor: pointer;
        border-radius: 4px;
    }

    .return-customer-btn {
        background: #222222;
    }

    .return-customer-btn:hover {
        background: #E62E04;
        color: #fff;
    }

    .flexbox {
        display: flex;

    }

    .input-box {
        background-color: #F7F7F7;
        margin-bottom: 20px;
        padding: 10px;
        border-radius: 10px;
        border: solid #ECECEC;
    }
    .borderform{
        border: 1px solid #E6E6E6;
        padding: 20px;
        border-radius: 10px;
        background: white;
    }
    .backgroundbody{
        background: #E6E6E6;
        width: 100%;
        margin: 0 !important;
    }
    .sinuo div div textarea{
        width: 100%;
        margin: 5px 0 0px 0;
        padding: 0.375rem 0.75rem;
        border: 0px;
        outline:none;
    }
    .document {
        background-color: white;
    }
    .sinuo div div input[type=radio] {
        height: 12px;
        margin-left: 20px;
        margin-right: 5px;
    }
    .labelbutton {
        font-size: 18px;
    }
    .style-role {
        width: 10% !important;
    }
    .user-details {
        margin-top: 40px;
    }
    .sinuo div div select {
        width: 100%;
        margin: 5px 0 0px 0;
        padding: 0.375rem 0.75rem;
        background-color: rgba( 247, 247, 247, 1);
        border: 0px;
        outline:none;
    }
</style>



<%@include file="/templates/public/inc/footer.jsp"%>