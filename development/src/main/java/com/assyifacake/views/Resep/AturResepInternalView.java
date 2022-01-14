/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.assyifacake.views.Resep;

import com.assyifacake.controllers.Resep.AturResepController;
import com.assyifacake.views.Produk.*;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author hp
 */
public class AturResepInternalView extends javax.swing.JInternalFrame {

    private AturResepController cA;
    
    private String idProduk = null;
    
    public AturResepInternalView() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
        cA = new AturResepController(this);
        cA.tampilTabel();
        cA.kontrolButtonAkses();
    }

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }
    
    public JTextArea getBahanTA() {
        return bahanTA;
    }

    public void setBahanTA(JTextArea bahanTA) {
        this.bahanTA = bahanTA;
    }

    public JTextArea getLangkahTA() {
        return langkahTA;
    }

    public void setLangkahTA(JTextArea langkahTA) {
        this.langkahTA = langkahTA;
    }

    public JTextField getNamaProdukTF() {
        return namaProdukTF;
    }

    public void setNamaProdukTF(JTextField namaProdukTF) {
        this.namaProdukTF = namaProdukTF;
    }

    public JButton getBatalBT() {
        return batalBT;
    }

    public JButton getHapusBT() {
        return hapusBT;
    }

    public JButton getPilihProdukBT() {
        return pilihProdukBT;
    }

    public JButton getSimpanBT() {
        return simpanBT;
    }

    public JTable getTabelResep() {
        return tabelResep;
    }

    public JButton getUbahBT() {
        return ubahBT;
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
        jLabel1 = new javax.swing.JLabel();
        namaProdukTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelResep = new javax.swing.JTable();
        simpanBT = new javax.swing.JButton();
        ubahBT = new javax.swing.JButton();
        hapusBT = new javax.swing.JButton();
        batalBT = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pilihProdukBT = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        langkahTA = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        bahanTA = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 0, 204));
        setPreferredSize(new java.awt.Dimension(772, 484));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(772, 482));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel1.setText("Nama Produk");

        namaProdukTF.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        namaProdukTF.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Bahan-Bahan");

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Langkah-Langkah");

        tabelResep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tabelResep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelResep.setRowHeight(35);
        tabelResep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelResepMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelResep);

        simpanBT.setBackground(new java.awt.Color(113, 191, 109));
        simpanBT.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        simpanBT.setText("SIMPAN");
        simpanBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simpanBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBTActionPerformed(evt);
            }
        });

        ubahBT.setBackground(new java.awt.Color(89, 191, 223));
        ubahBT.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        ubahBT.setText("UBAH");
        ubahBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ubahBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahBTActionPerformed(evt);
            }
        });

        hapusBT.setBackground(new java.awt.Color(219, 83, 77));
        hapusBT.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        hapusBT.setForeground(new java.awt.Color(255, 255, 255));
        hapusBT.setText("HAPUS");
        hapusBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hapusBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBTActionPerformed(evt);
            }
        });

        batalBT.setBackground(new java.awt.Color(88, 88, 88));
        batalBT.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        batalBT.setForeground(new java.awt.Color(255, 255, 255));
        batalBT.setText("BATAL");
        batalBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        batalBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalBTActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel4.setText("Atur Resep");

        pilihProdukBT.setBackground(new java.awt.Color(204, 204, 204));
        pilihProdukBT.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        pilihProdukBT.setText("Pilih Produk");
        pilihProdukBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pilihProdukBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihProdukBTActionPerformed(evt);
            }
        });

        langkahTA.setColumns(20);
        langkahTA.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        langkahTA.setRows(5);
        jScrollPane4.setViewportView(langkahTA);

        bahanTA.setColumns(20);
        bahanTA.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        bahanTA.setRows(5);
        jScrollPane5.setViewportView(bahanTA);

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("(Opsional)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(336, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(320, 320, 320))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addComponent(namaProdukTF, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pilihProdukBT, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(batalBT, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(hapusBT, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(ubahBT, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simpanBT)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(namaProdukTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pilihProdukBT)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanBT)
                    .addComponent(ubahBT)
                    .addComponent(hapusBT)
                    .addComponent(batalBT))
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

    private void pilihProdukBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihProdukBTActionPerformed
       new DaftarProdukFrameView(this).setVisible(true);
    }//GEN-LAST:event_pilihProdukBTActionPerformed

    private void batalBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalBTActionPerformed
        cA.kontrolButtonAkses();
        cA.bersihkan();
    }//GEN-LAST:event_batalBTActionPerformed

    private void ubahBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahBTActionPerformed
        cA.ubah();
    }//GEN-LAST:event_ubahBTActionPerformed

    private void hapusBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBTActionPerformed
        cA.hapus();
    }//GEN-LAST:event_hapusBTActionPerformed

    private void simpanBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBTActionPerformed
        cA.simpan();
    }//GEN-LAST:event_simpanBTActionPerformed

    private void tabelResepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelResepMouseClicked
        cA.ambilDataTabel();
    }//GEN-LAST:event_tabelResepMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bahanTA;
    private javax.swing.JButton batalBT;
    private javax.swing.JButton hapusBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea langkahTA;
    private javax.swing.JTextField namaProdukTF;
    private javax.swing.JButton pilihProdukBT;
    private javax.swing.JButton simpanBT;
    private javax.swing.JTable tabelResep;
    private javax.swing.JButton ubahBT;
    // End of variables declaration//GEN-END:variables
}
