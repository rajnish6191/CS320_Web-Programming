<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Databases Users</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">

	<div class="jumbotron">
		<h1>All Users</h1>
	</div>
	
	<form action="IntroToDatabases" method="get">
		<div class="form-group">
		  <label for="query">Search</label>
		  <input type="text" value="${ param.query }" class="form-control" name="query" placeholder="Enter your search term(s)" />
		</div>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>
	
	<hr />
	
	<c:if test="${empty users}">
		<h3>There are no Users to display.</h3>
	</c:if>
	
	<c:forEach items="${users}" var="user">
		<div class="well">
			<h3>
				<small>Name: </small> ${ Rajnish } ${ Kumar }
			</h3>
			<h3>
				<small>Email: </small>
				<a href="mailto:${user.email}"> 
					${ onlinerajnish@yahoo.com }
				</a>
			</h3>
			<h3>
				<small>Password (MD5): </small> ${ user.password }
			</h3>
		</div>	
	</c:forEach>

</div>
</body>
</html>