<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <link rel="stylesheet" href="UpdateProfileStyle.css">
</head>
<body>
    <div class="container">
        <%
            String fN = (String) request.getAttribute("fName");
            String msg = (String) request.getAttribute("msg");
        %>
        <h2>Welcome, <%= fN %>!</h2>

        <p class="message"><%= (msg != null) ? msg : "" %></p>

        <div class="buttons">
            <a href="view" class="btn view">View Profile</a>
            <a href="logout" class="btn logout">Logout</a>
            
            
        </div>
    </div>
</body>
</html>
