<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<%-- <c:set var="path" value="${pageContext.request.contextPath }"></c:set> --%>
<c:set var="path" value="${pageContext.request.contextPath}" />
${path}
<div class="panel panel-default">
	<div class="panel-heading">
		<strong> 
			<span class="glyphicon glyphicon-info-sign"></span>Address List
		</strong> 
	</div>
	<div class="panel-body">
		<table class="table table-bordered table-condensed table-hover table-striped">
			<thead>
				<tr>
					<th>Country</th>
					<th>State</th>
					<th>City</th>
					<th>User</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${addresses}" var="address">
					<tr>
						<td>${address.country}</td>
						<td>${address.state}</td>
						<td>${address.city}</td>
						<td>${address.user.userName}</td>
						<td><a href="${path}/address/edit/${address.id}"><span class="glyphicon glyphicon-edit"></a></td>
						<td><a href="${path}/address/delete/${address.id}"><span class="glyphicon glyphicon-trash"></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<p>
	<a href="${path}">Welcome</a>
</p>
