package viewAll;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kevin
 */
import dao.DataAksesAll;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.*;
import sistem.Roster;

public class LiatRoster extends JFrame {

    public LiatRoster() {
        initComponent();
    }

    private void initComponent() {
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
        pnlIsi.setLocation(0, 250);
        add(pnlIsi);
        
        Object[] arrMinggu = {"tgl: 1 - 5", "tgl: 8 - 12", "tgl: 15 - 19", "tgl: 22 - 26"};
        cbbMinggu = new JComboBox(arrMinggu);
        cbbMinggu.setBounds(500, 10, 100, 20);
        pnlIsi.add(cbbMinggu);
        
        btnCari = new JButton("Cari");
        btnCari.setBounds(600,10,100,20);
        btnCari.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //table roster
                String minggu = String.valueOf(cbbMinggu.getSelectedItem());
                //hasi dari database ditampung llRoster
                LinkedList<Roster> llRoster = DataAksesAll.viewRoster(minggu);
                //
                Object[] judul = {"Jam","Senin","Selasa","Rabu","Kamis","Juamat","Sabtu"};
                Object[][] row = new Object[11][7];
                for(int i = 0; i < 11; i++){
                    //mengatur jam pada row 1
                    row[i][0] = String.valueOf(7+i)+".00 - "+String.valueOf(8+i)+".00";
                    for(int j = 1; j < 7; j++){
                        for(int k = 0; k < llRoster.size(); k++){
                            //mengabil dari linked list
                            if( llRoster.get(k).getJam().equals(row[i][0]) && hariKeAngka(llRoster.get(k).getHari()).equals("" + j)){
                                row[i][j] = llRoster.get(k).getDosen()+" - "+llRoster.get(k).getMatkul()+" - "+llRoster.get(k).getRuangan()+" - tgl: "+llRoster.get(k).getTgl();
                            }else{
                                row[i][j] = " ";
                            }
                        }
                    }
                }

                tableRoster = new JTable(row, judul);
                scrol = new JScrollPane(tableRoster);
                scrol.setBounds(35, 35, 900, 200);
                pnlIsi.add(scrol);
            }
        });
        pnlIsi.add(btnCari);

        
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
    
    private String hariKeAngka(String hari){
        String a = "";
        switch(hari){
            case "Senin":
                a = "1";
                break;
            case "Selasa":
                a = "2";
                break;
            case "Rabu":
                a = "3";
                break;
            case "Kamis":
                a = "4";
                break;
            case "Jumat":
                a = "5";
                break;
            case "Sabtu":
                a = "6";
                break;
        }
        return a;
    }
    
    
    
    private JPanel pnlUtama;
    private JLabel lblJudul;

    private JPanel pnlIsi;
    private JTable tableRoster;
    private JScrollPane scrol;
    private JComboBox cbbMinggu;
    private JButton btnCari;
}
