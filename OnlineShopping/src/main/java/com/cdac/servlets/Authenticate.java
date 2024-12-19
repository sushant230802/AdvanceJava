package com.cdac.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection;
    private PreparedStatement psAuthenticate;
 
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cdac_pune","root","cdac");
			psAuthenticate=connection.prepareStatement(
					"select * from users where userName=? and password=?" );
		}catch(ClassNotFoundException | SQLException e) {
			throw new ServletException("failed to initiatize "
					+ "Authenticate servlet due to db connection issue",e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		if(userName==null || password==null) {
			throw new ServletException("input para issues");
		}
		
		
			

					try {
						psAuthenticate.setString(2, password);
						psAuthenticate.setString(1, userName);
						
						try(ResultSet result=psAuthenticate.executeQuery();)
						{
							if(result.next()) {
								HttpSession session=request.getSession();
								session.setAttribute("userName",userName);
								if(userName.equals("admin")) {
									response.sendRedirect("Administration.html");
								}
								else {
								response.sendRedirect("Category");
								}
							}
							else {
								out.println("authentication failure");
								out.println("you are culprit");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			if(psAuthenticate!=null) {
				psAuthenticate.close();
			}
			if(connection!=null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
