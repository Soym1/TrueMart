<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@include file="/templates/public/inc/header.jsp"%>--%>

<!--HORIZONTAL MENU-->
<jsp:include page="/templates/public/inc/header.jsp"/>
<div class="main-page-banner pb-50 off-white-bg">
    <div class="container">
        <div class="row">
            <!-- Vertical Menu Start Here -->
            <div class="col-xl-3 col-lg-4 d-lg-block">
                <div class="vertical-menu mb-all-30">
                    <nav>
                        <ul class="vertical-menu-list">
                            <li class=""><a href="/ListProduct?category=Computers%20%26%20Laptops"><span><img
                                    src="/templates/public/img/vertical-menu/8.png" alt="menu-icon"></span>Computers &
                                Laptops</a>
                                <%--                                <ul class="ht-dropdown mega-child">--%>
                                <%--                                    <li><a href="view/public/store.jsp">Office chair <i class="fa fa-angle-right"></i></a>--%>
                                <%--                                        <!-- category submenu end-->--%>
                                <%--                                        <ul class="ht-dropdown mega-child">--%>
                                <%--                                            <li><a href="view/public/store.jsp">Bibendum Cursus</a></li>--%>
                                <%--                                            <li><a href="view/public/store.jsp">Dignissim Turpis</a></li>--%>
                                <%--                                            <li><a href="view/public/store.jsp">Dining room</a></li>--%>
                                <%--                                            <li><a href="view/public/store.jsp">Dining room</a></li>--%>
                                <%--                                        </ul>--%>
                                <%--                                        <!-- category submenu end-->--%>
                                <%--                                    </li>--%>
                                <%--                                    <li><a href="view/public/store.jsp">Purus Lacus <i class="fa fa-angle-right"></i></a>--%>
                                <%--                                        <!-- category submenu end-->--%>
                                <%--                                        <ul class="ht-dropdown mega-child">--%>
                                <%--                                            <li><a href="view/public/store.jsp">Magna Pellentesq</a></li>--%>
                                <%--                                            <li><a href="view/public/store.jsp">Molestie Tortor</a></li>--%>
                                <%--                                            <li><a href="view/public/store.jsp">Vehicula Element</a></li>--%>
                                <%--                                            <li><a href="view/public/store.jsp">Sagittis Blandit</a></li>--%>
                                <%--                                        </ul>--%>
                                <%--                                        <!-- category submenu end-->--%>
                                <%--                                    </li>--%>
                                <%--                                    <li><a href="view/public/store.jsp">Sagittis Eget</a></li>--%>
                                <%--                                    <li><a href="view/public/store.jsp">Sagittis Eget</a></li>--%>
                                <%--                                </ul>--%>
                                <!-- category submenu end-->
                            </li>
                            <li><a href="/ListProduct?category=Phones%20%26%20Tablets"><span><img
                                    src="/templates/public/img/vertical-menu/4.png" alt="menu-icon"></span>Phones &
                                Tablets</a>
                            </li>
                            <li><a href="/ListProduct?category=Accessories"><span><img
                                    src="/templates/public/img/vertical-menu/12.png" alt="menu-icon"
                                    style="opacity: 0.4;"></span>Accessories</a>
                            </li>
                            <li><a href="ListProduct?category=Sports"><span><img
                                    src="/templates/public/img/vertical-menu/3.png"
                                    alt="menu-icon"></span>Sports</a>
                            </li>
                            </li>
                            <li><a href="/ListProduct?category=Electronics"><span><img
                                    src="/templates/public/img/vertical-menu/6.png"
                                    alt="menu-icon"></span>Electronics</a>
                            </li>
                            <li><a href="/ListProduct?category=Furniture"><span><img
                                    src="/templates/public/img/vertical-menu/13.png" alt="menu-icon"
                                    style="opacity: 0.4;"></span>Furniture</a>
                            </li>
                            <li><a href="/ListProduct?category=TV"><span><img
                                    src="/templates/public/img/vertical-menu/8.png" alt="menu-icon"></span>TV</a>
                            </li>
                            <li><a href="/ListProduct?category=Fashions"><span><img
                                    src="/templates/public/img/vertical-menu/14.png" alt="menu-icon"
                                    style="opacity: 0.4;"></span>Fashions</a>
                            </li>
                            <li><a href="/ListProduct?category=Beauty"><span><img
                                    src="/templates/public/img/vertical-menu/5.png" alt="menu-icon"></span>Beauty</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
            <!-- Vertical Menu End Here -->
            <!-- Slider Area Start Here -->
            <div class="col-md-9" id="slider-img">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div id="tab125" class="tab-pane active">
                            <div class="products-slick slick-list-1" data-nav="#slick-nav-1">
                                <!-- product -->
                                <div class="product product-slider">
                                    <div class="product-img">
                                        <img class="big-img"
                                             src="/templates/public/img/slider/1.jpg"
                                             alt="">
                                    </div>
                                </div>
                                <!-- /product -->

                                <!-- product -->
                                <div class="product product-slider">
                                    <div class="product-img">
                                        <img class="big-img"
                                             src="/templates/public/img/slider/2.jpg"
                                             alt="">
                                    </div>

                                </div>
                                <!-- /product -->

                                <!-- product -->
                                <div class="product product-slider">
                                    <div class="product-img">
                                        <img class="big-img"
                                             src="/templates/public/img/slider/3.jpg"
                                             alt="">
                                    </div>

                                </div>
                                <!-- /product -->

                                <!-- product -->
                                <div class="product product-slider">
                                    <div class="product-img">
                                        <img class="big-img"
                                             src="/templates/public/img/slider/4.jpg"
                                             alt="">
                                    </div>
                                </div>
                                <!-- /product -->

                                <!-- product -->
                                <div class="product-img product-slider">
                                    <div class="product-img">
                                        <img class="big-img"
                                             src="/templates/public/img/slider/5.jpg"
                                             alt="">
                                    </div>
                                </div>
                                <div id="slick-nav-14" class="products-slick-nav"></div>
                            </div>
                            <!-- /product -->
                        </div>
                    </div>
                    <!-- /tab -->
                </div>
            </div>
        </div>
        <!-- Slider Area End Here -->
    </div>
    <!-- Row End -->
</div>
<!-- Container End -->
</header>
<!-- Categorie Menu & Slider Area End Here -->
<!-- /NAVIGATION -->
<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="shop">
                    <div class="shop-img">
                        <img src="/templates/public/img/shop01.png" alt="">
                    </div>
                    <div class="shop-body">
                        <h3>Laptop<br>Collection</h3>
                        <a href="/view/public/store.jsp" class="cta-btn">Shop now <i
                                class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
            <!-- /shop -->

            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="shop">
                    <div class="shop-img">
                        <img src="/templates/public/img/shop03.png" alt="">
                    </div>
                    <div class="shop-body">
                        <h3>Accessories<br>Collection</h3>
                        <a href="/view/public/store.jsp" class="cta-btn">Shop now <i
                                class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
            <!-- /shop -->

            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="shop">
                    <div class="shop-img">
                        <img src="/templates/public/img/shop02.png" alt="">
                    </div>
                    <div class="shop-body">
                        <h3>Cameras<br>Collection</h3>
                        <a href="/view/public/store.jsp" class="cta-btn">Shop now <i
                                class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
            <!-- /shop -->
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
                    <h3 class="title">New product</h3>
                    <div class="section-nav">
                        <ul class="section-tab-nav tab-nav" id="category-list-new-product">
                            <li class="active"><a data-toggle="tab" href="#tab1">Computers & Laptops</a></li>
                            <li><a data-toggle="tab" href="#tab1">Phones & Tablets</a></li>
                            <li><a data-toggle="tab" href="#tab1">Accessories</a></li>
                            <li><a data-toggle="tab" href="#tab1">Sports</a></li>
                            <li><a data-toggle="tab" href="#tab1">Electronics</a></li>
                            <li><a data-toggle="tab" href="#tab1">Furniture</a></li>
                            <li><a data-toggle="tab" href="#tab1">TV</a></li>
                            <li><a data-toggle="tab" href="#tab1">Fashions</a></li>
                            <li><a data-toggle="tab" href="#tab1">Beauty</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /section title -->

            <!-- Products tab & slick -->
            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div id="tab-new-product" class="tab-pane active">
                            <div class="products-slick slick-list" data-nav="#slick-nav-1">
                                <!-- product -->
                                <div class="product">
                                    <div class="product-img new-product-img">
                                        <img src=""
                                             alt="">
                                        <div class="product-label">
                                            <span class="new">NEW</span>
                                        </div>
                                    </div>
                                    <div class="product-body new-product-body">
                                        <h3 class="product-name"><a
                                                href="#"></a></h3>
                                        <h4 class="product-price"></h4>
                                        <div class="product-rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product-btns">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i><span
                                                    class="tooltipp">add to cart</span></button>
                                            <button class="quick-view"><a href=""></a><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <!-- /product -->
                                <!-- product -->
                                <div class="product">
                                    <div class="product-img new-product-img">
                                        <img src=""
                                             alt="">
                                        <div class="product-label">
                                            <span class="new">NEW</span>
                                        </div>
                                    </div>
                                    <div class="product-body new-product-body">
                                        <h3 class="product-name "><a
                                                href=""#></a></h3>
                                        <h4 class="product-price"></h4>
                                        <div class="product-rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product-btns">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i><span
                                                    class="tooltipp">add to cart</span></button>
                                            <button class="quick-view"><a href=""></a><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                            </button>
                                        </div>
                                    </div>

                                </div>
                                <!-- /product -->
                                <!-- product -->
                                <div class="product">
                                    <div class="product-img new-product-img">
                                        <img src=""
                                             alt="">
                                        <div class="product-label">
                                            <span class="new">NEW</span>
                                        </div>
                                    </div>
                                    <div class="product-body new-product-body">
                                        <h3 class="product-name"><a
                                                href="#"></a></h3>
                                        <h4 class="product-price"></h4>
                                        <div class="product-rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product-btns">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i><span
                                                    class="tooltipp">add to cart</span></button>
                                            <button class="quick-view"><a href=""></a><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                            </button>
                                        </div>
                                    </div>

                                </div>
                                <!-- /product -->
                                <!-- product -->
                                <div class="product">
                                    <div class="product-img new-product-img">
                                        <img src=""
                                             alt="">
                                        <div class="product-label">
                                            <span class="new">NEW</span>
                                        </div>
                                    </div>
                                    <div class="product-body new-product-body">
                                        <h3 class="product-name"><a
                                                href="#"></a></h3>
                                        <h4 class="product-price"></h4>
                                        <div class="product-rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product-btns">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i><span
                                                    class="tooltipp">add to cart</span></button>
                                            <button class="quick-view"><a href=""></a><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                            </button>
                                        </div>
                                    </div>

                                </div>
                                <!-- /product -->
                                <!-- product -->
                                <div class="product">
                                    <div class="product-img new-product-img">
                                        <img src=""
                                             alt="">
                                        <div class="product-label">
                                            <span class="new">NEW</span>
                                        </div>
                                    </div>
                                    <div class="product-body new-product-body">
                                        <h3 class="product-name"><a
                                                href="#"></a></h3>
                                        <h4 class="product-price"></h4>
                                        <div class="product-rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product-btns">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i><span
                                                    class="tooltipp">add to cart</span></button>
                                            <button class="quick-view"><a href=""></a><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                            </button>
                                        </div>
                                    </div>

                                </div>
                                <!-- /product -->
                                <div id="slick-nav-product-new-product" class="products-slick-nav"></div>
                            </div>
                            <!-- /product -->
                        </div>
                    </div>
                    <!-- /tab -->
                </div>
            </div>
        </div>
        <!-- Slider Area End Here -->
    </div>
    <!-- Row End -->
</div>

<!-- HOT DEAL SECTION -->
<div id="hot-deal" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <div class="hot-deal">
                    <ul class="hot-deal-countdown">
                        <li>
                            <div>
                                <h3>02</h3>
                                <span>Days</span>
                            </div>
                        </li>
                        <li>
                            <div>
                                <h3>10</h3>
                                <span>Hours</span>
                            </div>
                        </li>
                        <li>
                            <div>
                                <h3>34</h3>
                                <span>Mins</span>
                            </div>
                        </li>
                        <li>
                            <div>
                                <h3>60</h3>
                                <span>Secs</span>
                            </div>
                        </li>
                    </ul>
                    <h2 class="text-uppercase">hot deal this week</h2>
                    <p>New Collection Up to 50% OFF</p>
                </div>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /HOT DEAL SECTION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <!-- section title -->
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">Top Selling</h3>
                    <div class="section-nav">
                        <ul class="section-tab-nav tab-nav" id="category-list-top-selling">
                            <li class="active"><a data-toggle="tab" href="#tab1">Computers & Laptops</a></li>
                            <li><a data-toggle="tab" href="#tab1">Phones & Tablets</a></li>
                            <li><a data-toggle="tab" href="#tab1">Accessories</a></li>
                            <li><a data-toggle="tab" href="#tab1">Sports</a></li>
                            <li><a data-toggle="tab" href="#tab1">Electronics</a></li>
                            <li><a data-toggle="tab" href="#tab1">Furniture</a></li>
                            <li><a data-toggle="tab" href="#tab1">TV</a></li>
                            <li><a data-toggle="tab" href="#tab1">Fashions</a></li>
                            <li><a data-toggle="tab" href="#tab1">Beauty</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /section title -->

            <!-- Products tab & slick -->
            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div id="tab-top-selling" class="tab-pane active">
                            <div class="products-slick slick-list" data-nav="#slick-nav-1">
                                <!-- product -->
                                <div class="product">
                                    <div class="product-img top-selling-product-img">
                                        <img src="/templates/public/img/product01.png"
                                             alt="">
                                        <div class="product-label">
                                            <span class="new best-selling">BEST SALE</span>
                                        </div>
                                    </div>
                                    <div class="product-body top-selling-product-body">
                                        <h3 class="product-name"><a
                                                href="/view/public/product.jsp">product
                                            name goes here</a></h3>
                                        <h4 class="product-price">$980.00
                                            <del class="product-old-price">$990.00</del>
                                        </h4>
                                        <div class="product-rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product-btns">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i><span
                                                    class="tooltipp">add to cart</span></button>
                                            <button class="quick-view"><a href=""></a><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <!-- /product -->
                                <!-- product -->
                                <div class="product">
                                    <div class="product-img top-selling-product-img">
                                        <img src="/templates/public/img/product01.png"
                                             alt="">
                                        <div class="product-label">
                                            <span class="new best-selling">BEST SALE</span>
                                        </div>
                                    </div>
                                    <div class="product-body top-selling-product-body">
                                        <h3 class="product-name "><a
                                                href="/view/public/product.jsp">product
                                            name goes here</a></h3>
                                        <h4 class="product-price">$980.00
                                            <del class="product-old-price">$990.00</del>
                                        </h4>
                                        <div class="product-rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product-btns">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i><span
                                                    class="tooltipp">add to cart</span></button>
                                            <button class="quick-view"><a href=""></a><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                            </button>
                                        </div>
                                    </div>

                                </div>
                                <!-- /product -->
                                <!-- product -->
                                <div class="product">
                                    <div class="product-img top-selling-product-img">
                                        <img src="/templates/public/img/product01.png"
                                             alt="">
                                        <div class="product-label">
                                            <span class="new best-selling">BEST SALE</span>
                                        </div>
                                    </div>
                                    <div class="product-body top-selling-product-body">
                                        <h3 class="product-name"><a
                                                href="/view/public/product.jsp">product
                                            name goes here</a></h3>
                                        <h4 class="product-price">$980.00
                                            <del class="product-old-price">$990.00</del>
                                        </h4>
                                        <div class="product-rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product-btns">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i><span
                                                    class="tooltipp">add to cart</span></button>
                                            <button class="quick-view"><a href=""></a><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                            </button>
                                        </div>
                                    </div>

                                </div>
                                <!-- /product -->
                                <!-- product -->
                                <div class="product">
                                    <div class="product-img top-selling-product-img">
                                        <img src="/templates/public/img/product01.png"
                                             alt="">
                                        <div class="product-label">
                                            <span class="new best-selling">BEST SALE</span>
                                        </div>
                                    </div>
                                    <div class="product-body top-selling-product-body">
                                        <h3 class="product-name"><a
                                                href="/view/public/product.jsp">product
                                            name goes here</a></h3>
                                        <h4 class="product-price">$980.00
                                            <del class="product-old-price">$990.00</del>
                                        </h4>
                                        <div class="product-rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product-btns">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i><span
                                                    class="tooltipp">add to cart</span></button>
                                            <button class="quick-view"><a href=""></a><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                            </button>
                                        </div>
                                    </div>

                                </div>
                                <!-- /product -->
                                <!-- product -->
                                <div class="product">
                                    <div class="product-img top-selling-product-img">
                                        <img src="/templates/public/img/product01.png"
                                             alt="">
                                        <div class="product-label">
                                            <span class="new best-selling">BEST SALE</span>
                                        </div>
                                    </div>
                                    <div class="product-body top-selling-product-body">
                                        <h3 class="product-name"><a
                                                href="/view/public/product.jsp">product
                                            name goes here</a></h3>
                                        <h4 class="product-price">$980.00
                                            <del class="product-old-price">$990.00</del>
                                        </h4>
                                        <div class="product-rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product-btns">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i><span
                                                    class="tooltipp">add to cart</span></button>
                                            <button class="quick-view"><a href=""></a><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                            </button>
                                        </div>
                                    </div>

                                </div>
                                <!-- /product -->
                                <div id="slick-nav-product-top-selling" class="products-slick-nav"></div>
                            </div>
                            <!-- /product -->
                        </div>
                    </div>
                    <!-- /tab -->
                </div>
            </div>
        </div>
        <!-- Slider Area End Here -->
    </div>
    <!-- Row End -->
</div>
<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <div class="section-title">
            <h3 class="title">Suggestions for you</h3>
        </div>

        <!-- row -->
        <div class="row">
            <div class="col-md-4 col-xs-6">
                <div class="section-title">
                    <div class="section-nav">
                        <div id="slick-nav-3" class="products-slick-nav"></div>
                    </div>
                </div>
                <div class="products-widget-slick" data-nav="#slick-nav-3">
                    <div>
                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product07.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a href=/view/public/product.jsp">product
                                    name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /product widget -->

                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product08.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /product widget -->

                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product09.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- product widget -->
                    </div>

                    <div>
                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product01.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /product widget -->

                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product02.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /product widget -->

                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product03.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- product widget -->
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xs-6">
                <div class="section-title">
                    <div class="section-nav">
                        <div id="slick-nav-4" class="products-slick-nav"></div>
                    </div>
                </div>

                <div class="products-widget-slick" data-nav="#slick-nav-4">
                    <div>
                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product04.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /product widget -->

                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product05.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /product widget -->

                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product06.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- product widget -->
                    </div>

                    <div>
                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product07.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /product widget -->

                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product08.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /product widget -->

                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product09.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- product widget -->
                    </div>
                </div>
            </div>

            <div class="clearfix visible-sm visible-xs"></div>

            <div class="col-md-4 col-xs-6">
                <div class="section-title">
                    <div class="section-nav">
                        <div id="slick-nav-5" class="products-slick-nav"></div>
                    </div>
                </div>

                <div class="products-widget-slick" data-nav="#slick-nav-5">
                    <div>
                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product01.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /product widget -->

                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product02.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /product widget -->

                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product03.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- product widget -->
                    </div>

                    <div>
                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product04.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /product widget -->

                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product05.png" alt="">
                            </div>
                            <div class="product-body  suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /product widget -->

                        <!-- product widget -->
                        <div class="product-widget">
                            <div class="product-img suggestion-product-img">
                                <img src="/templates/public/img/product06.png" alt="">
                            </div>
                            <div class="product-body suggestion-product-body">
                                <h3 class="product-name"><a
                                        href="/view/public/product.jsp">product name goes
                                    here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- product widget -->
                    </div>
                </div>
            </div>

        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<%@include file="/templates/public/inc/footer.jsp" %>
