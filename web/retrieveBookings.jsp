<%-- 
    Document   : retrieveBookings.jsp
    Created on : 20 Jan, 2021, 10:42:32 AM
    Author     : weixu
--%>
<%@page import="sg.edu.nyp.Booking"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Retrieve Bookings</title>
    </head>
    <body>
        <h1>RETRIEVE BOOKINGS</h1>
        <table>
            <tr>
                <th>NRIC No.</th>
                <th>Flight Code</th>
                <th>Seat ID</th>
                <th>Employee ID</th>
                <th>Timestamp</th>
            </tr>
            <%
                List<Booking> searchResult = (List<Booking>) session.getAttribute("getAllBookings");
                
                if (searchResult == null || searchResult.size() <= 0){
            %>
            <tr><td colspan="6">(No result is found)</td></tr>
            <% 
                } else {
                    for(Booking booking : searchResult) {
            %>
            <tr>
                <td><%=booking.getNRICNo()%></td>
                <td><%=booking.getFlightCode()%></td>
                <td><%=booking.getSeatID()%></td>
                <td><%=booking.getEmployeeID()%></td>
                <td><%=booking.getTimestamp()%></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
        <a href="menu.jsp">Back To Main Menu</a>
    </body>
</html>
