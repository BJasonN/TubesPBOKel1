package view;


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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jason
 */
public class LihatNilai extends JFrame{
    public LihatNilai(){
        initComponents();
    }
    
    public void initComponents(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        this.setTitle("Nilai");
        
        pnlUtama = new JPanel();
        pnlUtama.setBounds(0, 0, 1000, 250);
        add(pnlUtama);
        
        lblJudul = new JLabel();
        lblJudul.setIcon(new ImageIcon(resizeImage("capture.png")));
        pnlUtama.add(lblJudul);
        
        pnlIsi = new JPanel();
        pnlIsi.setBounds(0, 250, 1000, 350);
        add(pnlIsi);
        pnlIsi.setLayout(null);
        
        lblLihat = new JLabel("Lihat Nilai");
        lblLihat.setBounds(170, 40, 400, 50);
        pnlIsi.add(lblLihat);
        
        Object[] sem = {"Ganjil", "Genap", "Pendek"};
        cbbSem = new JComboBox(sem);
        cbbSem.setBounds(150, 100, 100, 25);
        pnlIsi.add(cbbSem);
        
        Object[] thnSem = {"2014", "2015", "2016", "2017", "2018"};
        cbbThnSem = new JComboBox(thnSem);
        cbbThnSem.setBounds(150, 125, 100, 25);
        pnlIsi.add(cbbThnSem);
        
        Object[] header = {"Matkul", "1", "2", "3", "4", "5", "UTS", "UAS", "AA", "Index"};
        Object[][] isiPerRow = {
                               {"PBO", "100", "100", "100", "100", "100", "100", "100", "100", "A"},
                               {"PBO", "100", "100", "100", "100", "100", "100", "100", "100", "A"},
                               {"PBO", "100", "100", "100", "100", "100", "100", "100", "100", "A"},
                               {"PBO", "100", "100", "100", "100", "100", "100", "100", "100", "A"},
                               };
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(150, 175, 100, 50);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tblLihatNilai = new JTable(isiPerRow, header);
                scroll = new JScrollPane(tblLihatNilai);
                scroll.setBounds(400, 40, 400, 100);
                pnlIsi.add(scroll);
            }
        });
        pnlIsi.add(btnSubmit);
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
    private JPanel pnlIsi;
    private JLabel lblJudul;
    private JLabel lblLihat;
    private JComboBox cbbThnSem;
    private JComboBox cbbSem;
    private JTable tblLihatNilai;
    private JScrollPane scroll;
    private JButton btnSubmit;
}