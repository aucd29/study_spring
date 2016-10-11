<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join</title>
</head>
<body>
	<table border="1">
	<tr>
		<td><spring:message code="label.title" /></td>
		<td>${vo.getTitle() }</td>
	</tr>
	<tr>
		<td><spring:message code="label.writer" /></td>
		<td>${vo.getWriter() }</td>
	</tr>
	<tr>
		<td><spring:message code="label.content" /></td>
		<td>${vo.getContent() }</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="modify" onClick="javascript:location.href='./modify?id=${vo.getId()}'" />
			<input type="button" value="back" onClick="javascript:history.back();" />
		</td>
	</tr>
	</table>
</body>
</html>