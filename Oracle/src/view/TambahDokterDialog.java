/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model_RS.Dokter;
import model_RS.RumahSakit;
import sun.security.rsa.RSACore;

/**
 *
 * @author user only
 */
public class TambahDokterDialog extends JDialog {

    private RumahSakit rumahSakit;
    private JLabel tambahDokterLabel;
    private JLabel idDokterLabel;
    private JTextField idDokterText;
    private JLabel namaDokterLabel;
    private JTextField namaDokterText;
    private JButton tambahButton;
    private MyDokterDialog owner;

    public TambahDokterDialog(MyDokterDialog owner, RumahSakit rs) {
        super(owner);
        this.owner = owner;
        rumahSakit = rs;
        init();
    }

    /**
     * Fungsi untuk inisialisasi
     */
    public void init() {
        // set size
        setSize(400, 300);
        // set layout
        setLayout(null);
        tambahDokterLabel = new JLabel("Tambah Dokter");
        tambahDokterLabel.setBounds(85, 25, 200, 20);
        this.add(tambahDokterLabel);

        idDokterLabel = new JLabel("ID Dokter");
        idDokterLabel.setBounds(30, 100, 150, 25);
        this.add(idDokterLabel);

        idDokterText = new JTextField();
        idDokterText.setBounds(125, 100, 150, 25);
        this.add(idDokterText);

        namaDokterLabel = new JLabel("Nama Dokter");
        namaDokterLabel.setBounds(30, 150, 150, 25);
        this.add(namaDokterLabel);

        namaDokterText = new JTextField();
        namaDokterText.setBounds(125, 150, 150, 25);
        this.add(namaDokterText);

        // tambah Tombol Tambah
        tambahButton = new JButton("Tambah");
        tambahButton.setBounds(50, 200, 100, 30);
        add(tambahButton);
        // set action listener button
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahDokter();
            }
        });
    }

    public void tambahDokter() {
        Dokter dokter = new Dokter();
        dokter.setIdDokter(idDokterText.getText());
        dokter.setNama(namaDokterText.getText());

        rumahSakit.tambahDokter(dokter);
        rumahSakit.simpanDataDokter();
        owner.refreshTabelDokter();
        dispose();
    }
}
