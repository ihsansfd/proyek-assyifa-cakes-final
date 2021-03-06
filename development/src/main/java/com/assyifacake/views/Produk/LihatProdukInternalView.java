/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.assyifacake.views.Produk;

import com.assyifacake.controllers.Produk.LihatProdukController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author hp
 */
public class LihatProdukInternalView extends javax.swing.JInternalFrame {

    private LihatProdukController controller;
    
    public JLabel getImage1() {
        return image1;
    }

    public JLabel getImage2() {
        return image2;
    }

    public JLabel getImage3() {
        return image3;
    }

    public JLabel getImage4() {
        return image4;
    }

    public JLabel getImage5() {
        return image5;
    }

    public JLabel getImage6() {
        return image6;
    }
    
    public JLabel getHargaProduk1() {
        return hargaProduk1;
        
    }

    public JLabel getHargaProduk2() {
        return hargaProduk2;
    }

    public JLabel getHargaProduk3() {
        return hargaProduk3;
    }

    public JLabel getHargaProduk4() {
        return hargaProduk4;
    }

    public JLabel getHargaProduk5() {
        return hargaProduk5;
    }

    public JLabel getHargaProduk6() {
        return hargaProduk6;
    }

    public JLabel getNamaProduk1() {
        return namaProduk1;
    }

    public JLabel getNamaProduk2() {
        return namaProduk2;
    }

    public JLabel getNamaProduk3() {
        return namaProduk3;
    }

    public JLabel getNamaProduk4() {
        return namaProduk4;
    }

    public JLabel getNamaProduk5() {
        return namaProduk5;
    }
    
    public JLabel getNamaProduk6() {
        return namaProduk6;
    }

    public JButton getNext() {
        return next;
    }

    public JButton getPrev() {
        return prev;
    }

    public JTextField getSearch() {
        return search;
    }

    
    public LihatProdukInternalView() {
        this.controller = new LihatProdukController(this);
        initComponents();
        controller.myComponents();
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

        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        image1 = new javax.swing.JLabel();
        namaProduk1 = new javax.swing.JLabel();
        hargaProduk1 = new javax.swing.JLabel();
        image2 = new javax.swing.JLabel();
        namaProduk2 = new javax.swing.JLabel();
        hargaProduk2 = new javax.swing.JLabel();
        namaProduk3 = new javax.swing.JLabel();
        hargaProduk3 = new javax.swing.JLabel();
        image3 = new javax.swing.JLabel();
        image4 = new javax.swing.JLabel();
        namaProduk4 = new javax.swing.JLabel();
        hargaProduk4 = new javax.swing.JLabel();
        image5 = new javax.swing.JLabel();
        namaProduk5 = new javax.swing.JLabel();
        hargaProduk5 = new javax.swing.JLabel();
        image6 = new javax.swing.JLabel();
        namaProduk6 = new javax.swing.JLabel();
        hargaProduk6 = new javax.swing.JLabel();
        prev = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        judul7 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setBackground(new java.awt.Color(153, 0, 204));
        setPreferredSize(new java.awt.Dimension(772, 484));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(772, 482));

        image1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        namaProduk1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        namaProduk1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        namaProduk1.setText("Nama Kue 1");

        hargaProduk1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        hargaProduk1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hargaProduk1.setText("Rp 10000");

        image2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        namaProduk2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        namaProduk2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        namaProduk2.setText("Nama Kue 2");

        hargaProduk2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        hargaProduk2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hargaProduk2.setText("Rp 10000");

        namaProduk3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        namaProduk3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        namaProduk3.setText("Nama Kue 3");

        hargaProduk3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        hargaProduk3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hargaProduk3.setText("Rp 10000");

        image3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        image4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        namaProduk4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        namaProduk4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        namaProduk4.setText("Nama Kue 4");

        hargaProduk4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        hargaProduk4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hargaProduk4.setText("Rp 10000");

        image5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        namaProduk5.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        namaProduk5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        namaProduk5.setText("Nama Kue 5");

        hargaProduk5.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        hargaProduk5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hargaProduk5.setText("Rp 10000");

        image6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        namaProduk6.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        namaProduk6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        namaProduk6.setText("Nama Kue 6");

        hargaProduk6.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        hargaProduk6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hargaProduk6.setText("Rp 10000");

        prev.setBackground(new java.awt.Color(113, 191, 109));
        prev.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        prev.setText("Prev");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        next.setBackground(new java.awt.Color(113, 191, 109));
        next.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lb_lihatProduk.png"))); // NOI18N

        judul7.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        judul7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        judul7.setText("Cari Berdasarkan Nama atau ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hargaProduk1)
                                    .addComponent(namaProduk1)
                                    .addComponent(image1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hargaProduk2)
                                    .addComponent(namaProduk2)
                                    .addComponent(image2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hargaProduk3)
                                    .addComponent(namaProduk3)
                                    .addComponent(image3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hargaProduk4)
                                    .addComponent(namaProduk4)
                                    .addComponent(image4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hargaProduk5)
                                    .addComponent(namaProduk5)
                                    .addComponent(image5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hargaProduk6)
                                    .addComponent(namaProduk6)
                                    .addComponent(image6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(100, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(judul7)
                .addGap(18, 18, 18)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(judul7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(image2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(namaProduk2)
                                        .addGap(5, 5, 5)
                                        .addComponent(hargaProduk2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(image3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(namaProduk3)
                                        .addGap(5, 5, 5)
                                        .addComponent(hargaProduk3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(image6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(namaProduk6)
                                        .addGap(5, 5, 5)
                                        .addComponent(hargaProduk6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(image5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(namaProduk5)
                                        .addGap(5, 5, 5)
                                        .addComponent(hargaProduk5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(image1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(namaProduk1)
                                .addGap(5, 5, 5)
                                .addComponent(hargaProduk1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(image4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(namaProduk4)
                                .addGap(5, 5, 5)
                                .addComponent(hargaProduk4)
                                .addGap(42, 42, 42)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        
        controller.nextBT();
    }//GEN-LAST:event_nextActionPerformed

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
        controller.prevBT();
    }//GEN-LAST:event_prevActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hargaProduk1;
    private javax.swing.JLabel hargaProduk2;
    private javax.swing.JLabel hargaProduk3;
    private javax.swing.JLabel hargaProduk4;
    private javax.swing.JLabel hargaProduk5;
    private javax.swing.JLabel hargaProduk6;
    private javax.swing.JLabel image1;
    private javax.swing.JLabel image2;
    private javax.swing.JLabel image3;
    private javax.swing.JLabel image4;
    private javax.swing.JLabel image5;
    private javax.swing.JLabel image6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel judul7;
    private javax.swing.JLabel namaProduk1;
    private javax.swing.JLabel namaProduk2;
    private javax.swing.JLabel namaProduk3;
    private javax.swing.JLabel namaProduk4;
    private javax.swing.JLabel namaProduk5;
    private javax.swing.JLabel namaProduk6;
    private javax.swing.JButton next;
    private javax.swing.JButton prev;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
