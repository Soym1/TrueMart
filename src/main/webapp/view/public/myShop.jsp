<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/public/inc/header.jsp"%>

<!-- Register Account Start -->

<!-- Start Product Home Page -->


<c:if test="${shopLogin.id == shop.id}">
<div class="createProduct">
    <a class="newProduct" href="/shop?actionUser=addproduct">
        <i class="fa fa-cart-plus"></i>
        add products
    </a>
</div>
</c:if>
<div class="addProducts">
    <div class="shopLeft">
        <div class="shoplogo">
            <img class="imageProduct" src="/templates/public/img/shop/${shop.shopper_details.avatar}" alt="${shop.shopper_details.avatar}">
        </div>
        <div class="shopname">
            <h1 class="name">${shop.shop_name}</h1>
            <p class="paragraph">Welcome 😍 😍 😍 😍</p>
        </div>
    </div>
    <div class="shopRight">
        <div class="leftInformation">
            <p class="now" href="">Product: ${numpro}</p>
            <br>
            <p class="now" href="">Email: ${shop.shopper_details.email}</p>
            <br>
            <p class="now" href="">Order Sold: 80</p>
        </div>
        <div class="rightInformation">
            <p class="now" href="">Phone: ${shop.shopper_details.phonenumber}</p>
            <br>
            <p class="now" href="">Address: ${shop.shopper_details.address}<p>
            <br>
            <p class="now" href="">Join Date: ${shop.shopper_details.date_created}</p>
        </div>
    </div>
</div>

<!-- End Product Home Page -->










<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <!-- section title -->
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">Trending Products</h3>
                </div>
            </div>
            <!-- /section title -->

            <!-- Products tab & slick -->
            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div id="tab2" class="tab-pane fade in active">
                            <div class="products-slick" data-nav="#slick-nav-2">
                                <c:forEach items="${listPS}" var="o" end="7">
                                    <div class="product">
                                        <a href="/ProductDetail?id=${o.id}">
                                            <div class="product-img">
                                                <img src="/templates/public/img/total_category/${o.id}/${o.image}" alt="" style="width: 265px; height: 162.74px">
<%--                                                <div class="product-label">--%>
<%--                                                    <span class="sale">NEW</span>--%>
<%--                                                </div>--%>
                                            </div>
                                            <div class="product-body">
                                                <p class="product-category">${o.category.category_name}</p>
                                                <h3 class="product-name"><a href="/ProductDetail?id=${o.id}">${o.name}</a></h3>
                                                <h4 class="product-price">${o.price} VNĐ</h4>
                                                <div class="product-rating">
                                                </div>
                                                <div class="product-btns">
                                                    <button class="quick-view"><a href="/ProductDetail?id=${o.id}"><i class="fa fa-eye"></i></a><span
                                                            class="tooltipp">quick view</span></button>
                                                </div>
                                            </div>
                                            <div class="add-to-cart">
                                                <button class="add-to-cart-btn ${o.id}"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                            </div>
                                        </a>
                                    </div>
                                    <!-- /product -->
                                </c:forEach>
                            </div>
                            <div id="slick-nav-2" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>
            <!-- /Products tab & slick -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <!-- section title -->
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">Products</h3>
                </div>
            </div>
            <!-- /section title -->

            <!-- Products tab & slick -->
            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div id="tab2" class="tab-pane fade in active">
                            <div class="flexBox">
                                <!-- product -->
                                <c:forEach items="${listPS}" var="o">
                                <div class="product">
                                    <a href="/ProductDetail?id=${o.id}">
                                        <div class="product-img">
                                            <img src="/templates/public/img/total_category/${o.id}/${o.image}" alt="" style="width: 265px; height: 162.74px">
                                            <div class="product-label">
                                                <span class="sale">NEW</span>
                                            </div>
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${o.category.category_name}</p>
                                            <h3 class="product-name"><a href="/ProductDetail?id=${o.id}">${o.name}</a></h3>
                                            <h4 class="product-price">${o.price} VNĐ</h4>
                                            <div class="product-rating">
                                            </div>
                                            <div class="product-btns">
                                                <button class="quick-view"><a href="/ProductDetail?id=${o.id}"><i class="fa fa-eye"></i></a><span
                                                        class="tooltipp">quick view</span></button>
                                            </div>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn ${o.id}"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                        </div>
                                    </a>
                                </div>
                                <!-- /product -->
                                </c:forEach>
                            </div>
                            <div id="slick-nav-2" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>
            <!-- /Products tab & slick -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->



<style>

    .createProduct{
        margin-top: 30px;
        margin-right: 30px;
        margin-bottom: 30px;
        height: 42px;
    }
    .newProduct{
        float: right;
        background-color: black;
        border: medium none;
        color: #ffffff;
        /* display: inline-block; */
        font-weight: 500;
        font-size: 15px;
        padding: 10px 30px;
        text-align: center;
        text-transform: uppercase;
        -webkit-transition: all 300ms ease-in 0s;
        transition: all 300ms ease-in 0s;
        cursor: pointer;
        border-radius: 4px;
    }
    .newProduct:hover {
        background: #E62E04;
        color: #fff;
    }
    .addProducts{
        margin: 60px 60px 30px 60px;
        display: flex;
    }
    .shopLeft{
        background-color: #00000099;
        width: 40%;
        height: 150px;
        border-radius: 5px;
        display: flex;
    }
    .imageProduct {
        height: 100px;
        width: 100px;
        border-radius: 50px;
    }
    .shoplogo{
        height: 100px;
        width: 100px;
        margin-top: 10px;
        margin-left: 10px;
    }
    .shopname {
        margin-left: 20px;
        margin-top: 20px;
    }
    .name{
        color: white;
        font-size: 20px;
    }
    .paragraph{
        color: white;
        font-family: 'Helvetica Neue', Helvetica, Arial;
    }

    .shopRight{
        background-color: white;
        width: 60%;
        height: 150px;
        display: flex;
    }
    .leftInformation{
        width: 50%;
    }
    .rightInformation{
        width: 50%;
    }
    .now{
        margin-top: 10px;
        margin-left: 20px;
        margin-bottom: 0px;
        font-family: 'Helvetica Neue', Helvetica, Arial;
        font-size: 14px;
    }
    .section{
        margin-bottom: 30px;
    }
    /* .flexBox{
        display: flex;
        flex-wrap: wrap;
    } */
    .product{
        margin: 10px;
        width: 265px;
        height: 400px;
        float: left;
        border-bottom-width: 2px;
        border-bottom-color: #333;

    }
    .product .product-body{
        z-index: 499!important;
    }
    .add-to-cart {
        bottom: 0!important;
        z-index: 500!important;
    }
    .products-slick .product.slick-slide {
        height: 397px!important;
    }

</style>



<%@include file="/templates/public/inc/footer.jsp"%>