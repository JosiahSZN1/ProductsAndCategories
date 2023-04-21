<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Product Page</title>
</head>
<body>
	<div class="container">
		<h1><c:out value="${thisProduct.name}"/></h1>
		<p><a href="/">Home</a></p>
		<hr>
		<h2>Categories: </h2>
		<ul>
			<c:forEach var="category" items="${assignedCategories}">
				<li><c:out value="${category.name}"/></li>
			</c:forEach>
		</ul>
		<hr>
		<h2>Add Category: </h2>
		<form action="/products/${thisProduct.id}" method="post">
			<select name="categoryID">
				<c:forEach var="category" items="${unassignedCategories}">
					<option value="${category.id}">${category.name}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Add">
		</form>
	</div>
</body>
</html>