package com.cdac.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import com.cdac.cart.CartItem;

/**
 * Servlet implementation class ListCart
 */
@WebServlet("/ListCart")
public class ListCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter(); 
		HttpSession session=request.getSession(false);
		if(session==null) {
			response.sendRedirect("Login.html");
			return;
		}
		Vector<CartItem> objCart=(Vector<CartItem>)session.getAttribute("cart");
		if(objCart==null || objCart.size()<=0) {
			out.println("cart is empty");
		}
		else {
			out.println("<html>");
			out.println("<body>");
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th>Category Id</th>");
			out.println("<th>Product Id</th>");
			out.println("<th>Product Price</th>");
			out.println("</tr>");
			double total=0;
			for(CartItem objItem:objCart) {
				out.println("<tr>");
				out.println("<td>"+objItem.getCategoryId()+"</td>");
				out.println("<td>"+objItem.getProductId()+"</td>");
				out.println("<td>"+objItem.getProductPrice()+"</td>");
				out.println("</tr>");
				total+=objItem.getProductPrice();
			}
			out.println("</table>");
			out.println("Total amount: <b>"+total+"</b></br>");
			out.println("<a href='Category'>Continue Shopping</a></br>");
			out.println("<a href='Card.html'>CheckOut</a></br>");
			out.println("<a href='Logout'>Logout</a></br>");
			out.println("</body>");
			out.println("</html>");

		}
	}
}
