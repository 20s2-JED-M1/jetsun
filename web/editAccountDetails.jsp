<%-- 
    Document   : changepassword
    Created on : 14 Dec, 2020, 10:35:49 AM
    Author     : weixu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SaveMore IT Store</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <b>SaveMore IT Store System Menu - Change Password</b><br/>
        <p>
            <form action="password" method="post">
                Email: 
                <input type="email" name="email" required/><br/>
                New Password: 
                <input type="password" name="password1" required/><br/>
                Confirm new password: 
                <input type="password" name="password2" required/><br/><br/>
                <input type="submit" value="Submit"/><br/>
                <font color="red">
                <%=session.getAttribute("changePasswordSuccess")==null?"":session.getAttribute("changePasswordSuccess")%><br/>
                </font>
                <font color="red">
                <%=session.getAttribute("changePasswordFailed")==null?"":session.getAttribute("changePasswordFailed")%><br/>
                </font>
                <font color="red">
                <%=session.getAttribute("wrongEmailPasswordChange")==null?"":session.getAttribute("wrongEmailPasswordChange")%><br/>
                </font>
            </form>
        </p>
        <a href="account.jsp">Back</a><br/>
    </body>
</html>