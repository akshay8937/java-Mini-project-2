<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<link rel="stylesheet" href="./css/style.css">
<body>
    <div class="main-container">
        <form method="POST" action="j_security_check">
            <div>
                <h1 class="head">Login</h1>
            </div>
            <div class="container">
                <label for="username">Username</label>
                <input type="text" name="j_username" placeholder="Enter Username" required>

                <label for="password">Password</label>
                <input type="password" name="j_password" placeholder="Enter Password" required>

                <button type="submit" >Login</button>
                
                <span class="password"><a href="#">Forget Password?</a></span>
            </div>
            </form>
    </div>

</body>
</html>