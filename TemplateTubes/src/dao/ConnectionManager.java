/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author kevin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ConnectionManager {
    private static String server = "jdbc:mysql://localhost/sia";
    private static String username = "root";
    private static String password = "";
    private static Connection connection;
    
    public static Connection getConnection(){//singleton
        if(connection == null){
            connection = logOn();
        }
        return connection;
    }
    //putuskan koneksinya gaes
    public static boolean cutConnection(){
        int r = JOptionPane.showConfirmDialog(null, "Are you sure?", "Log out", JOptionPane.YES_OPTION);
        if(r == JOptionPane.YES_OPTION){
            logOff();//belom sukses
            return true;
        }else {
            return false;
        }
    }
    
    private static Connection logOn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            System.out.println("Koneksi sukses");
            return DriverManager.getConnection(server, username, password);
        }catch(SQLException e){
            e.printStackTrace(System.err);
        }catch(ClassNotFoundException ex){
            ex.printStackTrace(System.err);
            System.out.println("JDBC.ODBC driver tidak ditemukan");
        }
        return null;
    }
    private static void logOff(){
        try {
            connection.close();
            System.out.println("Connection close");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}
