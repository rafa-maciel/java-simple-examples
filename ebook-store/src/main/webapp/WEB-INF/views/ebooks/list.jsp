<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>Software Develpment Ebooks</title>
</head>
<body>
	<p><strong>Cart items: ${cart.size}</strong></p>
	<hr />
	<h1>Tech Ebooks - Let's code</h1>
	${message}
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Desciption</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ebook" items="${ebooks}">
				<tr>
					<td>
						<a href="${spring:mvcUrl('EC#detail').arg(0, ebook.id).build()}">${ebook.title}</a>
					</td>
					<td>${ebook.description}</td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>

</body>
</html>
