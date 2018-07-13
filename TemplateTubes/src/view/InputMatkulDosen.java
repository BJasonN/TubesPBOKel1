package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import javax.swing.WindowConstants;

/**
 *
 * @author Sutanto
 */
public class InputMatkulDosen extends JFrame{
    public InputMatkulDosen(){
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
        
        lblinputmatkul = new JLabel("Input Matkul Dosen");
        pnl1.add(lblinputmatkul);
        lblinputmatkul.setBounds(400,250 , 250, 50);
        lblinputmatkul.setFont(new Font("Arial",Font.BOLD,18));
        
        lbldosen= new JLabel("Dosen : ");
        pnl1.add(lbldosen);
        lbldosen.setBounds(380,300, 100, 30);
        lbldosen.setFont(new Font("Arial",Font.BOLD,15));
        dosen= new JComboBox();
        dosen.setBounds(480,300 , 100, 20);
        pnl1.add(dosen);
        
        
        lblmatkul = new JLabel("Mata Kuliah : ");
        pnl1.add(lblmatkul);
        lblmatkul.setBounds(380,350, 100, 30);
        lblmatkul.setFont(new Font("Arial",Font.BOLD,15));
        matkul= new JComboBox();
        matkul.setBounds(480,350, 100, 20);
        pnl1.add(matkul);
        
        lblsemester = new JLabel("Semester : ");
        pnl1.add(lblsemester);
        lblsemester.setBounds(380,400, 100, 30);
        lblsemester.setFont(new Font("Arial",Font.BOLD,15));
        semester= new JComboBox();
        semester.setBounds(480,400, 100, 20);
        pnl1.add(semester);
        
        submit= new JButton("submit");
        submit.setBounds(360,450, 100, 20);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Diinput!");
            }
        });
        pnl1.add(submit);
        
        back= new JButton("back");
        back.setBounds(500,450, 100, 20);
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
    
    JPanel pnl1;
    JPanel pnlUtama;
    JLabel lblJudul;
    JLabel lblinputmatkul;
    JLabel lblmatkul;
    JLabel lbldosen;
    JLabel lblsemester;
    JButton submit;
    JButton back;
    JComboBox dosen;
    JComboBox matkul;
    JComboBox semester;
}
