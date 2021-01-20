/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp;

//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import javax.annotation.Resource;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.sql.DataSource;
//
//@WebServlet("/register")
//public class RegisterServlet extends HttpServlet {
//    @Resource(name="jdbc/jed")
//    private DataSource dsStoreManagement;
//    @Override
//    protected void doPost(HttpServletRequest request,
//            HttpServletResponse response)
//            throws ServletException, IOException{
//        
//        int customerId = 0;
//        
////        String customerIdString = request.getParameter("customerId");
////        int customerId = Integer.parseInt(customerIdString);
//        String fullname = request.getParameter("fullname");
//        String email = request.getParameter("email");
//        String addressline1 = request.getParameter("addressline1");
//        String addressline2 = request.getParameter("addressline2");
//        String postalcode = request.getParameter("postalcode");
//        String mobile = request.getParameter("mobile");
//        String password = request.getParameter("password");
////        String confirmPassword = request.getParameter("confirmPassword");
//        
//        String sqlInsert1 = "INSERT INTO customer (fullname, email, addressline1, postalcode, mobile, password";
//        String sqlInsert2 = "VALUES(?,?,?,?,?,?";
//        
//        
//       
//        if(addressline2 != null && !addressline2.isEmpty()) {
//            sqlInsert1 += ", addressline2";
//            sqlInsert2 += ", ?";
//        }
//        sqlInsert1 += ") ";
//        sqlInsert2 += ") ";
//
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
////        PreparedStatement preparedStatement2 = null;
//        ResultSet resultset = null;
//        
//        
//
//        try
//        {
//            connection = dsStoreManagement.getConnection();
//            connection.setAutoCommit(false);
//            
//            preparedStatement = connection.prepareStatement(sqlInsert1 + sqlInsert2);
////            preparedStatement.setInt(1, customerId);
//            preparedStatement.setString(1, fullname);
//            preparedStatement.setString(2, email);
//            preparedStatement.setString(3, addressline1);
//            preparedStatement.setString(4, postalcode);
//            preparedStatement.setString(5, mobile);
//            preparedStatement.setString(6, password);
//            
//            
//            if(addressline2 != null && !addressline2.isEmpty()){
//                preparedStatement.setString(7, addressline2);
//            }
//            
//       
//
//                         
////            preparedStatement.setString(8, confirmPassword);
//            //insert data into db
//            preparedStatement.executeUpdate();
//            
//             String sqlCheck = "SELECT * FROM customer WHERE email = ?";
//            preparedStatement = connection.prepareStatement(sqlCheck);
//            preparedStatement.setString(1, email);
//            
//            resultset = preparedStatement.executeQuery();
//            
//            if(resultset.next()){
//                customerId = resultset.getInt("customerId");
//            }
//
//            //code reach this line, insertion must have been successful
//            //commit the transaction
//            connection.commit();
//            
//            request.getSession().setAttribute("message", fullname);
//            
//            CustomerRecord customerRecord = new CustomerRecord();
//            
//            customerRecord.setFullName(request.getParameter("fullname"));
//            customerRecord.setEmail(request.getParameter("email"));
//            customerRecord.setAddressLine1(request.getParameter("addressLine1"));
//            customerRecord.setAddressLine2(request.getParameter("addressLine2"));
//            customerRecord.setPostalCode(request.getParameter("postalCode"));
//            customerRecord.setMobile(request.getParameter("mobile"));
//            customerRecord.setPassword(request.getParameter("password"));
//            customerRecord.setCustomerId(customerId);
//            
//            HttpSession session = request.getSession();
//            
//            List<CustomerRecord> customerlist = (List<CustomerRecord>)
//                    session.getAttribute("customerlist");
//            if(customerlist == null){
//                customerlist = new ArrayList<>();
//            } else {
//                customerlist.clear();
//            }
//            
//            customerlist.add(customerRecord);
//            session.setAttribute("customerlist", customerlist);
//            
//        }
//        catch(SQLException ex)
//        {
//            request
//                    .getSession()
//                    .setAttribute("message",
//                     "An error has occured in the insertion process, Please check with your DB administrator for more details.");
//            try
//            {
//                //rollback if error
//                connection.rollback();
//            }
//            catch(SQLException ex1)
//            {
//                    ex1.printStackTrace();
//                    System.err.println(ex1.getMessage());
//                    
//            }
//            ex.printStackTrace();
//            System.err.println(ex.getMessage());
//        }
//        
//        finally
//        {
//            //resultset, statement, connection closed in finally
//            //ensure that they will be closed no matter what happens in system
//            if(resultset != null) {
//                try {
//                    resultset.close();
//                } catch(SQLException ex) {
//                    try {
//                        //Roll back if there is an error
//                        connection.rollback();
//                    } catch (SQLException ex1) {
//                        ex1.printStackTrace();
//                        System.err.println(ex1.getMessage());
//                    }
//                    ex.printStackTrace();
//                    System.err.println(ex.getMessage());
//                }
//            }
//            if(preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch(SQLException ex) {
//                    try{
//                        connection.rollback();
//                    }catch(SQLException ex1){
//                        ex1.printStackTrace();
//                        System.err.println(ex1.getMessage());
//                    }
//                }
//            }
//            if(connection != null) {
//                try {
//                    connection.setAutoCommit(true);
//                    connection.close();
//                } catch(SQLException ex) {
//                    try{
//                        connection.rollback();
//                    }catch(SQLException ex1){
//                        ex1.printStackTrace();
//                        System.err.println(ex1.getMessage());
//                    }
//                    ex.printStackTrace();
//                    System.err.println(ex.getMessage());
//                }
//            }
//            response.sendRedirect(this.getServletContext().getContextPath() +
//                    "/Shopping.jsp");
//        }
//    }
//}
