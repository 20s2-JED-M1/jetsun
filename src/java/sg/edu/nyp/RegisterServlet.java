/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nyp;

import java.security.MessageDigest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    public static String getSha256(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(value.getBytes());
            return bytesToHex(md.digest());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte b : bytes) {
            result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        String nricno = request.getParameter("nric");
        String title = request.getParameter("title");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address1 = request.getParameter("address");
        String passportno = request.getParameter("passportno"); //optional
        String passportexpiry = request.getParameter("expirydate");
        String mobile = request.getParameter("mobileno");
        String plainPassword = request.getParameter("password");
        String password = getSha256(plainPassword);
        
        String dob = request.getParameter("dob");
        String officeno = request.getParameter("officeno");
        String homeno = request.getParameter("homeno");
        String memberno = request.getParameter("memberno");
        String billingaddress = request.getParameter("billingaddress");

    }

}
