/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 184461L
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //End the session
        HttpSession session = request.getSession();
        session.invalidate();
        //Or Alternatively, request.getSession().invalidate();
        System.out.println("=====================");
        System.out.println("In LogoutServlet");
        System.out.println("=====================");
        //Do a client-side redirect to the index page
        response.sendRedirect(this.getServletContext().getContextPath()+ "/index.jsp");
    }
}

