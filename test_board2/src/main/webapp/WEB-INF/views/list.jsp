<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><a href="./add"><spring:message code="lable.new"/></a></p>
<table border="1">
<tr>
	<td><spring:message code="label.seq" /></td>
	<td><spring:message code="label.title" /></td>
	<td><spring:message code="label.writer" /></td>
	<td><spring:message code="label.read" /></td>
</tr>

<c:forEach var="data" items="${list }">
<tr>
	<td>${data.getId() }</td>
	<td><a href="./read?id=${data.getId() }">${data.getTitle() }</a></td>
	<td>${data.getWriter() }</td>
	<td>${data.getCount() }</td>
</tr>
</c:forEach>

</table>
</body>
</html>