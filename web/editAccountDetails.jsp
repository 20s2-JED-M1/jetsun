<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit profile</title>                 
    </head>
    <body>                   
        <p>Edit account details for <%=session.getAttribute("email")%></p>
        <hr/>
        <form method="post" action="dataValidation">                    
                <div>
                    Email:<input type="email" name="emailvalue" required><br/><br/>                                              
                    Password: <input type="password" name="password" required/><br/><br/>
                    Confirm Password:<input type="password" name="reconfirmpassword" required/><br/><br/>            
                </div>
           
            <input type="submit" value="Save Details"/>                
        </form>       
        <a href="homepage.jsp">Go back to home page</a><br /><br />
    </body>
</html>

