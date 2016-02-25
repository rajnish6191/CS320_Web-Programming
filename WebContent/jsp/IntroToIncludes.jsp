<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="pageBean" class="beans.PageDataBean" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Intro To Includes</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

</head>
<body>
<jsp:setProperty property="pageTitle" name="pageBean" value="Intro To Includes"/>
<jsp:include page="includes/header.jsp"/>

<div class="container">
	<div class="well">
		<h2 class="text-center">This is the body of the page.</h2>
	</div>
</div>
</body>
</html>