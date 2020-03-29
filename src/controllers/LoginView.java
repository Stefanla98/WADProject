package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginView
 */
@WebServlet("/LoginView")
public class LoginView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		List<String> errors =(List<String>) request.getAttribute("errors");
		List<String> errorsReg =(List<String>) request.getAttribute("errorsReg");
		
		pw.append("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"    <title>Burgerville</title>\r\n" + 
				"\r\n" + 
				"    <!-- meta -->\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no\">\r\n" + 
				"\r\n" + 
				"    <!-- css -->\r\n" + 
				"    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"css/bootstrap-theme.min.css\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"css/login.css\">\r\n" + 
				"\r\n" + 
				"    <!-- google font -->\r\n" + 
				"    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Kreon:300,400,700'>\r\n" + 
				"    \r\n" + 
				"    <!-- js -->\r\n" + 
				"    <script src=\"js/vendor/modernizr-2.6.2-respond-1.1.0.min.js\"></script>\r\n" + 
				"</head>\r\n" + 
				"<body data-spy=\"scroll\" data-target=\"#navbar\" data-offset=\"120\" >\r\n" + 
				"\r\n" + 
				"<div class=\"container\" id=\"container\">\r\n" + 
				"	<div class=\"form-container sign-up-container\">\r\n" + 
				"		<form method=\"post\" action=\"RegistrationController\">\r\n" + 
				"			<h1>Create Account</h1>\r\n" + 
				"			<div class=\"social-container\">\r\n" + 
				"				<a href=\"#\" class=\"social\"><i class=\"fab fa-facebook-f\"></i></a>\r\n" + 
				"				<a href=\"#\" class=\"social\"><i class=\"fab fa-google-plus-g\"></i></a>\r\n" + 
				"				<a href=\"#\" class=\"social\"><i class=\"fab fa-linkedin-in\"></i></a>\r\n" + 
				"			</div>\r\n" + 
				"			<span>or use your email for registration</span>\r\n" + 
				"			<input type=\"text\" name=\"uname\" placeholder=\"Name\" />\r\n" + 
				"			<input type=\"email\" name=\"email\" placeholder=\"Email\" />\r\n" + 
				"			<input type=\"password\" name=\"password\" placeholder=\"Password\" />\r\n" + 
				"			<button>Sign Up</button>\r\n");
				pw.append("			\r\n" + 
				"		</form>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"form-container sign-in-container\">\r\n" + 
				"		<form method=\"post\" action=\"LoginController\">\r\n" + 
				"			<h1>Sign in</h1>\r\n" + 
				"			<div class=\"social-container\">\r\n" + 
				"				<a href=\"#\" class=\"social\"><i class=\"fab fa-facebook-f\"></i></a>\r\n" + 
				"				<a href=\"#\" class=\"social\"><i class=\"fab fa-google-plus-g\"></i></a>\r\n" + 
				"				<a href=\"#\" class=\"social\"><i class=\"fab fa-linkedin-in\"></i></a>\r\n" + 
				"			</div>\r\n" + 
				"			<span>or use your account</span>\r\n" + 
				"			<input type=\"text\" name =\"uname\" placeholder=\"username\" />\r\n" + 
				"			<input type=\"password\" name=\"password\" placeholder=\"Password\" />\r\n" + 
				"			<a href=\"#\">Forgot your password?</a>\r\n" + 
				"			<button>Sign In</button>\r\n");
				if(errors != null && !errors.isEmpty()) {
					for(String error : errors)
						pw.println(error+"</br>");
				}
				if(errorsReg != null && !errorsReg.isEmpty()) {
					for(String error : errorsReg)
						pw.println(error+"</br>");
				}
				pw.append("			\r\n" + 
				"		</form>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"overlay-container\">\r\n" + 
				"		<div class=\"overlay\">\r\n" + 
				"			<div class=\"overlay-panel overlay-left\">\r\n" + 
				"				<h1>Welcome Back!</h1>\r\n" + 
				"				<p>To keep connected with us please login with your personal info</p>\r\n" + 
				"				<button class=\"ghost\" id=\"signIn\">Sign In</button>\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"overlay-panel overlay-right\">\r\n" + 
				"				<h1>Hello, Friend!</h1>\r\n" + 
				"				<p>Enter your personal details and start journey with us</p>\r\n" + 
				"				<button class=\"ghost\" id=\"signUp\">Sign Up</button>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"   \r\n" + 
				"\r\n" + 
				"    <script src=\"js/jquery-2.1.3.min.js\"></script>\r\n" + 
				"    <script src=\"js/jquery.actual.min.js\"></script>\r\n" + 
				"    <script src=\"js/jquery.scrollTo.min.js\"></script>\r\n" + 
				"    <script src=\"js/bootstrap.min.js\"></script>\r\n" + 
				"    <script src=\"js/main.js\"></script>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

}
