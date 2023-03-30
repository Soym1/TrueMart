<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/templates/public/inc/header.jsp" %>
<link rel="stylesheet" href="../../templates/public/CSS/invoice.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"
        integrity="sha512-GsLlZN/3F2ErC5ifS5QtgpiJtWd43JWSuIgh7mbzZ8zBps+dvLusV+eNQATqgA/HdeKFVgA5v3S/cIrLF7QnIg=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<div class="breadcrumb-area mt-30">
    <div class="container">
        <div class="breadcrumb">
            <ul class="d-flex align-items-center">
                <li><a href="/">Home</a></li>
                <li><a href="/view/public/cart.jsp">Cart</a></li>
                <li><a href="/view/public/cart.jsp">Checkout</a></li>
                <li class="active"><a>Bill</a></li>
            </ul>
        </div>
    </div>
    <!-- Container End -->
</div>
<!-- Breadcrumb End -->

<!-- Cart Main Area Start -->
<div class="container">
    <div class="download-btn">
        <button id="download-invoice">
            <i class="fa fa-download" aria-hidden="true">
                <span class="download-span">Download invoice</span>
            </i>
        </button>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="card" id="invoice">
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="mb-4 pull-left">
                                <ul class="list list-unstyled mb-0 text-left">
                                    <li><img src="/templates/public/img/header.png" id="img-header"alt="logo"> </li>
                                    <li>169-C, Technohub</li>
                                    <li>Dubai Silicon Oasis</li>
                                    <li>(+800) 123 456 789)</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="mb-4 ">
                                <div class="text-sm-right">
                                    <h4 class="invoice-color mb-2 mt-md-2">Invoice ${result.code}</h4>
                                    <ul class="list list-unstyled mb-0">
                                        <li>Date: <span class="font-weight-semibold">${result.payDate}</span></li>
<%--                                        <li>Due date: <span class="font-weight-semibold">March 30, 2020</span></li>--%>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="d-md-flex flex-md-wrap">
                        <div class="mb-4 mb-md-2 text-left"><span class="text-muted">Invoice To:</span>
                            <ul class="list list-unstyled mb-0">
                                <li>
                                    <h5 class="my-2">${customerInfo.firstname} ${customerInfo.lastname}</h5>
                                </li>
                                <li><span class="font-weight-semibold">${result.address}</span></li>

                                <li>${customerInfo.phonenumber}</li>
                                <li><a href="#" data-abc="true"></a>${customerInfo.email}</li>
                            </ul>
                        </div>

                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table table-lg">
                        <thead>
                        <tr>
                            <th style="width: 10px;">Image</th>
                            <th>Product</th>
                            <th style="width:150px">Shop</th>
                            <th style="width:150px">Price</th>
                            <th>Quantity</th>
                            <th style="width:150px">Discount</th>
                            <th style="width:150px">Total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="x" items="${listCart}">
                            <tr>
                                <td><img src="/templates/public/img/total_category/${x.key.id}/1.jpg"></td>
                                <td>
                                    <a href="/ProductDetail?id=${x.key.id}" style="font-size: 16px">${x.key.name}</a>
                                </td>
                                <td>${x.key.shop.shop_name}</td>
                                <td>${x.key.price} VNĐ</td>
                                <td><span class="font-weight-semibold">${x.value}</span></td>
                                <td>${discount} VNĐ</td>
                                <td><fmt:setLocale value="vi_VN"/>
                                    <fmt:formatNumber type="currency"
                                                      currencySymbol="VNĐ"
                                                      value="${Integer.parseInt(x.key.price.replace('.','')) * x.value}"
                                    ></fmt:formatNumber>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
                <div class="card-body">
                    <div class="d-md-flex flex-md-wrap">
                        <div class="mb-2 ml-auto"><span class="text-muted">Payment Details:</span>
                            <div class="d-flex flex-wrap wmin-md-400">
                                <ul class="list list-unstyled mb-0 text-left">
                                    <li>
                                        <h5 class="my-2">Total Due:</h5>
                                    </li>
                                    <li>Method Payment:</li>
                                    <c:if test="${result.method.equals('VNPay')}">
                                        <li>Bank code:</li>
                                        <li>VNPAY Response Code:</li>
                                        <li>Paydate:</li>
                                    </c:if>
                                </ul>
                                <ul class="list list-unstyled text-right mb-0 ml-auto">
                                    <li>
                                        <h5 class="font-weight-semibold my-2">                                    <fmt:setLocale value="vi_VN"/>
                                            <fmt:formatNumber type="currency"
                                                              currencySymbol="VNĐ"
                                                              value="${total}"
                                            ></fmt:formatNumber></td></h5>
                                    </li>
                                    <li><span class="font-weight-semibold">${result.method}</span></li>
                                    <c:if test="${result.method.equals('VNPay')}">
                                        <li><span class="font-weight-semibold">${result.bankCode}</span></li>
                                        <li><span class="font-weight-semibold">${result.ResponseCode}</span></li>
                                        <li><span class="font-weight-semibold">${result.payDate}</span></li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    const button = document.getElementById("download-invoice");

    function generatePDF() {
        const element = document.getElementById("invoice");
        var opt = {
            margin:       0,
            filename:     ${result.code} +'.pdf',
            image:        { type: 'jpeg', quality: 0.98 },
            html2canvas:  { scale: 2 },
            jsPDF:        { unit: 'in', format: 'a4', orientation: 'portrait' },
        };
        html2pdf().set(opt).from(element).save();
    }

    button.addEventListener("click", generatePDF);
</script>
<%@include file="/view/public/chat.jsp" %>
<%@include file="/templates/public/inc/footer.jsp" %>