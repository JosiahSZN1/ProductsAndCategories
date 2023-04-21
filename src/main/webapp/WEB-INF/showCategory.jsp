<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Category Page</title>
</head>
<body>
	<div class="container">
		<h1><c:out value="${thisCategory.name}"/></h1>
		<p><a href="/">Home</a></p>
		<hr>
		<h2>Products: </h2>
		<ul>
			<c:forEach var="product" items="${assignedProducts}">
				<li><c:out value="${product.name}"/></li>
			</c:forEach>
		</ul>
		<hr>
		<h2>Add Product: </h2>
		<form action="/categories/${thisCategory.id}" method="post">
			<select name="productID">
				<c:forEach var="product" items="${unassignedProducts}">
					<option value="${product.id}">${product.name}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Add">
		</form>
	</div>
</body>
</html>