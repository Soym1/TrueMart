<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>

    <!-- Favicons -->
    <link rel="shortcut icon" href="/templates/public/img/favicon.ico">
    <!-- Fontawesome css -->
    <link rel="stylesheet" href="/templates/public/CSS/font-awesome.min.css">
    <!-- Ionicons css -->
    <link rel="stylesheet" href="/templates/public/CSS/ionicons.min.css">
    <!-- linearicons css -->
    <link rel="stylesheet" href="/templates/public/CSS/linearicons.css">
    <!-- Nice select css -->
    <link rel="stylesheet" href="/templates/public/CSS/nice-select.css">
    <!-- Jquery fancybox css -->
    <link rel="stylesheet" href="/templates/public/CSS/jquery.fancybox.css">
    <!-- Jquery ui price slider css -->
    <link rel="stylesheet" href="/templates/public/CSS/jquery-ui.min.css">
    <!-- Meanmenu css -->
    <link rel="stylesheet" href="/templates/public/CSS/meanmenu.min.css">
    <!-- Nivo slider css -->
    <link rel="stylesheet" href="/templates/public/CSS/nivo-slider.css">
    <!-- Owl carousel css -->
    <link rel="stylesheet" href="/templates/public/CSS/owl.carousel.min.css">
    <!-- Bootstrap css -->
    <link rel="stylesheet" href="/templates/public/CSS/bootstrap.min.css">
    <!-- Custom css -->
    <link rel="stylesheet" href="/templates/public/CSS/default.css">
    <!-- Main css -->
    <%--    <link rel="stylesheet" href="/templates/public/style.css">--%>
    <!-- Responsive css -->
    <link rel="stylesheet" href="/templates/public/CSS/responsive.css">

    <!-- Modernizer js -->
    <script src="/templates/public/js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
            crossorigin="anonymous"></script>
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Truemart</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
    <!-- Bootstrap -->

    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="/templates/public/CSS/slick.css"/>
    <link type="text/css" rel="stylesheet" href="/templates/public/CSS/slick-theme.css"/>

    <!-- nouislider -->
    <link type="text/css" rel="stylesheet"
          href="/templates/public/CSS/nouislider.min.css"/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="/templates/public/CSS/font-awesome.min.css">

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="/templates/public/CSS/style.css"/>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- HEADER -->
<header>

    <!-- MAIN HEADER -->
    <div id="header">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="/" class="logo">
                            <img src="/templates/public/img/logo.png" alt="">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-6">
                    <div class="header-search">
                        <form action="/Search" method="get">
                            <select class="input-select">
                                <option value="0">All Categories</option>
                            </select>
                            <input value="${text}" name="txt" type="text" class="input" placeholder="Search here">
                            <button class="search-btn" type="submit">Search</button>

                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->
                <div class="col-md-3 clearfix">
                    <div class="header-ctn">

                        <!-- /Cart -->
                        <!-- Wishlist -->
                        <c:if test="${UserLogin == null}">
                            <div style="color: white;">
                                <div style="text-align: center">
                                    <i class="fa fa-user-o"></i>
                                </div>
                                <span><a href="/Authed?actionUser=login" style="color: white;font-size: 14px">Login </a>|<a href="/register" style="color: white;font-size: 14px"> Register</a></span>

                            </div>
                        </c:if>
                        <c:if test="${UserLogin != null}">
                            <!-- Cart -->
                            <div class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                    <i class="fa fa-shopping-cart"></i>
                                    <span>Your Cart</span>
                                    <div class="qty" id="qty-cart"></div>
                                </a>
                                <div class="cart-dropdown">
                                    <div class="cart-list">
                                    </div>
                                    <div class="cart-summary">
                                        <small id="amount-product"> Item(s) selected</small>
                                        <h5 id="sub-total">SUBTOTAL:</h5>
                                    </div>
                                    <div class="cart-btns">
                                        <a href="/Cart">View Cart</a>
                                        <a href="/Checkout">Checkout <i
                                                class="fa fa-arrow-circle-right"></i></a>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <a href="/Authed?actionUser=logout">
                                    <i class="fa fa-sign-out"></i>
                                    <span>Logout !!!</span>
                                </a>
                            </div>
                            <%@include file="/view/public/chat.jsp" %>
                        </c:if>
                        <!-- /Wishlist -->
                        <!-- Menu Toogle -->
                        <div id="menu-toggle">
                            <a>
                                <i class="fa fa-bars"></i>
                                <span>Menu</span>
                            </a>
                        </div>
                        <!-- /Menu Toogle -->
                    </div>
                </div>
                <!-- /ACCOUNT -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->


<!-- NAVIGATION -->
<nav id="navigation">
    <!-- container -->
    <div class="container">
        <!-- responsive-nav -->
        <div id="responsive-nav">
            <!-- NAV -->
            <ul class="main-nav nav navbar-nav">
                <li class="active" style="text-align: center"><a href="/">HOME</a>
                </li>
                <li><a href="/ListProduct">Store</a>
                </li>
                <li><a href="/ListShop">Shop</a></li>
                <li><a href="">About us</a></li>
                <li><a href="/contact">contact us</a></li>
                <c:if test="${UserLogin.role.equals('Producter')}">
                <li><a href="/shop">shop details</a></li>
                </c:if>
            </ul>
            <!-- /NAV -->
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<!-- /NAVIGATION -->
<!--HORIZONTAL MENU-->

<div class="header-bottom header-sticky">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-xl-9 col-lg-9 col-md-12" style="width: 100%;margin: 0 0 0 6%;text-align: center;">
                <nav>
                    <ul class="header-bottom-list d-flex dflexs">
                        <li class="active"><a href="/">home</a>
                        </li>
                        <li><a href="/ListProduct">Product</a>
                        </li>
                        <li><a href="/ListShop">Shop</a></li>
                        <li><a href="/view/public/aboutUs.jsp">About us</a></li>
                        <li><a href="/contact">contact us</a></li>
                        <c:if test="${UserLogin.role.equals('Producter')}">
                            <li><a href="/shop">shop details</a></li>
                        </c:if>
                    </ul>
                </nav>

            </div>
        </div>
        <!-- Row End -->
    </div>
    <!-- Container End -->
</div>
<script>
    $(document).ready(function (){
        let username = "${UserLogin.username}";
        if(${UserLogin != null}) {
            $.ajax({
                url: '/Cart',
                method: 'POST',
                dataType: "JSON",
                data: {
                    type: "get-cart",
                    username: username
                },
                success: function(data){
                    loadCartData(data);
                },
                error: function (){
                    alert('Có lỗi xảy ra');
                }
            });
        }
    })
</script>

