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
    <form action="/ebooks" method="post">
      <div>
        <label>Title</label>
        <input type="text" name="title">
      </div>

      <div>
        <label>Description</label>
        <textarea name="description" rows="8" cols="80"></textarea>
      </div>

      <div>
        <label>Pages</label>
        <input type="text" name="pages">
      </div>
	
      <c:forEach items="${types}" var="priceType" varStatus="status">
        <div>
          <label>${priceType}</label>
          <input type="text" name="prices[${status.index}].value" />
          <input type="hidden" name="prices[${status.index}].type" value="${priceType}">
        </div>
      </c:forEach>

      <button type="submit">Save</button>
    </form>
  </body>
</html>
