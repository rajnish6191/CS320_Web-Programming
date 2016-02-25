<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC Register</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

</head>
<body>

<div class="container">

<form action="../mvc/RegisterUser" method="get">

<p class="text-danger">
	${ nameError }
</p>
<label>Name</label>
<input type="text" name="name" value="${param.name}"/>

<br />

<p class="text-danger">
	${ emailError }
</p>
<label>E-mail</label>
<input type="text" name="email" value="${param.email}"/>

<br />

<p class="text-danger">
	${ passwordError }
</p>
<label>Password</label>
<input type="password" name="password" value="${param.password}"/>

<br />

<input type="submit" value="Register" />

</form>
</div>
</body>
</html>