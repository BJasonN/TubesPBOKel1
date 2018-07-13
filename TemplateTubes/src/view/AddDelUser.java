package view;

import sistem.Mahasiswa;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
import dao.ConnectionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class AddDelUser extends JFrame {

    public AddDelUser() {
        initComponent();
    }

    private void initComponent() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(Color.blue);
        setTitle("Add/Delete User");

        getContentPane().setLayout(null);

        pnlUtama = new JPanel();
        pnlUtama.setSize(1000, 250);
        add(pnlUtama);

        lblJudul = new JLabel();
        lblJudul.setIcon(new ImageIcon(resizeImage("capture.png")));
        pnlUtama.add(lblJudul);
        //-------------------------------------

        pnlIsi = new JPanel();
        pnlIsi.setLayout(null);
        pnlIsi.setSize(1000, 350);
        pnlIsi.setLocation(0, 250);
        add(pnlIsi);

        lblAddUser = new JLabel("Add User");
        lblAddUser.setLocation(450, -30);
        lblAddUser.setSize(200, 100);
        pnlIsi.add(lblAddUser);

        lblNama = new JLabel("Name : ");
        lblNama.setLocation(350, 0);
        lblNama.setSize(100, 100);
        pnlIsi.add(lblNama);
        txtNama = new JTextField(20);
        txtNama.setLocation(400, 35);
        txtNama.setSize(170, 20);
        pnlIsi.add(txtNama);

        lblId = new JLabel("Id : ");
        lblId.setLocation(350, 30);
        lblId.setSize(100, 100);
        pnlIsi.add(lblId);
        txtId = new JTextField(20);
        txtId.setLocation(400, 70);
        txtId.setSize(170, 20);
        pnlIsi.add(txtId);

        Object[] arrPilihan = {"Mahasiswa", "Dosen", "Admin"};
        cbbPilihan = new JComboBox(arrPilihan);
        cbbPilihan.setSize(170, 20);
        cbbPilihan.setLocation(400, 100);
        pnlIsi.add(cbbPilihan);

        btnSubmitAdd = new JButton("Submit");
        btnSubmitAdd.setSize(170, 20);
        btnSubmitAdd.setLocation(400, 130);
        btnSubmitAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = ConnectionManager.getConnection();
                String nama = txtNama.getText();
                String id = txtId.getText();
                String password = nama + id;

                Object pilihan = cbbPilihan.getSelectedItem();
                if (pilihan.equals("Mahasiswa")) {
                    try {
                        Statement st = con.createStatement();
                        String sql = "insert into mahasiswalogin(nama,nim,password)"
                                + "values('" + nama + "','" + id + "','" + password + "');";
                        st.execute(sql);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }else{
                    
                }

                JOptionPane.showMessageDialog(null, "Data Berhasil Diinput!");
            }
        });
        pnlIsi.add(btnSubmitAdd);

        rbtnFemale = new JRadioButton("Female");
        rbtnFemale.setLocation(600, 35);
        rbtnFemale.setSize(170, 20);
        pnlIsi.add(rbtnFemale);
        rbtnMale = new JRadioButton("Male");
        rbtnMale.setLocation(600, 65);
        rbtnMale.setSize(170, 20);
        pnlIsi.add(rbtnMale);

        gender = new ButtonGroup();
        gender.add(rbtnMale);
        gender.add(rbtnFemale);

        //---------------------------------------
        lblDellUser = new JLabel("Dellete User");
        lblDellUser.setSize(200, 100);
        lblDellUser.setLocation(445, 140);
        pnlIsi.add(lblDellUser);

        cbbPilihan = new JComboBox(arrPilihan);
        cbbPilihan.setSize(170, 20);
        cbbPilihan.setLocation(400, 210);
        pnlIsi.add(cbbPilihan);

        Object[] arrNama = {"nama1", "nama2"};
        cbbNama = new JComboBox(arrNama);
        cbbNama.setSize(170, 20);
        cbbNama.setLocation(400, 240);
        pnlIsi.add(cbbNama);

        btnSubmitDell = new JButton("Delete");
        btnSubmitDell.setSize(170, 20);
        btnSubmitDell.setLocation(400, 270);
        btnSubmitDell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
            }
        });
        pnlIsi.add(btnSubmitDell);

        back = new JButton("Back");
        back.setBounds(800, 280, 170, 20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Admin().setVisible(true);
            }
        });
        pnlIsi.add(back);
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

    private JPanel pnlUtama;
    private JLabel lblJudul;

    private JPanel pnlIsi;
    private JLabel lblAddUser;
    private JLabel lblNama;
    private JLabel blbTahun;
    private JLabel lblId;
    private JTextField txtNama;
    private JTextField txtTahun;
    private JTextField txtId;
    private JButton btnSubmitAdd;
    private JRadioButton rbtnFemale;
    private JRadioButton rbtnMale;
    private ButtonGroup gender;

    private JLabel lblDellUser;
    private JComboBox cbbPilihan;
    private JComboBox cbbNama;
    private JButton btnSubmitDell;

    private JButton back;
}
