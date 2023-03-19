<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/public/inc/header.jsp"%>



<!-- Add Products Start -->

<div class="container backgroundbody">

    <form action="" method="post" class="sinuo borderform" enctype="multipart/form-data">
        <h3 class="headerthree">Add product information</h3>
        <div class="user-details">
            <div class="input-box">
                <label for="name">Product name</label>
                <input type="text" id="name" name="name" placeholder="enter product name" value="" required>
            </div>
            <div class="input-box">
                <label for="category">Category</label>
                <br>
                <select id="category" name="category" required>
                    <c:forEach items="${listCate}" var="cate">
                        <option value="${cate.id}" >${cate.category_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input-box">
                <label for="image">Logo image</label>
                <input type="file" id="image" name="image" placeholder="enter your image" class="image" value="" required>
            </div>
            <div class="input-box">
                <label for="price">Pricing a Product</label>
                <input type="text" id="price" name="price" placeholder="enter your product price" required>
            </div>
            <div class="input-box">
                <label for="quantity">Quantity Product</label>
                <input type="number" id="quantity" name="quantity" placeholder="enter your product quantity" required>
            </div>
            <div class="input-box document">
                <label for="decription">Product description</label>
                <textarea id="decription" name="decription" rows="4" cols="50" placeholder="enter your product description" value="" required></textarea>
            </div>
            <div class="input-box document">
                <label for="details">Product details</label>
                <textarea id="details" name="details" rows="4" cols="50" placeholder="Enter product details" value="" required></textarea>
            </div>
        </div>
        <div class="button">
            <input type="submit" value="Add" class="return-customer-btn">
        </div>
    </form>
</div>

<!-- Add Products End -->

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