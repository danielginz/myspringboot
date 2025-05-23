<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${path}/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<script type="text/javascript" src="${path}/webjars/jquery/3.7.1/jquery.min.js"></script>
<%-- <c:set var="path" value="${pageContext.request.contextPath }"></c:set> --%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<%-- ${path} --%>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong> 
			<span class="glyphicon glyphicon-list"></span>User List
		</strong>
		<div class="float-end">
			<a href="javascript:void(0);" onclick="addForm('user')">
				<span class="glyphicon glyphicon-info-plus-sign"></span>New User
			</a>
		</div>
	</div>
	<div class="panel-body">
		<table class="table table-bordered table-condensed table-hover table-striped">
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
						<td><a href="javascript:void(0);" onclick="editForm('user', '${user.id}')"><span class="glyphicon glyphicon-edit"></span></a></td>
						<td><a href="${path}/user/delete/${user.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<p>
	<a href="${path}">Welcome</a>
</p>
