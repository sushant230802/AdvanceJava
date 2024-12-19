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
<%  Class.forName("com.mysql.cj.jdbc.Driver");
	try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac_pune","root","cdac");
		PreparedStatement psAuthenticate=connection.prepareStatement("select * from users where userName=? and password=?");	
			){
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		psAuthenticate.setString(1,userName);
		psAuthenticate.setString(2,password);
		ResultSet result=psAuthenticate.executeQuery();
		if(result.next()){
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);
			response.sendRedirect("category.jsp");	
		}
		else{
%>	
		<font color="red">Invalid username/password</font>
		<jsp:include page="login.html"/>
		<%
			}
		}
		%>
</body>
</html>