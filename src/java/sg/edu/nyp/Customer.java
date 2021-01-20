/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp;

import java.io.Serializable;
import java.sql.Date;

public class Customer implements Serializable {
    public final long serialVersionUID = -1L;
    private String NRICNo;
    private String Title;
    private String Name;
    private String Email;
    private String HomeAdd;
    private String BillingAdd;
    private String PassportNo;
    private String PassportExpiry;
    private String MobilePhone;
    private Date DoB;
    private String OfficePhone;
    private String HomePhone;
    private String KrisFlyer;
    private String Password;
    

    public String getNRICNo() {
        return NRICNo;
    }

    public void setNRICNo(String NRICNo) {
        this.NRICNo = NRICNo;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getHomeAdd() {
        return HomeAdd;
    }

    public void setHomeAdd(String HomeAdd) {
        this.HomeAdd = HomeAdd;
    }

    public String getBillingAdd() {
        return BillingAdd;
    }

    public void setBillingAdd(String BillingAdd) {
        this.BillingAdd = BillingAdd;
    }

    public String getPassportNo() {
        return PassportNo;
    }

    public void setPassportNo(String PassportNo) {
        this.PassportNo = PassportNo;
    }

    public String getPassportExpiry() {
        return PassportExpiry;
    }

    public void setPassportExpiry(String PassportExpiry) {
        this.PassportExpiry = PassportExpiry;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public void setMobilePhone(String MobilePhone) {
        this.MobilePhone = MobilePhone;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date DoB) {
        this.DoB = DoB;
    }

    public String getOfficePhone() {
        return OfficePhone;
    }

    public void setOfficePhone(String OfficePhone) {
        this.OfficePhone = OfficePhone;
    }

    public String getHomePhone() {
        return HomePhone;
    }

    public void setHomePhone(String HomePhone) {
        this.HomePhone = HomePhone;
    }

    public String getKrisFlyer() {
        return KrisFlyer;
    }

    public void setKrisFlyer(String KrisFlyer) {
        this.KrisFlyer = KrisFlyer;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
    

   