package com.cdac.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AddSession
 */
@WebServlet("/AddSession")
public class AddSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		HttpSession session=request.getSession();
		
		out.println("id:"+session.getId());
		session.setMaxInactiveInterval(20);
		session.setAttribute("data", "this is session");
		session.setAttribute("username", "pankaj");
		out.println("Session created");
		
	}

	
}
