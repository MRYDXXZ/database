/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gui.logindanregist;

import com.mysql.cj.Query;
import connect.connect_database;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class utama extends menu {

    /**
     * Creates new form utama
     */
    private String SQL;
    DefaultTableModel model;
    int index, confirm;
    String noresi,
            namapengirim,
            namapenerima,
            nopengirim,
            nopenerima,
            alamatpengirim,
            alamatpenerima,
            jenislayanan,
            statuspengiriman,
            detailpaket,
            query;

    public utama() {
        initComponents();
        Color bg = new Color(128, 128, 128);
        getContentPane().setBackground(bg);

        Object kolom[] = {"no.resi", "nama pengirim", "no.pengirim", "alamat pengirim", "nama penerima", "no.penerima", "alamat penerima", "jenis layanan", "status", "detail"};
        Object data[][] = {};

        model = new DefaultTableModel(data, kolom);
        jTablehasil.setModel(model);

//        menampilkan data ke database
       jTablehasil.getSelectionModel().addListSelectionListener(e -> {  
    if (!e.getValueIsAdjusting()) {  
        int selectedRow = jTablehasil.getSelectedRow();  
        if (selectedRow != -1) {  
            txtnoresi.setText(model.getValueAt(selectedRow, 0).toString());  
            txtnamapengirim.setText(model.getValueAt(selectedRow, 1).toString());  
            txtnopengirim.setText(model.getValueAt(selectedRow, 2).toString());  
            jTextAreaalamatpengirim.setText(model.getValueAt(selectedRow, 3).toString());  
            txtnamapenerima.setText(model.getValueAt(selectedRow, 4).toString());  
            txtnopenerima.setText(model.getValueAt(selectedRow, 5).toString());  
            jTextAreaalamatpenerima.setText(model.getValueAt(selectedRow, 6).toString());  
            jcbstatuspengiriman.setSelectedItem(model.getValueAt(selectedRow, 7).toString()); // Indeks 7 untuk status  
            jTextAreadetailpaket.setText(model.getValueAt(selectedRow, 8).toString()); // Indeks 8 untuk detail  
  
            // Mengambil jenis layanan dari kolom yang benar  
            String jenislayanan = model.getValueAt(selectedRow, 9).toString(); // Indeks 9 untuk jenis layanan  
            if (jenislayanan.equals("Reguler")) {  
                jRadioButtonreguler.setSelected(true);  
            } else if (jenislayanan.equals("Express")) {  
                jRadioButtonexpress.setSelected(true);  
            }  
        }  
    }  
});  


//        mengambil data dari database
        Connection conn = connect_database.getConnection();

        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Koneksi database gagal!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            SQL = "SELECT * FROM data_table";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet res = stmt.executeQuery(SQL);

            if (!res.isBeforeFirst()) { // Jika result set kosong
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                while (res.next()) {
                    model.addRow(new Object[]{
                        res.getString("no_resi"),
                        res.getString("nama_pengirim"),
                        res.getString("no_pengirim"),
                        res.getString("alamat_pengirim"),
                        res.getString("nama_penerima"),
                        res.getString("no_penerima"),
                        res.getString("alamat_penerima"),
                        res.getString("jenis_layanan"),
                        res.getString("status_pengiriman"),
                        res.getString("detail_paket"),});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

//       JOptionPane.showMessageDialog(this, "selamat datang di Aplikasi PAKETMU", "informasi !", JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(this, "Silahkan isi tabel", "informasi !", JOptionPane.INFORMATION_MESSAGE);
    }

    //    public void TampilData() {
//        model = new DefaultTableModel();
//        model.addColumn("no Resi");
//        model.addColumn("nama Pengirim");
//        model.addColumn("no Pengirim");
//        model.addColumn("alamat Pengirim");
//        model.addColumn("nama Penerima");
//        model.addColumn("no Penerima");
//        model.addColumn("alamat Penerima"); // Perbaikan nama kolom
//        model.addColumn("jenis layanan");
//        model.addColumn("status pengiriman");
//        model.addColumn("detail paket");
//
//        jTableHasil.setModel(model);
//        Connection conn = connect_database.getConnection();
//
//        if (conn == null) {
//            JOptionPane.showMessageDialog(this, "Koneksi database gagal!", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        try {
//            String SQL = "SELECT * FROM data_table";
//            java.sql.Statement stmt = conn.createStatement();
//            java.sql.ResultSet res = stmt.executeQuery(SQL);
//
//            if (!res.isBeforeFirst()) { // Jika result set kosong
//                JOptionPane.showMessageDialog(this, "Data tidak ditemukan!", "Info", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                while (res.next()) {
//                    model.addRow(new Object[]{
//                        res.getString("no_resi"),
//                        res.getString("nama_pengirim"),
//                        res.getString("no_pengirim"),
//                        res.getString("alamat_pengirim"),
//                        res.getString("nama_penerima"),
//                        res.getString("no_penerima"),
//                        res.getString("alamat_penerima"), // Perbaikan nama kolom
//                        res.getString("jenis_layanan"),
//                        res.getString("status_pengiriman"),
//                        res.getString("detail_paket"),});
//                }
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupjenislayanan = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnamapengirim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnamapenerima = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnopengirim = new javax.swing.JTextField();
        txtnopenerima = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaalamatpengirim = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaalamatpenerima = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtnoresi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreadetailpaket = new javax.swing.JTextArea();
        jcbstatuspengiriman = new javax.swing.JComboBox<>();
        jRadioButtonreguler = new javax.swing.JRadioButton();
        jRadioButtonexpress = new javax.swing.JRadioButton();
        btnsimpan = new javax.swing.JButton();
        btnhapusinput = new javax.swing.JButton();
        btnhapusisi = new javax.swing.JButton();
        btnhapusbaris = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablehasil = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel1.setText("APLIKASI PAKETKU");

        jLabel2.setText("NAMA PENGIRIM");

        txtnamapengirim.setBackground(new java.awt.Color(204, 0, 0));
        txtnamapengirim.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("NAMA PENERIMA");

        txtnamapenerima.setBackground(new java.awt.Color(204, 0, 0));
        txtnamapenerima.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("NO.PENGIRIM");

        jLabel5.setText("NO.PENERIMA");

        txtnopengirim.setBackground(new java.awt.Color(204, 0, 0));
        txtnopengirim.setForeground(new java.awt.Color(255, 255, 255));

        txtnopenerima.setBackground(new java.awt.Color(204, 0, 0));
        txtnopenerima.setForeground(new java.awt.Color(255, 255, 255));
        txtnopenerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnopenerimaActionPerformed(evt);
            }
        });

        jLabel6.setText("ALAMAT PENGIRIM");

        jLabel7.setText("ALAMAT PENERIMA");

        jTextAreaalamatpengirim.setBackground(new java.awt.Color(204, 0, 0));
        jTextAreaalamatpengirim.setColumns(20);
        jTextAreaalamatpengirim.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaalamatpengirim.setRows(5);
        jScrollPane1.setViewportView(jTextAreaalamatpengirim);

        jTextAreaalamatpenerima.setBackground(new java.awt.Color(204, 0, 0));
        jTextAreaalamatpenerima.setColumns(20);
        jTextAreaalamatpenerima.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaalamatpenerima.setRows(5);
        jScrollPane2.setViewportView(jTextAreaalamatpenerima);

        jLabel8.setText("NO.RESI");

        txtnoresi.setBackground(new java.awt.Color(204, 0, 0));
        txtnoresi.setForeground(new java.awt.Color(255, 255, 255));
        txtnoresi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoresiActionPerformed(evt);
            }
        });

        jLabel9.setText("JENIS LAYANAN");

        jLabel10.setText("STATUS PENGIRIMAN");

        jLabel11.setText("DETAIL PAKET");

        jTextAreadetailpaket.setBackground(new java.awt.Color(204, 0, 0));
        jTextAreadetailpaket.setColumns(20);
        jTextAreadetailpaket.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreadetailpaket.setRows(5);
        jScrollPane3.setViewportView(jTextAreadetailpaket);

        jcbstatuspengiriman.setBackground(new java.awt.Color(204, 0, 0));
        jcbstatuspengiriman.setForeground(new java.awt.Color(255, 255, 255));
        jcbstatuspengiriman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PESANAN DIBUAT", "PAKET DIJEMPUT EKSPEDISI", "DALAM PERJALANAN", "SEDANG DIKIRIM", "PAKET DITERIMA", "TERTUNDA", "RETURN", " " }));

        jRadioButtonreguler.setBackground(new java.awt.Color(204, 0, 0));
        groupjenislayanan.add(jRadioButtonreguler);
        jRadioButtonreguler.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonreguler.setText("REGULER");

        jRadioButtonexpress.setBackground(new java.awt.Color(204, 0, 0));
        groupjenislayanan.add(jRadioButtonexpress);
        jRadioButtonexpress.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonexpress.setText("EXPRESS");

        btnsimpan.setBackground(new java.awt.Color(102, 0, 0));
        btnsimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnsimpan.setText("SIMPAN");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnhapusinput.setBackground(new java.awt.Color(102, 0, 0));
        btnhapusinput.setForeground(new java.awt.Color(255, 255, 255));
        btnhapusinput.setText("HAPUS INPUT");
        btnhapusinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusinputActionPerformed(evt);
            }
        });

        btnhapusisi.setBackground(new java.awt.Color(102, 0, 0));
        btnhapusisi.setForeground(new java.awt.Color(255, 255, 255));
        btnhapusisi.setText("HAPUS ISI");
        btnhapusisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusisiActionPerformed(evt);
            }
        });

        btnhapusbaris.setBackground(new java.awt.Color(102, 0, 0));
        btnhapusbaris.setForeground(new java.awt.Color(255, 255, 255));
        btnhapusbaris.setText("HAPUS BARIS");
        btnhapusbaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusbarisActionPerformed(evt);
            }
        });

        jTablehasil.setBackground(new java.awt.Color(204, 0, 0));
        jTablehasil.setForeground(new java.awt.Color(255, 255, 255));
        jTablehasil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "no.resi", "nama pengirim", "no.pengirim", "alamat pengirim", "nama penerima", "no.penerima", "alamat penerima", "jenis layanan", "status", "detail"
            }
        ));
        jScrollPane4.setViewportView(jTablehasil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnoresi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtnopengirim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnamapengirim, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(138, 138, 138)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(149, 149, 149)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtnopenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(166, 166, 166)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41)
                                                .addComponent(jcbstatuspengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jRadioButtonexpress, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtnamapenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(78, 78, 78)
                                                    .addComponent(jRadioButtonreguler, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnsimpan)
                                .addGap(133, 133, 133)
                                .addComponent(btnhapusinput)
                                .addGap(179, 179, 179)
                                .addComponent(btnhapusisi)
                                .addGap(162, 162, 162)
                                .addComponent(btnhapusbaris)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnoresi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnamapengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnamapenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonreguler)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jRadioButtonexpress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnopengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnopenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnsimpan)
                                    .addComponent(btnhapusinput)
                                    .addComponent(btnhapusisi)
                                    .addComponent(btnhapusbaris))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(207, 207, 207))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcbstatuspengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnoresiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoresiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnoresiActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:

//      data pelanggan
        try {
            // Koneksi ke database
            Connection conn = connect_database.getConnection();
            System.out.println("Koneksi berhasil!");

            // Query untuk memasukkan data
            query = "INSERT INTO data_table(no_resi, nama_pengirim, no_pengirim, alamat_pengirim, nama_penerima, no_penerima, alamat_penerima, jenis_layanan, status_pengiriman, detail_paket) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            // Mengisi parameter query
            stmt.setString(1, txtnoresi.getText().trim());    
stmt.setString(2, txtnamapengirim.getText().trim());    
stmt.setString(3, txtnopengirim.getText().trim());    
stmt.setString(4, jTextAreaalamatpengirim.getText().trim());    
stmt.setString(5, txtnamapenerima.getText().trim());    
stmt.setString(6, txtnopenerima.getText().trim());    
stmt.setString(7, jTextAreaalamatpenerima.getText().trim());    
stmt.setString(8, jcbstatuspengiriman.getSelectedItem().toString());    
stmt.setString(9, jTextAreadetailpaket.getText().trim());    
  
// Mode pengiriman  
String jenislayanan = jRadioButtonreguler.isSelected() ? "Reguler" : "Express";  
stmt.setString(10, jenislayanan);
  

            // Menjalankan query
            stmt.executeUpdate();
            System.out.println("Query berhasil dijalankan.");

            // Menampilkan pesan sukses
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan.", "Database", JOptionPane.INFORMATION_MESSAGE);

            // Menambahkan data ke tabel
            DefaultTableModel model = (DefaultTableModel) jTablehasil.getModel();
            model.addRow(new Object[]{
                txtnoresi.getText().trim(),
                txtnamapengirim.getText().trim(),
                txtnopengirim.getText().trim(),
                jTextAreaalamatpengirim.getText().trim(),
                txtnamapenerima.getText().trim(),
                txtnopenerima.getText().trim(),
                jTextAreaalamatpenerima.getText().trim(),
                jcbstatuspengiriman.getSelectedItem().toString(),
                jTextAreadetailpaket.getText().trim(),
                
            });
        } catch (SQLException e) {
            // Menampilkan error jika ada
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnhapusinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusinputActionPerformed
        // TODO add your handling code here:
        
        
        confirm = JOptionPane.showConfirmDialog(this, "anda yakin untuk hapus input ?",
                "konfirmasi !", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {;
            txtnoresi.setText("");
            txtnamapengirim.setText("");
            txtnamapenerima.setText("");
            txtnopengirim.setText("");
            txtnopenerima.setText("");
            txtnamapenerima.setText("");
            jTextAreaalamatpengirim.setText("");
            jTextAreaalamatpenerima.setText("");
            jcbstatuspengiriman.setSelectedItem("None");
            jTextAreadetailpaket.setText("");
            groupjenislayanan.clearSelection();
            JOptionPane.showMessageDialog(this, "input berhasil dihapus !", "informasi !", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_btnhapusinputActionPerformed

    private void btnhapusbarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusbarisActionPerformed
        // TODO add your handling code here:
        Connection conn = connect_database.getConnection();

        int confirm = JOptionPane.showConfirmDialog(this, "Apakah yakin menghapus baris?",
                "Konfirmasi!", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Query penghapusan dengan PreparedStatement
                String sql = "DELETE FROM data_table WHERE no_resi = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);

                // Mengisi parameter query
                stmt.setString(1, txtnoresi.getText().trim());

                // Menjalankan query
                int rowsDeleted = stmt.executeUpdate();

                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus.", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                    // Menghapus data dari tabel
                    DefaultTableModel model = (DefaultTableModel) jTablehasil.getModel();
                    int selectedRow = jTablehasil.getSelectedRow();
                    if (selectedRow != -1) {
                        model.removeRow(selectedRow);
                    }

                    // Reset input form
                    txtnoresi.requestFocus();
                    txtnoresi.setText("");
                    txtnamapengirim.setText("");
                    txtnopengirim.setText("");
                    jTextAreaalamatpengirim.setText("");
                    txtnamapenerima.setText("");
                    txtnopenerima.setText("");
                    jTextAreaalamatpenerima.setText("");
                    groupjenislayanan.clearSelection();
                    jcbstatuspengiriman.setSelectedIndex(0);
                    jTextAreadetailpaket.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Data tidak ditemukan.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Log error
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnhapusbarisActionPerformed

    private void btnhapusisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusisiActionPerformed
        // TODO add your handling code here:        Connection conn = connect_database.getConnection();
        
        confirm = JOptionPane.showConfirmDialog(this, "apakah yakin menghapus semua data ?",
                "konfirmasi !", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
           model.setRowCount(0); //menghapus semua isi dari tabel
            JOptionPane.showMessageDialog(this, "semua data berhasil dihapus !", "informasi !", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnhapusisiActionPerformed

    private void txtnopenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnopenerimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnopenerimaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapusbaris;
    private javax.swing.JButton btnhapusinput;
    private javax.swing.JButton btnhapusisi;
    private javax.swing.JButton btnsimpan;
    private javax.swing.ButtonGroup groupjenislayanan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButtonexpress;
    private javax.swing.JRadioButton jRadioButtonreguler;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTablehasil;
    private javax.swing.JTextArea jTextAreaalamatpenerima;
    private javax.swing.JTextArea jTextAreaalamatpengirim;
    private javax.swing.JTextArea jTextAreadetailpaket;
    private javax.swing.JComboBox<String> jcbstatuspengiriman;
    private javax.swing.JTextField txtnamapenerima;
    private javax.swing.JTextField txtnamapengirim;
    private javax.swing.JTextField txtnopenerima;
    private javax.swing.JTextField txtnopengirim;
    private javax.swing.JTextField txtnoresi;
    // End of variables declaration//GEN-END:variables
}
