/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.assyifacake.views.Produk;

import com.assyifacake.controllers.MenuUtama.MenuUtamaController;
import com.assyifacake.utils.IndonesiaCurrency;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author hp
 */
public class DetailProdukInternalView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ContohInternalView
     */
    
    private int idProduk;

    
    public DetailProdukInternalView() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
       styling();
        
    }
    
    private void styling() {
        bahanBahan.setLineWrap(true);
        bahanBahan.setWrapStyleWord(true);
        langkahLangkah.setLineWrap(true);
        langkahLangkah.setWrapStyleWord(true);
    }
    public int getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }


    public JTextArea getBahanBahan() {
        return bahanBahan;
    }

    public JLabel getGambarProduk() {
        return gambarProduk;
    }

    public JTextField getHargaProduk() {
        return hargaProduk;
    }

    public JLabel getKembali() {
        return kembali;
    }

    public JTextField getLaba() {
        return laba;
    }

    public JTextArea getLangkahLangkah() {
        return langkahLangkah;
    }

    public JTextField getNamaProduk() {
        return namaProduk;
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
        jPanel2 = new javax.swing.JPanel();
        kembali = new javax.swing.JLabel();
        gambarProduk = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        namaProduk = new javax.swing.JTextField();
        hargaProduk = new javax.swing.JTextField();
        laba = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        bahanBahan = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        langkahLangkah = new javax.swing.JTextArea();
        aturProduk = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(153, 0, 204));
        setPreferredSize(new java.awt.Dimension(772, 484));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(772, 482));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(772, 482));

        kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_back.png"))); // NOI18N
        kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kembaliMouseClicked(evt);
            }
        });

        gambarProduk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel3.setText("Detail Produk");

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel4.setText("Nama Produk");

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Harga Produk");

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Laba");

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Bahan-Bahan");

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Cara Buat");

        namaProduk.setEditable(false);
        namaProduk.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N

        hargaProduk.setEditable(false);
        hargaProduk.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N

        laba.setEditable(false);
        laba.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N

        jScrollPane1.setPreferredSize(new java.awt.Dimension(238, 102));

        bahanBahan.setEditable(false);
        bahanBahan.setColumns(20);
        bahanBahan.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        bahanBahan.setRows(5);
        jScrollPane1.setViewportView(bahanBahan);

        langkahLangkah.setEditable(false);
        langkahLangkah.setColumns(20);
        langkahLangkah.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        langkahLangkah.setRows(5);
        jScrollPane2.setViewportView(langkahLangkah);

        aturProduk.setBackground(new java.awt.Color(89, 191, 223));
        aturProduk.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        aturProduk.setText("Atur Produk");
        aturProduk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aturProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aturProdukActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(kembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(171, 171, 171)
                        .addComponent(aturProduk))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(gambarProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(laba, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargaProduk, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaProduk, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kembali, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(aturProduk, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(namaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(hargaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(laba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(gambarProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
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

    private void kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseClicked
       Container container = SwingUtilities.getAncestorOfClass(JDesktopPane.class, (Component) evt.getSource());
            if (container != null)
            {
                JDesktopPane desktop = (JDesktopPane) container;
                LihatProdukInternalView view = new LihatProdukInternalView();
                MenuUtamaController.tampilKePanel(view, desktop);
            }
            
    }//GEN-LAST:event_kembaliMouseClicked

    private void aturProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aturProdukActionPerformed
        UbahProdukDetailFrameView ubahView = new UbahProdukDetailFrameView();
        ubahView.setId(idProduk);
        ubahView.getNama().setText(namaProduk.getText());
        ubahView.getHarga().setText(String.valueOf(IndonesiaCurrency.formatBack(hargaProduk.getText())));
        ubahView.getLaba().setText(String.valueOf(IndonesiaCurrency.formatBack(laba.getText())));
        JLabel label = gambarProduk;       
        ImageIcon icon = (ImageIcon) label.getIcon();
        ImageIcon iconResized = new ImageIcon(icon.getImage().getScaledInstance(149, 149, Image.SCALE_SMOOTH));
        JLabel labelIcon = new JLabel();
        labelIcon.setSize(new Dimension(149,149));
        labelIcon.setIcon(iconResized);
        ubahView.getPanelGambar().removeAll();
        ubahView.getPanelGambar().revalidate();
        ubahView.getPanelGambar().add(labelIcon);
        ubahView.setVisible(true);
        if(ubahView.sukses) {
            Container container = SwingUtilities.getAncestorOfClass(JDesktopPane.class, (Component) evt.getSource());
            if (container != null)
            {
                JDesktopPane desktop = (JDesktopPane) container;
                LihatProdukInternalView view = new LihatProdukInternalView();
                MenuUtamaController.tampilKePanel(view, desktop);
            }
        }
//        ubahView.getPanelGambar().add(iconResized);
    }//GEN-LAST:event_aturProdukActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton aturProduk;
    private javax.swing.JTextArea bahanBahan;
    private javax.swing.JLabel gambarProduk;
    private javax.swing.JTextField hargaProduk;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kembali;
    private javax.swing.JTextField laba;
    private javax.swing.JTextArea langkahLangkah;
    private javax.swing.JTextField namaProduk;
    // End of variables declaration//GEN-END:variables
}
