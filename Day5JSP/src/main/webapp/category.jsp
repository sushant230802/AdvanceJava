<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome <b><%= session.getAttribute("userName") %></b>
<br/><%= session.getAttribute("password") %>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Image</th>
		</tr>
		<% 
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac_pune","root","cdac");
			PreparedStatement psCategory=connection.prepareStatement("select * from category");
			ResultSet result=psCategory.executeQuery();
				){
			while(result.next()){ %>
			<tr>
			<td><%= result.getString("categoryName")+"a" %></td>
			<td><%= result.getString("categoryDescription") %></td>
			<td><img src='<%= "Images/"+ result.getString("categoryImageUrl")%>' alt="no image shown"></td>
			</tr>
			<%
			}
		}
		%>
	</table>
</body>
</html>