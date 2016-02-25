<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display All Users</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

</head>
<body>

<div class="container">

	<p class="text-right">
		<a class="btn btn-primary" href="Login.jsp?action=logout">Logout</a>
	</p>

	<div class="jumbotron">
		<h1>Hello, ${ currentUser }</h1>
	</div>
	
	<h2>List of Users</h2>
	<c:choose>
		<c:when test="${empty users}">
			<p class="lead">There are no users to display</p>
		</c:when>
		<c:otherwise>
		
			<c:forEach items="${ users }" var="user">
				<div class="well">
					<h3><small>Name: </small>${ user.name}</h3>
					<h4><small>Email: </small>${user.email}</h4>
					<h4><small>Password: </small>${user.password}</h4>
				</div>
			</c:forEach>
					
		</c:otherwise>
	</c:choose>
	
</div>
</body>
</html>