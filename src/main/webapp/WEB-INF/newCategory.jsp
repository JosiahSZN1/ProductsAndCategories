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
<title>New Category</title>
</head>
<body>
	<div class="container">
		<h1>New Category</h1>
		<p><a href="/">Home</a></p>
		<hr>
		<form:form action="/categories/new" method="post" modelAttribute="newCategory">
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
	        			<td colspan=2><input type="submit" value="Submit"/></td>
	        		</tr>
				</thead>
			</table>
		</form:form>
	</div>
</body>
</html>