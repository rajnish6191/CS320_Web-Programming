<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<title>EL Table</title>
</head>
<body style='background-color:#fffbd7;'>
<div class="container">
<center>
<b><u>EL Table</b></u> 
	<br \>
	<br \>
	<br \>           
  <table class="table table-bordered table-striped">
      <tr>
        <th colspan="2" CLASS="colored">Arithmetic Operators</th>
        <th colspan="2" CLASS="colored">Relational Operators</th>
      </tr>
      <tr>
      <th>Expression</th>
      <th>Result</th>
      <th>Expression</th>
      <th>Result</th>
      </tr>

      <tr align="center">
        <td>${"$"}{3+2-1}</td>
        <td>${ 3+2-1 }</td>
        <td>${"$"}{1 < 2} </td>
        <td>${ 1<2 } </td>
      </tr>
      
      <tr align="center">
        <td>${"$"}{"1" + 2}</td>
        <td>${ "1"+2 }</td>
        <td>${"$"}{"a" < "b"} </td>
        <td>${ "a"<"b" } </td>
      </tr>
      
      <tr align="center">
        <td>${"$"}{1 + 2*3 + 3/4}</td>
        <td>${1 + 2*3 + 3/4}</td>
        <td>${"$"}{2/3 >= 3/2} </td>
        <td>${ 2/3>=3/2 } </td>
      </tr>
      
      <tr align="center">
        <td>${"$"}{3 % 2}</td>
        <td>${3%2}</td>
        <td>${"$"}{3/4 == 0.75} </td>
        <td>${ 3/4==0.75 } </td>
      </tr>
      
      <tr align="center">
      	<td>${"$"}{(8 div 2) mod 3}</td>
      	<td>${(8 div 2) mod 3}</td>
      	<td>${"$"}{null == "test"} </td>
      	<td>${ null == "test" } </td>
      </tr>
	  
	  <tr>
        <th colspan="2">Logical Operators</th>
        <th colspan="2"><code>empty</code> Operator</th>
      </tr>
      
      <tr>
      	<th>Expression</th>
      	<th>Result</th>
      	<th>Expression</th>
      	<th>Result</th>
      </tr>
      
      <tr align="center">
      	<td>${"$"}{(1<2) && (4<3)}</td>
      	<td>${(1<2) && (4<3)}</td>
      	<td>${"$"}{empty ""} </td>
      	<td>${ empty "" } </td>
      </tr>
      
      <tr align="center">
      	<td>${"$"}{(1<2) || (4<3)}</td>
      	<td>${(1<2)||(4<3)}</td>
      	<td>${"$"}{empty null} </td>
      	<td>${ empty null } </td>
      </tr>
      
      <tr align="center">
      	<td>${"$"}{!(1 < 2)}</td>
      	<td>${!(1<2)}</td>
      	<td>${"$"}{empty param.blah} </td>
      	<td>${ empty param.blah } </td>
      </tr>
  </table>
</div>
</body>
</html>