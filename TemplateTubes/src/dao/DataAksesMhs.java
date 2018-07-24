/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class DataAksesMhs {
    public static List<String> getNilaiMhs(String ntable) {
        List<String> ListData = new ArrayList();
        String sql = "select * from "+ntable;
        try {
            Connection con = ConnectionManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                //disimpen per array dipisah ,
                ListData.add(rs.getString(1)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(7));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ListData;
    }
    
    public static void addSaran(String nama, String nim, String saran) {
        String sql = "insert into saran values(?,?,?)";

        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nim);
            st.setString(2, nama);
            st.setString(3, saran);
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
