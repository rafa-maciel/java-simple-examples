<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Software Develpment Ebooks</title>
  </head>
  <body>
    <h1>Tech Ebooks - Let's code</h1>
    <form:form action="${s:mvcUrl('EC#save').build()}" method="POST" modelAttribute="ebook">
    
      <div>
        <label>Title</label>
        <input type="text" name="title">
        <form:errors path="title"/>
      </div>

      <div>
        <label>Description</label>
        <textarea name="description" rows="8" cols="80"></textarea>
        <form:errors path="description"/>
      </div>

      <div>
        <label>Pages</label>
        <input type="text" name="pages">
        <form:errors path="pages"/>
      </div>
	
      <c:forEach items="${types}" var="priceType" varStatus="status">
        <div>
          <label>${priceType}</label>
          <input type="text" name="prices[${status.index}].value" />
          <input type="hidden" name="prices[${status.index}].type" value="${priceType}">
        </div>
      </c:forEach>

      <button type="submit">Save</button>
    </form:form>
  </body>
</html>
