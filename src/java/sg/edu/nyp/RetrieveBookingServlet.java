/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author weixu
 */
@WebServlet("/retrieveBookings")
public class RetrieveBookingServlet extends HttpServlet{
    @EJB
    private CustomerManagementEJB customerManagementEJB;
    
    @Override
    protected void doPost (HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        String nricNo = customer.getNRICNo();
        List<Booking> allBookings = customerManagementEJB.getAllBookings(nricNo);
        
        System.out.println(allBookings);
        
        session.setAttribute("getAllBookings", allBookings);
        
        response.sendRedirect(this.getServletContext().getContextPath() + "/retrieveBookings.jsp");
    }
}
