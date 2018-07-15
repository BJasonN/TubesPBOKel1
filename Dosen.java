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
        btnKehadiran.setBounds(300, 100, 400, 50);
        btnKehadiran.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Kehadiran().setVisible(true);//nanti ganti jadi kehadiran
            }
        });
        pnlIsi.add(btnKehadiran);
        
        btnInputNilai = new JButton("Input Nilai");
        btnInputNilai.setBounds(300, 150, 400, 50);
        btnInputNilai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Kehadiran().setVisible(true);//nanti ganti jadi input nilai
            }
        });
        pnlIsi.add(btnInputNilai);
        
        btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(300, 200, 400, 50);
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION);
                if(r == JOptionPane.YES_OPTION){
                    dispose();
                    new Admin().setVisible(true); //nanti ganti jadi login
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
        new Dosen().setVisible(true);
    }
    
    private JPanel pnlUtama;
    private JPanel pnlIsi;
    private JLabel lblJudul;
    private JLabel lblDosen;
    private JButton btnKehadiran;
    private JButton btnInputNilai;
    private JButton btnLogOut;
}
