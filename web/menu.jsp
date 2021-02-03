<%@page import="sg.edu.nyp.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <h1>Menu</h1>
        <%
                Customer customer = (Customer) session.getAttribute("customer");
                
                if(customer == null){
                    customer = new Customer();
                    customer.setName("new customer");
                }
            %>
        <h3>
            Welcome, <%=customer.getName()%>!
            <br/>
        </h3>
            <a href="searchflight.jsp">Book a Flight</a><br>
        <a href="editAccountDetails.jsp">Edit Account</a>
        <form action="retrieveBookings" method="post">
            <input type="submit" value="Retrieve Past Booking" />
        </form>
        <br/>
        <br/>
        <form action="logout" method="post">
	    <input type="submit" value="Log Out"/>
	</form>      
        <%
            //Clear the message at the end of the JSP
            session.setAttribute("message",null);
        %>
    </body>
</html>