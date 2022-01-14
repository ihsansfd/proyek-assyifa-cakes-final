/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.assyifacake.views.Transaksi;

import com.assyifacake.controllers.Transaksi.DetailTransaksiController;
import com.assyifacake.views.Produk.*;
import java.awt.Component;
import java.awt.Container;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author hp
 */
public class DetailTransaksiInternalView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ContohInternalView
     */
    
    DetailTransaksiController controller;
    
    public DetailTransaksiInternalView() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        controller = new DetailTransaksiController(this);
        controller.myComponents();
        
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }
    

    public JButton getCetakStrukBT() {
        return cetakStrukBT;
    }

    public JButton getHapusBT() {
        return hapusBT;
    }

    public JRadioButton getSelesaiRB() {
        return selesaiRB;
    }

    public ButtonGroup getStatus() {
        return status;
    }

    public JTable getTabel() {
        return tabel;
    }

    public JButton getTandaiSelesaiBT() {
        return tandaiSelesaiBT;
    }

    public JRadioButton getTertundaRB() {
        return tertundaRB;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        status = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        hapusBT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tertundaRB = new javax.swing.JRadioButton();
        selesaiRB = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        tandaiSelesaiBT = new javax.swing.JButton();
        cetakStrukBT = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 0, 204));
        setPreferredSize(new java.awt.Dimension(772, 484));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(772, 482));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(772, 482));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_back.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel3.setText("Detail Transaksi");

        status.add(tertundaRB);
        tertundaRB.setText("Tertunda");
        tertundaRB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tertundaRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tertundaRBActionPerformed(evt);
            }
        });

        status.add(selesaiRB);
        selesaiRB.setText("Selesai");
        selesaiRB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selesaiRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selesaiRBActionPerformed(evt);
            }
        });

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
        tabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabel.setRowHeight(35);
        jScrollPane1.setViewportView(tabel);

        tandaiSelesaiBT.setBackground(new java.awt.Color(113, 191, 109));
        tandaiSelesaiBT.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        tandaiSelesaiBT.setText("TANDAI SELESAI");
        tandaiSelesaiBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tandaiSelesaiBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tandaiSelesaiBTActionPerformed(evt);
            }
        });

        cetakStrukBT.setBackground(new java.awt.Color(89, 191, 223));
        cetakStrukBT.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        cetakStrukBT.setText("CETAK STRUK");
        cetakStrukBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cetakStrukBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakStrukBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(54, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(189, 189, 189)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selesaiRB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tertundaRB, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(hapusBT, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tandaiSelesaiBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cetakStrukBT)
                .addGap(203, 203, 203))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tertundaRB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selesaiRB)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hapusBT)
                    .addComponent(tandaiSelesaiBT)
                    .addComponent(cetakStrukBT))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
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

    private void tertundaRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tertundaRBActionPerformed
        if(tertundaRB.isSelected()) {
            String sql = "SELECT transaksi.id, transaksi_detail.nama_produk, transaksi_detail.harga_produk, transaksi_detail.laba_produk, "
                + "transaksi_detail.kuantitas, transaksi_detail.subtotal, transaksi.nama_pembeli, transaksi.no_hp_pembeli, transaksi.alamat, transaksi.total, transaksi.uang_bayar,"
                + "transaksi.total_laba, transaksi.tenggat,transaksi.status, transaksi.tanggal_transaksi FROM transaksi "
                + "INNER JOIN transaksi_detail on (transaksi_detail.id_transaksi = transaksi.id) WHERE transaksi.status = 'Pending' ORDER BY transaksi.created_at DESC";
            tandaiSelesaiBT.setEnabled(true);
            controller.tampilDataTabel(sql);
        }
    }//GEN-LAST:event_tertundaRBActionPerformed

    private void tandaiSelesaiBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tandaiSelesaiBTActionPerformed
        controller.tandaiSelesai();
    }//GEN-LAST:event_tandaiSelesaiBTActionPerformed

    private void cetakStrukBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakStrukBTActionPerformed
        controller.printStruk();
    }//GEN-LAST:event_cetakStrukBTActionPerformed

    private void selesaiRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesaiRBActionPerformed
         if(selesaiRB.isSelected()) {
            String sql = "SELECT transaksi.id, transaksi_detail.nama_produk, transaksi_detail.harga_produk, transaksi_detail.laba_produk, "
                + "transaksi_detail.kuantitas, transaksi_detail.subtotal, transaksi.nama_pembeli, transaksi.no_hp_pembeli, transaksi.alamat, transaksi.total, transaksi.uang_bayar,"
                + "transaksi.total_laba, transaksi.tenggat,transaksi.status, transaksi.tanggal_transaksi FROM transaksi "
                + "INNER JOIN transaksi_detail on (transaksi_detail.id_transaksi = transaksi.id) WHERE transaksi.status = 'Selesai' ORDER BY transaksi.created_at DESC";
            tandaiSelesaiBT.setEnabled(false);
            controller.tampilDataTabel(sql);
        }
    }//GEN-LAST:event_selesaiRBActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
         Container container = SwingUtilities.getAncestorOfClass(JDesktopPane.class, (Component) evt.getSource());
            if (container != null)
            {
                JDesktopPane desktop = (JDesktopPane) container;
                desktop.removeAll();
                LihatProdukInternalView view = new LihatProdukInternalView();
                desktop.add(view);
                view.setVisible(true);
            }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void hapusBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBTActionPerformed
        controller.hapus();
    }//GEN-LAST:event_hapusBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cetakStrukBT;
    private javax.swing.JButton hapusBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton selesaiRB;
    private javax.swing.ButtonGroup status;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tandaiSelesaiBT;
    private javax.swing.JRadioButton tertundaRB;
    // End of variables declaration//GEN-END:variables
}
