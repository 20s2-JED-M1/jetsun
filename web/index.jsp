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
        <p>
            <font color="red">
                    <%=session.getAttribute("message")==null?"":session.getAttribute("message")%><br/>
            </font>
        </p>
        

        <form name="user" action="login" method="post">
                Email Address : <input type="text" name="email" required/><br/>
                Password : <input type="password" name="password" required/><br/>
            <input type="submit" value="Login"/> <br/>
        </form>
        <br/>
        <a href="Register.jsp">Don't have an account?</a>
        <%
            //Clear the message at the end of the JSP
            session.setAttribute("message",null);
        %>
    </body>
</html>