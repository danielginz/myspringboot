<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<c:set var> is not recognized by jstl(?). If it's not commented it will cause "Validation error messages from TagLibraryValidator"  --%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="${path}/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
		<title>Welcome</title>
		<style>
			/* .row {
				margin-top: 50px; margin-left: 0px; margin-right: 0px;
			}
			.menu {
				height: 100%; position: fixed; background-color: #f8f8f8;
			}
			.menu .navbar-nav li {
				width: 100%; border-bottom: 1px solid #e7e7e7;
			} */
		</style>
	</head>
    <body>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			 <form id="logoutForm" method="POST" action="${path}/logout">
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		    </form>
		    
		    
			<nav class="navbar navbar-expand-lg bg-body-tertiary">
			        <div class="navbar-header">
		    			<a class="navbar-brand" href="javascript:void(0);">Tour Java</a>
		    		</div>
		    		
		    		<div class="container-fluid">
					    <!-- <a class="navbar-brand" href="javascript:void(0);">Tour Java</a> -->
					    <div class="collapse navbar-collapse" id="navbarNav">
					      <ul class="navbar-nav w-100">
					        <li class="nav-item">
					          <a class="nav-link active" aria-current="page" href="${path}"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home</a>
					        </li>
					        <li class="nav-item">
					          <a class="nav-link" href="javascript:void(0);"><span class="glyphicon glyphicon-info-sign"></span> About</a>
					        </li>
					        <li class="nav-item">
					          <a class="nav-link" href="javascript:void(0);"><span class="glyphicon glyphicon-phone-alt"></span> Contact</a>
					        </li>
					        <li class="nav-item ms-lg-auto">
								<a href="javascript:void(0);" onclick="document.forms['logoutForm'].submit()">Welcome ${pageContext.request.userPrincipal.name} | <span class="glyphicon glyphicon-log-out"></span> Logout</a>
							</li>
					        <!-- <li class="nav-item">
					          <a class="nav-link disabled" aria-disabled="true">Disabled</a>
					        </li> -->
					      </ul>
							
				    	</div>
  					</div>
		    </nav>
		    
			<div class="aaa">
				<div class="menu navbar navbar-default">
					<div class="menu-container">
						<ul class="nav navbar-nav">
								<li><a href="${path}/user/list"><span class="glyphicon glyphicon-user"></span>User List</a></li>
								<li><a href="${path}/address/list"><span class="glyphicon glyphicon-info-sign"></span>Address List</a></li>
						</ul>
					</div>
				</div>
				<div class="container-fluid">
		    		<div class="inner-jsp panel-body" style="margin-left: 210px;">
		    			<c:forEach begin="0" end="2" varStatus="loop">
		    				<div class="col-md-12">
		    					<h2>${heading}</h2>
		    					<p class="text-justify">${description}</p>
		    				</div>
		    			</c:forEach>
		    		</div>
		    	</div>
			</div>
			<div class="navbar navbar-default navbar-fixed-bottom">
		    	<div class="container">
		    		<div class="col-md-10 navbar-text text-center">© 2025-26, All Rights Reserved by Tour Java</div>
		    	</div>
		    </div>			
		</c:if>
	</body>
</html>