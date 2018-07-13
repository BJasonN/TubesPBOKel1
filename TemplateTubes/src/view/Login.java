package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Sutanto
 */
public class Login extends JFrame{
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
                dispose();
                if(setLogIn.equals("Mahasiswa")){
                    new JFrameMahasiswa().setVisible(true);
                }else if(setLogIn.equals("Dosen")){
                    new Dosen().setVisible(true);
                }else {
                    new Admin().setVisible(true);
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
