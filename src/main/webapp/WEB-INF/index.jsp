<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<title>Home</title>
</head>
<body>
	<div class="container">
		<h1>Home Page</h1>
		<p><a href="/products/new">New Product</a></p>
		<p><a href="/categories/new">New Category</a></p>
		<hr>
		<table class ="table table-bordered">
			<thead>
				<tr>
					<th>Products</th>
					<th>Categories</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<ul>
							<c:forEach var="product" items="${products}">
								<li><a href="/products/${product.id}"><c:out value="${product.name}"/></a></li>
							</c:forEach>
						</ul>
					</td>
					<td>
						<ul>
							<c:forEach var="category" items="${categories}">
								<li><a href="/categories/${category.id}"><c:out value="${category.name}"/></a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>