<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Burgerville</title>

    <!-- meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">

    <!-- css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">

    <!-- google font -->
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Kreon:300,400,700'>
    
    <!-- js -->
    <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<body data-spy="scroll" data-target="#navbar" data-offset="120" >

<div class="container" id="container">
	<div class="form-container sign-up-container">
		<form method="post" action="RegistrationController">
			<h1>Create Account</h1>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
			<span>or use your email for registration</span>
			<input type="text" name="uname" placeholder="Name" required minlength="1" />
			<input type="email" name="email" placeholder="Email" />
			<input type="password" name="password" placeholder="Password" required minlength="1"/>
			<button>Sign Up</button>
			
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form method="post" action="LoginController">
			<h1>Sign in</h1>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
			<span>or use your account</span>
			<input type="text" name="uname"  placeholder="username" />
			<input type="password" name="password" placeholder="Password" />
			<a href="#">Forgot your password?</a>
			<button>Sign In</button>
			<c:if test="${not empty requestScope.errors}">
			<c:forEach var="error" items="${errors}">
			${error}
			</c:forEach>
			</c:if>
			<c:if test="${not empty requestScope.errorsReg}">
			<c:forEach var="errorR" items="${errorsReg}">
			${errorR}
			</c:forEach>
			</c:if>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Welcome Back!</h1>
				<p>To keep connected with us please login with your personal info</p>
				<button class="ghost" id="signIn">Sign In</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Hello, Friend!</h1>
				<p>Enter your personal details and start journey with us</p>
				<button class="ghost" id="signUp">Sign Up</button>
			</div>
		</div>
	</div>
</div>

   

    <script src="js/jquery-2.1.3.min.js"></script>
    <script src="js/jquery.actual.min.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>