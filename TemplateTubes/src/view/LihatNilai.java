package view;

import dao.DataAkses;
import sistem.MainSistem;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        
        lblSem = new JLabel("Semester : ");
        lblSem.setBounds(100, 100, 100, 25);
        pnlIsi.add(lblSem);
        
        Object[] sem = {"1", "2", "3", "4", "5", "6", "7", "8"};
        cbbSem = new JComboBox(sem);
        cbbSem.setBounds(170, 100, 100, 25);
        pnlIsi.add(cbbSem);
        
//        Object[] thnSem = {"2014", "2015", "2016", "2017", "2018"};
//        cbbThnSem = new JComboBox(thnSem);
//        cbbThnSem.setBounds(150, 125, 100, 25);
//        pnlIsi.add(cbbThnSem);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(150, 175, 100, 50);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] ArrData ={};
                List<String> ListData = new ArrayList();
                //ambil tahun dan semester dari combo box
//                String tahun = (String) cbbThnSem.getSelectedItem();
                String smt = (String) cbbSem.getSelectedItem();
                
                //ambil id mahasiswa yang sedang login
                String idAktif = MainSistem.nama;
                String ntable = idAktif+smt;
                //isi tabel didapatkan dari akses database
                ListData = DataAkses.getNilaiMhs(ntable);
//                ArrData = ListData.toArray(new String[ListData.size()]);//gimana caranya ga error==>lu masukin array 1D ke 2D
                //bangun array berisi header dan isi tabel
                String[] header = {"Matkul", "Tugas","Kuis", "UTS", "UAS", "Index"};
                String[][] isiPerRow = new String[ListData.size()][6];
                for(int i = 0; i < ListData.size(); i++){
                    //dipecah
                    String[] arrSplit = ListData.get(i).split(",");
                    for(int j = 0; j < 6; j++){
                        
                        isiPerRow[i][j]=arrSplit[j];
                    }
                }
                //add nilai ke tabel
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
    public static void main(String[] args) {
        new LihatNilai().setVisible(true);
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
    private JLabel lblSem;
}
