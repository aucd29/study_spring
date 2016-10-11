<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>LOGIN</title>
</head>
<body>
<h1>
	LOGIN  
</h1>

<P>  LOGIN ${login}. </P>

<table border="1">
<tr>
	<td>id</td>
	<td>title</td>
	<td>writer</td>
	<td>read</td>
</tr>
<c:forEach var="data" items="${list}">
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
