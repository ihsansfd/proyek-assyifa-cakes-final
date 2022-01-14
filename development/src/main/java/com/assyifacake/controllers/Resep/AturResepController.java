/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.controllers.Resep;

import com.assyifacake.controllers.KontrakCRUD;
import static com.assyifacake.db.KoneksiDatabase.getConnection;
import com.assyifacake.helpers.validations.NotNullValidation;
import com.assyifacake.helpers.validations.exceptions.NullException;
import com.assyifacake.models.Resep.AturResepModel;
import com.assyifacake.views.Resep.AturResepInternalView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author EZ-Claim
 */
public class AturResepController implements KontrakCRUD{

    private AturResepInternalView view;
    DefaultTableModel model;
    AturResepModel mA = new AturResepModel();
    JTable tabel;
    
    public AturResepController(AturResepInternalView view) {
        this.view = view;
        this.tabel = view.getTabelResep();
    }
    
    @Override
    public void kontrolButtonAkses() {
        view.getBatalBT().setEnabled(true);
        view.getSimpanBT().setEnabled(true);
        view.getUbahBT().setEnabled(false);
        view.getHapusBT().setEnabled(false);
    }

    @Override
    public void kontrolButtonUbah() {
        view.getBatalBT().setEnabled(true);
        view.getSimpanBT().setEnabled(false);
        view.getUbahBT().setEnabled(true);
        view.getHapusBT().setEnabled(true);
    }

    @Override
    public void bersihkan() {
        kontrolButtonAkses();
        view.getNamaProdukTF().setText("");
        view.getBahanTA().setText("");
        view.getLangkahTA().setText("");
        tabel.clearSelection();
    }

    @Override
    public void simpan() {
        JTextComponent[] validasiNotNull = {view.getNamaProdukTF(),view.getBahanTA()};
        try {
            NotNullValidation.validate(validasiNotNull);
        } catch (NullException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Harap Isi Data!", WARNING_MESSAGE);
            return;
        }
        mA.setId(view.getIdProduk());
        mA.setNama(view.getNamaProdukTF().getText());
        mA.setBahan(view.getBahanTA().getText());
        mA.setLangkah(view.getLangkahTA().getText());
        
        int opsi = JOptionPane.showConfirmDialog(view, String.format("Nama Produk : %s \n "
                                                        + "Bahan-bahan : %s \n"
                                                        + "Langkah-langkah : %s \n",
                mA.getNama(), mA.getBahan(), mA.getLangkah()),"Yakin ingin simpan ke resep?",JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION) {
             mA.simpan();
        } else {
            return;
        }
        bersihkan();
        this.tampilTabel();
    }

    @Override
    public void ubah() {
        JTextComponent[] validasiNotNull = {view.getNamaProdukTF(),view.getBahanTA()};
        try {
            NotNullValidation.validate(validasiNotNull);
        } catch (NullException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Harap Isi Data!", WARNING_MESSAGE);
            return;
        }
        
        mA.setId(view.getIdProduk());
        mA.setNama(view.getNamaProdukTF().getText());
        mA.setBahan(view.getBahanTA().getText());
        mA.setLangkah(view.getLangkahTA().getText());
        int opsi = JOptionPane.showConfirmDialog(view, String.format("Nama Produk : %s \n "
                                                        + "Bahan-bahan : %s \n"
                                                        + "Langkah-langkah : %s \n",
                mA.getNama(), mA.getBahan(), mA.getLangkah()),"Yakin ingin ubah ke resep?",JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION) {
            mA.ubah();
        } else {
            return;
        }
        bersihkan();
        kontrolButtonAkses();
        tampilTabel();
    }

    @Override
    public void hapus() {
        int opsi = JOptionPane.showConfirmDialog(view, String.format("Nama Produk : %s \n "
                                                        + "Bahan-bahan : %s \n"
                                                        + "Langkah-langkah : %s \n",
                view.getNamaProdukTF().getText(), view.getBahanTA().getText(), view.getLangkahTA().getText()),"Yakin ingin hapus data ini dari resep?",JOptionPane.YES_NO_OPTION);
        if (opsi != JOptionPane.YES_OPTION) {
            return; 
        }
        mA.setId(view.getIdProduk());
        mA.hapus();
        bersihkan();
        kontrolButtonUbah();
        tampilTabel();
    }

    @Override
    public void tampilTabel() {
        model = new DefaultTableModel();
        tabel.setModel(model);
        model.addColumn("ID Produk");
        model.addColumn("Nama");
        model.addColumn("Bahan-Bahan");
        model.addColumn("Langkah-Langkah");
        tabel.setModel(model);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT resep.id_produk, produk.nama, resep.bahan_bahan, resep.cara_pembuatan FROM resep INNER JOIN produk on (resep.id_produk = produk.id) ORDER BY resep.updated_at DESC ";
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        
        try {
            conn = getConnection();
            stat = (Statement) conn.createStatement();
            res = stat.executeQuery(sql);
            while(res.next()) {
                Object[] hasil;
                hasil = new Object[4];
                hasil[0] = res.getString("resep.id_produk");
                hasil[1] = res.getString("produk.nama");
                hasil[2] = res.getString("resep.bahan_bahan");
                hasil[3] = res.getString("resep.cara_pembuatan");

                model.addRow(hasil);
        }
        } catch (SQLException ex) {
            System.err.print("gagal eksekusi:" + ex);
        }  finally {
            try {
                conn.close();
                res.close();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(AturResepModel.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
    }

    @Override
    public void ambilDataTabel() {
        int index = tabel.getSelectedRow();
        String idProduk = String.valueOf(tabel.getValueAt(index, 0));
        String nama = String.valueOf(tabel.getValueAt(index, 1));
        String bahan = String.valueOf(tabel.getValueAt(index, 2));
        String langkah = String.valueOf(tabel.getValueAt(index, 3));
        
        view.setIdProduk(idProduk);
        view.getNamaProdukTF().setText(nama);
        view.getBahanTA().setText(bahan);
        view.getLangkahTA().setText(langkah);
        
        kontrolButtonUbah();
    }
    
}
