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
 * Servlet implementation class RegisterView
 */
@WebServlet("/RegisterView")
public class RegisterView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterView() {
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
		
		pw.append("<h1>Registration form</h1>   \r\n" + 
				"            <form method=\"post\" action=\"RegistrationController\"> \r\n" + 
				"              <div class=\"form-element\">\r\n" + 
				"                    <label for=\"name\">Name</label>\r\n" + 
				"                    <input type=\"text\" name=\"name\" id=\"name\" size=\"40\" required minlength=\"1\">\r\n" + 
				"                    <span id=\"name-error\" class=\"error-message\"></span>\r\n" + 
				"                </div>\r\n" + 
				"                <div class=\"form-element\">\r\n" + 
				"                    <label for=\"username\">Username</label>\r\n" + 
				"                    <input type=\"text\" name=\"uname\" id=\"uname\" required minlength=\"1\">\r\n" + 
				"                </div>\r\n" + 
				"                <div class=\"form-element\">\r\n" + 
				"                    <label for=\"password\">Password</label>\r\n" + 
				"                    <input type=\"password\" name=\"password\" id=\"password\" required minlength=\"1\" pattern=\"^\\S{6,}$\" onchange=\"this.setCustomValidity(this.validity.patternMismatch ? 'Must have at least 6 characters' : ''); if(this.checkValidity()) form.rPassword.pattern = this.value;\" placeholder=\"Password\"\r\n" + 
				"                    >\r\n" + 
				"                </div>\r\n" + 
				"                <div class=\"form-element\">\r\n" + 
				"                    <label for=\"rPassword\">Repeat password</label>\r\n" + 
				"                    <input type=\"password\" id=\"rPassword\" required minlength=\"1\" pattern=\"^\\S{6,}$\" onchange=\"this.setCustomValidity(this.validity.patternMismatch ? 'Please enter the same Password as above' : '');\" oninvalid=\"this.setCustomValidity('Please enter the same password')\" placeholder=\"Verify Password\">\r\n" + 
				"                </div>\r\n" + 
				"                <div class=\"form-element\">\r\n" + 
				"                    <label for=\"email\">Email</label>\r\n" + 
				"                    <input type=\"email\" id=\"email\" name=\"email\" required minlength=\"1\">\r\n" + 
				"                </div>\r\n" + 
				"                <div class=\"form-element\">\r\n" + 
				"                    <label for=\"gender\">Gender</label>\r\n" + 
				"                    Male<input type=\"radio\" name=\"gender\" value=\"male\" checked> \r\n" + 
				"                    Female<input type=\"radio\" name=\"gender\" value=\"female\"> \r\n" + 
				"                </div>\r\n" + 
				"                <div class=\"form-element\">\r\n" + 
				"                    <label for=\"tel\">Telephone</label>\r\n" + 
				"                    <input type=\"tel\" name=\"tel\" id=\"tel\" required minlength=\"1\" onchange=\"this.setCustomValidity(this.validity.patternMismatch \r\n" + 
				"                    ? 'Enter Phone number here, only numbers, use 00 instead of +' : '');\">\r\n" + 
				"                </div>\r\n" + 
				"                <div class=\"form-element\">\r\n" + 
				"                    <label for=\"country\">Country</label>\r\n" + 
				"                    <select name=\"country\" id=\"country\">\r\n" + 
				"                        <option>Romania</option>\r\n" + 
				"                        <option>Italy</option>\r\n" + 
				"                        <option>France</option>\r\n" + 
				"                        <option>Germany</option>\r\n" + 
				"                    </select>\r\n" + 
				"                </div>\r\n" + 
				"                <div class=\"form-element\">\r\n" + 
				"                    <label for=\"maillist\">Subscribe to maillist</label>\r\n" + 
				"                    <input type=\"checkbox\" name=\"maillist\" id=\"maillist\">\r\n" + 
				"                </div> \r\n" + 
				"                  <div class=\"form-element\">\r\n" + 
				"                    <input type=\"submit\" value=\"Submit\" onc>\r\n" + 
				"                    <input type=\"reset\" value=\"Reset\">\r\n" + 
				"                </div>  \r\n" + 
				"                      \r\n" + 
				"                    \r\n" + 
				"            </form>");
				if(errors != null && !errors.isEmpty()) {
					for(String error : errors)
						pw.println(error+"</br>");
				}
	}

}
