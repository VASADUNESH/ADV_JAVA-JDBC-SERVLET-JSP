<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.UserBean"
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link rel="stylesheet" href="ViewProfileStyle.css">
</head>
<body>
    <%
        UserBean ub = (UserBean) application.getAttribute("ub");
    %>
    <div class="container">
        <h2>User: <%= ub.getfName() %></h2>

        <div class="profile-details">
            <p><strong>Name:</strong> <%= ub.getfName() %> <%= ub.getlName() %></p>
            <p><strong>City:</strong> <%= ub.getCity() %></p>
            <p><strong>Email:</strong> <%= ub.getmId() %></p>
            <p><strong>Phone:</strong> <%= ub.getPhNo() %></p>
        </div>

        <div class="buttons">
            <a href="edit" class="btn edit">Edit</a>
            <a href="logout" class="btn logout">Logout</a>
        </div>
    </div>
</body>
</html>
