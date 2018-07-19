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
import java.util.LinkedList;
import java.util.List;
import sistem.KotakSaran;
import sistem.Mahasiswa;
import sistem.Matkul;
import sistem.Orang;
import view.Saran;

public class DataAkses {

    //output untuk menunjukkan nama dosen/mhs yg mau dihapus
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
        } else {
            try {
                Connection con = ConnectionManager.getConnection();
                String sql = "select * from dosenlogin";
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
    
    //untuk mendapatkan nama dosen
    public static String[] getNamaDosen() {
        ArrayList<Orang> lNamaD = getUsernameDosen("Dosen");

        String[] namad = new String[lNamaD.size()];
        for (int i = 0; i < lNamaD.size(); i++) {
            Orang org = lNamaD.get(i);
            namad[i] = org.getNama();
        }
        return namad;
    }
    
    //untuk mendapatkan nama mhs
    public static String[] getNamaMhs() {
        ArrayList<Mahasiswa> lNamaM = getUsernameMhs("Mahasiswa");

        String[] namaM = new String[lNamaM.size()];
        for (int i = 0; i < lNamaM.size(); i++) {
            Mahasiswa org = lNamaM.get(i);
            namaM[i] = org.getNama();
        }
        return namaM;
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

    public static void addUser(String nama, String id, String pass, String gender, String pilihan) {
        try {
            Connection con = ConnectionManager.getConnection();
            Statement st = con.createStatement();
            String sql = "";
            if (pilihan.equals("Mahasiswa")) {
                sql = "insert into mahasiswalogin(nama,nim,password,gender)"
                        + "values('" + nama + "','" + id + "','" + pass + "','" + gender + "');";
            } else {
                sql = "insert into dosenlogin(id,nama,password,gender)"
                        + "values('" + id + "','" + nama + "','" + pass + "','" + gender + "');";

                st.executeUpdate(sql);
            }
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void delUser(String nama, String pilihan) {

        if (pilihan.equals("Mahasiswa")) {

            try {
                Connection con = ConnectionManager.getConnection();
                Statement st = con.createStatement();
                String sql = "delete from mahasiswalogin where nama='" + nama + "'";
                st.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                Connection con = ConnectionManager.getConnection();
                Statement st = con.createStatement();
                String sql = "delete from dosenlogin where nama='" + nama + "'";

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    //untuk menambah matkul yang tersedia
    public static void addMatkul(String nama, String kode, int sks) {
        String sql = "insert into matkul values(?,?," + sks + ")";

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

    //untuk mendapatkan list nama matkul yang ada
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

    //untuk tambah matkul dosen per semester
    public static void addMatkulDosen(String ntable, String matkul, String sks) {
        
        String sql = "insert into $tableName values('"+matkul +"','" + sks + "','0.0','0.0','0.0','0.0')";
        try {
            String query =sql.replace("$tableName",ntable);
            Connection con = ConnectionManager.getConnection();
            PreparedStatement st = con.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //untuk buat table dosen persemester
    public static void addBuatTableMatkulDosen(String ntable, String matkul, String sks) {
        String sql = "create table if not exists $tableName("
            +"matkul varchar(20),"
            +"sks int(2),"
            +"ptugas float(10),"
            +"pkuis float(10),"
            +"puts float(10),"
            +"puas float(10))";
        try {
            String query =sql.replace("$tableName",ntable);
            Connection con = ConnectionManager.getConnection();
            PreparedStatement st = con.prepareStatement(query);
            st.executeUpdate();
            System.out.println("sukses");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
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
    
    //untuk set persentase nilai
    public static void addPersentase(String ntable,String nmatkul,String ptugas,String pkuis,String puts,String puas){
        String sql="update $tableName set ptugas="+ptugas+",pkuis="+pkuis+",puts="+puts+",puas="+puas+" where matkul='"+nmatkul+"'";
        try {
            Connection con = ConnectionManager.getConnection();
            String query =sql.replace("$tableName",ntable);
            PreparedStatement st = con.prepareStatement(query);
            st.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //untuk tambah matkul yang ditambah diambil matkul
    public static void addMatkulMhs(String ntable, String matkul, String sks) {
        
        String sql = "insert into $tableName values('"+matkul +"','" + sks + "','0.0','0.0','0.0','0.0')";
        try {
            String query =sql.replace("$tableName",ntable);
            Connection con = ConnectionManager.getConnection();
            PreparedStatement st = con.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //untuk membuat tabel matkul yang diambil seorang mahasiswa pada semester tertentu
    public static void addBuatTableMatkulMhs(String ntable, String matkul, String sks) {
        String sql = "create table if not exists $tableName("
            +"matkul varchar(20),"
            +"sks int(2),"
            +"nilai tugas float(10),"
            +"nilai kuis float(10),"
            +"nilai uts float(10),"
            +"nilai uas float(10))";
        try {
            String query =sql.replace("$tableName",ntable);
            Connection con = ConnectionManager.getConnection();
            PreparedStatement st = con.prepareStatement(query);
            st.executeUpdate();
            System.out.println("sukses");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //untuk melihat list table yang ada
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

    //untuk tambah saran 
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

    //masukin data ke roster
    public static void addRoster(String dosen, String matkul, String tgl, String ruangan, String jam, String hari) {
        try {
            String sql = "insert into roster(dosen,matkul,tgl,ruangan,jam,hari)"
                    + "values('" + dosen + "','" + matkul + "','" + tgl + "','" + ruangan + "','" + jam + "','" + hari + "')";

            Connection con = ConnectionManager.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //hapus data dari roster
    public static void delRoster(String jam, String hari, String tgl) {
        try {
            Connection con = ConnectionManager.getConnection();
            Statement st = con.createStatement();
            String sql = "delete from roster where jam ='" + jam + "' and hari='" + hari + "' and tgl=" + tgl;
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
    
    //untuk mendapatkan data saran dari table
    public static String[][] getSaran() {
        LinkedList<KotakSaran> lsaran = new LinkedList<>();
        String[][] daftarsaran = null;
        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "select * from saran";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                KotakSaran saran = new KotakSaran();
                Mahasiswa mhs = new Mahasiswa();
                mhs.setNama(rs.getString("nama"));
                mhs.setId(rs.getString("nim"));
                saran.setIsiFeedBack(rs.getString("saran"));
                saran.setMhs(mhs);
                lsaran.add(saran);
            }
            daftarsaran = new String[lsaran.size()][3];
            for (int i = 0; i < lsaran.size(); i++) {
                daftarsaran[i][0] = lsaran.get(i).getMhs().getId();
                daftarsaran[i][1] = lsaran.get(i).getMhs().getNama();
                daftarsaran[i][2] = lsaran.get(i).getIsiFeedBack();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return daftarsaran;
    }
}
