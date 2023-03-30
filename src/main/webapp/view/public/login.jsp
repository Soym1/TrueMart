<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/templates/public/inc/header.jsp"%>
<body>
		<div class="login">
			<h3>Login</h3>
			<form action="" method="post">
				<label for="email">Username</label>
				<input type="text" id="email" name="email" placeholder="Enter your username address..." required title="This must be not empty" />
				<label for="password">Password</label>
				<input type="password" id="password" name="password" placeholder="Password" required title="This must be not empty" />
				<label><a href="#">Forgot password?</a></label>
				<input type="submit" id="submit" name="submit" value="LOGIN"/>
			</form>
			<p>Don't have account? <a href="/register">Sign Up</a></p>
		</div>
</body>
<script>
	window.onload = function (){
		if (location.href.split("?")[1] === "err=1"){
			$("body").append('  <div class="alert alert-danger alert-add-cart">\n' +
					'    <strong>Alert!</strong> Your username or password is incorrect\n' +
					'  </div>')
			setTimeout(function (){
				$(".alert-add-cart").remove();
			},5000)
		}
	}
</script>
<%@include file="/templates/public/inc/footer.jsp"%>