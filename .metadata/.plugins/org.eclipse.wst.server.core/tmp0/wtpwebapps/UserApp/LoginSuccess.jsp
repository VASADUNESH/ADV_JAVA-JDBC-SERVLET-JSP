<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.UserBean"
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <link rel="stylesheet" href="Loginsucess.css">
</head>
<body>
    <div class="container">
        <h2>Welcome, 
        <%= 
        ((UserBean) application.getAttribute("ub")).getfName() 
        %>!</h2>
        
        <div class="links">
            <a href="view" class="btn">View Profile</a>
            <a href="logout" class="btn logout">Logout</a>
        </div>
    </div>
</body>
</html>
