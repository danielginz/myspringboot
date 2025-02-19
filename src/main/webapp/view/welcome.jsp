<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<c:set var> is not recognized by jstl(?). If it's not commented it will cause "Validation error messages from TagLibraryValidator"  --%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<html>
<head>
<!-- <script type="text/javascript">
	function myprint() {
	  console.log('AAA');
	};
</script> -->

<!-- https://mkyong.com/spring-security/spring-security-form-login-example/ -->

<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<c:if test="${pageContext.request.userPrincipal.name != null}">
	<form method="post" id="logoutForm" action="${path}/logout">
		<input type="hidden" name="${_csrf.parameterName} value="${_csrf.token}"/>
	</form>
	<p>Welcome {pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()" >Logout</a></p>
	${message}
	<%-- ${path} --%>
	<p><a href="${path}/user/list">User List</a></p>
	<p><a href="${path}/user/form">Add User</a></p>
	<p><a href="${path}/address/list">Address List</a></p>
	<p><a href="${path}/address/form">Add Address</a></p>
</c:if>

</body>
</html>