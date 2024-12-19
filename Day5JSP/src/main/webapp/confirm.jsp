<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="objUser" class="com.cdac.beans.User" scope="session"/>
	<jsp:setProperty property="*" name="objUser"/>
	
	UserName:<jsp:getProperty property="userName" name="objUser"/>
	<br/>
	Password:<jsp:getProperty property="password" name="objUser"/>
	<br/>
	Name:<jsp:getProperty property="name" name="objUser"/>
	<br/>
	Email:<jsp:getProperty property="email" name="objUser"/>
	<br/>
	
	<a href="register.jsp">Register</a>
	
</body>
</html>