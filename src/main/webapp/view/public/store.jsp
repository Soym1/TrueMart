<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/public/inc/header.jsp" %>

<!-- BREADCRUMB -->
<div id="breadcrumb" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <ul class="breadcrumb-tree">
                    <li><a href="/">Home</a></li>
                    <li><a href="/view/public/store.jsp">All Categories</a></li>
                </ul>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /BREADCRUMB -->
<c:set var="error" value="${param.err}"></c:set>
<c:if test="${error.equals('1')}">
    <h4 class="Error">Id not exits</h4>
</c:if>
<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- ASIDE -->
            <div id="aside" class="col-md-3">
                <!-- aside Widget -->

                <!-- /aside Widget -->

                <!-- aside Widget -->
                <div class="aside">
                    <h3 class="aside-title">Category</h3>
                    <div class="checkbox-filter">
                        <c:forEach items="${ListC}" var="c">
                        <c:if test="${category == c.category_name}">
                        <div class="input-checkbox">
                            <input type="checkbox" checked id="category-${c.id}">
                            <label for="category-${c.id}" class="checked">
                                <span></span>${c.category_name}</label>
                            </c:if>
                            <c:if test="${category != c.category_name}">
                            <div class="input-checkbox">
                                <input type="checkbox" id="category-${c.id}">
                                <label for="category-${c.id}">
                                    <span></span>${c.category_name}</label>
                                </c:if>
                            </div>
                            </c:forEach>
                            <!-- aside Widget -->
                            <div class="aside">
                                <h3 class="aside-title">Price</h3>
                                <div class="price-filter">
                                    <div id="price-slider"></div>
                                    <div class="input-number price-min">
                                        <input id="price-min" type="number">
                                        <span class="qty-up qty-up-1000">+</span>
                                        <span class="qty-down qty-down-1000">-</span>
                                    </div>
                                    <span></span>
                                    <div class="input-number price-max">
                                        <input id="price-max" type="number">
                                        <span class="qty-up qty-up-1000">+</span>
                                        <span class="qty-down qty-down-1000">-</span>
                                    </div>
                                </div>
                            </div>
                            <!-- /aside Widget -->
                        </div>
                    </div>
                    <!-- /aside Widget -->
                    <!-- aside Widget -->
                    <%--						<div class="aside">--%>
                    <%--							<h3 class="aside-title">Top selling</h3>--%>
                    <%--							<div class="product-widget">--%>
                    <%--								<div class="product-img">--%>
                    <%--									<img src="https://drive.google.com/uc?id=${product.image}" alt="">--%>
                    <%--								</div>--%>
                    <%--								<div class="product-body">--%>
                    <%--									<p class="product-category">Category</p>--%>
                    <%--									<h3 class="product-name"><a href="/ProductDetail?id=${product.id}">product name goes here</a></h3>--%>
                    <%--									<h4 class="product-price">${product.price}<del class="product-old-price">${product.price}</del></h4>--%>
                    <%--								</div>--%>
                    <%--							</div>--%>

                    <%--							<div class="product-widget">--%>
                    <%--								<div class="product-img">--%>
                    <%--									<img src="https://drive.google.com/uc?id=${product.image}" alt="">--%>
                    <%--								</div>--%>
                    <%--								<div class="product-body">--%>
                    <%--									<p class="product-category">Category</p>--%>
                    <%--									<h3 class="product-name"><a href="/ProductDetail?id=${product.id}">product name goes here</a></h3>--%>
                    <%--									<h4 class="product-price">${product.price}<del class="product-old-price">${product.price}</del></h4>--%>
                    <%--								</div>--%>
                    <%--							</div>--%>

                    <%--							<div class="product-widget">--%>
                    <%--								<div class="product-img">--%>
                    <%--									<img src="https://drive.google.com/uc?id=${product.image}" alt="">--%>
                    <%--								</div>--%>
                    <%--								<div class="product-body">--%>
                    <%--									<p class="product-category">Category</p>--%>
                    <%--									<h3 class="product-name"><a href="/ProductDetail?id=${product.id}">product name goes here</a></h3>--%>
                    <%--									<h4 class="product-price">${product.price}<del class="product-old-price">${product.price}</del></h4>--%>
                    <%--								</div>--%>
                    <%--							</div>--%>
                    <%--						</div>--%>
                    <!-- /aside Widget -->
                </div>
                <!-- /ASIDE -->

                <!-- STORE -->
                <div id="store" class="col-md-9">
                    <!-- store top filter -->
                    <div class="store-filter clearfix">
                        <div class="store-sort">
                            <%--                        <label>--%>
                            <%--                            Sort By:--%>
                            <%--                            <select class="input-select">--%>
                            <%--                                <option value="0">Popular</option>--%>
                            <%--                                <option value="1">Position</option>--%>
                            <%--                            </select>--%>
                            <%--                        </label>--%>

                            <label>
                                Show:
                                <select class="input-select">
                                    <option value="0">30</option>
                                    <option value="1">60</option>
                                </select>
                            </label>
                        </div>
                        <ul class="store-grid">
                            <li class="active"><i class="fa fa-th"></i></li>
                            <li><a href="#"><i class="fa fa-th-list"></i></a></li>
                        </ul>
                    </div>
                    <!-- /store top filter -->
                    <!-- store products -->
                    <div class="row" id="show-product">
                        <!-- product -->
                        <c:forEach items="${ListP}" var="o">
                            <div class="col-md-4 col-xs-6">
                                <div class="product category-${o.category.id}">
                                    <a href="/ProductDetail?id=${o.id}">
                                        <div class="product-img store-img">
                                            <img style="position: absolute; bottom: 0; max-height: 100%; padding:10px"
                                                 src="/templates/public/img/total_category/${o.id}/${o.image}"
                                                 alt='${o.image}'
                                            >
                                            <div class="product-label">
                                            </div>
                                        </div>
                                        <div class="product-body store-body">
                                            <p class="product-category">${o.category.category_name}</p>
                                            <h3 class="product-name"><a href="/ProductDetail?id=${o.id}">${o.name}</a>
                                            </h3>
                                            <h4 class="product-price"
                                                style="margin-top: 20px;">${o.price} VNĐ</h4>
                                            <div class="product-rating" style="bottom: 5px">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn ${o.id}"><i class="fa fa-shopping-cart"></i>
                                                add to cart
                                            </button>
                                        </div>
                                    </a>

                                </div>
                            </div>
                        </c:forEach>
                    </div>

                    <!-- /store products -->

                    <!-- store bottom filter -->
                    <div class="store-filter clearfix">
                        <span class="store-qty">Showing 30 products</span>
                        <ul class="store-pagination">
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                        </ul>
                    </div>
                    <!-- /store bottom filter -->
                </div>
                <!-- /STORE -->
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /SECTION -->
</div>

<script>

</script>
<%@include file="/templates/public/inc/footer.jsp" %>
