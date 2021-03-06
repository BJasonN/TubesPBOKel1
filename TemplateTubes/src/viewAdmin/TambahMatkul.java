package viewAdmin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
import viewAdmin.Admin;
import dao.DataAksesAdmin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TambahMatkul extends JFrame{
    public TambahMatkul(){
        initComponent();
    }
    
    private void initComponent(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(Color.blue);
        setTitle("Add Mata Kuliah");
        
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
        //--------------------------------
        
        lbltambahmatkul = new JLabel("Tambah Matkul");
        lbltambahmatkul.setBounds(450, -60, 100,200);
        pnlIsi.add(lbltambahmatkul);
        
        lblMatkul = new JLabel("Matkul : ");
        lblMatkul.setBounds(350,-20,100,200);
        pnlIsi.add(lblMatkul);
        
        txtMatkul = new JTextField();
        txtMatkul.setBounds(450,70,170,20);
        pnlIsi.add(txtMatkul);
        
        lblKodeMatkul = new JLabel("Kode Matkul : ");
        lblKodeMatkul.setBounds(350, 10, 100,200);
        pnlIsi.add(lblKodeMatkul);
        
        txtKodeMatkul = new JTextField();
        txtKodeMatkul.setBounds(450,100,170,20);
        pnlIsi.add(txtKodeMatkul);
        
        lbljumlah = new JLabel("Jumlah SKS: ");
        lbljumlah.setBounds(350, 40, 100,200);
        pnlIsi.add(lbljumlah);
        
        jumlah = new JTextField();
        jumlah.setBounds(450, 130, 50,20);
        pnlIsi.add(jumlah);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(450,180,170,20);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtMatkul.getText();
                String kode=txtKodeMatkul.getText();
                int sks = Integer.parseInt(jumlah.getText());
                DataAksesAdmin.addMatkul(nama, kode, sks);
                JOptionPane.showMessageDialog(null, "Data Berhasil Diinput!");
            }
        });
        pnlIsi.add(btnSubmit);
        
        back = new JButton("Back");
        back.setBounds(800, 280, 170, 20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Admin().setVisible(true);
            }
        });
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
    
    
    private JPanel pnlUtama;
    private JLabel lblJudul;
    private JPanel pnlIsi;
    private JLabel lbltambahmatkul;
    private JLabel lbljumlah;
    private JLabel lblMatkul;
    private JLabel lblKodeMatkul;
    private JTextField jumlah;
    private JTextField txtMatkul;
    private JTextField txtKodeMatkul;
    private JButton btnSubmit;
    
    private JButton back;
}
