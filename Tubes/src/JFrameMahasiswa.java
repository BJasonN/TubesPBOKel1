/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

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
        lnilai.setBounds(200,300,100,30);
        pnl1.add(lnilai);
        
        kehadiran= new JButton("Kehadiran");
        kehadiran.setBounds(200,350,100,30);
        pnl1.add(kehadiran);
        
        roster= new JButton("Roster");
        roster.setBounds(200,400,100,30);
        pnl1.add(roster);
        
        saran= new JButton("Saran");
        saran.setBounds(200,450,100,30);
        pnl1.add(saran);
        
        logout= new JButton("Logout");
        logout.setBounds(650,300,100,30);
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
    
    public static void main(String[] args) {
        new JFrameMahasiswa().setVisible(true);
    }
    
    JLabel lblmhs;
    JLabel lblJudul;
    JButton lnilai;
    JButton kehadiran;
    JButton roster;
    JButton saran;
    JButton logout;
    JPanel pnlUtama;
    JPanel pnl1;
}
