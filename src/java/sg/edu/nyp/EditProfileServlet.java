/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nyp.CustomerManagementEJB;

/**
 *
 * @author weixu
 */
@WebServlet("/password")
public class EditProfileServlet extends HttpServlet {  
//    @Resource(name="jdbc/jed")
//    private DataSource dsBookManagement;
    
    @EJB
    private CustomerManagementEJB CustomerManagement;
    
    @Override
    protected void doPost (HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        boolean changedPassword = false;
        
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        ResultSet resultset = null;
        
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1"); 
        String password2 = request.getParameter("password2");
        
        System.out.println("Request parameter email: " + email);
        
                System.out.println("Request parameter email: " + customer.getEmail());

        
        if(email.equals(customer.getEmail())){ //Check email
            if(password1.equals(password2)){ //Check Password
                //Do Update Password
                String finalpassword = password1;
                
                try {
                    changedPassword = CustomerManagement.changePassword(email, finalpassword);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(changedPassword);
                if(changedPassword){
                    request.getSession().setAttribute("changePasswordSuccess", "Successfully changed password!");
                    response.sendRedirect(this.getServletContext().getContextPath() + "/editAccountDetails.jsp");
                } else {
                    request.getSession().setAttribute("changePasswordFailed", "Failed to changed password!");
                    response.sendRedirect(this.getServletContext().getContextPath() + "/editAccountDetails.jsp");
                }
            }
        } else {
            request.getSession().setAttribute("wrongEmailPasswordChange", "Wrong email!");
            response.sendRedirect(this.getServletContext().getContextPath() + "/editAccountDetails.jsp");
        }
    }
    
}