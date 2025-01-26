<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
${path}
</head>
<body>
    <form:form method="post" action="${path}/user/add" modelAttribute="userForm">
    	<form:hidden path="id"/>
		<p>User Id : <form:input path="userId" placeholder="Enter User Id"/> </p>
		<p>User Name : <form:input path="userName" placeholder="Enter User Name"/> </p>
		<p>Password : <form:password path="password" placeholder="Enter Password"/> </p>
		<p>
			Role : 
			<form:select path="role.id">
				<c:forEach items="${roles}" var="role">
					<form:option value="${role.id}">${role.name}</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:button value="Save">Save</form:button>
			<a href="${path}/user/list">List User</a>
		</p>
	</form:form>
</body>
</html>