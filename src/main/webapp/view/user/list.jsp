<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:set var="path" value="${pageContext.request.contextPath }"></c:set> --%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head> 
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
${path}
	<table border="1">
		<thead>
			<tr>
				<th>User Id</th>
				<th>User Name</th>
				<th>Password</th>
				<th>Role</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.userId}</td>
				<td>${user.userName}</td>
				<td>${user.password}</td>
				<td>${user.role.name}</td>
				<td><a href="${path}/user/edit/${user.id}">E</a></td>
				<td><a href="${path}/user/delete/${user.id}">D</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="${path}">Welcome</a></p>
</body>
</html>