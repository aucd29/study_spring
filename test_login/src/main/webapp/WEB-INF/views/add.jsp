<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join</title>
</head>
<body>
<form action="./add" method="post">
	<table border="1">
	<tr>
		<td><spring:message code="label.title" /></td>
		<td><input type="text" name="title" /></td>
	</tr>
	<tr>
		<td><spring:message code="label.writer" /></td>
		<td><input type="text" name="writer" /></td>
	</tr>
	<tr>
		<td><spring:message code="label.content" /></td>
		<td><textarea name="content" ></textarea></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="<spring:message code="label.submit" />" /></td>
	</tr>
	</table>
</form>
</body>
</html>