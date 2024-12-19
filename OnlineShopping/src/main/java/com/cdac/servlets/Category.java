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
 * Servlet implementation class Category
 */
@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
    private PreparedStatement psCategory;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cdac_pune","root","cdac");
			 psCategory=connection.prepareStatement("select * from category");
		} catch (ClassNotFoundException |SQLException e) {
			throw new ServletException("failed to initiatize "
					+ "Authenticate servlet due to db connection issue",e);
		}
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		
		if(session==null) {
			response.sendRedirect("Login.html");
			return;
		}
		String userName=(String)session.getAttribute("userName");
		try(ResultSet result=psCategory.executeQuery();)
			{
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Welcome "+userName+"</h1><br/>");
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<th>Description</th>");
			out.println("<th>Image</th>");
			out.println("</tr>");
			while(result.next()) {
				out.println("<tr>");
				out.println("<td><a href='Products?categoryId="+result.getInt("categoryId")+"'>"+
						result.getString("categoryName")+"</a></td>");
				out.println("<td>"+result.getString("categoryDescription")+"</td>");
				out.println("<td><img src='Images/"+result.getString("categoryImageUrl")+ "' alt='no image' height='60px' width='60px'/></td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			if(psCategory!=null) {
				psCategory.close();
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
