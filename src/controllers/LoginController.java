package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> errors = new ArrayList<>();
		String name = request.getParameter("uname");
		String password = request.getParameter("password");
		
		Integer count = (int)(long) getServletContext().getAttribute("counter");
		
		++count;
		ServletContext sc = getServletContext();
		sc.setAttribute("counter", count);
		
		if(name == null || name.equals("")) {
			errors.add("Name cannot be empty!");
		}
		
		PrintWriter pw = response.getWriter();
		
		try {
			if(UserDAO.getInstance().loginVerification(name, password)) {
				request.getSession().setAttribute("user", name);
				request.getRequestDispatcher("frontPage.jsp").forward(request, response);
			} else {
				errors.add("Username and/or password combination is wrong!");
				request.setAttribute("errors", errors);
				request.getRequestDispatcher("LoginRegisterView.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 

}
