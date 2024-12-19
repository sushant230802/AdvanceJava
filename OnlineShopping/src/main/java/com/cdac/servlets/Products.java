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
 * Servlet implementation class Product
 */
@WebServlet("/Products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
    private PreparedStatement psProducts;
 
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cdac_pune","root","cdac");
			 psProducts=connection.prepareStatement(
					"select * from products where categoryId=?" );
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
		
		try {
			String temp=request.getParameter("categoryId");
			int categoryId=Integer.parseInt(temp);
			psProducts.setInt(1,categoryId);
			
			try(ResultSet result=psProducts.executeQuery()){
				out.println("<html>");
				out.println("<body>");
				out.println("<h1>Welcome "+userName+"</h1><br/>");
				out.println("<table border='1'>");
				out.println("<tr>");
				out.println("<th>Name</th>");
				out.println("<th>Description</th>");
				out.println("<th>Price</th>");
				out.println("<th>Image</th>");
				out.println("</tr>");
				
				while(result.next()) {
					out.println("<tr>");
					out.println("<td>"+result.getString("productName")+"</td>");
					out.println("<td>"+result.getString("productDescription")+"</td>");
					out.println("<td>"+result.getString("productPrice")+"</td>");
					out.println("<td><img src='Images/"+result.getString("productImageUrl")+"' height='60px' width='60px'/></td>");
					out.println("<td><a href='AddCart?categoryId="
					+result.getInt("categoryId")
					+"&productId="
					+result.getInt("productId")
					+"&productPrice="
					+result.getFloat("productPrice")
					+"'>Add to Cart</a></td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
			}
		}
			catch(SQLException e2) {
				e2.printStackTrace();
		}
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			if(psProducts!=null) {
				psProducts.close();
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
