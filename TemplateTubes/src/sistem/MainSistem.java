/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem;
import view.Login;
/**
 *
 * @author kevin
 */
import dao.ConnectionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MainSistem {
    public static String nama;
    public static String nim;
    
    public static void main(String[] args) {
        new Login().setVisible(true);
        
    }
    
}
