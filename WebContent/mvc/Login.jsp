<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:out value="<h1>Hello</h1>" />

<c:if test="${!empty param.action && param.action == 'logout' }">
	<c:remove var="currentUser" scope="session" />
</c:if>

<c:if test="${!empty param.username}">
	<c:set var="currentUser" value="${param.username}" scope="session" />
	<c:redirect url="DisplayUsers" />
</c:if>


<form action="Login.jsp" method="post">
	Username: <input type="text" name="username" />
	<br />
	Password: <input type="text" name="password" />
	<br />
	<input type="submit" value="Login" />
</form>

</body>
</html>