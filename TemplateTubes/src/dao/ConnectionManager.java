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
        try{
            connection.close();
            System.out.println("Connection close");
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    
}
