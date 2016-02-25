<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="beanCounter" class="beans.PageCounterBean" scope="application" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page Counter Bean</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>

<div class="container">
	<h1>
		This page has been viewed: <jsp:getProperty name="beanCounter" property="count" />
	</h1>

	<div class="well">
		<p class="lead">
			The counter used to track this page is a bean.  It's current value is: 
			<jsp:getProperty name="beanCounter" property="count" />
		</p>
	</div>

</div>
</body>
</html>