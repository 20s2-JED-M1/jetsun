/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Asus
 */
@Stateless
public class CustomerManagementEJB {
    
     @Resource(name = "jdbc/jed")
    private DataSource customerManagement;
}
