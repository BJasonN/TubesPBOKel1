/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
import sistem.Matkul;

/**
 *
 * @author USER
 */
public class DataAksesDosen {
    //untuk mendapatkan matkul tertentu yang diajar oleh dosen tertentu
    public static String[] getNamaMatkulPerDosen(String ntable) {
        LinkedList<String> matkul=new LinkedList<>();
        String [] lmatkul=null;
        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "select * from $tableName";
            String query =sql.replace("$tableName",ntable);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                matkul.add(rs.getString("matkul"));
            }
            
            lmatkul=new String[matkul.size()];
            for(int i=0;i<matkul.size();i++){
                lmatkul[i]=matkul.get(i);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lmatkul;
    }
    
    public static void addPersentase(String ntable,String nmatkul,String ptugas,String pkuis,String puts,String puas){
        String sql="update $tableName set ptugas="+ptugas+",pkuis="+pkuis+",puts="+puts+",puas="+puas+" where matkul='"+nmatkul+"'";
        try {
            Connection con = ConnectionManager.getConnection();
            String query =sql.replace("$tableName",ntable);
            PreparedStatement st = con.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static LinkedList<String> listTable() {
        LinkedList<String> daftarTable = new LinkedList<>();
        int i = 0;
        try {
            Connection con = ConnectionManager.getConnection();
            DatabaseMetaData md = con.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
                daftarTable.add(rs.getString(3));
                i++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return daftarTable;
    }
    
    public static void inputNilai(String tugas, String kuis, String uts, String uas, String nama, String matkul, String sem,String namadosen,char index) {
        try {
            Connection con = ConnectionManager.getConnection();
            Statement st = con.createStatement();
            String namaTable = nama+sem;
//            char index=hitungNilai(tugas,kuis,uts,uas,matkul,sem,namadosen);
//            System.out.println(index);
            String sql = "update "+namaTable+" set nilaitugas = "+Float.valueOf(tugas)+","
                    + "nilaikuis = "+Float.valueOf(kuis)+","
                    + "nilaiuts = "+Float.valueOf(uts)+","
                    + "nilaiuas = "+Float.valueOf(uas)+","
                    +"indeks = '"+index+
                    "' where matkul='"+matkul+"';";
            st.executeUpdate(sql);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static String[] getNama(String pilih) {
        String[] arrNama = {};
        List<String> lNama = new ArrayList<>();
        if (pilih.equals("Mahasiswa")) {
            System.out.println("kepilih mahasiswa");
            try {
                Connection con = ConnectionManager.getConnection();
                String sql = "select * from mahasiswalogin";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    lNama.add(rs.getString(2));
                    System.out.println(rs.getString(2));
                }
                arrNama = new String[lNama.size()];
                for (int i = 0; i < lNama.size(); i++) {
                    arrNama[i] = lNama.get(i);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("kepilih dosen");
            try {
                Connection con = ConnectionManager.getConnection();
                String sql = "select * from dosenlogin";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    lNama.add(rs.getString(2));
                    System.out.println(rs.getString(2));
                }
                arrNama = new String[lNama.size()];
                for (int i = 0; i < lNama.size(); i++) {
                    arrNama[i] = lNama.get(i);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return arrNama;
    }
    
    public static ArrayList<Matkul> getNamaMatkul() {
        ArrayList<Matkul> lmatkul = new ArrayList<>();
        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "select * from matkul";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Matkul matkul = new Matkul();
                int sks = Integer.parseInt(rs.getString("sks"));
                matkul.setSks(sks);
                matkul.setNamaMatkul(rs.getString("nama"));
                lmatkul.add(matkul);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lmatkul;
    }
    
    public static char hitungNilai(String tugas,String kuis,String uts,String uas,String matkul,String sem,String namadosen){
        String namaTable2=namadosen+sem;
        char index;
        Matkul dmatkul=getPersentase(matkul,namaTable2);
        
        float ptugas=(dmatkul.getPresentaseNilai().get("tugas"))/100;
        float pkuis=(dmatkul.getPresentaseNilai().get("kuis"))/100;
        float puts=(dmatkul.getPresentaseNilai().get("uts"))/100;
        float puas=(dmatkul.getPresentaseNilai().get("uas"))/100;
        float nakhir=ptugas*Float.valueOf(tugas)+pkuis*Float.valueOf(kuis)+puts*Float.valueOf(uts)+puas*Float.valueOf(uas);
        
        
        if(nakhir>80){
            index='A';
        }else if(nakhir>70){
            index='B';
        }else if(nakhir>60){
            index='C';
        }else if(nakhir>50){
            index='D';
        }else{
            index='E';
        }
        
        return index;
    }
    
    public static Matkul getPersentase(String matkul,String ntable){
        String sql = "select * from "+ntable+" where matkul='"+matkul+"';";
        Matkul dmatkul= new Matkul();
        System.out.println("test");
        try {
            
            Connection con = ConnectionManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            float ptugas=0;
            float pkuis=0;
            float puts=0;
            float puas=0;
            while(rs.next()){
                ptugas = Float.valueOf(rs.getString("ptugas"));
                pkuis = Float.valueOf(rs.getString("pkuis"));
                puts = Float.valueOf(rs.getString("puts"));
                puas = Float.valueOf(rs.getString("puas"));
            }
            
            HashMap<String,Float>lpmatkul=new HashMap<>();
            lpmatkul.put("tugas", ptugas);
            lpmatkul.put("kuis", pkuis);
            lpmatkul.put("uts", puts);
            lpmatkul.put("uas", puas);
            dmatkul.setNamaMatkul(matkul);
            dmatkul.setPresentaseNilai(lpmatkul);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return dmatkul;
    }
}
