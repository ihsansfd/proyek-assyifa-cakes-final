/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.controllers.Produk;

import com.assyifacake.helpers.validations.FileSizeValidation;
import com.assyifacake.helpers.validations.IsImageValidation;
import com.assyifacake.helpers.validations.NotNullValidation;
import com.assyifacake.helpers.validations.exceptions.FileSizeExceededException;
import com.assyifacake.helpers.validations.exceptions.NotAnImageException;
import com.assyifacake.helpers.validations.exceptions.NullException;
import com.assyifacake.models.Produk.AturProdukModel;
import com.assyifacake.utils.ByteToIcon;
import com.assyifacake.utils.IndonesiaCurrency;
import com.assyifacake.utils.PathToByte;
import com.assyifacake.views.Produk.UbahProdukDetailFrameView;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class UbahProdukFrameController {
    
    UbahProdukDetailFrameView view;
    AturProdukModel model = new AturProdukModel();
    
    byte[] gambar = null;
    
    
    public UbahProdukFrameController(UbahProdukDetailFrameView view) {
        this.view = view;
    }
    
    public void uploadGambar() {
        try {
            IsImageValidation.validate(view.getGambar());
            FileSizeValidation.validate(view.getGambar());
            gambar = PathToByte.generate(view.getGambar());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view, "Eror saat mengunggah file: " + ex.getMessage(), "Ada Kesalahan!", ERROR_MESSAGE);
            return;
        } catch (NotAnImageException ex) {
            JOptionPane.showMessageDialog(view, "Eror saat mengunggah file: " + ex.getMessage(), "Ada Kesalahan!", ERROR_MESSAGE);
            return;
        } catch (FileSizeExceededException ex) {
            JOptionPane.showMessageDialog(view, "Eror saat mengunggah file: " + ex.getMessage(), "Ada Kesalahan!", ERROR_MESSAGE);
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
        panelView.setVisible(true);
        panelView.add(imageLabel);
    }
    
    public boolean ubah() {
        JTextField[] validasi = {view.getNama(),view.getHarga(),view.getLaba()};
        try {
            NotNullValidation.validate(validasi);
        } catch (NullException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Ada Kesalahan!", ERROR_MESSAGE);
            return false;
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
            model.setId(view.getId());
            model.setNama(view.getNama().getText());
            model.setHarga(view.getHarga().getText());
            model.setLaba(view.getLaba().getText());
            model.setGambar(gambar);
            model.ubah();
            
            
            return true;
         } else {
             return false;
         }
    }
    
    public boolean hapus() {
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
        model.setId(view.getId());
        model.hapus();
        return true;
         } else {
             return false;
         }
    }
    
    
}
