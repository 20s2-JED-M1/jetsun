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

@WebServlet("/bookseat")
public class BookingServlet extends HttpServlet
{
    @EJB
    private FlightBean flightBean;
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException{
        HttpSession session = request.getSession();
        
        Customer customer = (Customer) session.getAttribute("customer");
        String nric = customer.getNRICNo();
        int flightCode = (int) session.getAttribute("flightCode");
        int seatID = Integer.parseInt(request.getParameter("seatid"));
        int employeeId = 1;
        
        System.out.println("flightCode: " + flightCode);
        System.out.println("seatID before function call: " + seatID);
        boolean checkbookSeat = flightBean.bookSeat(seatID, flightCode, nric, employeeId);
        
        if(checkbookSeat)
        {
            boolean checkupdatevacancy = flightBean.updateVacancy(flightCode);
            if(checkupdatevacancy)
            {
                System.out.println("mother and son is working!!");
            }
            else{
                System.out.println("son is not working!!");
            }
            
        }
        else
        {
             System.out.println("mother is not working!!");
        }
        
        
        //Client side redirect
        response.sendRedirect(this.getServletContext().getContextPath() + "/bookingflightconfirmed.jsp"); 
    }
    
    
}
