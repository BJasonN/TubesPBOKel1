package viewDosen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import viewDosen.Dosen;
import dao.DataAksesDosen;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
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
import sistem.MainSistem;

/**
 *
 * @author Sutanto
 */
public class SetPersentase extends JFrame {

    private String[] lmatkul;

    public SetPersentase() {
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(Color.blue);

        pnlUtama = new JPanel();
        pnlUtama.setBounds(0, 0, 1000, 250);
        add(pnlUtama);

        lblJudul = new JLabel();
        lblJudul.setIcon(new ImageIcon(resizeImage("Capture.png")));
        pnlUtama.add(lblJudul);

        pnl1 = new JPanel();
        pnl1.setBounds(0, 250, 1000, 350);
        add(pnl1);
        pnl1.setLayout(null);

        lblsetpersen = new JLabel("Set Persentase Nilai");
        pnl1.add(lblsetpersen);
        lblsetpersen.setBounds(390, 250, 250, 50);
        lblsetpersen.setFont(new Font("Arial", Font.BOLD, 18));

        lblsem = new JLabel("Semester : ");
        pnl1.add(lblsem);
        lblsem.setBounds(380, 300, 100, 30);
        lblsem.setFont(new Font("Arial", Font.PLAIN, 15));
        String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"};
        sem = new JComboBox(arr);
        sem.setBounds(480, 300, 100, 20);
        pnl1.add(sem);

        search = new JButton("Search");
        search.setBounds(430, 330, 100, 20);
        search.setFont(new Font("Arial", Font.PLAIN, 15));
        pnl1.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String smatkul = (String) sem.getSelectedItem();
                String ntable = MainSistem.nama + smatkul;
                LinkedList<String> ltable = DataAksesDosen.listTable();
                boolean cek = false;
                int i = 0;
                while (i < ltable.size() && cek == false) {
                    if (ltable.get(i).equals(ntable)) {
                        cek = true;
                    }
                    i++;
                }

                if (cek == false) {
                    JOptionPane.showMessageDialog(null, "Semester tersebut belum diinput matkul");
                } else {
                    lmatkul = DataAksesDosen.getNamaMatkulPerDosen(ntable);
                    lblmatkul = new JLabel("Mata Kuliah : ");
                    pnl1.add(lblmatkul);
                    lblmatkul.setBounds(380, 370, 100, 30);
                    lblmatkul.setFont(new Font("Arial", Font.PLAIN, 15));
                    matkul = new JComboBox(lmatkul);
                    matkul.setBounds(480, 370, 100, 20);
                    pnl1.add(matkul);
                }

            }
        });

        lblnilaitugas = new JLabel("Nilai Tugas : ");
        pnl1.add(lblnilaitugas);
        lblnilaitugas.setBounds(330, 410, 100, 30);
        lblnilaitugas.setFont(new Font("Arial", Font.PLAIN, 15));
        tugas = new JTextField();
        tugas.setBounds(430, 410, 30, 20);
        pnl1.add(tugas);
        lblpersen = new JLabel("%");
        lblpersen.setBounds(465, 410, 20, 20);
        pnl1.add(lblpersen);

        lblnilaikuis = new JLabel("Nilai Kuis : ");
        pnl1.add(lblnilaikuis);
        lblnilaikuis.setBounds(330, 450, 100, 30);
        lblnilaikuis.setFont(new Font("Arial", Font.PLAIN, 15));
        kuis = new JTextField();
        kuis.setBounds(430, 450, 30, 20);
        pnl1.add(kuis);
        lblpersen = new JLabel("%");
        lblpersen.setBounds(465, 450, 20, 20);
        pnl1.add(lblpersen);

        lblnilaiUts = new JLabel("Nilai UTS : ");
        pnl1.add(lblnilaiUts);
        lblnilaiUts.setBounds(500, 410, 100, 30);
        lblnilaiUts.setFont(new Font("Arial", Font.PLAIN, 15));
        uts = new JTextField();
        uts.setBounds(600, 410, 30, 20);
        pnl1.add(uts);
        lblpersen = new JLabel("%");
        lblpersen.setBounds(635, 410, 20, 20);
        pnl1.add(lblpersen);

        lblnilaiUas = new JLabel("Nilai UAS : ");
        pnl1.add(lblnilaiUas);
        lblnilaiUas.setBounds(500, 450, 100, 30);
        lblnilaiUas.setFont(new Font("Arial", Font.PLAIN, 15));
        uas = new JTextField();
        uas.setBounds(600, 450, 30, 20);
        pnl1.add(uas);
        lblpersen = new JLabel("%");
        lblpersen.setBounds(635, 450, 20, 20);
        pnl1.add(lblpersen);

        submit = new JButton("submit");
        submit.setBounds(360, 500, 100, 20);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String smatkul = (String) sem.getSelectedItem();
                String ptugas = tugas.getText();
                String pkuis = kuis.getText();
                String puts = uts.getText();
                String puas = uas.getText();
               
                float ptugas2=Float.parseFloat(ptugas);
                float pkuis2=Float.parseFloat(pkuis);
                float puts2=Float.parseFloat(puts);
                float puas2=Float.parseFloat(puas);
                float total=ptugas2+pkuis2+puts2+puas2;
                
                System.out.println(ptugas2);
                if(total==100.0){
                     String nmatkul =(String)matkul.getSelectedItem();
                    String ntable = MainSistem.nama + smatkul;
                    DataAksesDosen.addPersentase(ntable, nmatkul, ptugas, pkuis, puts, puas);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diinput!");
                }else{
                    JOptionPane.showMessageDialog(null, "Data lebih besar atau lebih kecil dari 100%");
                }
            }
        });
        pnl1.add(submit);

        back = new JButton("back");
        back.setBounds(500, 500, 100, 20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Dosen().setVisible(true);
            }
        });
        pnl1.add(back);

    }

    private Image resizeImage(String url) {
        Image dimg = null;
        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(1000, 250, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return dimg;
    }

    

    private JPanel pnl1;
    private JPanel pnlUtama;
    private JLabel lblpersen;
    private JLabel lblJudul;
    private JLabel lblsetpersen;
    private JLabel lblmatkul;
    private JLabel lblnilaikuis;
    private JLabel lblnilaitugas;
    private JLabel lblnilaiUts;
    private JLabel lblnilaiUas;
    private JLabel lblsem;
    private JButton search;
    private JButton submit;
    private JButton back;
    private JTextField kuis;
    private JTextField tugas;
    private JTextField uts;
    private JTextField uas;
    private JComboBox matkul;
    private JComboBox sem;
}
