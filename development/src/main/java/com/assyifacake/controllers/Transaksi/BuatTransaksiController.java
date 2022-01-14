/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.controllers.Transaksi;

import com.assyifacake.helpers.validations.NotNullValidation;
import com.assyifacake.helpers.validations.NumbersValidation;
import com.assyifacake.helpers.validations.exceptions.NotNumbersException;
import com.assyifacake.helpers.validations.exceptions.NullException;
import com.assyifacake.models.Transaksi.BuatTransaksiModel;
import com.assyifacake.utils.IndonesiaCurrency;
import com.assyifacake.views.Transaksi.BuatTransaksiInternalView;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import javax.swing.JTextField;
import static javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author user
 */
public class BuatTransaksiController {
    
    BuatTransaksiInternalView view;
    JTable tabel;
    DefaultTableModel model;
    public BuatTransaksiController(BuatTransaksiInternalView view) {
        this.view = view;
        this.tabel = view.getTabel();
    }
    
    
    public void myComponents() {
        model = new DefaultTableModel();
        tabel.setModel(model);
        view.getjScrollPane1().setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tabel.setAutoResizeMode(AUTO_RESIZE_OFF);
        tabel.setSelectionMode(SINGLE_INTERVAL_SELECTION);
        tabel.getTableHeader().setReorderingAllowed(false);
        model.addColumn("Nama Produk");
        model.addColumn("Harga");
        model.addColumn("Laba");
        model.addColumn("Kuantitas");
        model.addColumn("Subtotal");
        
        
        
    }    
    public void tambahKeTabel() {
        JTextComponent[] cekNull = {view.getPembeliField(), view.getProdukField()};        
        try {
            NotNullValidation.validate(cekNull);
        } catch (NullException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Ada Kesalahan!", ERROR_MESSAGE);
            return;

        }
        String namaProduk = view.getNamaProduk();
        int hargaProduk = view.getHargaProduk();
        int labaProduk = view.getLabaProduk();
        int kuantitasProduk = (Integer) view.getKuantitasProduk().getValue();
        int subtotal = kuantitasProduk * hargaProduk;
        
        Object[] hasil = new Object[5];
        
        hasil[0] = namaProduk;
        hasil[1] = IndonesiaCurrency.format(hargaProduk);
        hasil[2] = IndonesiaCurrency.format(labaProduk);
        hasil[3] = kuantitasProduk;
        hasil[4] = IndonesiaCurrency.format(subtotal);
        
        int jumlahRow =   model.getRowCount();
        if(jumlahRow > 0) {
            for(int x = 0; x < jumlahRow; x++) {
                String kolomNamaProduk = tabel.getValueAt(x, 0).toString();
                int kolomHargaProduk = IndonesiaCurrency.formatBack(tabel.getValueAt(x, 1).toString());
                int kolomLabaProduk = IndonesiaCurrency.formatBack(tabel.getValueAt(x, 2).toString());
                int kolomKuantitas = Integer.parseInt(tabel.getValueAt(x, 3).toString());
                int kolomSubtotal = IndonesiaCurrency.formatBack(tabel.getValueAt(x, 4).toString());
                if(kolomNamaProduk.equals(namaProduk) && kolomHargaProduk == hargaProduk && 
                   kolomLabaProduk == labaProduk) {
                    int kolomKuantitasBaru = kolomKuantitas + kuantitasProduk;
                    int kolomSubtotalBaru = kolomSubtotal + subtotal;
                    tabel.setValueAt(kolomKuantitasBaru, x, 3);
                    tabel.setValueAt( IndonesiaCurrency.format(kolomSubtotalBaru),x, 4);
                    
                    int total = 0;
                    int totalLaba = 0;
                    int subtotalBaru = 0;
                    for(int index = 0; index < jumlahRow; index++)  {
                        subtotalBaru = IndonesiaCurrency.formatBack(tabel.getValueAt(index,4).toString());
                        totalLaba += IndonesiaCurrency.formatBack(tabel.getValueAt(index,2).toString()) * 
                                    (Integer) tabel.getValueAt(index,3);
                        total += subtotalBaru;
                    }
                    
                    view.getTotalBayarTF().setText(String.valueOf(total));
                    view.getUangBayarTF().setText(String.valueOf(total));
                    view.getTotalLabaTF().setText(String.valueOf(totalLaba));
                    return;
                 
                }
            }
        }
        model.addRow(hasil);
        int total = 0;
        int subtotalBaru = 0;
        int totalLaba = 0;
        if(Integer.parseInt(view.getTotalBayarTF().getText()) == 0) {
            subtotalBaru = IndonesiaCurrency.formatBack(tabel.getValueAt(0, 4).toString());
            totalLaba = IndonesiaCurrency.formatBack(tabel.getValueAt(0,2).toString()) * 
            (Integer)tabel.getValueAt(0,3);
            total = subtotalBaru;
        } else{
            for(int index = 0; index < model.getRowCount(); index++)  {
                subtotalBaru = IndonesiaCurrency.formatBack(tabel.getValueAt(index,4).toString());
                total += subtotalBaru;
                totalLaba += IndonesiaCurrency.formatBack(tabel.getValueAt(0,2).toString()) * 
            (Integer)tabel.getValueAt(0,3);
            }
            
            
        }
        view.getTotalBayarTF().setText(String.valueOf(total));
        view.getTotalLabaTF().setText(String.valueOf(totalLaba));
        view.getUangBayarTF().setText(String.valueOf(total));
        view.getPilihPelangganBT().setEnabled(false);
        
    }
    
    public void simpan() {
        
        
        // validasi input
        
        JTextComponent[] cekNull = {view.getPembeliField(), view.getProdukField(), view.getTotalBayarTF(), view.getTotalLabaTF(), view.getUangBayarTF()};        
        try {
            NotNullValidation.validate(cekNull);
        } catch (NullException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Ada Kesalahan!", ERROR_MESSAGE);
            return;

        } 
        
       JTextField[] cekAngka = {view.getTotalBayarTF(), view.getTotalLabaTF(), view.getUangBayarTF()};
       
        try {
            new NumbersValidation().validateMany(cekAngka);
        } catch (NotNumbersException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Ada Kesalahan!", ERROR_MESSAGE);
            return;
        }
        
        if(Integer.parseInt(view.getTotalBayarTF().getText()) == 0 || Integer.parseInt(view.getUangBayarTF().getText()) == 0 ||
                Integer.parseInt(view.getTotalLabaTF().getText()) == 0 ) {
            JOptionPane.showMessageDialog(view, "Pastikan semua kolom terisi!", "Ada Kesalahan!", ERROR_MESSAGE);
            return;
            
        }
        
        
        if(Integer.parseInt(view.getUangBayarTF().getText()) < Integer.parseInt(view.getTotalBayarTF().getText())) {
            JOptionPane.showMessageDialog(view, "Uang bayar tidak boleh kurang dari total bayar!", "Ada Kesalahan!", ERROR_MESSAGE);
            return;
    }
        
        // status transaksi
        
        String statusTransaksi = "";
        
        if(LocalDate.now().equals(view.getDatePicker().getDate())) {
            statusTransaksi = "Selesai";
        } else {
            statusTransaksi = "Pending";
        };
        
        String pesanTambahan = "";
        if(statusTransaksi.equals("Pending")) {
           pesanTambahan = "\n\n Transaksi berstatus pending tidak akan dimasukkan ke laporan penjualan hingga ditandai selesai";
        }
       int opsi =  JOptionPane.showConfirmDialog(tabel, "Sudah yakin dengan data yang Anda masukkan? \n\n Status transaksi: " + statusTransaksi + pesanTambahan, "Konfirmasi", YES_NO_OPTION);
       
        if (opsi != YES_OPTION) {
            return;
        }
        
        int jumlahRow =   tabel.getRowCount();
        BuatTransaksiModel transaksiModel = new BuatTransaksiModel();
        
        // tambah buat tabel transaksi
        transaksiModel.setNamaPembeli(view.getNamaPembeli());
        transaksiModel.setNoHpPembeli(view.getNomorPembeli());
        transaksiModel.setAlamatPembeli(view.getAlamatPembeli());
        transaksiModel.setStatus(statusTransaksi);
        transaksiModel.setTenggat(view.getDatePicker().getDate());
        transaksiModel.setTotal(Integer.parseInt(view.getTotalBayarTF().getText()));
        transaksiModel.setTotalLaba(Integer.parseInt(view.getTotalLabaTF().getText()));
        transaksiModel.setUangBayar(Integer.parseInt(view.getUangBayarTF().getText()));
        
        // tambah buat tabel transaksi_detail
        for(int x = 0; x < jumlahRow; x++) {
            String kolomNamaProduk = tabel.getValueAt(x, 0).toString();
            int kolomHargaProduk = IndonesiaCurrency.formatBack(tabel.getValueAt(x, 1).toString());
            int kolomLaba = IndonesiaCurrency.formatBack(tabel.getValueAt(x, 2).toString());
            int kolomKuantitas = (Integer) tabel.getValueAt(x, 3);
            int kolomSubtotal = IndonesiaCurrency.formatBack(tabel.getValueAt(x, 4).toString());
            
            Object[] hasil = new Object[5];
            hasil[0] = kolomNamaProduk;
            hasil[1] = kolomHargaProduk;
            hasil[2] = kolomLaba;
            hasil[3] = kolomKuantitas;
            hasil[4] = kolomSubtotal;
                    
            transaksiModel.getDataTransaksiDetail().add(hasil);           
        }
        
        transaksiModel.simpan();
        bersihkan();
        
        
        
        
    }
    
    public void bersihkan() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        view.setIdPembeli(0);
        view.setNamaPembeli("");
        view.setNomorPembeli("");
        view.setAlamatPembeli("");
        
        view.setIdProduk(0);
        view.setNamaProduk("");
        view.setHargaProduk(0);
        view.setLabaProduk(0);
        
        view.getDatePicker().setDate(LocalDate.now());
        
        view.getPembeliField().setText("");
        view.getProdukField().setText("");
        view.getTotalBayarTF().setText("0");
        view.getTotalLabaTF().setText("0");
        view.getUangBayarTF().setText("0");
        view.getKuantitasProduk().setValue(1);
        view.getPilihPelangganBT().setEnabled(true);
    }
    
    public void batal() {
       bersihkan();
    }
    
}
