package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LiatRoster extends JFrame{
    public LiatRoster(){
        initComponent();
    }
    
    private void initComponent(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(Color.blue);
        setTitle("Roster");
        
        getContentPane().setLayout(null);
        
        pnlUtama = new JPanel();
        pnlUtama.setSize(1000, 250);
        add(pnlUtama);
        
        lblJudul = new JLabel();
        lblJudul.setIcon(new ImageIcon(resizeImage("capture.png")));
        pnlUtama.add(lblJudul);
        
        pnlIsi = new JPanel();
        pnlIsi.setLayout(null);
        pnlIsi.setSize(1000, 350);
        pnlIsi.setLocation(0,250);
        add(pnlIsi);
        
        Object[] judul = {"Jam","Senin","Selasa","Rabu","Kamis","Juamat","Sabtu"};
        Object[][] row = {
            {"07.00 - 08.00","PBO - Ria - R1","qwe","fsd","aa","bb","cc"},
            {"08.00 - 09.00","PBO","qwe","fsd","aa","bb","cc"},
            {"09.00 - 10.00","PBO","qwe","fsd","aa","bb","cc"},
            
        };
        
        tableRoster = new JTable(row, judul);
        scrol = new JScrollPane(tableRoster);
        scrol.setBounds(35, 35, 900, 200);
        pnlIsi.add(scrol);
        
        
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
    private JLabel lblJudul;
    
    private JPanel pnlIsi;
    private JTable tableRoster;
    private JScrollPane scrol;
}
