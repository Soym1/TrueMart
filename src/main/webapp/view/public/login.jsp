<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/public/inc/header.jsp"%>
<body>
		<div class="login">
			<h3>Login</h3>
			<form action="" method="post">
				<label for="email">Email</label>
				<input type="text" id="email" name="email" placeholder="Enter your email address..." />
				<label for="password">Password</label>
				<input type="password" id="password" name="password" placeholder="Password" />
				<label><a href="#">Forgot password?</a></label>
				<input type="submit" id="submit" name="submit" value="LOGIN"/>
			</form>
			<p>Don't have account? <a href="/register">Sign Up</a></p>
		</div>
</body>
<%@include file="/templates/public/inc/footer.jsp"%>