<%@ page contentType="text/html;charset=UTF-8"
language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - TaskMaster</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<nav>
    <div class="nav-content">
        <div class="logo">TaskMaster</div>
        <div class="nav-links">
            <a href="index.html">Home</a>
            <a href="signup.jsp">Sign Up</a>
        </div>
    </div>
</nav>

<div class="auth-container">
    <form method="post" action="login" class="auth-form login-form">
        <h2>Welcome Back</h2>
        <h3 style="color: red;">
            <% Object obj = request.getAttribute("error");%>
            <%=(obj != null) ? obj.toString() : ""%>
        </h3>
        <div class="form-group">
            <input type="email" name="email" placeholder="Email" required>
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Password" required>
        </div>
        <button type="submit" class="auth-button">Login</button>
        <p class="auth-link">Don't have an account? <a href="signup.jsp">Sign Up</a></p>
    </form>
</div>
</body>
</html>