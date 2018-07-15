package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ConnectionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import sistem.MainSistem;

/**
 *
 * @author Sutanto
 */
public class Login extends JFrame{
    public static String sid = "";
    public Login(){
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
        
        lbllogin = new JLabel("Login");
        pnl1.add(lbllogin);
        lbllogin.setBounds(470,250 , 250, 50);
        lbllogin.setFont(new Font("Arial",Font.BOLD,18));
        
        lbltlogin= new JLabel("Tipe Login : ");
        pnl1.add(lbltlogin);
        lbltlogin.setBounds(370,300, 100, 30);
        lbltlogin.setFont(new Font("Arial",Font.PLAIN,15));
        Object[] tipeLogin  = {"Mahasiswa", "Dosen", "Admin"}; 
        login = new JComboBox(tipeLogin);
        login.setBounds(470,300 , 100, 20);
        pnl1.add(login);
        
        lblid= new JLabel("ID: ");
        pnl1.add(lblid);
        lblid.setBounds(370,350, 100, 30);
        lblid.setFont(new Font("Arial",Font.PLAIN,15));
        id= new JTextField();
        id.setBounds(470,350 , 100, 20);
        pnl1.add(id);
        
        lblpassword = new JLabel("Password : ");
        pnl1.add(lblpassword);
        lblpassword.setBounds(370,400, 100, 30);
        lblpassword.setFont(new Font("Arial",Font.PLAIN,15));
        password= new JTextField();
        password.setBounds(470,400, 100, 20);
        pnl1.add(password);
        
        submit= new JButton("Submit");
        submit.setBounds(450,450,100,20);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object setLogIn = login.getSelectedItem();
                sid = id.getText();//dibuat public diatas agar gampang cari data lihat nilai
                String spassword = password.getText();
                //untuk masuk ke mahasiswa
                if(setLogIn.equals("Mahasiswa")){
                    Connection con = ConnectionManager.getConnection();
                    String pass=null;
                    String nim = null;
                    
                    //function connect ke sql
                    try {
                        Statement st = con.createStatement();
                        String sql = "select * from mahasiswalogin where nim = '"+sid+"'";
                        ResultSet rs=st.executeQuery(sql);
                        while(rs.next()){
                                nim=rs.getString("nim");
                                pass=rs.getString("password");
                        }
                        //untuk login bisa atau tidak
                        
                        if(!sid.equals(nim)){
                            JOptionPane.showMessageDialog(null, "ID salah");
                        }else{
                            if(spassword.equals(pass)){
                                MainSistem.id=nim;
                                System.out.println(MainSistem.id);
                                dispose();
                                new JFrameMahasiswa().setVisible(true);
                            }else{
                                JOptionPane.showMessageDialog(null, "Password salah");
                            }
                        }
                        
                        
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    
                }else if(setLogIn.equals("Dosen")){
                    new Dosen().setVisible(true);
                }else {
                    if(sid.equals("admin")&& spassword.equals("ada")){
                        dispose();
                        new Admin().setVisible(true);
                    }else{
                        if(!sid.equals("admin")){
                            JOptionPane.showMessageDialog(null, "ID salah");
                        }else if (!spassword.equals("ada")){
                            JOptionPane.showMessageDialog(null, "Password salah");
                        }
                    }
                    
                }
            }
        });
        pnl1.add(submit);
        
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
    
    JPanel pnlUtama;
    JPanel pnl1;
    JLabel lbltlogin;
    JLabel plogin;
    JLabel lblJudul;
    JLabel lbllogin;
    JLabel lblpassword;
    JLabel lblid;
    JComboBox login;
    JButton mhs;
    JButton dosen;
    JButton admin;
    JButton submit;
    JTextField password;
    JTextField id;
    
}
