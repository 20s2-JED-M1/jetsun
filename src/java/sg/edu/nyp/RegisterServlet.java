/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nyp;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Resource(name = "jdbc/jed")
    private DataSource dbRegister;

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

        String nric = request.getParameter("nric");
        String title = request.getParameter("title");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String passportno = request.getParameter("passportno"); //optional
        String passportexpiryString = request.getParameter("expirydate");
        String mobile = request.getParameter("mobileno");
        String plainPassword = request.getParameter("password");
        String password = getSha256(plainPassword);

        String dobString = request.getParameter("dob");
        String officeno = request.getParameter("officeno");
        String homeno = request.getParameter("homeno");
        String memberno = request.getParameter("memberno");
        String billingaddress = request.getParameter("billingaddress");

        Date dob = null;
        Date passportexpiry = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {

            dob = (Date) sdf.parse(dobString);
            passportexpiry = (Date) sdf.parse(passportexpiryString);
        } catch (ParseException e) {
            System.out.println("Error Parsing dates");

        }

        Customer customer = new Customer();
        customer.setNRICNo(nric);
        customer.setTitle(title);
        customer.setName(name);
        customer.setEmail(email);
        customer.setHomeAdd(address);
        customer.setBillingAdd(billingaddress);
        customer.setPassportNo(passportno);
        customer.setPassportExpiry(passportexpiry);
        customer.setMobilePhone(mobile);
        customer.setDoB(dob);
        customer.setOfficePhone(officeno);
        customer.setHomePhone(homeno);
        customer.setKrisFlyer(memberno);

        System.out.println(plainPassword + "checking password");

        String sqlInsertAccFirstPart = "INSERT INTO customer (NRICNo, Title, Name, Email, HomeAdd";
        String sqlInsertAccSecondPart = "VALUES (?, ?, ?, ?, ? ";

        if (billingaddress != null && !billingaddress.isEmpty()) {
            sqlInsertAccFirstPart += ",BillingAdd";
            sqlInsertAccSecondPart += ", ?";
        }

        sqlInsertAccFirstPart += " ,PassportNo,PassportExpiry,MobilePhone";
        sqlInsertAccSecondPart += ", ?, ?, ?";

        if (dobString != null && !dobString.isEmpty()) {
            sqlInsertAccFirstPart += ", DoB";
            sqlInsertAccSecondPart += ", ?";
        }
        if (officeno != null && !officeno.isEmpty()) {
            sqlInsertAccFirstPart += ", OfficePhone";
            sqlInsertAccSecondPart += ", ?";
        }
        if (homeno != null && !homeno.isEmpty()) {
            sqlInsertAccFirstPart += ", HomePhone";
            sqlInsertAccSecondPart += ", ?";
        }
        if (memberno != null && !memberno.isEmpty()) {
            sqlInsertAccFirstPart += ", KrisFlyer";
            sqlInsertAccSecondPart += ", ?";
        }

        sqlInsertAccFirstPart += " ,password)";
        sqlInsertAccSecondPart += ",?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;

        try {
            //Initialise the connection, statement and resultset  
            connection = dbRegister.getConnection();

            //Set auto commit to false to control the transaction
            connection.setAutoCommit(false);
            System.out.println("Front half + " + sqlInsertAccFirstPart);
            System.out.println("Back half + " + sqlInsertAccSecondPart);
            preparedStatement = connection.prepareStatement(sqlInsertAccFirstPart + sqlInsertAccSecondPart);
            //preparedStatement = connection.prepareStatement("Select * from Customer");
            preparedStatement.setString(1, nric);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, address);

            //Counter counts the number of question mark so that we can dynamically
            //generate position where the variable is to be added
            int counter = 6;

            if (billingaddress != null && !billingaddress.isEmpty() && billingaddress.equals(address)) {
                preparedStatement.setString(counter++, null);
                
            } else if (billingaddress != null && !billingaddress.isEmpty() && !billingaddress.equals(address)) {
                preparedStatement.setString(counter++, billingaddress);

            }
            preparedStatement.setString(7, passportno);
            preparedStatement.setString(8, passportexpiryString);
            preparedStatement.setString(9, mobile);

            int newCounter = 10;

            if (dobString != null && !dobString.isEmpty()) {
                preparedStatement.setString(newCounter++, dobString);
            }

            if (officeno != null && !officeno.isEmpty()) {
                preparedStatement.setString(newCounter++, officeno);
            }
            if (homeno != null && !homeno.isEmpty()) {
                preparedStatement.setString(newCounter++, homeno);
            }

            if (memberno != null && !memberno.isEmpty()) {
                preparedStatement.setString(newCounter++, memberno);
            }

            preparedStatement.setString(14, password);

            System.out.println("checking statement " + preparedStatement);

            //Insert date into the database
            preparedStatement.executeUpdate();

            //If the code reaches this line, insertion must have been successful
            //Commit the transaction
            connection.commit();

            //Leave a message in the session that the insertion is successful
            // request.getSession().setAttribute("message","The account has been created successfully.");
        } catch (SQLException ex) {
            request
                    .getSession()
                    .setAttribute("message",
                            "An error has occured in the insertion process, Please check with your DB administrator for more details.");
            try {
                //Roll back if there is an error
                connection.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                System.err.println(ex1.getMessage());
            }
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        } finally {
            //Resultset, Statement and Connection are closed in the finally 
            // clause to ensure that they will be closed no matter what 
            // happens to the system.
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException ex) {
                    try {
                        //Roll back if there is an error
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                        System.err.println(ex1.getMessage());
                    }
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    try {
                        //Roll back if there is an error
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                        System.err.println(ex1.getMessage());
                    }
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            if (connection != null) {
                try {
                    //Undo auto commit before closing the connection
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException ex) {
                    try {
                        //Roll back if there is an error
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                        System.err.println(ex1.getMessage());
                    }
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            //Make a client side redirect to the search result page

            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);

            response.sendRedirect(this.getServletContext().getContextPath() + "/menu.jsp");
        }

    }

}
