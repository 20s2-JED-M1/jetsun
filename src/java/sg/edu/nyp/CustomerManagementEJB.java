/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Asus
 */
@Stateless
public class CustomerManagementEJB {
    //Test Push For BLOO
    
     @Resource(name = "jdbc/jed")
    private DataSource customerManagement;
     
     public boolean changePassword(String email, String password) throws NoSuchAlgorithmException {
        String hashedPassword = null;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        hashedPassword = sb.toString();

        System.out.println(hashedPassword);

        boolean success = false;
        String sqlInsertPasswordFirstHalf = "UPDATE customer SET password = ?";
        String sqlInsertPasswordSecondHalf = "WHERE email = ?";

        //Declaration
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //intialize connection
            connection = customerManagement.getConnection();

            statement = connection.prepareStatement(sqlInsertPasswordFirstHalf + sqlInsertPasswordSecondHalf);
            statement.setString(1, hashedPassword);
            statement.setString(2, email);

            // Counter counts the question mark to generate position
            // To add variable
//            int counter = 4;
//            
//            if(year != null && !year.isEmpty())
//                statement.setInt(counter++, Integer.parseInt(year));
//            
//            if(publisher != null && !publisher.isEmpty())
//                statement.setString(counter++, publisher);
//            
//            if(about != null && !about.isEmpty())
//                statement.setString(counter++, about);
            // Insert data to DB
            statement.executeUpdate();

            success = true;
        } catch (SQLException ex) {

            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        } finally {
            //Resultset, Statement and Connection are closed in the finally 
            // clause to ensure that they will be closed no matter what 
            // happens to the system.
            if (statement != null) {
                try {
                    statement.close();
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
                };
            }
        }
        return success;
    }
}
     

