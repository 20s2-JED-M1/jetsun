package sg.edu.nyp;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import static sg.edu.nyp.RegisterServlet.getSha256;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Resource(name = "jdbc/jed")
    private DataSource userCatalogue;
    
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
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        //Get user input
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        password = getSha256(password);
        //If user input can be found in db, isSuccessful will be true
        boolean isSuccessful = false;
        
        //Declare new customer object to store customer
        Customer customer = new Customer();

        //Declare the connection, statement and resultset objects
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;

        try {
            //Initialise the connection, statement and resultset 

            // Get the connection from the DataSource 
            connection = userCatalogue.getConnection();

            // Prepare the Statement using the Connection
            preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE email = ? AND password = ?");

//            System.out.println(preparedStatement);
            
            // Set the userinput into the prepared statement
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            // Make a query to the DB using ResultSet through the Statement            
            resultset = preparedStatement.executeQuery();
            
            System.out.println(preparedStatement);
            
            if(resultset.next())
            {
                //Rertieve all records from the resultset
                customer.setNRICNo(resultset.getString("NRICNo"));
                customer.setTitle(resultset.getString("Title"));
                customer.setName(resultset.getString("Name"));
                customer.setEmail(resultset.getString("Email"));
                customer.setHomeAdd(resultset.getString("HomeAdd"));
                customer.setBillingAdd(resultset.getString("BillingAdd"));
                customer.setPassportNo(resultset.getString("PassportNo"));
                customer.setPassportExpiry(resultset.getDate("PassportExpiry"));
                customer.setMobilePhone(resultset.getString("MobilePhone"));
                customer.setDoB(resultset.getDate("DoB"));
                customer.setOfficePhone(resultset.getString("OfficePhone"));
                customer.setHomePhone(resultset.getString("HomePhone"));
                customer.setKrisFlyer(resultset.getString("KrisFlyer"));

                isSuccessful = true;
            }

        } catch (SQLException ex) {
            //Usually, the error should be logged somewhere in the system log.
            //Sometimes, users may also need to be notified regarding such error
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
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
        }
        
        if(isSuccessful == true)
        {
            //Store customer object into session
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);

            RequestDispatcher rd
                = request.getRequestDispatcher("/menu");
            rd.forward(request, response);
        }
        else
        {
            request.getSession().setAttribute("message", "Invalid email or password.");
            response.sendRedirect(this.getServletContext().getContextPath());
        }
    }
}