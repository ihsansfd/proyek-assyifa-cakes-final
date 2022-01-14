/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.controllers.Produk;

import com.assyifacake.controllers.KontrakCRUD;
import static com.assyifacake.db.KoneksiDatabase.getConnection;
import com.assyifacake.helpers.validations.FileSizeValidation;
import com.assyifacake.helpers.validations.IsImageValidation;
import com.assyifacake.helpers.validations.NotNullValidation;
import com.assyifacake.helpers.validations.NumbersValidation;
import com.assyifacake.helpers.validations.exceptions.FileSizeExceededException;
import com.assyifacake.helpers.validations.exceptions.NotAnImageException;
import com.assyifacake.helpers.validations.exceptions.NotNumbersException;
import com.assyifacake.helpers.validations.exceptions.NullException;
import com.assyifacake.models.Produk.AturProdukModel;
import com.assyifacake.utils.ByteToIcon;
import com.assyifacake.utils.IndonesiaCurrency;
import com.assyifacake.utils.PathToByte;
import com.assyifacake.views.Produk.AturProdukInternalView;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class AturProdukController implements KontrakCRUD {
    
    AturProdukInternalView view;
    DefaultTableModel tabelModel;
    AturProdukModel model = new AturProdukModel();
    JTable tabel;
    byte[] gambar = null;
    public AturProdukController(AturProdukInternalView view) {
        this.view = view;
        this.tabel = view.getTabel();
    }

    @Override
    public void kontrolButtonAkses() {
        view.getBatal().setEnabled(true);
        view.getSimpan().setEnabled(true);
        view.getUbah().setEnabled(false);
        view.getHapus().setEnabled(false);
    }

    @Override
    public void kontrolButtonUbah() {
        view.getBatal().setEnabled(true);
        view.getSimpan().setEnabled(false);
        view.getUbah().setEnabled(true);
        view.getHapus().setEnabled(true);
    }

    @Override
    public void bersihkan() {
        kontrolButtonAkses();
        view.getNama().setText("");
        view.getHarga().setText("");
        view.getLaba().setText("");
        view.setId("");
        view.getPanelGambar().removeAll();
        view.getPreviewGambar().setVisible(false);
        view.getPanelGambar().setVisible(false);
        tabel.clearSelection();
        gambar = null;
    }
    
    public void uploadGambar() {
        try {
            IsImageValidation.validate(view.getGambar());
            FileSizeValidation.validate(view.getGambar());
            gambar = PathToByte.generate(view.getGambar());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view, "Eror saat mengunggah file: " + ex.getMessage(), "Ada Kesalahan!", WARNING_MESSAGE);
            return;
        } catch (NotAnImageException ex) {
            JOptionPane.showMessageDialog(view, "Eror saat mengunggah file: " + ex.getMessage(), "Ada Kesalahan!", WARNING_MESSAGE);
            return;
        } catch (FileSizeExceededException ex) {
            JOptionPane.showMessageDialog(view, "Eror saat mengunggah file: " + ex.getMessage(), "Ada Kesalahan!", WARNING_MESSAGE);
            return;
        }
        ImageIcon iconPreview = ByteToIcon.decode(gambar);
        int width = 150;
        int height = 149;
        Image resizedImage = iconPreview.getImage().getScaledInstance(width, height, SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JPanel panelView = view.getPanelGambar();
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(resizedIcon);
        imageLabel.setSize(150,149);
        panelView.removeAll();
        panelView.repaint();
        view.getPreviewGambar().setVisible(true);
        panelView.setVisible(true);
        panelView.add(imageLabel);
    }

    @Override
    public void simpan() {
        JTextField[] validasiNotNull = {view.getNama(),view.getHarga(),view.getLaba()};
        JTextField[] validasiNumber = {view.getHarga(),view.getLaba()};
        try {
            NotNullValidation.validate(validasiNotNull);
            new NumbersValidation().validateMany(validasiNumber);
        } catch (NullException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Ada Kesalahan!", WARNING_MESSAGE);
            return;
        } catch (NotNumbersException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage() + " untuk harga dan laba", "Ada Kesalahan!", WARNING_MESSAGE);
            return;
        }
        model.setNama(view.getNama().getText());
        model.setHarga(view.getHarga().getText());
        model.setLaba(view.getLaba().getText());
        model.setGambar(gambar);
        String hargaIndo = IndonesiaCurrency.format(Integer.parseInt(view.getHarga().getText()));
        String labaIndo = IndonesiaCurrency.format(Integer.parseInt(view.getLaba().getText()));
        
        int opsi = JOptionPane.showConfirmDialog(view, String.format("Nama Produk : %s \n "
                                                        + "Harga : %s \n"
                                                        + "Laba : %s \n"
                                                       ,
                view.getNama().getText(), hargaIndo, labaIndo),"Yakin ingin simpan data ini ke database?",JOptionPane.YES_NO_OPTION);
         if (opsi == JOptionPane.YES_OPTION) {      
            model.simpan();
            bersihkan();
            kontrolButtonAkses();
            tampilTabel();
    } else {
             return;
         }
    }

    @Override
    public void ubah() {
            JTextField[] validasi = {view.getNama(),view.getHarga(),view.getLaba()};
        try {
            NotNullValidation.validate(validasi);
        } catch (NullException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Ada Kesalahan!", WARNING_MESSAGE);
            return;
        }
        String hargaIndo = IndonesiaCurrency.format(Integer.parseInt(view.getHarga().getText()));
        String labaIndo = IndonesiaCurrency.format(Integer.parseInt(view.getLaba().getText()));
        int opsi = JOptionPane.showConfirmDialog(view, String.format(
                                                        "ID : %s \n " + 
                                                        "Nama Produk : %s \n "
                                                        + "Harga : %s \n"
                                                        + "Laba : %s \n"
                                                       ,
                view.getId(),view.getNama().getText(), hargaIndo, labaIndo),"Yakin ingin ubah data ini dari database?",JOptionPane.YES_NO_OPTION);
         if (opsi == JOptionPane.YES_OPTION) { 
            model.setId(Integer.parseInt(view.getId()));
            model.setNama(view.getNama().getText());
            model.setHarga(view.getHarga().getText());
            model.setLaba(view.getLaba().getText());
            model.setGambar(gambar);
            model.ubah();
            bersihkan();
            kontrolButtonAkses();
            tampilTabel();
         } else {
             return;
         }
    }

    @Override
    public void hapus() {
        String hargaIndo = IndonesiaCurrency.format(Integer.parseInt(view.getHarga().getText()));
        String labaIndo = IndonesiaCurrency.format(Integer.parseInt(view.getLaba().getText()));
        int opsi = JOptionPane.showConfirmDialog(view, String.format(
                                                        "ID : %s \n " + 
                                                        "Nama Produk : %s \n "
                                                        + "Harga : %s \n"
                                                        + "Laba : %s \n"
                                                       ,
                view.getId(),view.getNama().getText(), hargaIndo, labaIndo),"Yakin ingin hapus data ini dari database?",JOptionPane.YES_NO_OPTION);
         if (opsi == JOptionPane.YES_OPTION) {      
        model.setId(Integer.parseInt(view.getId()));
        model.hapus();
        bersihkan();
        kontrolButtonAkses();
        tampilTabel();
         } else {
             return;
         }
    }

    @Override
    public void tampilTabel() {
        view.getPreviewGambar().setVisible(false);
        view.getPanelGambar().setVisible(false);
        tabelModel = new DefaultTableModel(){
            @Override
        public Class<?> getColumnClass(int column) {
                switch(column) {
                case 4: return ImageIcon.class;
                default: return Object.class;
                }
            }
        };
        tabel.setModel(tabelModel);
        tabel.setSelectionMode(SINGLE_INTERVAL_SELECTION);
        tabel.getTableHeader().setReorderingAllowed(false);
        tabelModel.addColumn("ID");
        tabelModel.addColumn("Nama Produk");
        tabelModel.addColumn("Harga");
        tabelModel.addColumn("Laba");
        tabelModel.addColumn("Gambar");
        tabel.setModel(tabelModel);
        tabelModel.getDataVector().removeAllElements();
        tabelModel.fireTableDataChanged();
        
        String sql = "SELECT * FROM produk ORDER BY updated_at DESC";
        Statement stat = null;
        ResultSet res = null;
        Connection conn = null;
        try{
            conn = getConnection();
            stat = (Statement) conn.createStatement();
            res = stat.executeQuery(sql);
            while(res.next()) {
                Object[] hasil;
                hasil = new Object[7];
                hasil[0] = res.getString("id");
                hasil[1] = res.getString("nama");
                
                String hargaDalamIndo = IndonesiaCurrency.format(res.getInt("harga"));
                String labaDalamIndo = IndonesiaCurrency.format(res.getInt("laba"));
                hasil[2] = hargaDalamIndo;
                hasil[3] = labaDalamIndo;
                
                ImageIcon icon = null;
                int width = 80;
                int height = 50;
                if(res.getBytes("gambar") == null) {
                    icon = new ImageIcon(getClass().getResource("/img/defaultImage.png"));
                } else {
                    icon = ByteToIcon.decode(res.getBytes("gambar"));
                }
                Image resizedImage = icon.getImage().getScaledInstance(width, height, SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);
                hasil[4] = resizedIcon;

                tabelModel.addRow(hasil);
        }
        } catch (SQLException ex) {
            System.err.print("gagal eksekusi:" + ex);
        } finally {
            try {
                conn.close();
                stat.close();
                res.close();
            } catch (SQLException ex) {
                Logger.getLogger(AturProdukController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void ambilDataTabel() {
        int index = tabel.getSelectedRow();
        String id = String.valueOf(tabel.getValueAt(index, 0));
        String nama = String.valueOf(tabel.getValueAt(index, 1));
        String harga = String.valueOf(IndonesiaCurrency.formatBack(String.valueOf(tabel.getValueAt(index, 2))));
        String laba = String.valueOf(IndonesiaCurrency.formatBack(String.valueOf(tabel.getValueAt(index, 3))));
        
        view.setId(id);
        view.getNama().setText(nama);
        view.getHarga().setText(harga);
        view.getLaba().setText(laba);        
        kontrolButtonUbah();
    }
}
