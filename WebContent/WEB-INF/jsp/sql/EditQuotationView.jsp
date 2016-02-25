<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Edit Page</title>
</head>
<body style='background-color:#c5718b;'>
<form action="../FinalExam/EditQuotationController" method="post">
	Author:<input type="text" name="author" value="${editItem.author}"> <br />
	Quotation:<input type="text" name="quote" value="${editItem.quote}"> <br />
	<input type="hidden" name="edit_id" value = "${editItem.id}">
	<input type = "submit" name="submit" value="Edit">
</form>
</body>
</html>