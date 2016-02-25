<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Intro To EL</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

</head>
<body>

<div class="container">

<h2>
	<small>Request Parameter ('pageTitle')</small>
	${ param.pageTitle }
</h2>

<h2>
	<small>Header ('User-Agent')</small>
	${ header["User-Agent"] }
</h2>

<h2>
	<small>JSESSIONID Cookie: </small> 
	${ cookie.JSESSIONID.value } 
</h2>

<h2>
	<small>Server: </small> 
	${ pageContext.servletContext.serverInfo } 
</h2>

</div>

</body>
</html>