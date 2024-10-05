<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page import="java.time.*" %>

<!DOCTYPE html>
<html lang="${language}">
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    body {
        background-color: #f0f2f5;
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
    .btn-primary {
        background-color: #007bff;
        border: none;
    }
    .btn-secondary {
        background-color: #6c757d;
        border: none;
    }
    .btn-success {
        background-color: #28a745;
        border: none;
    }
    .btn-warning {
        background-color: #ffc107;
        border: none;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Welcome to Our E-commerce Site</h1>
        </div>
        <div class="row">
            <div class="col-md-6 mb-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h2 class="card-title">Login</h2>
                        <a href="login" class="btn btn-primary">Login</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 mb-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h2 class="card-title">Register</h2>
                        <a href="register" class="btn btn-secondary">Register</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h2 class="card-title">Buyer Dashboard</h2>
                        <a href="buyer-dashboard" class="btn btn-success">Buyer Dashboard</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 mb-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h2 class="card-title">Seller Dashboard</h2>
                        <a href="seller-dashboard" class="btn btn-warning">Seller Dashboard</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>