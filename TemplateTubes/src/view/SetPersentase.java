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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Sutanto
 */
public class SetPersentase extends JFrame{
    public SetPersentase(){
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
        
        lblsetpersen = new JLabel("Set Persentase Nilai");
        pnl1.add(lblsetpersen);
        lblsetpersen.setBounds(390,250 , 250, 50);
        lblsetpersen.setFont(new Font("Arial",Font.BOLD,18));
        
        lblmatkul = new JLabel("Mata Kuliah : ");
        pnl1.add(lblmatkul);
        lblmatkul.setBounds(380,300, 100, 30);
        lblmatkul.setFont(new Font("Arial",Font.PLAIN,15));
        matkul= new JComboBox();
        matkul.setBounds(480,300, 100, 20);
        pnl1.add(matkul);
        
        lblnilaitugas = new JLabel("Nilai Tugas : ");
        pnl1.add(lblnilaitugas);
        lblnilaitugas.setBounds(330,340, 100, 30);
        lblnilaitugas.setFont(new Font("Arial",Font.PLAIN,15));
        tugas= new JTextField();
        tugas.setBounds(430,340, 30, 20);
        pnl1.add(tugas);
        lblpersen = new JLabel("%");
        lblpersen.setBounds(465,340,20,20);
        pnl1.add(lblpersen);
        
        lblnilaikuis= new JLabel("Nilai Kuis : ");
        pnl1.add(lblnilaikuis);
        lblnilaikuis.setBounds(330,380, 100, 30);
        lblnilaikuis.setFont(new Font("Arial",Font.PLAIN,15));
        kuis= new JTextField();
        kuis.setBounds(430,380 , 30, 20);
        pnl1.add(kuis);
        lblpersen = new JLabel("%");
        lblpersen.setBounds(465,380,20,20);
        pnl1.add(lblpersen);
        
        lblnilaiUts = new JLabel("Nilai UTS : ");
        pnl1.add(lblnilaiUts);
        lblnilaiUts.setBounds(500,340, 100, 30);
        lblnilaiUts.setFont(new Font("Arial",Font.PLAIN,15));
        uts= new JTextField();
        uts.setBounds(600,340, 30, 20);
        pnl1.add(uts);
        lblpersen = new JLabel("%");
        lblpersen.setBounds(635,340,20,20);
        pnl1.add(lblpersen);
        
        lblnilaiUas= new JLabel("Nilai UAS : ");
        pnl1.add(lblnilaiUas);
        lblnilaiUas.setBounds(500,380, 100, 30);
        lblnilaiUas.setFont(new Font("Arial",Font.PLAIN,15));
        uas= new JTextField();
        uas.setBounds(600,380 , 30, 20);
        pnl1.add(uas);
        lblpersen = new JLabel("%");
        lblpersen.setBounds(635,380,20,20);
        pnl1.add(lblpersen);
        
        submit= new JButton("submit");
        submit.setBounds(360,450, 100, 20);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String smatkul= (String) matkul.getSelectedItem();
                float ptugas=Float.parseFloat(tugas.getText());
                float pkuis =Float.parseFloat(kuis.getText());
                float puts =Float.parseFloat(uts.getText());
                float puas =Float.parseFloat(uas.getText());
                
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
                new Dosen().setVisible(true);
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
        new SetPersentase().setVisible(true);
    }
    
    JPanel pnl1;
    JPanel pnlUtama;
    JLabel lblpersen;
    JLabel lblJudul;
    JLabel lblsetpersen;
    JLabel lblmatkul;
    JLabel lblnilaikuis;
    JLabel lblnilaitugas;
    JLabel lblnilaiUts;
    JLabel lblnilaiUas;
    JButton submit;
    JButton back;
    JTextField kuis;
    JTextField tugas;
    JTextField uts;
    JTextField uas;
    JComboBox matkul;
}
