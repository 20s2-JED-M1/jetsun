/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

/**
 *
 * @author home
 */
@WebServlet("/search")
public class SearchFlightServlet extends HttpServlet {
    
    @Resource(name = "jdbc/collabproj")
    private DataSource flights;
    
    
    
    
}
