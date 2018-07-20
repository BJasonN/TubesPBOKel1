package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dao.DataAkses;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import sistem.MainSistem;

/**
 *
 * @author Sutanto
 */
public class MhsSaran extends JFrame{
    public MhsSaran(){
        initComponents();
    }
    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(Color.blue);
        
        pnlUtama = new JPanel();
        pnlUtama.setBounds(0,0,1000, 250);
        add(pnlUtama);
        
        lblJudul = new JLabel();
        lblJudul.setIcon(new ImageIcon(resizeImage("Capture.png")));
        pnlUtama.add(lblJudul);
        
        pnl1= new JPanel();
        pnl1.setBounds(0,250,1000,350);
        add(pnl1);
        pnl1.setLayout(null);
        
        saran = new JLabel("Saran");
        pnl1.add(saran);
        saran.setBounds(470,250 , 250, 50);
        saran.setFont(new Font("Arial",Font.BOLD,18));
        
        lblnim= new JLabel("Nim : ");
        pnl1.add(lblnim);
        lblnim.setBounds(350,300, 100, 30);
        lblnim.setFont(new Font("Arial",Font.PLAIN,15));
        nim= new JTextArea();
        nim.setBounds(450,300 , 100, 20);
        nim.setText(MainSistem.nim);
        pnl1.add(nim);
        
        
        lblmahasiswa = new JLabel("Mahasiswa : ");
        pnl1.add(lblmahasiswa);
        lblmahasiswa.setBounds(350,350, 100, 30);
        lblmahasiswa.setFont(new Font("Arial",Font.PLAIN,15));
        mhs= new JTextArea();
        mhs.setBounds(450,350, 100, 20);
        mhs.setText(MainSistem.nama);
        pnl1.add(mhs);
        
        lblsaranmhs = new JLabel("Saran : ");
        pnl1.add(lblsaranmhs);
        lblsaranmhs.setBounds(350,400, 100, 30);
        lblsaranmhs.setFont(new Font("Arial",Font.PLAIN,15));
        saranmhs= new JTextArea();
        saranmhs.setBounds(450,400, 200, 80);
        pnl1.add(saranmhs);
        
        submit= new JButton("submit");
        submit.setBounds(350,500, 100, 20);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = mhs.getText();
                String inim = nim.getText();
                String saran = saranmhs.getText();
                DataAkses.addSaran(nama, inim, saran);
                JOptionPane.showMessageDialog(null, "Data Berhasil Diinput!");
            }
        });
        pnl1.add(submit);
        
        back= new JButton("back");
        back.setBounds(550,500, 100, 20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new JFrameMahasiswa().setVisible(true);
            }
        });
        pnl1.add(back);
        
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
    private JPanel pnl1;
    private JLabel lblJudul;
    private JLabel saran;
    private JLabel lblmahasiswa;
    private JLabel lblnim;
    private JLabel lblsaranmhs;
    private JButton submit;
    private JButton back;
    private JTextArea nim;
    private JTextArea mhs;
    private JTextArea saranmhs;
}
