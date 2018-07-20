/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

/**
 *
 * @author ASUS
 */
public class LihatSaran extends JFrame{
    public LihatSaran(){
        initComponents();
        
    }
    
    private void initComponents(){
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
        
        lbllihatsaran = new JLabel("Lihat Saran");
        pnl1.add(lbllihatsaran);
        lbllihatsaran.setBounds(450,250 , 250, 50);
        lbllihatsaran.setFont(new Font("Arial",Font.BOLD,18));
        
        String []judul = {"NIM","Nama","FeedBack"};
        String[][]lihatsaran=DataAkses.getSaran();
        table = new JTable(lihatsaran,judul);
        scroll= new JScrollPane(table);
        scroll.setBounds(40, 300, 900, 100);
        pnl1.add(scroll);
        back= new JButton("back");
        back.setBounds(550,500, 100, 20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Admin().setVisible(true);
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
    private JPanel pnl1;
    private JPanel pnlUtama;
    private JLabel lblJudul;
    private JTable table;
    private JScrollPane scroll;
    private JLabel lbllihatsaran;
    private JButton back;
}
