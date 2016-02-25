<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="beans.BackgroundColorBean" id="bg" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 

	<jsp:setProperty name="bg" property="r" value="255" />
	<jsp:setProperty name="bg" property="g" param="green" />
	<jsp:setProperty name="bg" property="b" />
	
	<jsp:setProperty name="bg" property="*" />
	
	<style type="text/css">
		body{
			background-color: rgb(
									<jsp:getProperty name="bg" property="r" />,
									${ bg.g },
									${bg.b}
								);
		}
	</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Background Bean</title>
</head>
<body>

<h2>
	2 + 4/2 in EL is ${ 2 + 4 / 2 }
</h2>

<h2>
	JSESSIONID Cookie: ${ cookie.JSESSIONID.value }
</h2>

<h3>
	Red:   <jsp:getProperty name="bg" property="r" />	<br />
	Green: <jsp:getProperty name="bg" property="g" />	<br />
	Blue:  <jsp:getProperty name="bg" property="b" />	<br />
</h3>

</body>
</html>