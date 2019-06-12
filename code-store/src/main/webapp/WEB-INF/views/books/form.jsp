<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>CodeHome - Create new Book</title>
  </head>
  <body>
    <h1>Create new Book</h1>
    <form action="/code-store/books" method="post">
      <div>
        <label for="title">Title</label>
        <input type="text" name="title" value="" id="title">
      </div>
      <div>
        <label for="description">Description</label>
        <textarea name="description" rows="10" cols="80" id="description"></textarea>
      </div>
      <div>
        <label for="pages">Pages</label>
        <input type="number" name="pages" value="" id="pages">
      </div>

      <button type="submit">Save</button>
    </form>
  </body>
</html>
