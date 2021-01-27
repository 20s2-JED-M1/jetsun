<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NYP Flight Booking Management System</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <b>NYP Flight Booking Management System - Search</b>
        <form action="search" method="post">
            <p>
                Enter city name: 
                <input type="text" name="searchterm" required/><br/>
                <input type="submit" value="Search"/>
            </p>
        </form>
        <a href="/jetsun/menu.jsp">Back</a>
    </body>
</html>
