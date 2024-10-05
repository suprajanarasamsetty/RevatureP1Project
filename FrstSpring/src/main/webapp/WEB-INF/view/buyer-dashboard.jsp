<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="${language}">
<head>
<meta charset="UTF-8">
<title>Buyer Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    body {
        background-color: #f8f9fa;
        font-family: Arial, sans-serif;
    }
    .container {
        margin-top: 50px;
    }
    .header {
        text-align: center;
        margin-bottom: 50px;
    }
    .header h1 {
        font-size: 3em;
        color: #343a40;
    }
    .card {
        border: none;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        transition: transform 0.2s;
    }
    .card:hover {
        transform: scale(1.05);
    }
    .card-title {
        font-size: 1.5em;
        color: #495057;
    }
    .btn {
        border-radius: 50px;
        padding: 10px 20px;
        font-size: 1em;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Buyer Dashboard</h1>
            <c:if test="${not empty sessionScope.user}">
                <p>Welcome, ${sessionScope.user.firstName} ${sessionScope.user.lastName}</p>
                <form action="${pageContext.request.contextPath}/user/logout" method="get">
                    <button type="submit" class="btn btn-danger">Logout</button>
                </form>
            </c:if>
        </div>
        <div class="row">
            <div class="col-md-4 mb-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h2 class="card-title">Profile</h2>
                        <a href="${pageContext.request.contextPath}/profile" class="btn btn-primary">View Profile</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h2 class="card-title">Orders</h2>
                        <a href="${pageContext.request.contextPath}/orders" class="btn btn-secondary">View Orders</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h2 class="card-title">Cart</h2>
                        <a href="${pageContext.request.contextPath}/cart" class="btn btn-success">View Cart</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>