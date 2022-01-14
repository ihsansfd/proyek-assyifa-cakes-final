/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.controllers.DaftarPembeli;

import com.assyifacake.db.KoneksiDatabase;
import com.assyifacake.models.DaftarPembeli.PembeliModel;
import com.assyifacake.views.DaftarPembeli.DaftarPembeliInternalView;
import com.assyifacake.controllers.Login.LoginController;
import com.assyifacake.helpers.validations.NotNullValidation;
import com.assyifacake.helpers.validations.NumbersValidation;
import com.assyifacake.helpers.validations.exceptions.NotNumbersException;
import com.assyifacake.helpers.validations.exceptions.NullException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JTable;
import static javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author EZ-Claim
 */
public class PembeliController extends KoneksiDatabase{
    
    private DefaultTableModel model;
    private PembeliModel mP;
    private DaftarPembeliInternalView vP;
    private JTable tabelPembeli;
    
    public PembeliController (DaftarPembeliInternalView vP){
        this.vP = vP;
        tabelPembeli = vP.getTabelDaftarPembeli();
    }
    
    public void kontrolButtonAkses() {
        LoginController cL = LoginController.getInstance();
        JButton simpan = vP.getSimpanBT();
        JButton ubah = vP.getUbahBT();
        JButton hapus = vP.getHapusBT();
        JButton batal = vP.getBatalBT();
       
           simpan.setEnabled(true);
           ubah.setEnabled(false);
           hapus.setEnabled(false);
           batal.setEnabled(true);
    }

    public void kontrolButtonUbah() {
        LoginController cL = LoginController.getInstance();
        JButton simpan = vP.getSimpanBT();
        JButton ubah = vP.getUbahBT();
        JButton hapus = vP.getHapusBT();
        JButton batal = vP.getBatalBT();       
            
            simpan.setEnabled(false);
            ubah.setEnabled(true);
            hapus.setEnabled(true);
            batal.setEnabled(true);  
    }

    public void bersihkan() {
        vP.setIdPembeli(0);
        vP.getNamaPembeliTF().setText("");
        vP.getNoHpTF().setText("");
        vP.getAlamatTA().setText("");
    }

    public void simpan() {
        JTextComponent[] input = {vP.getNamaPembeliTF(),vP.getNoHpTF(), vP.getAlamatTA()};
        try {
            NotNullValidation.validate(input);
        } catch (NullException ex) {
             JOptionPane.showMessageDialog(vP, ex.getMessage(), "Ada Kesalahan!", WARNING_MESSAGE);
            return;
        }
        
        try {
            // kolom no hp harus berupa angka
            new NumbersValidation().validate(vP.getNoHpTF().getText(), "Nomor HP");
        } catch (NotNumbersException ex) {
            JOptionPane.showMessageDialog(vP, ex.getMessage(), "Ada Kesalahan!", WARNING_MESSAGE);
            return;
        }
        
        mP = new PembeliModel();
        mP.setNama(vP.getNamaPembeliTF().getText());
        mP.setNoHP(vP.getNoHpTF().getText());
        mP.setAlamat(vP.getAlamatTA().getText());
        
        
        int opsi = JOptionPane.showConfirmDialog(vP, String.format("Nama : %s \n "
                                                        + "Nomor HP : %s \n"
                                                        + "Alamat : %s \n",
                mP.getNama(), mP.getNoHP(), mP.getAlamat()),"Yakin ingin simpan ke database?",JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION) {
             mP.simpan();
        } else {
            return;
        }
        bersihkan();
        this.tampilTabel();
    }

    public void ubah() {
        JTextComponent[] input = {vP.getNamaPembeliTF(),vP.getNoHpTF(), vP.getAlamatTA()};
        try {
            NotNullValidation.validate(input);
        } catch (NullException ex) {
             JOptionPane.showMessageDialog(vP, ex.getMessage(), "Ada Kesalahan!", WARNING_MESSAGE);
            return;
        }
        
        try {
            // kolom no hp harus berupa angka
            new NumbersValidation().validate(vP.getNoHpTF().getText(), "Nomor HP");
        } catch (NotNumbersException ex) {
            JOptionPane.showMessageDialog(vP, ex.getMessage(), "Ada Kesalahan!", WARNING_MESSAGE);
            return;
        }
        mP = new PembeliModel();
        mP.setId(vP.getIdPembeli());
        mP.setNama(vP.getNamaPembeliTF().getText());
        mP.setNoHP(vP.getNoHpTF().getText());
        mP.setAlamat(vP.getAlamatTA().getText());
        int opsi = JOptionPane.showConfirmDialog(vP, String.format("Nama : %s \n "
                                                        + "Nomor HP : %s \n"
                                                        + "Alamat : %s \n",
                mP.getNama(), mP.getNoHP(), mP.getAlamat()),"Yakin ingin ubah data ini ke database?",JOptionPane.YES_NO_OPTION);
         if (opsi == JOptionPane.YES_OPTION) {
            mP.ubah();
        } else {
            return;
        }
        bersihkan();
        kontrolButtonAkses();
        tampilTabel();
    }

    public void hapus() {
        int opsi = JOptionPane.showConfirmDialog(vP, String.format("Nama : %s \n "
                                                        + "Nomor HP : %s \n"
                                                        + "Alamat : %s \n",
                mP.getNama(), mP.getNoHP(), mP.getAlamat()),"Yakin ingin hapus data ini ke database?",JOptionPane.YES_NO_OPTION);
         if (opsi != JOptionPane.YES_OPTION) {
            return; 
         }
         
        mP = new PembeliModel();
        mP.setId(vP.getIdPembeli());
        mP.hapus();
        bersihkan();
        kontrolButtonUbah();
        tampilTabel();
    }

    public void tampilTabel() {
        model = new DefaultTableModel();
        tabelPembeli.setModel(model);
        tabelPembeli.setSelectionMode(SINGLE_INTERVAL_SELECTION);
        tabelPembeli.getTableHeader().setReorderingAllowed(false);
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Nomor HP");
        model.addColumn("Alamat");
        tabelPembeli.setModel(model);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT * FROM pembeli ORDER BY updated_at DESC";
        
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        
        try {
            conn = getConnection();
            stat = conn.createStatement();
            res = stat.executeQuery(sql);
            while(res.next()) {
                Object[] hasil;
                hasil = new Object[5];
                hasil[0] = res.getInt("id");
                hasil[1] = res.getString("nama");
                hasil[2] = res.getString("no_hp");
                hasil[3] = res.getString("alamat");

                model.addRow(hasil);
        }
        } catch (SQLException ex) {
            System.err.print("gagal eksekusi:" + ex);
        } finally {
            try {
                conn.close();
                stat.close();
                res.close();
            } catch (SQLException ex) {
                Logger.getLogger(PembeliController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ambilDataTabel() {
        int index = tabelPembeli.getSelectedRow();
        int id = (Integer) tabelPembeli.getValueAt(index, 0);
        String nama = String.valueOf(tabelPembeli.getValueAt(index, 1));
        String noHP = String.valueOf(tabelPembeli.getValueAt(index, 2));
        String alamat = String.valueOf(tabelPembeli.getValueAt(index, 3));
        
        vP.setIdPembeli(id);
        vP.getNamaPembeliTF().setText(nama);
        vP.getNoHpTF().setText(noHP);
        vP.getAlamatTA().setText(alamat);
        
        kontrolButtonUbah();
    }
    
    
}
