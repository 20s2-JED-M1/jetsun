/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    //Inject your EJB here
    @EJB
    private FlightBean flightBean;
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException{
        String searchTerm = request.getParameter("searchterm");
        List<Flight> searchResult = new ArrayList<>();
        searchResult = flightBean.searchFlight(searchTerm);
        
        //Set the search term and the search results in the session
        HttpSession session = request.getSession();
        session.setAttribute("searchterm", searchTerm);
        session.setAttribute("searchresult", (Object)searchResult);
        
        //Client side redirect
        response.sendRedirect(this.getServletContext().getContextPath() + "/searchresult.jsp"); 
    }
}
