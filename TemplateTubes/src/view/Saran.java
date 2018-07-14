/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author Sutanto
 */
public class Saran extends JFrame{
    public Saran(){
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
        
        pnl1 = new JPanel();
        pnl1.setSize(800, 200);
        add(pnl1);
        pnl1.setLayout(null);
        
        lblsaran = new JLabel("Saran");
        pnl1.add(lblsaran);
        lblsaran.setBounds(470,250 , 250, 50);
        lblsaran.setFont(new Font("Arial",Font.BOLD,18));
        
        Object row[]={"Nama","Saran"};
        Object isi[][]={{"1","2"},{"1","2"}};
        table= new JTable(isi,row);
        scroll = new JScrollPane(table);
        scroll.setBounds(100, 300, 800, 200);
        pnl1.add(scroll);
        
        back= new JButton("Back");
        back.setBounds(450,530,100,20);
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
    
    public static void main(String[] args) {
        Saran saran = new Saran();
        saran.setVisible(true);
    }
    
    JPanel pnlUtama;
    JPanel pnl1;
    JLabel lbltlogin;
    JLabel plogin;
    JLabel lblJudul;
    JLabel lblsaran;
    JLabel lblpassword;
    JLabel lblid;
    JComboBox login;
    JButton mhs;
    JButton dosen;
    JButton admin;
    JButton back;
    JTextField password;
    JTextField id;
    JTable table;
    JScrollPane scroll;
}
