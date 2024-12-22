package com.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.entity.User;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String userName=request.getParameter("userName");
	String password=request.getParameter("password");
	ServletContext application = getServletContext();
	SessionFactory hibernateFactory=(SessionFactory)application.getAttribute("hibernateFactory");
	System.out.println(hibernateFactory);
	try (Session hibernateSession = hibernateFactory.openSession()) {
		User objUser=hibernateSession.get(User.class, userName);
		System.out.println(objUser);
		if(objUser!=null) {
			if(objUser.getPassword().equals(password)) {
				//response.sendRedirect("Category.jsp");
				response.getWriter().println("go to category display");
				return;
			}
		}
		response.sendRedirect("Login.html");
		
		
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
