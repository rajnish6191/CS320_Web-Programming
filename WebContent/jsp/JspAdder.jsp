<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Adder</title>
</head>
<body>

<h1>JSP Adder</h1>

<%= request.getParameter("op1")  %>
 + 
<%= request.getParameter("op2")  %>
 =
 
 <%
 
 try{
	 int op1 = Integer.parseInt(request.getParameter("op1"));
	 int op2 = Integer.parseInt(request.getParameter("op2"));
	 
	 out.write( op1 + op2 );
 }catch(Exception e){
	 out.write("Invalid input");
 }
 %>
 
<form>
	<input type="text" name="op1" placeholder="Number 1" />
	+
	<input type="text" name="op2" placeholder="Number 2" />
	=
	
	<br />
	<br />
	
	<input type="submit" value="Add" />
	
</form>
</body>
</html>