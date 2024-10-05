<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Add New Product</h2>
	<form action="${pageContext.request.contextPath}/add" method="post">
	    <label for="name">Product Name:</label>
	    <input type="text" id="name" name="name" required><br>

	    <label for="description">Description:</label>
	    <textarea id="description" name="description" required></textarea><br>

	    <label for="price">Price:</label>
	    <input type="number" id="price" name="price" step="0.01" required><br>

	    <input type="hidden" id="userId" name="userId" value="${userId}"><!-- Assuming userId is available in the JSP context -->

	    <button type="submit">Add Product</button>
	</form>

</body>
</html>