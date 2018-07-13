/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

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
        
        Object[] arrPilihan = {"R1", "R2", "R3"};
        cbbRuangan = new JComboBox(arrPilihan);
        cbbRuangan.setSize(170, 20);
        cbbRuangan.setLocation(100,100);
        pnlIsi.add(cbbRuangan);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setSize(170, 20);
        btnSubmit.setLocation(100, 190);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Diinput!");
            }
        });
        pnlIsi.add(btnSubmit);
        
        Object[] judul = {"Jam","Senin","Selasa","Rabu","Kamis","Juamat","Sabtu"};
        Object[][] row = {
            {"07.00 - 08.00","PBO - Ria - R1","qwe","fsd","aa","bb","cc"},
            {"08.00 - 09.00","PBO","qwe","fsd","aa","bb","cc"},
            {"09.00 - 10.00","PBO","qwe","fsd","aa","bb","cc"}
        };
        
        tableRoster = new JTable(row, judul);
        scrol = new JScrollPane(tableRoster);
        scrol.setBounds(350, 35, 600, 200);
        pnlIsi.add(scrol);
        
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
        
        Object[] arrWaktu = {"07.00 - 08.00","08.00 - 09.00","09.00 - 10.00",
                            "10.00 - 11.00","11.00 - 12.00","12.00 - 13.00",
                            "13.00 - 14.00","14.00 - 15.00","15.00 - 16.00",
                            "16.00 - 17.00","17.00 - 18.00"
                            };
        cbbWaktu = new JComboBox(arrWaktu);
        cbbWaktu.setBounds(100, 130, 170, 20);
        pnlIsi.add(cbbWaktu);
        
        Object[] arrHari = {"Senin","Selasa","Rabu","Kamis","Jumat","Sabtu"};
        cbbHari = new JComboBox(arrHari);
        cbbHari.setBounds(100, 160, 170, 20);
        pnlIsi.add(cbbHari);
        
        lblDelete = new JLabel("Delete : ");
        lblDelete.setBounds(100, 170, 100,200);
        pnlIsi.add(lblDelete);
        
        cbbDelHari = new JComboBox(arrHari);
        cbbDelHari.setBounds(170,260,100,20);
        pnlIsi.add(cbbDelHari);
        
        cbbDelWaktu = new JComboBox(arrWaktu);
        cbbDelWaktu.setBounds(280, 260, 100, 20);
        pnlIsi.add(cbbDelWaktu);
        
        btnDel = new JButton("Delete");
        btnDel.setBounds(390, 260, 100, 20);
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Data Berhasil DIhapus!");
            }
        });
        pnlIsi.add(btnDel);
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
    
    private JPanel pnlUtama;
    private JLabel lblJudul;
    
    private JPanel pnlIsi;
    private JLabel lblNama;
    private JLabel lblMatKul;
    private JTextField txtNama;
    private JTextField txtMatKul;
    private JButton btnSubmit;
    private JLabel lblJam;
    
    private JComboBox cbbRuangan;
    private JTable tableRoster;
    private JScrollPane scrol;
    private JComboBox cbbWaktu;
    private JComboBox cbbHari;
    
    private JButton logOut;
    
    private JLabel lblDelete;
    private JComboBox cbbDelWaktu;
    private JComboBox cbbDelHari;
    private JButton btnDel;
}
