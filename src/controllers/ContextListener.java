package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebListener("/ContextListener")
public class ContextListener implements ServletContextListener {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		
		Number n = 0;
		Long count = n.longValue();
	
		sc.setAttribute("counter", count);
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		
	}

}
