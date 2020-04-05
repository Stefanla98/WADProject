package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class ReservationController
 */
@WebServlet("/ReservationController")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationController() {
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
		
		String fName = (String) request.getParameter("first_name");
		String lName = (String) request.getParameter("last_name");
		String email = (String) request.getParameter("email");
		String phone = (String) request.getParameter("phone");
		String date = (String) request.getParameter("reserv_date");
		String noGuests = (String) request.getParameter("numb_guests");
		String timeFrom = (String) request.getParameter("alt_reserv_date");
		String timeTo = (String) request.getParameter("time");
		
		
		try {
			UserDAO.getInstance().makeReservation(fName, lName, email, phone, date, noGuests, timeFrom, timeTo);
			request.getRequestDispatcher("frontPage.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
