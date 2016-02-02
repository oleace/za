<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
     String base = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="icon" type="image/x-icon" href="${path }/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="${path }/favicon.ico" />
	
	<title>version</title>

</head>
<body>
Welcome to BOYA SYNC Service:
当前版本：0.0.1 build-<%=new Date().getTime()%>
</body>
</html>