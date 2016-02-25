<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Quotation Page</title>
</head>
<body style='background-color:#aeaeae;'>
<form action="../FinalExam/QuotationController" method="get">
		<div class="form-group">
		  <label for="query">Search</label>
		  <input type="text" value="${ param.query }" class="form-control" name="query" placeholder="By Author/Quotation" />
		</div>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>
<c:if test="${empty quotes}">
		<h3>No Users to display</h3>
	</c:if>
			<Table border="2">
			<tr><th>Author</th><th>Quotation</th><th>Delete</th><th>Edit</th></tr>
			
			<c:forEach items="${quotes}" var="quotes">
		
			<tr>
			<% if((String)request.getAttribute("highlight") == "true")
			   {
				%>
				<td bgcolor="#FF0000">${quotes.author}</td>
				<td bgcolor="#00FF00">${quotes.quote}</td>
				<%
			   }
				else {
					
					%>
					<td>${quotes.author}</td>
					<td>${quotes.quote}</td>
					<%
					
					
				}
				
			%>
			
			<td><a href="../FinalExam/QuotationController?delete=${quotes.id}">Delete</a></td>
			<td><a href="../FinalExam/EditQuotationController?edit=${quotes.id}">Edit</a></td>
			</tr>	
			</c:forEach>
			<tr>
			<br>
			<a href="../FinalExam/AddQuotationController">Add Quotation</a>
			</tr>
			</Table>
</body>
</html>