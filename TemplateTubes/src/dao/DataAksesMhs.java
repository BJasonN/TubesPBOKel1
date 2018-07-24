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
import java.util.HashMap;
import java.util.List;
import sistem.Mahasiswa;
import sistem.Matkul;
import sistem.NilaiMhsPerSemester;
import sistem.NilaiSatuMatkulPerMhs;

/**
 *
 * @author USER
 */
public class DataAksesMhs {
    public static NilaiMhsPerSemester getNilaiMhs(String nama,String sem) {
        NilaiMhsPerSemester mhs= new NilaiMhsPerSemester();
        Mahasiswa maha= new Mahasiswa();
        maha.setNama(nama);
        mhs.setMhs(maha);
        mhs.setSem(sem);
        ArrayList<NilaiSatuMatkulPerMhs> dnilai= new ArrayList<>();
        
        String ntable=nama+sem;
        String sql = "select * from "+ntable;
        try {
            Connection con = ConnectionManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                //disimpen per array dipisah ,
                NilaiSatuMatkulPerMhs nilaim=new NilaiSatuMatkulPerMhs();
                Matkul matkul=new Matkul();
                matkul.setNamaMatkul(rs.getString("matkul"));
                matkul.setSks(Integer.parseInt(rs.getString("sks")));
                HashMap<String,Integer> nilai= new HashMap<>();
                nilai.put("tugas", Integer.parseInt(rs.getString("nilaitugas")));
                nilai.put("kuis", Integer.parseInt(rs.getString("nilaikuis")));
                nilai.put("uts", Integer.parseInt(rs.getString("nilaiuts")));
                nilai.put("uas", Integer.parseInt(rs.getString("nilaiuas")));
                
                nilaim.setMatkul(matkul);
                nilaim.setNilai(nilai);
                nilaim.setIndeks(rs.getString("indeks"));
                dnilai.add(nilaim);
            }
            mhs.setDnilai(dnilai);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mhs;
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
