/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.ejb.Stateless;

@Stateless
public class FlightBean {
    @Resource(name="jdbc/jed")
    private DataSource dsBookCatalogue;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultset = null;
    public List<Flight> searchFlight(String searchTerm){
        List<Flight> searchResult = new ArrayList<>();
        try {
            String sql = "select * from flight where title like ?";
            //Initializing
            //Get the connection from the DataSource
            connection = dsBookCatalogue.getConnection();
            //Create a state,emt using the Connection
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + searchTerm + "%");
            //Make a query to the DB using ResultSet through the Statement
            resultset = statement.executeQuery();

            //retrieval
            while(resultset.next()){
                //Create a book object
                Flight book = new Flight();
                //Retrieve the data from the recordset and store it into a book object.
                book.setFlightCode(resultset.getString("FlightCode"));
                book.setDeparture(resultset.getString("Departure"));
                book.setDestination(resultset.getString("Destination"));
                book.setDepartureDate(resultset.getDate("DepartureDate"));
                book.setFlightVacancy(resultset.getString("FlightVacancy"));
                book.setEmployeeID(resultset.getString("EmployeeID"));
                //Store the book object into the list
                searchResult.add(book);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            Logger.getLogger(FlightBean.class.getName()).log(Level.SEVERE, null, ex);                 
        } finally {
            //clean up memory
            if(resultset != null){
                try {
                    resultset.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FlightBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FlightBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FlightBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return searchResult;
    }
}