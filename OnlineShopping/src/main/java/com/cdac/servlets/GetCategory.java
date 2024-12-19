package com.cdac.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteCategory
 */
@WebServlet("/GetCategory")
public class GetCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection;
    private PreparedStatement psSelect;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cdac_pune","root","cdac");
			psSelect=connection.prepareStatement("select * from category");
		}catch (ClassNotFoundException |SQLException e) {
			throw new ServletException("failed to initiatize "
					+ "Authenticate servlet due to db connection issue",e);
		}
	}
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			PrintWriter out=response.getWriter();
			try(ResultSet result=psSelect.executeQuery()){
				out.println("<html>");
				out.println("<body>");
				out.println("<form action='DeleteCategory' method='post'>");
				out.println("<label for='options'>Choose CategoryId</label>");
				out.println("<select id='options' name='categoryId'>");
				while(result.next()) {
					out.println("<option value='"+result.getInt("categoryId")+"'>"+result.getInt("categoryId")+"</option>");
				}
				out.println("</select>");
				out.println("<input type='submit'/>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}

}
