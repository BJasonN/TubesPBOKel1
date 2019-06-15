/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class InputNilai extends JFrame{
    public InputNilai(){
        initComponents();
    }
    private void initComponents(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(Color.blue);
        setTitle("Input Nilai");
        
        getContentPane().setLayout(null);
        
        pnlUtama = new JPanel();
        pnlUtama.setSize(1000, 250);
        add(pnlUtama);
        
        lblJudul = new JLabel();
        lblJudul.setIcon(new ImageIcon(resizeImage("capture.png")));
        pnlUtama.add(lblJudul);
        
        pnlIsi = new JPanel();
        pnlIsi.setLayout(null);
        pnlIsi.setSize(1000, 350);
        pnlIsi.setLocation(0,250);
        add(pnlIsi);
        //-----------------------------------------------
        lblNamaMhs = new JLabel("Nama Mahasiswa : ");
        lblNamaMhs.setSize(150, 100);
        lblNamaMhs.setLocation(280, -10);
        pnlIsi.add(lblNamaMhs);
        
        Object[] arrPilihMhs = {"mhs1","mhs2"};
        cbbMhs = new JComboBox(arrPilihMhs);
        cbbMhs.setSize(170, 20);
        cbbMhs.setLocation(390, 30);
        pnlIsi.add(cbbMhs);
        
        lblMatKul = new JLabel("Pilih Mata Kuliah : ");
        lblMatKul.setSize(150, 100);
        lblMatKul.setLocation(280, 20);
        pnlIsi.add(lblMatKul);
        
        Object[] arrPilihMatKul = {"Matkul1","Matkul2"};
        cbbMatKul = new JComboBox(arrPilihMatKul);
        cbbMatKul.setSize(170, 20);
        cbbMatKul.setLocation(390, 60);
        pnlIsi.add(cbbMatKul);
        
        lblTugas = new JLabel("Tugas : ");
        lblTugas.setLocation(280, 50);
        lblTugas.setSize(150, 100);
        pnlIsi.add(lblTugas);
        txtTugas = new JTextField(20);
        txtTugas.setSize(170, 20);
        txtTugas.setLocation(390, 90);
        pnlIsi.add(txtTugas);
        
        lblKuis = new JLabel("Kuis : ");
        lblKuis.setLocation(280, 80);
        lblKuis.setSize(150, 100);
        pnlIsi.add(lblKuis);
        txtKuis = new JTextField(20);
        txtKuis.setLocation(390, 120);
        txtKuis.setSize(170,20);
        pnlIsi.add(txtKuis);
        
        lblUTS = new JLabel("UTS : ");
        lblUTS.setLocation(280, 110);
        lblUTS.setSize(150,100);
        pnlIsi.add(lblUTS);
        txtUTS = new JTextField(20);
        txtUTS.setLocation(390,150);
        txtUTS.setSize(170,20);
        pnlIsi.add(txtUTS);
        
        lblUAS = new JLabel("UAS : ");
        lblUAS.setLocation(280,140);
        lblUAS.setSize(150,100);
        pnlIsi.add(lblUAS);
        txtUAS = new JTextField(20);
        txtUAS.setLocation(390,180);
        txtUAS.setSize(170,20);
        pnlIsi.add(txtUAS);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setLocation(390,210);
        btnSubmit.setSize(170,20);
        pnlIsi.add(btnSubmit);
        
        back = new JButton("Back");
        back.setBounds(800, 280, 170, 20);
        pnlIsi.add(back);
        
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
        new InputNilai().setVisible(true);
    }
    
    private JPanel pnlUtama;
    private JLabel lblJudul;
    
    private JPanel pnlIsi;
    private JLabel lblNamaMhs;
    private JLabel lblMatKul;
    private JLabel lblKuis;
    private JLabel lblTugas;
    private JLabel lblUTS;
    private JLabel lblUAS;
    private JComboBox cbbMhs;
    private JComboBox cbbMatKul;
    private JTextField txtKuis;
    private JTextField txtTugas;
    private JTextField txtUTS;
    private JTextField txtUAS;
    private JButton btnSubmit;
    private JButton back;
}