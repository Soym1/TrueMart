<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/templates/public/inc/header.jsp" %>
<div class="breadcrumb-area mt-30">
    <div class="container">
        <div class="breadcrumb">
            <ul class="d-flex align-items-center">
                <li><a href="/">Home</a></li>
                <li class="active"><a href="/view/public/cart.jsp">Cart</a></li>
            </ul>
        </div>
    </div>
    <!-- Container End -->
</div>
<!-- Breadcrumb End -->
<!-- Cart Main Area Start -->
<div class="cart-main-area ptb-10 ptb-sm-60">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12">
                <!-- Form Start -->
                <form action="#">
                    <!-- Table Content Start -->
                    <div class="table-content table-responsive mb-45">
                        <table>
                            <thead>
                            <tr>
                                <th class="product-thumbnail">Image</th>
                                <th class="product-name">Product</th>
                                <th class="shop-name">Shop</th>
                                <th class="product-price" style="width: 200px">Price</th>
                                <th class="product-quantity">Quantity</th>
                                <th class="product-discount">Discount</th>
                                <th class="product-subtotal" style="width: 200px">Total</th>
                                <th class="product-remove">Remove</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="x" items="${listCart}">
                                <tr id="${x.key.id}">
                                    <td class="product-thumbnail">
                                        <a href="/ProductDetail?id=${x.key.id}"><img
                                                src="/templates/public/img/total_category/${x.key.id}/1.jpg"
                                                alt="cart-image"></a>
                                    </td>
                                    <td class="product-name"><a
                                            href="/ProductDetail?id=${x.key.id}">${x.key.name}</a></td>
                                    <td class="shop-name"><span>${x.key.shop.shop_name}</span></td>
                                    <td class="product-price"><span class="amount">${x.key.price} VNĐ</span></td>
                                    <td class="product-quantity">
                                        <div class="input-number" style="width: 70px; margin-left: 25%" >
                                            <input type="number" value="${x.value}" min="1" max ="${x.key.quantity}" style=" background: #e5e5e5 none repeat scroll 0 0;">
                                            <span class="qty-up qty-up-1">+</span>
                                            <span class="qty-down qty-down-1">-</span>
                                        </div>
                                    </td>
                                    <td class="product-discount"><input type="text" placeholder="Promo code"></td>
                                    <td class="product-subtotal">
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber type="currency"
                                                          currencySymbol="VNĐ"
                                                          value="${Integer.parseInt(x.key.price.replace('.','')) * x.value}"
                                        ></fmt:formatNumber></td>
                                    <td class="product-remove"><a href="#"><i class="fa fa-times"
                                                                              aria-hidden="true"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- Table Content Start -->
                    <div class="row-bottom-cart">
                        <div class="row">
                            <!-- Cart Button Start -->
                            <!-- <div class="col-md-8 col-sm-12">
                                <div class="buttons-cart">
                                    <input type="submit" value="Update Cart">
                                    <a href="index.jsp">Continue Shopping</a>
                                </div>
                            </div> -->
                            <!-- Cart Button Start -->
                            <!-- Cart Totals Start -->
                            <div class="col-md-3 col-sm-12 " style="float: right;">
                                <div class="cart_totals float-right text-md-right">
                                    <!-- <h2>Cart Totals</h2>
                                    <br>
                                    <table class="total-subto" style="float: right;">
                                        <tbody>
                                            <tr class="cart-subtotal">
                                                <th>Subtotal</th>
                                                <td><span class="amount">$215.00</span></td>
                                            </tr>
                                            <tr class="cart-subtotal">
                                               <th>Discount</th>
                                               <td><span class="amount">$15.00</span></td>
                                           </tr>
                                            <tr class="order-total">
                                                <th>Total</th>
                                                <td>
                                                    <strong><span class="amount">$200.00</span></strong>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table> -->
                                    <div class="wc-proceed-to-checkout">
                                        <a href="/Checkout">CHECKOUT</a>
                                    </div>
                                </div>
                            </div>
                            <!-- Cart Totals End -->
                        </div>
                        <!-- Row End -->
                    </div>

                </form>
                <!-- Form End -->
            </div>
        </div>
        <!-- Row End -->
    </div>
</div>
<%@include file="/view/public/chat.jsp" %>
<%@include file="/templates/public/inc/footer.jsp" %>
