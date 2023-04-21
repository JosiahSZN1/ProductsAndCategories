<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>New Product</title>
</head>
<body>
	<div class="container">
		<h1>New Product</h1>
		<p><a href="/">Home</a></p>
		<hr>
		<form:form action="/products/new" method="post" modelAttribute="newProduct">
			<table>
				<thead>
					<tr>
						<td>Name: </td>
						<td>
							<form:errors path="name" class="text-danger"/>
							<form:input path="name" class="form-control"/>
						</td>
					</tr>
					<tr>
						<td>Description: </td>
						<td>
							<form:errors path="description" class="text-danger"/>
							<form:input path="description" class="form-control"/>
						</td>
					</tr>
					<tr>
						<td>Price: </td>
						<td>
							<form:errors path="price" class="text-danger"/>
							<form:input path="price" class="form-control"/>
						</td>
					</tr>
					<tr>
	        			<td colspan=2><input type="submit" value="Submit"/></td>
	        		</tr>
				</thead>
			</table>
		</form:form>
	</div>
</body>
</html>