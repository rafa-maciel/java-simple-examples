<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>Software Develpment Ebooks</title>
</head>
<body>

	<h1>${ebook.title}</h1>
	<p>${ebook.description}</p>
	<p><fmt:formatDate value="${ebook.publicationDate.time}" pattern="MM/yyyy"/></p>
	<p>${ebook.pages}</p>
	<p>You can see more in <a href="#" class="summary">here</a></p>

	<form class="add-cart" action='<c:url value="/cart/add"/>' method="post">
		<input type="hidden" name="ebookId" value="${ebook.id}"/>
		<ul>
			<c:forEach items="${ebook.prices}" var="price">
				<li>
					<input type="radio" name="typePrice" value="${price.type}"/>
					<p>${price.value}</p>
				</li>
			</c:forEach>
		</ul>
		<button type="submit">Buy Now</button>
	</form>

</body>
</html>
