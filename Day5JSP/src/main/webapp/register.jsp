<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
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

<jsp:useBean id="objUser" scope="session" type="com.cdac.beans.User"/>
	
	<%
	 Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac_pune","root","cdac");
			PreparedStatement psInsert=connection.prepareStatement("insert into users values(?,?,?,?)");	
				){
			psInsert.setString(1,objUser.getUserName());
			psInsert.setString(2,objUser.getPassword());
			psInsert.setString(3,objUser.getName());
			psInsert.setString(4,objUser.getEmail());
			psInsert.executeUpdate();
		}
	%>
	User Registered

	</body>
</html>