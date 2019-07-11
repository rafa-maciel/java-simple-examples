<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>Software Develpment Ebooks</title>
</head>
<body>
	<h1>Tech Ebooks - Let's code</h1>
	${message}
	<ul>
		<c:forEach var="ebook" items="${ebooks}">
			<li>${ebook.title}</li>
		</c:forEach>
	</ul>

</body>
</html>
