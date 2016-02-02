<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="jstl-core" prefix="c" %>
<%@ taglib uri="jstl-fmt" prefix="fmt" %>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<fmt:setBundle basename="conf/messages" var="msgf"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>登录 - <fmt:message key="app.name" bundle="${msgf }"/></title>
    <meta content="" name="author">
    <meta content="" name="Copyright">
    <meta content="" name="description">
    <meta content="" name="keywords">

    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

</head>

<body>
 这个就是登陆页面
</body>
</html>