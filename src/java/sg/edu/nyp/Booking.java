/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author weixu
 */
public class Booking implements Serializable{
    public final long serialVersionUID = -1L;
    private String NRICNo;
    private int FlightCode;
    private int SeatID;
    private int EmployeeID;
    private Date Timestamp;

    public String getNRICNo() {
        return NRICNo;
    }

    public int getFlightCode() {
        return FlightCode;
    }

    public int getSeatID() {
        return SeatID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public Date getTimestamp() {
        return Timestamp;
    }

    public void setNRICNo(String NRICNo) {
        this.NRICNo = NRICNo;
    }

    public void setFlightCode(int FlightCode) {
        this.FlightCode = FlightCode;
    }

    public void setSeatID(int SeatID) {
        this.SeatID = SeatID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public void setTimestamp(Date Timestamp) {
        this.Timestamp = Timestamp;
    }
}
