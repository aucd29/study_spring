<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ex.board1.data.BoardVo"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	LIST
</h1>

<P>  The time on the server is ${serverTime}. </P>
<ul>
<c:forEach var="data" items="${list }">
<li>${data}</li>
</c:forEach>
</ul>

<table border="1">
<tr>
	<td>id</td><td>title</td><td>writer</td><td>read</td>
</tr>
<c:forEach var="data" items="${list2}">
<tr>
	<td>${data.getSeq()}</td>
	<td>${data.getTitle()}</td>
	<td>${data.getWriter()}</td>
	<td>${data.getCnt()}</td>
</tr>
</c:forEach>
</table>

</body>
</html>
