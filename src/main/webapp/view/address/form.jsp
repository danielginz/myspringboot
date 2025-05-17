<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!-- if you use commandName (instead of modelAttribute), 
you will get "java.lang.IllegalStateException: Neither BindingResult nor plain target object for bean name 'command' available as request attribute" -->
<%-- ${path} --%>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong>
			<span class="glyphicon glyphicon-info-plus-sign"></span>New Address
		</strong>
	</div>
	<form:form method="post" class="form-horizontal" action="${path}/address/add" modelAttribute="addressForm" required="true">
		<form:hidden path="id"/>
		<div class="panel-body">
			<div class="form-group">
				<label class="col-md-2 control-label">Country: </label>
				<div class="col-md-4">
					<form:input class="form-control" path="country" placeholder="Enter Country" required="true"/>
				</div>
				
				<label class="col-md-2 control-label">State: </label>
				<div class="col-md-4">
					<form:input class="form-control" path="state" placeholder="Enter State" required="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">City : </label>
				<div class="col-md-4">
					<form:input  class="form-control" path="city" placeholder="Enter City" required="true"/> 
				</div>
				
				<label class="col-md-2 control-label">User :</label>
				<div class="col-md-4">
					<form:select class="form-control" path="user.id">
						<c:forEach items="${users}" var="user">
							<form:option value="${user.id}">${user.userName}</form:option>
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