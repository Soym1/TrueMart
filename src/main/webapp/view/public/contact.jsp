<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/public/inc/header.jsp"%>

		<div class="breadcrumb-area mt-30 down">
            <div class="container">
                <div class="breadcrumb">
                    <ul class="d-flex align-items-center horizontal ">
                        <li><a href="/">Home</a></li>
                        <li><a href="/contact" class="active">Contact Us</a></li>
                    </ul>
                </div>
            </div>
            <!-- Container End -->
        </div>


		<div class="contact">
			<h3>Contact Us</h3>
			<c:set var="error" value="${param.err}"></c:set>
			<c:set var="succres" value="${param.msg}"></c:set>
			<c:if test="${error == 1}">
				<p style="color: red">Contact Faild 😞</p>
			</c:if>
			<c:if test="${succres == 1}">
				<p style="color: green">😚 Contact Succres 😚 </p>
			</c:if>

			<form action="" method="post">
				<input type="text" id="name" name="name" placeholder="Name" />
				<input type="email" id="email" name="email" placeholder="Email" />
				<input type="url" id="website" name="website" placeholder="Website" />
				<input type="text" id="subject" name="subject" placeholder="Subject" />
				<textarea id="message" name="message" rows="10" cols="140" placeholder="Write your message" ></textarea>
				<input type="submit" id="submit" name="submit" value="Submit"/>
			</form>
		</div>

		<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d3834.206660369305!2d108.230238!3d16.0547622!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314219a486b7f699%3A0xae6269b629a63e82!2zVHJ1bmcgdMOibSDEkcOgbyB04bqhbyBs4bqtcCB0csOsbmggdmnDqm4gQ29kZUd5bSDEkMOgIE7hurVuZw!5e0!3m2!1svi!2s!4v1677117625659!5m2!1svi!2s" width="100%" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
<%@include file="/view/public/chat.jsp"%>
<%@include file="/templates/public/inc/footer.jsp"%>