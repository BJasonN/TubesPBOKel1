package view;
import sistem.Roster;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
import dao.DataAkses;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.util.LinkedList;

public class EditRoster extends JFrame{

    public EditRoster(){
        initComponent();
    }
    
    private void initComponent(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        
        setTitle("Roster Kuliah");
        
        getContentPane().setLayout(null);
        
        pnlUtama = new JPanel();
        pnlUtama.setSize(1000, 250);
        add(pnlUtama);
        
        lblJudul = new JLabel();
        lblJudul.setIcon(new ImageIcon(resizeImage("capture.png")));
        pnlUtama.add(lblJudul);
        //-------------------------------------
        
        pnlIsi = new JPanel();
        pnlIsi.setLayout(null);
        pnlIsi.setSize(1000, 350);
        pnlIsi.setLocation(0,250);
        add(pnlIsi);
        
        lblNama = new JLabel("Dosen : ");
        lblNama.setLocation(50, 0);
        lblNama.setSize(100, 100);
        pnlIsi.add(lblNama);
        txtNama = new JTextField(20);
        txtNama.setLocation(100, 35);
        txtNama.setSize(170, 20);
        pnlIsi.add(txtNama);
        
        lblMatKul = new JLabel("Matkul: ");
        lblMatKul.setLocation(50, 30);
        lblMatKul.setSize(100, 100);
        pnlIsi.add(lblMatKul);
        txtMatKul = new JTextField(20);
        txtMatKul.setLocation(100, 70);
        txtMatKul.setSize(170, 20);
        pnlIsi.add(txtMatKul);
        //tgl dari 1 sampai 31
        lblTgl = new JLabel("Tgl : ");
        lblTgl.setBounds(50,60,100,100);
        pnlIsi.add(lblTgl);
        Object[] arrTgl = new Object[31];
        for(int i = 0; i < 30; i++){
            arrTgl[i] = i+1;
        }
        cbbTgl = new JComboBox(arrTgl);
        cbbTgl.setBounds(100,100,170,20);
        pnlIsi.add(cbbTgl);
        //ruangan
        Object[] arrPilihan = {"R1", "R2", "R3","R4","R5"};
        cbbRuangan = new JComboBox(arrPilihan);
        cbbRuangan.setSize(50, 20);
        cbbRuangan.setLocation(100,130);
        pnlIsi.add(cbbRuangan);
        //masukin roster baru
        btnSubmit = new JButton("Submit");
        btnSubmit.setSize(170, 20);
        btnSubmit.setLocation(100, 190);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Diinput!");
                String dosen = txtNama.getText();
                String matkul = txtMatKul.getText();
                String tgl = String.valueOf(cbbTgl.getSelectedItem());
                String ruangan = String.valueOf(cbbRuangan.getSelectedItem());
                String jam = String.valueOf(cbbWaktu.getSelectedItem());
                String hari = String.valueOf(cbbHari.getSelectedItem());
                
                DataAkses.addRoster(dosen, matkul, tgl, ruangan, jam, hari);
            }
        });
        pnlIsi.add(btnSubmit);
        
        //button back
        logOut = new JButton("Back");
        logOut.setBounds(800, 280, 170, 20);
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Admin().setVisible(true);
            }
        });
        pnlIsi.add(logOut);
        
        //drop box jam
        Object[] arrWaktu = {"7.00 - 8.00","8.00 - 9.00","9.00 - 10.00",
                            "10.00 - 11.00","11.00 - 12.00","12.00 - 13.00",
                            "13.00 - 14.00","14.00 - 15.00","15.00 - 16.00",
                            "16.00 - 17.00","17.00 - 18.00"
                            };
        cbbWaktu = new JComboBox(arrWaktu);
        cbbWaktu.setBounds(150, 130, 120, 20);
        pnlIsi.add(cbbWaktu);
        
        Object[] arrHari = {"Senin","Selasa","Rabu","Kamis","Jumat","Sabtu"};
        cbbHari = new JComboBox(arrHari);
        cbbHari.setBounds(100, 160, 170, 20);
        pnlIsi.add(cbbHari);
        //==============================================
        //yg atas buat submit
        //yg bawah buat delete
        lblDelete = new JLabel("Delete : ");
        lblDelete.setBounds(100, 170, 100,200);
        pnlIsi.add(lblDelete);
        
        cbbDelHari = new JComboBox(arrHari);
        cbbDelHari.setBounds(170,260,100,20);
        pnlIsi.add(cbbDelHari);
        
        cbbDelWaktu = new JComboBox(arrWaktu);
        cbbDelWaktu.setBounds(280, 260, 100, 20);
        pnlIsi.add(cbbDelWaktu);
        
        cbbDelTgl = new JComboBox(arrTgl);
        cbbDelTgl.setBounds(390,260,100,20);
        pnlIsi.add(cbbDelTgl);
        
        btnDel = new JButton("Delete");
        btnDel.setBounds(500, 260, 100, 20);
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Data Berhasil DIhapus!");
                String jam = String.valueOf(cbbDelWaktu.getSelectedItem());
                String hari = String.valueOf(cbbDelHari.getSelectedItem());
                String tgl = String.valueOf(cbbDelTgl.getSelectedItem());
                DataAkses.delRoster(jam, hari, tgl);
            }
        });
        pnlIsi.add(btnDel);
        //==========================================================
        //untuk menunjukkan jadwal apa saja yang ada di sana
        btnCari = new JButton("Cari");
        btnCari.setBounds(600,10,100,20);
        btnCari.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //table roster
                String minggu = String.valueOf(cbbMinggu.getSelectedItem());
                //hasi dari database ditampung llRoster
                LinkedList<Roster> llRoster = DataAkses.viewRoster(minggu);
                //
                Object[] judul = {"Jam","Senin","Selasa","Rabu","Kamis","Juamat","Sabtu"};
                Object[][] row = new Object[11][7];
                for(int i = 0; i < 11; i++){
                    //mengatur jam pada row 1
                    row[i][0] = String.valueOf(7+i)+".00 - "+String.valueOf(8+i)+".00";
                    for(int j = 1; j < 7; j++){
                        for(int k = 0; k < llRoster.size(); k++){
                            //mengabil dari linked list
                            if( llRoster.get(k).getJam().equals(row[i][0]) && hariKeAngka(llRoster.get(k).getHari()).equals("" + j)){
                                row[i][j] = llRoster.get(k).getDosen()+" - "+llRoster.get(k).getMatkul()+" - "+llRoster.get(k).getRuangan()+" - tgl: "+llRoster.get(k).getTgl();
                            }else{
                                row[i][j] = " ";
                            }
                        }
                    }
                }

                tableRoster = new JTable(row, judul);
                scrol = new JScrollPane(tableRoster);
                scrol.setBounds(350, 35, 600, 200);
                pnlIsi.add(scrol);
            }
        });
        pnlIsi.add(btnCari);
        
        Object[] arrMinggu = {"tgl: 1 - 5","tgl: 8 - 12","tgl: 15 - 19","tgl: 22 - 26"};
        cbbMinggu = new JComboBox(arrMinggu);
        cbbMinggu.setBounds(500,10,100,20);
        pnlIsi.add(cbbMinggu);
    }
    
    private Image resizeImage(String url){
        Image dimg = null;
        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(1000, 250, Image.SCALE_SMOOTH);
        }catch(IOException ex) {
            ex.printStackTrace(System.err);
        }
        return dimg;
    }
    
    public static void main(String[] args) {
        new EditRoster().setVisible(true);
    }
    
    //menubah hari senin, selasa, rabu... menjadi 1,2,3...
    private String hariKeAngka(String hari){
        String a = "";
        switch(hari){
            case "Senin":
                a = "1";
                break;
            case "Selasa":
                a = "2";
                break;
            case "Rabu":
                a = "3";
                break;
            case "Kamis":
                a = "4";
                break;
            case "Jumat":
                a = "5";
                break;
            case "Sabtu":
                a = "6";
                break;
        }
        return a;
    }
    
    private JPanel pnlUtama;
    private JLabel lblJudul;
    
    private JPanel pnlIsi;
    private JLabel lblNama;
    private JLabel lblMatKul;
    private JTextField txtNama;
    private JTextField txtMatKul;
    private JButton btnSubmit;
    private JLabel lblJam;
    private JLabel lblTgl;
    private JLabel lblBulan;
    private JComboBox cbbTgl;
    
    private JComboBox cbbRuangan;
    private JTable tableRoster;
    private JScrollPane scrol;
    private JComboBox cbbWaktu;
    private JComboBox cbbHari;
    
    private JButton logOut;
    
    private JLabel lblDelete;
    private JComboBox cbbDelWaktu;
    private JComboBox cbbDelHari;
    private JComboBox cbbDelTgl;
    private JButton btnDel;
    
    private JButton btnCari;
    private JComboBox cbbMinggu;
}
