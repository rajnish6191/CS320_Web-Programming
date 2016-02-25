<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AirZip Locator - Rajnish Kumar</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body style='background-color:#c5718b;'>
<div class="container">
	<br>
	<br>
	<center><h3>Airport-Zipcode Locator</h3></center>	
	<center><h3>[By-Rajnish Kumar]</h3></center>
	<center><h3>[CIN: 304470392]</h3></center>
	<br>
	<br>
	<br>
	<form action="AirportZipcodeLocator" method="post">
		<input type="text" placeholder="Type Zipcode" name="zipname" />
		Radius :<input type="text" placeholder="Type Radius" name="zipradius" />
		<input type="submit" value="Search Airport" />
	</form>
	<br>
	<br>
	<form action="AirportZipcodeLocator" method="post">
		<input type="text" placeholder="Type City Name" name="cityname" />
		<!-- Radius: <input type="text" placeholder="Radius" name="cityradius" /> -->
		${error_airport}
		<input type="submit" value="Search Zipcode" />
	</form>
	
	<c:if test="${!empty zipairports}">
	<table class="table table-bordered table-striped table-hover">
		<tr>
			<th>Airport</th>			
			<th>This is the Map</th>
		</tr>
		<c:forEach items="${zipairports}" var="l" >
			<tr>				
				<td>${l.airport}</td>				
				<td>
				<img src="https://maps.googleapis.com/maps/api/staticmap?center=${l.latitude},${l.longitude}&maptype=roadmap&markers=color:red%7Clabel:A%7C${l.latitude},${l.longitude}&zoom=13&size=400x300&scale=1">
				</td>		
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<c:if test="${!empty city_result}">
		<table class="table table-hover table-bordered table-striped">
			<tr>
			<th>City</th>
			<th>Zipcode</th>			
			<th>This is the Map</th>
		</tr>
		<c:forEach items="${city_result}" var="cr">
		<tr>
			<td>${cr.city}</td>
			<td>${cr.zip }</td>
			<td>
				<img src="https://maps.googleapis.com/maps/api/staticmap?center=${cr.latitude},${cr.longitude}&zoom=13&size=400x300&maptype=roadmap&markers=color:blue%7Clabel:A%7C${cr.latitude},${cr.longitude}&scale=1">
			</td>
		</tr>
		</c:forEach>
		</table>
	</c:if>	
</div>
</body>
</html>