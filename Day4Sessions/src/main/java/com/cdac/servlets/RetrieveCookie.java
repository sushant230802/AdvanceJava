package com.cdac.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RetrieveCookie
 */
@WebServlet("/RetrieveCookie")
public class RetrieveCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie [] allCookies=request.getCookies();
		PrintWriter out=response.getWriter();
		if(allCookies==null || allCookies.length<=0) {
			out.println("no cookies sent from client");
		}
		else {
			for(Cookie objCookie: allCookies) {
				out.println("name:"+objCookie.getName());
				out.println("value:"+objCookie.getValue());
				out.println("age:"+objCookie.getMaxAge());
			}
		}
	}
}
