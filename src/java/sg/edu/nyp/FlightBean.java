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
            String sql = "select * from flight where destination like ? or Departure like ?";
            //Initializing
            //Get the connection from the DataSource
            connection = dsBookCatalogue.getConnection();
            //Create a state,emt using the Connection
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + searchTerm + "%");
            statement.setString(2, "%" + searchTerm + "%");
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
    public List<Seat> displaySeat(String flightCode){
        List<Seat> seatList = new ArrayList<>();
        try{
            String sql = "SELECT s.Id, s.SeatNum FROM collabproj.seat s inner join collabproj.booking b on s.Id != b.SeatID inner join collabproj.flight f on b.FlightCode = f.FlightCode where b.FlightCode = ?";
            //Initializing
            //Get the connection from the DataSource
            connection = dsBookCatalogue.getConnection();
            //Create a state,emt using the Connection
            statement = connection.prepareStatement(sql);
            statement.setString(1, flightCode);
            //Make a query to the DB using ResultSet through the Statement
            resultset = statement.executeQuery();

            //retrieval
            while(resultset.next()){
                //Create a book object
                Seat seats = new Seat();
                //Retrieve the data from the recordset and store it into a book object.
                seats.setId(resultset.getInt("Id"));
                seats.setSeatNum(resultset.getString("SeatNum"));
                //Store the book object into the list
                seatList.add(seats);
            }
        }catch(SQLException ex) {
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
        return seatList;
    }
    public boolean bookSeat(int seatid, int flightCode, String NRIC, int employeeid)
    {
       // 
        // 
          try{
              
            String sql = "INSERT INTO collabproj.booking (NRICNo, FlightCode,SeatID, EmployeeID, TIMESTAMP) VALUES ( ?,?,?,?,CURRENT_TIMESTAMP)";
            //Initializing
            //Get the connection from the DataSource
            connection = dsBookCatalogue.getConnection();
            //Create a state,emt using the Connection
            statement = connection.prepareStatement(sql);
            statement.setString(1, NRIC);
            statement.setInt(2, flightCode);
            statement.setInt(3, seatid);
            statement.setInt(4, employeeid);
            //Make a query to the DB using ResultSet through the Statement
            resultset = statement.executeQuery();
          
        }catch(SQLException ex) {
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
        return true;
    }
    public boolean updateVacancy(int flightCode)
    {
       try{
              
            String sql = "UPDATE collabproj.flight SET FlightVacancy = FlightVacancy - 1 WHERE FlightCode = ?";
            //Initializing
            //Get the connection from the DataSource
            connection = dsBookCatalogue.getConnection();
            //Create a state,emt using the Connection
            statement = connection.prepareStatement(sql);
            statement.setInt(1, flightCode);
  
            //Make a query to the DB using ResultSet through the Statement
            resultset = statement.executeQuery();
          
        }catch(SQLException ex) {
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
        return true;
    }

}
