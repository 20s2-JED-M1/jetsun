/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/seat")
public class SeatServlet extends HttpServlet {
    //Inject your EJB here
    @EJB
    private FlightBean flightBean;
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException{
        String flightCode = request.getParameter("flightCode");
        List<Seat> seatResult = new ArrayList<>();
        seatResult = flightBean.displaySeat(flightCode);
        
        //Set the search term and the search results in the session
        HttpSession session = request.getSession();
        session.setAttribute("flightCode", flightCode);
        session.setAttribute("seatResult", (Object)seatResult);
        
        //Client side redirect
        response.sendRedirect(this.getServletContext().getContextPath() + "/seat.jsp"); 
    }
}
