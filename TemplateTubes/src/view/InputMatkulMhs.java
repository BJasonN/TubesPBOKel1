package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dao.DataAkses;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import sistem.Matkul;

/**
 *
 * @author Sutanto
 */
public class InputMatkulMhs extends JFrame{
    public InputMatkulMhs(){
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
        
        lblinputmatkul = new JLabel("Input Matkul Mhs");
        pnl1.add(lblinputmatkul);
        lblinputmatkul.setBounds(400,250 , 250, 50);
        lblinputmatkul.setFont(new Font("Arial",Font.BOLD,18));
        
        lblmhs= new JLabel("Mahasiswa : ");
        pnl1.add(lblmhs);
        lblmhs.setBounds(380,300, 100, 30);
        lblmhs.setFont(new Font("Arial",Font.PLAIN,15));
        
        String[] llmhs = DataAkses.getNamaMhs();
        mhs= new JComboBox(llmhs);
        mhs.setBounds(480,300 , 100, 20);
        pnl1.add(mhs);
        
        
        lblinputmatkul = new JLabel("Mata Kuliah : ");
        pnl1.add(lblinputmatkul);
        lblinputmatkul.setBounds(380,350, 100, 30);
        lblinputmatkul.setFont(new Font("Arial",Font.PLAIN,15));
        
        ArrayList<Matkul> lmatkul = DataAkses.getNamaMatkul();
        String[] rmatkul = new String[lmatkul.size()];
        for (int i = 0; i < lmatkul.size(); i++) {
            rmatkul[i] = lmatkul.get(i).getNamaMatkul();
        }
        matkul= new JComboBox(rmatkul);
        matkul.setBounds(480,350, 100, 20);
        pnl1.add(matkul);
        
        lblsemester = new JLabel("Semester : ");
        pnl1.add(lblsemester);
        lblsemester.setBounds(380,400, 100, 30);
        lblsemester.setFont(new Font("Arial",Font.PLAIN,15));
        
        String[] sem = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"};
        semester= new JComboBox(sem);
        semester.setBounds(480,400, 100, 20);
        pnl1.add(semester);
        
        submit= new JButton("submit");
        submit.setBounds(350,450, 100, 20);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String tmhs = String.valueOf(mhs.getSelectedItem());
                String tmatkul = String.valueOf(matkul.getSelectedItem());
                String tsem = String.valueOf(semester.getSelectedItem());
                String sks = null;
                
                boolean cek = false;
                int i = 0;
                while (cek == false && i < lmatkul.size()) {
                    Matkul matkul= lmatkul.get(i);
                    if (matkul.getNamaMatkul().equals(tmatkul)) {
                        sks = Integer.toString(matkul.getSks());
                        cek = true;
                    }
                    i++;
                }
                String ntable = tmhs+ tsem;
                
                DataAkses.addBuatTableMatkulMhs(ntable, tmatkul, sks);
                DataAkses.addMatkulMhs(ntable, tmatkul, sks);
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
    
    public static void main(String[] args) {
        new InputMatkulMhs().setVisible(true);
    }
    
    JPanel pnl1;
    JPanel pnlUtama;
    JLabel lblJudul; 
    JLabel lblinputmatkul;
    JLabel lblmatkul;
    JLabel lblmhs;
    JLabel lblsemester;
    JButton submit;
    JButton back;
    JComboBox mhs;
    JComboBox matkul;
    JComboBox semester;
}
