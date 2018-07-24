/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import sistem.Roster;
/**
 *
 * @author USER
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import sistem.KotakSaran;
import sistem.Mahasiswa;
import sistem.Matkul;
import sistem.Orang;
import viewAll.Saran;

public class DataAksesAll {

    //untuk cek login mhs
    public static ArrayList<Mahasiswa> getUsernameMhs(String pilih) {

        ArrayList<Mahasiswa> lNama = new ArrayList<>();
        if (pilih.equals("Mahasiswa")) {

            try {
                Connection con = ConnectionManager.getConnection();
                String sql = "select * from mahasiswalogin";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    Mahasiswa mhs = new Mahasiswa();
                    mhs.setId(rs.getString("nim"));
                    mhs.setPassword(rs.getString("password"));
                    mhs.setNama(rs.getString("nama"));
                    lNama.add(mhs);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lNama;
    }

    //untuk cek login dosen
    public static ArrayList<Orang> getUsernameDosen(String pilih) {
        ArrayList<Orang> lNamaD = new ArrayList<>();
        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "select * from dosenlogin";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Orang dosen = new Orang();
                dosen.setId(rs.getString("id"));
                dosen.setPassword(rs.getString("password"));
                dosen.setNama(rs.getString("nama"));
                lNamaD.add(dosen);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lNamaD;
    }
    
    public static Orang getIdAdmin(){
        Orang admin = new Orang();
        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "select * from adminlogin";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                admin.setId(rs.getString("id"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return admin;
    }
    
    //tampilin data roster
    //input string tanggal awal sampai akhir selama seminggu
    //mereturn linkedlist berisi data di database
    public static LinkedList<Roster> viewRoster(String tgl) {
        LinkedList<Roster> llRoster = new LinkedList<>();
        String[] arrTgl = tgl.split(" ");
        String tgl1 = arrTgl[1];
        String tgl2 = arrTgl[3];
        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "select * from roster where tgl >=" + tgl1 + " and tgl <=" + tgl2;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Roster roster = new Roster();
                roster.setDosen(rs.getString(1));
                roster.setMatkul(rs.getString(2));
                roster.setRuangan(rs.getString(4));
                roster.setTgl(rs.getString(3));
                roster.setJam(rs.getString(5));
                roster.setHari(rs.getString(6));
                llRoster.add(roster);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return llRoster;
    }

}
