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
 * Servlet implementation class RetrieveSession
 */
@WebServlet("/RetrieveSession")
public class RetrieveSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		HttpSession session=request.getSession(false);
		
		if(session==null) {
			out.println("no session for this user ,need to login again");
		}
		else {
			out.println(session.getAttribute("data"));
			out.println(session.getAttribute("userName"));
			out.println("id:"+session.getId());
			out.println("inactive:"+session.getMaxInactiveInterval());
		}
		
	}



}
