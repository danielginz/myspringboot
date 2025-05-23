<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%-- ${path} --%>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong>
			<span class="glyphicon glyphicon-info-plus-sign"></span>New User
		</strong>
	</div>
	<form:form method="post" class="form-horizontal" action="${path}/user/add" modelAttribute="userForm">
	    <form:hidden path="id"/>
		<div class="panel-body">
			<div class="form-group">
				<%-- <label class="col-md-2 control-label">Full Name : </label>
				<div class="col-md-4">
					<form:input class="form-control" path="fullName" placeholder="Enter Full Name" required="true"/>
				</div> --%>
					
				<label class="col-md-2 control-label">User Id : </label>
				<div class="col-md-4">
					<form:input class="form-control" path="userId" placeholder="Enter User Id" required="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">User Name : </label>
				<div class="col-md-4">
					<form:input class="form-control" path="userName" placeholder="Enter User Name" required="true"/>
				</div>
					
				<label class="col-md-2 control-label">Password : </label>
				<div class="col-md-4">
					<form:password class="form-control" path="password" placeholder="Enter Password" required="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Role : </label>
				<div class="col-md-4">
					<form:select class="form-control" path="role.id">
						<c:forEach items="${roles}" var="role">
							<form:option value="${role.id}">${role.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
		</div>
		<div class="panel-footer">
			<form:button value="Save" class="btn btn-xs btn-default">
				<span class="glyphicon glyphicon-floppy-disk"></span> Save
			</form:button>
		</div>
	</form:form>
</div>