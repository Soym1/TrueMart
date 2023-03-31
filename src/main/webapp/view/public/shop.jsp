<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/public/inc/header.jsp"%>

		<!-- BREADCRUMB -->
<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<h3 class="breadcrumb-header">Shop</h3>
						<ul class="breadcrumb-tree">
							<li><a href="/">Home</a></li>
							<li class="active">Shop</li>
						</ul>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->

<div class="blog ptb-100  ptb-sm-60">
	<div class="container">
		<div class="main-blog">
			<div class="row">
				<c:forEach items="${listShop}" var="LS">
				<!-- Single Blog Start -->
				<div class="col-lg-6 col-sm-12">
					<div class="single-latest-blog">
						<div class="blog-img" style="width: 200px;height: 120px;">
							<a href="/shop?actionUser=view&&ids=${LS.id}"><img src="/templates/public/img/shop/${LS.shopper_details.avatar}" alt="${LS.shopper_details.avatar}" style="    width: 100%;height: 100%;"></a>
						</div>
						<div class="blog-desc">
							<h4><a href="/shop?actionUser=view&&ids=${LS.id}">${LS.shop_name}</a></h4>
							<p>${LS.shopper_details.category}</p>
							<a class="readmore" href="/shop?actionUser=view&&ids=${LS.id}">View Shop</a>
						</div>
						<div class="blog-date">
							<span>${LS.id}</span>
						</div>
					</div>
				</div>
				<!-- Single Blog End -->
				</c:forEach>

			</div>
			<!-- Row End -->
			<div class="row">
				<div class="col-sm-12">
					<div class="pro-pagination">
						<ul class="blog-pagination">
							<c:if test="${numberOfPages > 1}">
								<li class="<c:if test="${currentPage == 1}">disabled</c:if>"><a href="/ListShop?page=${currentPage - 1}"><<</a></li>

							<c:forEach begin="1" end="${numberOfPages}" varStatus="n" >
								<li class="<c:if test="${currentPage == n.index}">active</c:if> "><a href="/ListShop?page=${n.index}">${n.index}</a></li>
							</c:forEach>
							<li class="<c:if test="${currentPage == numberOfPages}">disabled</c:if>"><a href="/ListShop?page=${currentPage + 1}">>></a></li>
							</c:if>
						</ul>
						<div class="product-pagination">
							<span class="grid-item-list"></span>
						</div>
					</div>
					<!-- Product Pagination Info -->
				</div>
			</div>
			<!-- Row End -->
		</div>
	</div>
	<!-- Container End -->
</div>
<style>
	.disabled {
		pointer-events: none;
		background: #BBBBBB !important;
	}
</style>
		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

<%@include file="/templates/public/inc/footer.jsp"%>