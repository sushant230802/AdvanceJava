<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	for(int temp=0;temp<20;temp++){
	%>
	<h3><%= new java.util.Date() %></h3>
	<%
	}
	%>
	
	<%
		for(int temp=0;temp<20;temp++){
			out.println(new java.util.Date());
		}
	%>
</body>
</html>