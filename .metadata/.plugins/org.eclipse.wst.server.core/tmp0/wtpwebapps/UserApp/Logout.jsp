<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="LogoutStyle.css">
</head>
<body>
    <div class="container">
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
        %>
            <p class="message"><%= msg %></p>
        <%
            }
        %>

        <%@include file="login.html" %>
    </div>
</body>
</html>
