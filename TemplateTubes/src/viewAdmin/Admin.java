package viewAdmin;


import viewAdmin.AddDelUser;
import dao.ConnectionManager;
import java.awt.Dimension;
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
import view.Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jason
 */
public class Admin extends JFrame{
    public Admin(){
        initComponents();
    }
    
    public void initComponents(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        this.setTitle("Admin");
        
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
        
        lblAdmin = new JLabel("Admin");
        lblAdmin.setBounds(480, 40, 400, 50);
        pnlIsi.add(lblAdmin);
        
        btnAddDel = new JButton("Add/Delete");
        btnAddDel.setBounds(150, 100, 300, 25);
        btnAddDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddDelUser().setVisible(true);
            }
        });
        pnlIsi.add(btnAddDel);
        
        btnInputMatkulMhs = new JButton("Input Matkul Mahasiswa");
        btnInputMatkulMhs.setBounds(150, 150, 300, 25);
        btnInputMatkulMhs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputMatkulMhs().setVisible(true); 
            }
        });
        pnlIsi.add(btnInputMatkulMhs);
        
        btnInputMatkulDosen = new JButton("Input Matkul Dosen");
        btnInputMatkulDosen.setBounds(150, 200, 300, 25);
        btnInputMatkulDosen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputMatkulDosen().setVisible(true);
            }
        });
        pnlIsi.add(btnInputMatkulDosen);
        
        btnEditRoster = new JButton("Edit Roster");
        btnEditRoster.setBounds(550, 100, 300, 25);
        btnEditRoster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EditRoster().setVisible(true);
            }
        });
        pnlIsi.add(btnEditRoster);
        
        btnTambahMatkul = new JButton("Tambah Matkul");
        btnTambahMatkul.setBounds(550, 150, 300, 25);
        btnTambahMatkul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TambahMatkul().setVisible(true);
            }
        });
        pnlIsi.add(btnTambahMatkul);
        
        btnSaran = new JButton("Lihat Saran");
        btnSaran.setBounds(550, 200, 300, 25);
        btnSaran.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    dispose();
                    new LihatSaran().setVisible(true);
            }
        });
        pnlIsi.add(btnSaran);
        
        btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(550, 150, 300, 25);
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ConnectionManager.cutConnection()== true){
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
    
    public static void main(String[] args) {
        new Admin().setVisible(true);
    }
    private JPanel pnlUtama;
    private JPanel pnlIsi;
    private JLabel lblJudul;
    private JLabel lblAdmin;
    private JButton btnSaran;
    private JButton btnAddDel;
    private JButton btnInputMatkulMhs;
    private JButton btnLogOut;
    private JButton btnEditRoster;
    private JButton btnInputMatkulDosen;
    private JButton btnTambahMatkul;
}
