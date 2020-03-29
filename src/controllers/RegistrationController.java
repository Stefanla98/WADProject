package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationController() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		List<String> errorsReg = new ArrayList<>();
		String name = request.getParameter("uname");
		boolean userExist = false;
		
		if(name == null || name.equals("")) {
			errorsReg.add("Name cannot be empty!");
		}
		
		if(!errorsReg.isEmpty()) {
			request.setAttribute("errorsReg", errorsReg);
			request.getRequestDispatcher("LoginView").forward(request, response);
		}
		
		PrintWriter pw = response.getWriter();
		
		try {
			if(UserDAO.getInstance().userExists(request.getParameter("uname"))){
				errorsReg.add("Username already exists!");
				userExist = true;
				request.setAttribute("errorsReg", errorsReg);
				request.getRequestDispatcher("LoginView").forward(request, response);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(!userExist) {
				UserDAO.getInstance().addUser(request.getParameter("uname"), request.getParameter("password"), request.getParameter("email"), request.getParameter("gender"), 
						request.getParameter("tel"), request.getParameter("country"), request.getParameter("maillist"));
				errorsReg.add("Successfully Registered! Please Sign in!");
				request.setAttribute("errors", errorsReg);
				request.getRequestDispatcher("LoginView").forward(request, response);
			}
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		pw.close();
		
	}

}
