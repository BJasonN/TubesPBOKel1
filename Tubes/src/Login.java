/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matthew
 */
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Login extends JFrame {

    public Login() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setLayout(new GridLayout(2, 1));
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLUE);

        pnl1 = new JPanel();
        pnl1.setSize(800, 200);
        pnl1.setBackground(Color.green);
        add(pnl1);
        pnl1.setLayout(null);

        plogin = new JLabel("Pilih Login");
        pnl1.add(plogin);
        plogin.setBounds(350, 5, 100, 50);

        mhs = new JButton("Mahasiswa");
        mhs.setBounds(200, 40, 100, 30);
        pnl1.add(mhs);

        dosen = new JButton("Dosen");
        dosen.setBounds(450, 40, 100, 30);
        pnl1.add(dosen);

        admin = new JButton("Admin");
        admin.setBounds(330, 130, 100, 30);
        pnl1.add(admin);

        pnl2 = new JPanel();
        pnl2.setSize(800, 200);
        pnl2.setBackground(Color.ORANGE);
        add(pnl2);
        pnl2.setLayout(null);

        login = new JLabel("Login");
        pnl2.add(login);
        login.setBounds(360, 0, 100, 50);

        lblnim = new JLabel("Nim : ");
        pnl2.add(lblnim);
        lblnim.setBounds(280, 50, 100, 20);
        nim = new JTextField();
        nim.setBounds(390, 50, 100, 20);
        pnl2.add(nim);

        lblmahasiswa = new JLabel("Mahasiswa : ");
        pnl2.add(lblmahasiswa);
        lblmahasiswa.setBounds(280, 80, 100, 20);
        mahasiswa = new JTextField();
        mahasiswa.setBounds(390, 80, 100, 20);
        pnl2.add(mahasiswa);

        submit = new JButton("Submit");
        submit.setBounds(330, 120, 100, 30);
        pnl2.add(submit);

        submit.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mahasiswa.getText().equals("abc")) {
                    dispose();
                    new AddDelUser().setVisible(true);
                }

            }
        }
        );

    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
    JPanel pnl1;
    JPanel pnl2;
    JLabel plogin;
    JLabel login;
    JLabel lblmahasiswa;
    JLabel lblnim;
    JButton mhs;
    JButton dosen;
    JButton admin;
    JButton submit;
    JTextField mahasiswa;
    JTextField nim;
}
