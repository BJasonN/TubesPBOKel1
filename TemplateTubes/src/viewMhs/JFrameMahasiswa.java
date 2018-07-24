package viewMhs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import viewMhs.LihatNilai;
import dao.ConnectionManager;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import viewAll.LiatRoster;
import viewAll.Login;

/**
 *
 * @author Sutanto
 */
public class JFrameMahasiswa extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    public JFrameMahasiswa(){
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

        lblmhs = new JLabel("Mahasiswa");
        lblmhs.setBounds(430,250, 400, 50);
        pnl1.add(lblmhs);
        lblmhs.setFont(new Font("Arial",Font.BOLD,18));
        
        lnilai= new JButton("Lihat Nilai");
        lnilai.setBounds(430,300,100,30);
        lnilai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatNilai().setVisible(true);
            }
        });
        pnl1.add(lnilai);
        
//<<<<<<< HEAD
////        kehadiran= new JButton("Kehadiran");
////        kehadiran.setBounds(200,350,100,30);
////        kehadiran.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                new Kehadiran().setVisible(true);
////            }
////        });
////        pnl1.add(kehadiran);
//=======
//        kehadiran= new JButton("Kehadiran");
//        kehadiran.setBounds(200,350,100,30);
//        kehadiran.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                new Kehadiran().setVisible(true);
//            }
//        });
//        pnl1.add(kehadiran);
//>>>>>>> 90a16c4359ed562697ddcc2c1b924c5ec696b524
        
        roster= new JButton("Roster");
        roster.setBounds(430,350,100,30);
        roster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LiatRoster().setVisible(true);
            }
        });
        pnl1.add(roster);
        
        saran= new JButton("Saran");
        saran.setBounds(430,400,100,30);
        saran.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MhsSaran().setVisible(true);
            }
        });
        pnl1.add(saran);
        
        logout= new JButton("Logout");
        logout.setBounds(430,450,100,30);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ConnectionManager.cutConnection()== true){
                    dispose();
                    new Login().setVisible(true);
                }
            }
        });
        pnl1.add(logout);
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
    
    private JLabel lblmhs;
    private JLabel lblJudul;
    private JButton lnilai;
    private JButton kehadiran;
    private JButton roster;
    private JButton saran;
    private JButton logout;
    private JPanel pnlUtama;
    private JPanel pnl1;
}
