<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>Software Develpment Ebooks</title>
</head>
<body>
	<h1>Tech Ebooks - Let's code</h1>
	<form:form action="${spring:mvcUrl('EC#save').build()}" method="POST"
		modelAttribute="ebook" enctype="multipart/form-data">

		<div>
			<label>Title</label>
			<form:input path="title" />
			<form:errors path="title" />
		</div>

		<div>
			<label>Description</label>
			<form:textarea path="description" rows="8" cols="80" />
			<form:errors path="description" />
		</div>

		<div>
			<label>Pages</label>
			<form:input path="pages" />
			<form:errors path="pages" />
		</div>

		<div>
			<label>Publication Date</label>
			<form:input path="publicationDate" />
			<form:errors path="publicationDate" />
		</div>

		<c:forEach items="${types}" var="priceType" varStatus="status">
			<div>
				<label>${priceType}</label>
				<form:input path="prices[${status.index}].value" />
				<form:hidden path="prices[${status.index}].type"
					value="${priceType}" />
			</div>
		</c:forEach>
		
		<div>
			<label>Summary</label>
			<input name="summary" type="file" />
		</div>

		<button type="submit">Save</button>
	</form:form>
</body>
</html>
