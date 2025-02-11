<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.UserBean"
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile Update</title>
    <link rel="stylesheet" href="EditProfileStyles.css">
</head>
<body>
    <%
        String fN = (String) request.getAttribute("fName");
        UserBean ub = (UserBean) application.getAttribute("ub");
    %>
    <div class="container">
        <h2>Page belongs to User: <%= fN %></h2>

        <form action="update" method="post" class="profile-form">
            <label for="city">City:</label>
            <input type="text" id="city" name="city" value="<%= ub.getCity() %>" required>

            <label for="mid">Mail ID:</label>
            <input type="text" id="mid" name="mid" value="<%= ub.getmId() %>" required>

            <label for="phno">Phone No:</label>
            <input type="text" id="phno" name="phno" value="<%= ub.getPhNo() %>" required>

            <input type="submit" value="UpdateProfile" class="btn update">
        </form>
    </div>
</body>
</html>
