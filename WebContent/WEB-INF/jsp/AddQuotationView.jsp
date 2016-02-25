<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Add Page</title>
</head>
<body style='background-color:#fffbd7;'>
<a href="../FinalExam/QuotationController">Back to QuotationController</a>
<br>
<br>
<br>

<%
   if((String)request.getAttribute("success") == "false")
   {
	  %> 
	   <b> Empty Field Error </b>
	  <% 
   }

%>

<form action="../FinalExam/AddQuotationController" method="post">
<table>
<tr>
<td><label>Author</label></td>
<td><input type="text" name="author" placeholder="Author" /></td></br>
</tr>
<tr>
<td><label>Quote</label></td>
<td><input type="text" name="quote" placeholder="Quotation" /></td></br>
<td><input type="submit" value="Add Quotation">
</tr>
</table>
</form>
</body>
</html>