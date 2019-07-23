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
	<h1>This is your cart items, please buy it all, otherwise I will keep poor =(</h1>
	${message}
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Total</th>
				<th>Remove</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ cart.items }">
				<tr>
					<td>
						${ item.ebook.title }
					</td>
					<td>${ item.price }</td>
					<td>
						<input type="number" name="quantity" value="${ cart.getSize(item) }" />
					</td>
					<td>${ cart.getTotal(item) }</td>
					<td>
						<form action="${spring:mvcUrl('CC#remove').arg(0, item.ebook.id).arg(1, item.typePrice).build()}" method="post">			
							<button type="submit">Remove</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					<form action="${spring:mvcUrl('PC#finish').build()}" method="post">
						<button type="submit">Buy All</button>
					</form>
				</td>
				<td>
					${cart.total}
				</td>
			</tr>
		</tfoot>
		
	</table>
	
	

</body>
</html>
