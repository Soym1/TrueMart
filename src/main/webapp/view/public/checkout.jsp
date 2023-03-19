<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/public/inc/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- BREADCRUMB -->
<div class="breadcrumb-area mt-30">
    <div class="container">
        <div class="breadcrumb">
            <ul class="d-flex align-items-center">
                <li><a href="/">Home</a></li>
                <li><a href="/view/public/cart.jsp">Cart</a></li>
                <li class="active"><a>Checkout</a></li>
            </ul>
        </div>
    </div>
    <!-- Container End -->
</div>
<!-- /BREADCRUMB -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <div class="col-md-7">
                <!-- Billing Details -->
                <div class="billing-details">
                    <div class="section-title">
                        <h3 class="title">Billing address</h3>
                    </div>
                    <div class="form-group">
                        <label for="first-name">First Name</label>
                        <input id = "first-name" class="input" type="text" name="first-name" placeholder="First Name" value="${userInfo.getFirstname()}" >
                    </div>
                    <div class="form-group">
                        <label for="last-name">Last Name</label>
                        <input id="last-name" class="input" type="text" name="last-name" placeholder="Last Name" value="${userInfo.getLastname()}">
                    </div>
                    <div class="form-group">
                        <label for="email">Email </label>
                        <input id = "email"class="input" type="email" name="email" placeholder="Email" value="${userInfo.getEmail()}">
                    </div>
                    <div class="form-group">
                        <label for="address">Address </label>
                        <input id = "address" class="input" type="text" name="address" placeholder="Address" value="${userInfo.getAddress()}">
                    </div>
<%--                    <div class="form-group">--%>
<%--                        <label for="city">City </label>--%>
<%--                        <input id = "city" class="input" type="text" name="city" placeholder="City" >--%>
<%--                    </div>--%>
                    <div class="form-group">
                        <label for="telephone">Telephone </label>
                        <input id = "telephone"class="input" type="tel" name="tel" placeholder="Telephone" value="${userInfo.getPhonenumber()}">
                    </div>
                </div>
                <!-- /Billing Details -->

                <!-- Shiping Details -->
                <div class="shiping-details">
                    <div class="section-title">
                        <h3 class="title">Shiping address</h3>
                    </div>
                    <div class="input-checkbox">
                        <input type="checkbox" id="shiping-address">
                        <label for="shiping-address">
                            <span></span>
                            Ship to a diffrent address?
                        </label>
                        <div class="caption">
                            <div class="form-group">
                                <label for="address-diff">Address </label>
                                <input id = "address-diff" class="input" type="text" name="address" placeholder="Address">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Order Details -->
            <div class="col-md-5 order-details">
                <div class="section-title text-center">
                    <h3 class="title">Your Order</h3>
                </div>
                <div class="order-summary">
                    <div class="order-col">
                        <div><strong>PRODUCT</strong></div>
                        <div><strong>TOTAL</strong></div>
                    </div>
                    <div class="order-products">
                        <c:forEach var="x" items="${listCart}">
                            <div class="order-col">
                                <div>${x.value} x ${x.key.name}</div>
                                <div>
                                    <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber type="currency"
                                                          currencySymbol="VNĐ"
                                                          value="${Integer.parseInt(x.key.price.replace('.','')) * x.value}"
                                        ></fmt:formatNumber></td>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                    <div class="order-col">
                        <div>Shiping</div>
                        <div><strong>FREE</strong></div>
                    </div>
                    <div class="order-col">
                        <div><strong>TOTAL</strong></div>
                        <div><strong class="order-total ${total}"><fmt:setLocale value="vi_VN"/>
                            <fmt:formatNumber type="currency"
                                              currencySymbol="VNĐ"
                                              value="${total}"
                            ></fmt:formatNumber></td></strong></div>
                    </div>
                </div>
                <div class="payment-method">
                    <div class="input-radio-payment">
                        <input type="radio" name="payment" id="payment-1">
                        <label for="payment-1">Payment with cash</label>
                        <div class="content" style="display: none">Payment after receiving and checking.</div>
                    </div>
                    <div class="input-radio-payment">
                        <input type="radio" name="payment" id="payment-2">
                        <label for="payment-2">Payment with cash VNPay</label>
                        <div id="vnpay-choose-language" class="form-group" style="margin: 0 0 0 15px;display: none;">
                            <h5 style="font-family: Raleway, sans-serif;">Choose language for payment:</h5>
                            <input type="radio" id="language" Checked="True" name="language" value="vn">
                            <label for="language" class="font-size:14px">VietNamese</label><br>
                            <input type="radio" id="language" name="language" value="en">
                            <label for="language" class="font-size:14px">English</label><br>
                        </div>
                    </div>
                    <div class="input-checkbox">
                        <input type="checkbox" id="terms">
                        <label for="terms">
                            <span></span>
                            I've read and accept the <a href="#">terms & conditions</a>
                        </label>
                    </div>
                    <button class="primary-btn order-submit">Purchase</button>
                </div>
                <!-- /Order Details -->
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /SECTION -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="../../templates/public/js/payment.js"></script>
    <%@include file="/view/public/chat.jsp" %>
<%@include file="/templates/public/inc/footer.jsp" %>