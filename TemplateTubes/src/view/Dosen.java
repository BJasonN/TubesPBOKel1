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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
public class Dosen extends JFrame{
    public Dosen(){
        initComponents();
    }
    
    public void initComponents(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        this.setTitle("Dosen");
        
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
        
        lblDosen = new JLabel("Dosen");
        lblDosen.setBounds(480, 40, 400, 50);
        pnlIsi.add(lblDosen);
        
        btnKehadiran = new JButton("Kehadiran");
        btnKehadiran.setBounds(150, 100, 300, 25);
        btnKehadiran.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Kehadiran().setVisible(true);
            }
        });
        pnlIsi.add(btnKehadiran);
        
        btnInputNilai = new JButton("Input Nilai");
        btnInputNilai.setBounds(150, 150, 300, 25);
        btnInputNilai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputNilai().setVisible(true);
            }
        });
        pnlIsi.add(btnInputNilai);
        
        btnInputPrsn = new JButton("Set Persentase");
        btnInputPrsn.setBounds(150, 200, 300, 25);
        btnInputPrsn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SetPersentase().setVisible(true);
            }
        } );
        pnlIsi.add(btnInputPrsn);
        
        btnRoster = new JButton("Roster");
        btnRoster.setBounds(550, 100, 300, 25);
        btnRoster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LiatRoster().setVisible(true);
            }
        } );
        pnlIsi.add(btnRoster);
        
        btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(550, 150, 300, 25);
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION);
                if(r == JOptionPane.YES_OPTION){
                    dispose();
                    new Login().setVisible(true);
                }
            }
        });
        pnlIsi.add(btnLogOut);
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
    private JLabel lblDosen;
    private JButton btnKehadiran;
    private JButton btnInputNilai;
    private JButton btnLogOut;
    private JButton btnInputPrsn;
    private JButton btnRoster;
}
