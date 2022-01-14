/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.assyifacake.views.Transaksi;

import com.assyifacake.controllers.Transaksi.BuatTransaksiController;
import com.assyifacake.views.DaftarPembeli.DaftarPembeliFrameView;
import com.assyifacake.views.Produk.DaftarProdukFrameView;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings;
import java.awt.Dimension;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;
import javax.swing.UIManager;

/**
 *
 * @author hp
 */
public class BuatTransaksiInternalView extends javax.swing.JInternalFrame {

    private int idPembeli;
    private String namaPembeli;
    private String nomorPembeli;
    private String alamatPembeli;
    
    private int idProduk;
    private String namaProduk;
    private int hargaProduk;
    private int labaProduk;
    
    DatePicker datePicker;

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public String getNomorPembeli() {
        return nomorPembeli;
    }

    public void setNomorPembeli(String nomorPembeli) {
        this.nomorPembeli = nomorPembeli;
    }

    public String getAlamatPembeli() {
        return alamatPembeli;
    }

    public void setAlamatPembeli(String alamatPembeli) {
        this.alamatPembeli = alamatPembeli;
    }
    
    public JTextArea getPembeliField() {
        return pembeliField;
        
    }
    
    public JTextArea getProdukField() {
        return produkField;
    }

    public int getIdPembeli() {
        return idPembeli;
    }

    public void setIdPembeli(int idPembeli) {
        this.idPembeli = idPembeli;
    }

    public int getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public int getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(int hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public int getLabaProduk() {
        return labaProduk;
    }

    public void setLabaProduk(int labaProduk) {
        this.labaProduk = labaProduk;
    }

    public JSpinner getKuantitasProduk() {
        return kuantitasProduk;
    }

    public JTable getTabel() {
        return tabel;
    }

    public JTextField getTotalLabaTF() {
        return totalLabaTF;
    }

    public JTextField getTotalBayarTF() {
        return totalBayarTF;
    }

    public JTextField getUangBayarTF() {
        return uangBayarTF;
    }

    public JButton getPilihPelangganBT() {
        return pilihPelangganBT;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }
    
    
    private BuatTransaksiController controller;
    

    public BuatTransaksiInternalView() {
        initComponents();
        styling();
        myElements();
        controller = new BuatTransaksiController(this);
        controller.myComponents();
        
    }
    
    private void myElements() {
                // panel tenggat
        DatePickerSettings datePickerSettings = new DatePickerSettings();
        datePickerSettings.setFormatForDatesBeforeCommonEra("dd-MM-yyyy");
        datePickerSettings.setFormatForDatesCommonEra("dd-MM-yyyy");
        TimePickerSettings timePickerSettings = new TimePickerSettings();
        timePickerSettings.use24HourClockFormat();
        datePicker = new DatePicker(datePickerSettings);
        datePickerSettings.setDateRangeLimits(LocalDate.now(), LocalDate.now().plusDays(365));
        tenggat.repaint();
        tenggat.setPreferredSize(new Dimension(135,30));
        tenggat.add(datePicker);
        datePicker.setSize(135,30);
        datePicker.setDateToToday();
        datePicker.setVisible(true);
//        jScrollPane1.set
//        tabel.setPreferredSize(new Dimension(350,313));

    }
    
    private void styling() {
//                try {
//            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Metal".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            // If Nimbus is not available, you can set the GUI to another look and feel.
//        }        
        // biar line wraping
        pembeliField.setLineWrap(true);
        pembeliField.setWrapStyleWord(true);
        produkField.setLineWrap(true);
        produkField.setWrapStyleWord(true);
        jScrollPane3.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
        

        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pilihPelangganBT = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        pembeliField = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        produkField = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        kuantitasProduk = new javax.swing.JSpinner();
        jButton12 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        uangBayarTF = new javax.swing.JTextField();
        totalBayarTF = new javax.swing.JTextField();
        tenggat = new javax.swing.JPanel();
        totalLabaTF = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 0, 204));
        setPreferredSize(new java.awt.Dimension(772, 484));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(772, 482));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tabel.setRowHeight(50);
        jScrollPane1.setViewportView(tabel);

        jButton5.setBackground(new java.awt.Color(113, 191, 109));
        jButton5.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jButton5.setText("PROSES");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(88, 88, 88));
        jButton8.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("BATAL");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel4.setText("Buat Transaksi");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pelanggan"));

        pilihPelangganBT.setBackground(new java.awt.Color(204, 204, 204));
        pilihPelangganBT.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        pilihPelangganBT.setText("Pilih Pelanggan");
        pilihPelangganBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pilihPelangganBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihPelangganBTActionPerformed(evt);
            }
        });

        pembeliField.setColumns(20);
        pembeliField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        pembeliField.setRows(5);
        pembeliField.setEnabled(false);
        jScrollPane2.setViewportView(pembeliField);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pilihPelangganBT)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilihPelangganBT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Produk"));

        jButton11.setBackground(new java.awt.Color(204, 204, 204));
        jButton11.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jButton11.setText("Pilih Produk");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        produkField.setColumns(20);
        produkField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        produkField.setRows(5);
        produkField.setEnabled(false);
        jScrollPane3.setViewportView(produkField);

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kuantitas");

        kuantitasProduk.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9999, 1));
        kuantitasProduk.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        kuantitasProduk.setRequestFocusEnabled(false);

        jButton12.setBackground(new java.awt.Color(204, 204, 204));
        jButton12.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jButton12.setText("Tambah Produk");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton11)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(kuantitasProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton12)))
                .addGap(15, 15, 15))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kuantitasProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Total              :");

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Uang Bayar  :");

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tenggat    :");

        jLabel11.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Total Laba :");

        uangBayarTF.setText("0");

        totalBayarTF.setText("0");
        totalBayarTF.setEnabled(false);

        tenggat.setBackground(new java.awt.Color(51, 51, 51));
        tenggat.setForeground(new java.awt.Color(255, 255, 255));
        tenggat.setPreferredSize(new java.awt.Dimension(110, 30));

        javax.swing.GroupLayout tenggatLayout = new javax.swing.GroupLayout(tenggat);
        tenggat.setLayout(tenggatLayout);
        tenggatLayout.setHorizontalGroup(
            tenggatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        tenggatLayout.setVerticalGroup(
            tenggatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        totalLabaTF.setText("0");
        totalLabaTF.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(uangBayarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tenggat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(totalBayarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalLabaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(totalBayarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalLabaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tenggat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(uangBayarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        controller.tambahKeTabel();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        new DaftarProdukFrameView(this).setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void pilihPelangganBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihPelangganBTActionPerformed
        new DaftarPembeliFrameView(this).setVisible(true);
    }//GEN-LAST:event_pilihPelangganBTActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        controller.batal();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        controller.simpan();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner kuantitasProduk;
    private javax.swing.JTextArea pembeliField;
    private javax.swing.JButton pilihPelangganBT;
    private javax.swing.JTextArea produkField;
    private javax.swing.JTable tabel;
    private javax.swing.JPanel tenggat;
    private javax.swing.JTextField totalBayarTF;
    private javax.swing.JTextField totalLabaTF;
    private javax.swing.JTextField uangBayarTF;
    // End of variables declaration//GEN-END:variables

   
}
