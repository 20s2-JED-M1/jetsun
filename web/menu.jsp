<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <h1>Menu</h1>
        <a href="searchflight.jsp">Book a Flight</a>
        <form action="retrieveBookings" method="post">
            <input type="submit" value="Retrieve Past Booking" />
        </form>
        <a href="manageAccount.jsp">Manage Account</a>
    </body>
</html>