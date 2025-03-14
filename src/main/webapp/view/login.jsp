<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<p>Login</p>
	<form action="${path}/user/login" method="post" class="form-signin">
		<p style="color:red">${error}</p>
		<p style="color:green">${message}</p>
		<p><input type="text" name="username" placeholder="Enter User Name"/></p>
		<p><input type="password" name="password" placeholder="Password"/></p>
		<p>
			<input type="checkbox" name="remember-me" id="remember-me"/>
			<label>Remember Me</label>
		</p>
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<p><button type="submit">Login</button></p>
	</form>
	
</body>
</html>
<!-- After we created login.jsp, we don't need AuthenticationEntryPoint.java anymore.  -->