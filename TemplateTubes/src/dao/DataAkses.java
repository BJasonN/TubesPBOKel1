/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author USER
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sistem.Mahasiswa;

public class DataAkses {

    public static String[] getNama(String pilih) {
        String[] arrNama = {};
        List<String> lNama = new ArrayList<>();
        if (pilih.equals("Mahasiswa")) {
            try {
                Connection con = ConnectionManager.getConnection();
                String sql = "select * from mahasiswalogin";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    lNama.add(rs.getString(2));
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

    //untuk cek login
    public static ArrayList<Mahasiswa> getUsername(String pilih) {

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

    public static List<String> getNilaiMhs(String nim, String smt, String tahun) {
        List<String> ListData = new ArrayList();
        int i = 0;
        //buat dapet data buat lihat nilai dan kehadiran
        try {
            Connection con = ConnectionManager.getConnection();
            //ambil data nilai dari tabel nama mahasiswa
            String sql = "select matkul,nilai1,nilai2,nilai3,nilai4,nilai5,AA,index from '" + nim + "' where semester = '" + smt + "' and tahun = '" + tahun + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //ambil data sesuai tabel nama mahasiswa dan semester dan tahun
            while (rs.next()) {
                ListData.add(rs.getString(i));
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ListData;
    }

    public static List<String> getKehadiran(String nim, String smt, String tahun) {
        List<String> ListData = new ArrayList();
        int i = 0;
        //buat dapet data buat lihat nilai dan kehadiran
        try {
            Connection con = ConnectionManager.getConnection();
            //ambil data kehadiran dari tabel nama mahasiswa
            String sql = "select matkul,dosen,kehadiran from '" + nim + "' where semester = '" + smt + "' and tahun = '" + tahun + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //ambil data sesuai tabel nama mahasiswa dan semester dan tahun
            while (rs.next()) {
                ListData.add(rs.getString(i));
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ListData;
    }

    public static void delUser(String nama, String pilihan) {

        if (pilihan.equals("Mahasiswa")) {
            System.out.println("sda");
            try {
                Connection con = ConnectionManager.getConnection();
                Statement st = con.createStatement();
                String sql = "delete from mahasiswalogin where nama='" + nama + "'";
                st.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void addMatkul(String nama, String kode, int sks) {
        String sql = "insert into matkul values(?,?,"+sks+")";
        
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nama);
            st.setString(2, kode);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //masukin data ke roster
    public static void addRoster(String dosen,String matkul, String tgl, String ruangan, String jam, String hari){
        try{
            String sql = "insert into roster(dosen,matkul,tgl,ruangan,jam,hari)"+
                    "values('"+dosen+"','"+matkul+"','"+tgl+"','"+ruangan+"','"+jam+"','"+hari+"')";
            
            Connection con = ConnectionManager.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    //hapus data dari roster
    
}
