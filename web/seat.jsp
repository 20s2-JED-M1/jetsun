<%@page import="sg.edu.nyp.Seat"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Flight</title>
    </head>
    <body>
        <h1>Book Flight</h1>
        <form action="post" name="Book flight">
        <table>
            <th>Seat Number</th>
            <%
                System.out.println("Before searchresult");
                List<Seat> searchresult = (List<Seat>)session.getAttribute("seatResult");
                System.out.println("After searchresult");
                if(searchresult != null || searchresult.size() >= 0){
                    System.out.println("Inside if statemenet");
                    for(Seat seat : searchresult){
                        System.out.println("Inside for statement");
            %>
            <tr>
                <td><%=seat.getSeatNum()%></td>
                <td><input type="submit" value="Book"></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
        </form>
    </body>
</html>
