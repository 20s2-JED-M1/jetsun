<%@page import="sg.edu.nyp.Flight"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NYP Flight Booking Management System - Search Result</title>
    </head>
    <body>
        <p>
            <b>Search Results</b>
        </p>
        <hr/>
        <p>
            <!--A reminder note to the user on the search term he used--> 
            Search results for "<b><%=session.getAttribute("searchterm")%></b>"
        </p>
        <hr/>
       
            <!--Results-->
            <table>
                <tr>
                    <th>Flight Code</th>
                    <th>Departure</th>
                    <th>Destination</th>
                    <th>Departure Date</th>
                    <th>Flight Vacancy</th>
                    <th>Book</th>
                </tr>
                <%
                    List<Flight> searchresult = (List<Flight>)session.getAttribute("searchresult");
                    if(searchresult == null || searchresult.size() <= 0){
                %>
                <tr>
                    <td colspan="6">(No result is found)</td>
                </tr>
                <%
                    }else{
                        for(Flight book : searchresult){
                            System.out.println();
                %>
                
                <tr>
                   <form action="seat" method="post" name="buy">
                    <td><%=book.getFlightCode()%></td>
                    <td><%=book.getDeparture()%></td>
                    <td><%=book.getDestination()%></td>
                    <td><%=book.getDepartureDate()%></td>
                    <td><%=book.getFlightVacancy()%></td>
                    <input type="hidden" id="flightCode" name="flightCode" value="<%=book.getFlightCode()%>">
                    <td><input type="submit" value="Book Seat"></td>
                   </form>
                </tr>
                 <%
                    }%>
            </table>
           
            <% }
            %>
      
        <hr/>
        <a href="searchflight.jsp">Do another search</a><br/>
        <a href="menu.jsp">Go back to menu</a>
    </body>
</html>