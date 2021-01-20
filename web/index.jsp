<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/validation.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Login</h1>
        <form name="user" action="login" method="post">
                Email Address : <input type="text" name="email" required/><br/>
                Password : <input type="password" name="password" id="pass1" required/><br/>
            <input type="submit" value="Login"/> <br/>
        </form>
        <br/>
        <a href="Register.jsp">Don't have an account?</a>
    </body>
</html>