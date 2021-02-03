/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp;

import java.util.Date;

public class Flight {
    private final long serialVersionUID = -1L ;
    private String  Departure, Destination, FlightVacancy, EmployeeID;
    private int FlightCode;
    private Date DepartureDate;

    public Date getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(Date DepartureDate) {
        this.DepartureDate = DepartureDate;
    }

    public int getFlightCode() {
        return FlightCode;
    }

    public void setFlightCode(int FlightCode) {
        this.FlightCode = FlightCode;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String Departure) {
        this.Departure = Departure;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public String getFlightVacancy() {
        return FlightVacancy;
    }

    public void setFlightVacancy(String FlightVacancy) {
        this.FlightVacancy = FlightVacancy;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }
}
