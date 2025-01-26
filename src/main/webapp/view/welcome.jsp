<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<c:set var> is not recognized by jstl(?). If it's not commented it will cause "Validation error messages from TagLibraryValidator"  --%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<html>
<head> 
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
${message}
${path}
<p><a href="${path}/user/list">User List</a></p>
<p><a href="${path}/user/form">Add User</a></p>
<p><a href="${path}/address/list">Address List</a></p>
<p><a href="${path}/address/form">Add Address</a></p>
</body>
</html>