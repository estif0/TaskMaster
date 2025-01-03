<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up - TaskMaster</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<nav>
    <div class="nav-content">
        <div class="logo">TaskMaster</div>
        <div class="nav-links">
            <a href="index.html">Home</a>
            <a href="login.jsp">Login</a>
        </div>
    </div>
</nav>

<div class="auth-container">
    <form method="post" action="user" enctype="multipart/form-data" class="auth-form signup-form">
        <h2>Create Account</h2>
        <div class="form-group">
            <input type="text" name="firstName" id="firstName" placeholder="First Name" required>
        </div>
        <div class="form-group">
            <input type="text" name="lastName" id="lastName" placeholder="Last Name" required>
        </div>
        <div class="form-group">
            <input type="text" name="userName" id="username" placeholder="Username" required>
        </div>
        <div class="form-group">
            <input type="email" name="email" id="email" placeholder="Email" required>
        </div>
        <div class="form-group">
            <select name="gender" id="gender" required>
                <option value="">Select Gender</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
        </div>
        <div class="form-group">
            <input type="password" name="password" id="password" placeholder="Create Password" required>
        </div>
<%--        <div class="form-group">--%>
<%--            <input type="url" name="profilePictureUrl" id="profilePictureUrl" placeholder="Profile Picture URL" required>--%>
<%--        </div>--%>
        <div class="form-group checkbox">
            <input type="checkbox" name="terms" id="terms" required>
            <label for="terms">I agree to the <a href="#">Terms & Conditions</a></label>
        </div>
        <button type="submit" class="auth-button">Sign Up</button>
        <p class="auth-link">Already have an account? <a href="login.jsp">Login</a></p>
    </form>
</div>
</div>
</body>
</html>