<%@ page import="java.io.File" %>
<%@ page import="MVC.model.Product" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/public/inc/header.jsp" %>
<style>
    .slick-list.draggable {
        height: 500px !important;
    }

</style>
<!-- BREADCRUMB -->
<div id="breadcrumb" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <ul class="breadcrumb-tree">
                    <li><a href="/">Home</a></li>
                    <li><a href="<%=request.getContextPath()%>/view/public/store.jsp">Categories</a></li>
                    <li>
                        <a href="<%=request.getContextPath()%>/view/public/store.jsp">${product.category.category_name}</a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /BREADCRUMB -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- Product main img -->
            <div class="col-md-5 col-md-push-2">
                <div id="product-main-img">
                    <div class="product-preview focus-preview">
                        <img src="/templates/public/img/total_category/${product.id}/${product.image}" alt="${product.name}">
                    </div>
                    <%
                        Product product = (Product) request.getAttribute("product");
                        String filePath = application.getRealPath("/templates/public/img/total_category/" + product.getId() + "/2.jpg");
                        File file = new File(filePath);
                        if(!file.exists()){
                            %>
                    <div class="product-preview focus-preview">
                        <img src="/templates/public/img/total_category/${product.id}/${product.image}" alt="${product.name}">
                    </div>
                    <div class="product-preview focus-preview">
                        <img src="/templates/public/img/total_category/${product.id}/${product.image}" alt="${product.name}">
                    </div>
                    <div class="product-preview focus-preview">
                        <img src="/templates/public/img/total_category/${product.id}/${product.image}" alt="${product.name}">
                    </div>

                    <%
                        }else {
                    %>
                    <div class="product-preview focus-preview">
                        <img src="/templates/public/img/total_category/${product.id}/2.jpg" alt="${product.name}">
                    </div>
                    <div class="product-preview focus-preview">
                        <img src="/templates/public/img/total_category/${product.id}/3.jpg" alt="${product.name}">
                    </div>
                    <div class="product-preview focus-preview">
                        <img src="/templates/public/img/total_category/${product.id}/4.jpg" alt="${product.name}">
                    </div>
                    <%
                        }
                    %>

                </div>
            </div>
            <!-- /Product main img -->

            <!-- Product thumb imgs -->
            <div class="col-md-2  col-md-pull-5">
                <div id="product-imgs">
                    <div class="product-preview vertical-preview">
                        <img src="/templates/public/img/total_category/${product.id}/${product.image}" alt="${product.name}">
                    </div>
                    <%
                        filePath = application.getRealPath("/templates/public/img/total_category/" + product.getId() + "/2.jpg");
                        file = new File(filePath);
                        if(!file.exists()){
                    %>
                    <div class="product-preview vertical-preview">
                        <img src="/templates/public/img/total_category/${product.id}/${product.image}" alt="${product.name}">
                    </div>
                    <div class="product-preview vertical-preview">
                        <img src="/templates/public/img/total_category/${product.id}/${product.image}" alt="${product.name}">
                    </div>
                    <div class="product-preview vertical-preview">
                        <img src="/templates/public/img/total_category/${product.id}/${product.image}" alt="${product.name}">
                    </div>

                    <%
                    }else {
                    %>
                    <div class="product-preview vertical-preview">
                        <img src="/templates/public/img/total_category/${product.id}/2.jpg" alt="${product.name}">
                    </div>
                    <div class="product-preview vertical-preview">
                        <img src="/templates/public/img/total_category/${product.id}/3.jpg" alt="${product.name}">
                    </div>

                    <div class="product-preview vertical-preview">
                        <img src="/templates/public/img/total_category/${product.id}/4.jpg" alt="${product.name}">
                    </div>
                    <%
                        }
                    %>

                </div>
            </div>
            <!-- /Product thumb imgs -->

            <!-- Product details -->
            <div class="col-md-5">
                <div class="product-details">
                    <h2 class="product-name">${product.name}</h2>
                    <div>
                        <div class="product-rating">
                            <c:forEach begin="1" end="${trungbinh}">
                                <i class="fa fa-star"></i>
                            </c:forEach>
                            <c:forEach begin="${trungbinh + 1}" end="5">
                                <i class="fa fa-star-o empty"></i>
                            </c:forEach>
                        </div>
                        <a class="review-link" href="#">10 Review(s) | Add your review</a>
                    </div>
                    <div>
                        <h3 class="product-price">${product.price} VNĐ</h3>
                        <span class="product-available">In Stock</span>
                    </div>
                    <p>${o.description}</p>


                    <div class="add-to-cart">
                        <div class="qty-label">
                            Quantity
                            <div class="input-number">
                                <input type="number" value="1">
                                <span class="qty-up qty-up-1">+</span>
                                <span class="qty-down qty-down-1">-</span>
                            </div>
                        </div>
                        <button class="add-to-cart-btn ${product.id}"><i class="fa fa-shopping-cart"></i> add to
                            cart
                        </button>
                    </div>

                    <ul class="product-links">
                        <li>Share:</li>
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="#"><i class="fa fa-envelope"></i></a></li>
                    </ul>

                </div>
            </div>
            <!-- /Product details -->

            <!-- Product tab -->
            <div class="col-md-12">
                <div id="product-tab">
                    <!-- product tab nav -->
                    <ul class="tab-nav">
                        <li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
                        <li><a data-toggle="tab" href="#tab2">Details</a></li>
                        <li><a data-toggle="tab" href="#tab3">Reviews (${numreview})</a></li>
                    </ul>
                    <!-- /product tab nav -->

                    <!-- product tab content -->
                    <div class="tab-content">
                        <!-- tab1  -->
                        <div id="tab1" class="tab-pane fade in active">
                            <div class="row">
                                <div class="col-md-12">
                                    <p style="white-space: pre-line">${product.decription}</p>
                                </div>
                            </div>
                        </div>
                        <!-- /tab1  -->

                        <!-- tab2  -->
                        <div id="tab2" class="tab-pane fade in">
                            <div class="row">
                                <div class="col-md-12">
                                    <p style="white-space: pre-line">${product.details}</p>
                                </div>
                            </div>
                        </div>
                        <!-- /tab2  -->

                        <!-- tab3  -->
                        <div id="tab3" class="tab-pane fade in">
                            <div class="row">
                                <!-- Rating -->
                                <div class="col-md-12">
                                    <div id="rating" style="transform: translateX(40%); margin-bottom: 5rem">
                                        <div class="rating-avg">
                                            <span>${trungbinh}</span>
                                            <div class="rating-stars">
                                                <c:forEach begin="1" end="${trungbinh}">
                                                    <i class="fa fa-star"></i>
                                                </c:forEach>
                                                <c:forEach begin="${trungbinh + 1}" end="5">
                                                    <i class="fa fa-star-o empty"></i>
                                                </c:forEach>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <!-- /Rating -->
                                <div class="col-md-3"></div>
                                <!-- Reviews -->
                                <div class="col-md-6">
                                    <div id="reviews">
                                        <ul class="reviews">
                                            <c:forEach items="${review}" var="o">
                                                <li>
                                                    <div class="review-heading">
                                                        <h5 class="name">${o.user_review}</h5>
                                                        <p class="date">${o.date}</p>
                                                        <div class="review-rating">
                                                            <c:forEach begin="1" end="${o.rating}">
                                                                <i class="fa fa-star"></i>
                                                            </c:forEach>
                                                            <c:forEach begin="${o.rating + 1}" end="5">
                                                                <i class="fa fa-star-o empty"></i>
                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                    <div class="review-body">
                                                        <p>${o.content}</p>
                                                    </div>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                                <!-- /Reviews -->

                                <!-- Review Form -->
                                <div class="col-md-3">
                                    <div id="review-form">
                                        <c:if test="${UserLogin != null}">
                                            <form class="review-form">
                                                <textarea name="txt-content" class="input" id="review"
                                                          placeholder="Your Review"></textarea>
                                                <div name="txt-rating" class="input-rating">
                                                    <span>Your Rating: </span>

                                                    <div class="stars">
                                                        <input id="star5" name="rating" value="5" type="radio"
                                                               class="rating"><label
                                                            for="star5"></label>
                                                        <input id="star4" name="rating" value="4" type="radio"
                                                               class="rating"><label
                                                            for="star4"></label>
                                                        <input id="star3" name="rating" value="3" type="radio"
                                                               class="rating"><label
                                                            for="star3"></label>
                                                        <input id="star2" name="rating" value="2" type="radio"
                                                               class="rating"><label
                                                            for="star2"></label>
                                                        <input id="star1" name="rating" value="1" type="radio"
                                                               class="rating"><label
                                                            for="star1"></label>
                                                    </div>
                                                </div>
                                                <a class="btn btn-primary primary-btn" href="javascript:void(0)"
                                                   role="button" onclick="return getComment(${product.id})">Submit</a>
                                            </form>
                                        </c:if>
                                    </div>
                                </div>
                                <!-- /Review Form -->
                            </div>
                        </div>
                        <!-- /tab3  -->
                    </div>
                    <!-- /product tab content  -->
                </div>
            </div>
            <!-- /product tab -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->


<!-- /Section -->
</div>

<script type="text/javascript">
    function getComment(id) {
        var review = $("#review").val();
        var rating = $(".rating").filter(':checked').val();
        $.ajax({
            url: '/ProductDetail',
            type: 'POST',
            cache: false,
            data: {
                aid: id,
                areview: review,
                arating: rating
            },
            success: function (data) {
                $(".reviews").html(data);
            },
            error: function () {
                alert('Có lỗi xảy ra');
            }
        });
        return false;
    }
</script>
<%@include file="/templates/public/inc/footer.jsp" %>