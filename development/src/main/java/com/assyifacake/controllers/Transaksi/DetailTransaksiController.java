/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.controllers.Transaksi;

import static com.assyifacake.db.KoneksiDatabase.getConnection;
import com.assyifacake.helpers.formats.IndonesiaDateFormat;
import com.assyifacake.utils.IndonesiaCurrency;
import com.assyifacake.utils.StrukGenerator;
import com.assyifacake.views.Transaksi.DetailTransaksiInternalView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import static javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class DetailTransaksiController {
    
    JTable tabel;
    DefaultTableModel tabelModel;
    String statusTransaksi = "";
    
    DetailTransaksiInternalView view;
    public DetailTransaksiController(DetailTransaksiInternalView view) {
        this.view = view;
        this.tabel = view.getTabel();
        
    }
    
    public void myComponents() {
        
        // edit tabel biar enak
        view.getTandaiSelesaiBT().setEnabled(false);
        tabelModel = new DefaultTableModel();
        tabel.setModel(tabelModel);
        view.getjScrollPane1().setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tabel.setAutoResizeMode(AUTO_RESIZE_OFF);
        tabel.setSelectionMode(SINGLE_INTERVAL_SELECTION);
        tabel.getTableHeader().setReorderingAllowed(false);
        
        // tambahin kolom
        tabelModel.addColumn("ID Transaksi");
        tabelModel.addColumn("Nama Produk");
        tabelModel.addColumn("Harga");
        tabelModel.addColumn("Laba");
        tabelModel.addColumn("Kuantitas");
        tabelModel.addColumn("Subtotal");
        tabelModel.addColumn("Nama Pembeli");
        tabelModel.addColumn("No HP");
        tabelModel.addColumn("Alamat");
        tabelModel.addColumn("Total");
        tabelModel.addColumn("Kembalian");
        tabelModel.addColumn("Total Laba");
        tabelModel.addColumn("Tenggat");
        tabelModel.addColumn("Tanggal Transaksi");
        view.getSelesaiRB().setSelected(true);
        String sql = "SELECT transaksi.id, transaksi_detail.nama_produk, transaksi_detail.harga_produk, transaksi_detail.laba_produk, "
                + "transaksi_detail.kuantitas, transaksi_detail.subtotal, transaksi.nama_pembeli, transaksi.no_hp_pembeli, transaksi.alamat, transaksi.total, transaksi.uang_bayar,"
                + "transaksi.total_laba, transaksi.tenggat, transaksi.status, transaksi.tanggal_transaksi FROM transaksi "
                + "INNER JOIN transaksi_detail on (transaksi_detail.id_transaksi = transaksi.id) WHERE transaksi.status = 'Selesai' ORDER BY transaksi.created_at DESC";
        
        tampilDataTabel(sql);
    }
    
    public void tampilDataTabel(String sql) {
        tabelModel.getDataVector().removeAllElements();
        tabelModel.fireTableDataChanged();
        
         SwingWorker<String, Object[]> thread;
        thread = new SwingWorker<>() {
            @Override
            protected String doInBackground() throws Exception {
                Statement stat = null;
                Connection conn = null;
                ResultSet rs = null;

                try {
                    conn = getConnection();
                    stat = conn.createStatement();
                    rs = stat.executeQuery(sql);

                    while(rs.next()) {
                        Object[] hasil = new Object[14];
                        hasil[0] = rs.getInt("transaksi.id");
                        hasil[1] = rs.getString("transaksi_detail.nama_produk");
                        hasil[2] = IndonesiaCurrency.format(rs.getInt("transaksi_detail.harga_produk"));
                        hasil[3] = IndonesiaCurrency.format(rs.getInt("transaksi_detail.laba_produk"));
                        hasil[4] = rs.getInt("transaksi_detail.kuantitas");
                        hasil[5] = IndonesiaCurrency.format(rs.getInt("transaksi_detail.subtotal"));
                        hasil[6] = rs.getString("transaksi.nama_pembeli");
                        hasil[7] = rs.getString("transaksi.no_hp_pembeli");
                        hasil[8] = rs.getString("transaksi.alamat");
                        hasil[9] = IndonesiaCurrency.format(rs.getInt("transaksi.total"));
                        hasil[10] = IndonesiaCurrency.format((rs.getInt("transaksi.uang_bayar") - rs.getInt("transaksi.total")));
                        hasil[11] = IndonesiaCurrency.format(rs.getInt("transaksi.total_laba"));
                        hasil[12] = IndonesiaDateFormat.format( rs.getString("transaksi.tenggat"));
                        hasil[13] = IndonesiaDateFormat.format(rs.getString("transaksi.tanggal_transaksi"));
                        publish(hasil);
                        statusTransaksi = rs.getString("transaksi.status");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(DetailTransaksiController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        conn.close();
                        rs.close();
                        stat.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DetailTransaksiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        return "Selesai";
            }
            
            @Override
            protected void process(List<Object[]> chunks) {
                for(Object[] chunk : chunks) {
                tabelModel.addRow(chunk);                    
                }
            }
 };
        thread.execute();
        
    }
    
    public void hapus() {
        try {
            cekApakahBelumDiSelect();
        } catch (Exception ex) {
            return;
        }
        int hasil = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus transaksi ini?", "Peringatan!",YES_NO_OPTION, WARNING_MESSAGE);
        
        if(hasil != YES_OPTION) {
            return;
        }
        
        int rowSelected = tabel.getSelectedRow();
        int idTerhapus = (Integer) tabelModel.getValueAt(rowSelected, 0);
        
        Statement stat = null;
        Connection conn = null;
        String sql = "DELETE FROM transaksi WHERE id = " + idTerhapus;
        try {
            conn = getConnection();
            stat = conn.createStatement();
            stat.execute(sql);
            
            JOptionPane.showMessageDialog(view, "Data berhasil dihapus");
            sql = "SELECT transaksi.id, transaksi_detail.nama_produk, transaksi_detail.harga_produk, transaksi_detail.laba_produk, "
                + "transaksi_detail.kuantitas, transaksi_detail.subtotal, transaksi.nama_pembeli, transaksi.no_hp_pembeli, transaksi.alamat, transaksi.total, transaksi.uang_bayar,"
                + "transaksi.total_laba, transaksi.tenggat, transaksi.status, transaksi.tanggal_transaksi FROM transaksi "
                + "INNER JOIN transaksi_detail on (transaksi_detail.id_transaksi = transaksi.id) ORDER BY transaksi.created_at DESC";
            tampilDataTabel(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Ada Kesalahan!", ERROR_MESSAGE);
        } finally {
            try {
                conn.close();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(DetailTransaksiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void tandaiSelesai() {
        try {
            cekApakahBelumDiSelect();
        } catch (Exception ex) {
            return;
        }
        int hasil = JOptionPane.showConfirmDialog(view, "Yakin ingin menyelesaikan transaksi ini?", "Peringatan!",YES_NO_OPTION, QUESTION_MESSAGE);
        
        if(hasil != YES_OPTION) {
            return;
        }
        
        int rowSelected = tabel.getSelectedRow();
        int idSelesai = (Integer) tabelModel.getValueAt(rowSelected, 0);
        
        Statement stat = null;
        Connection conn = null;
        String sql = "UPDATE transaksi set status = 'Selesai' WHERE id = " + idSelesai;
        try {
            conn = getConnection();
            stat = conn.createStatement();
            stat.execute(sql);
            
            JOptionPane.showMessageDialog(view, "Data berhasil diperbarui!");
            sql = "SELECT transaksi.id, transaksi_detail.nama_produk, transaksi_detail.harga_produk, transaksi_detail.laba_produk, "
                + "transaksi_detail.kuantitas, transaksi_detail.subtotal,transaksi.status, transaksi.nama_pembeli, transaksi.no_hp_pembeli, transaksi.alamat, transaksi.total, transaksi.uang_bayar,"
                + "transaksi.total_laba, transaksi.tenggat, transaksi.tanggal_transaksi FROM transaksi "
                + "INNER JOIN transaksi_detail on (transaksi_detail.id_transaksi = transaksi.id) WHERE transaksi.status = 'Pending' ORDER BY transaksi.created_at DESC";
            tampilDataTabel(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Ada Kesalahan!", ERROR_MESSAGE);
        } finally {
            try {
                conn.close();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(DetailTransaksiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void cekApakahBelumDiSelect() throws Exception {
        if(tabel.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(view, "Anda harus pilih baris di tabel dulu!", "Ada Kesalahan!", WARNING_MESSAGE);
            throw new Exception();
        };
    }
    
    public void printStruk() {
        
        try {
            cekApakahBelumDiSelect();
        } catch (Exception ex) {
            return;
        }
        int rowDiambil = tabel.getSelectedRow();
        int idDiambil = (Integer) tabelModel.getValueAt(rowDiambil, 0);
        int totalDiambil = IndonesiaCurrency.formatBack(tabelModel.getValueAt(rowDiambil, 9).toString());
        int kembalian = IndonesiaCurrency.formatBack(tabelModel.getValueAt(rowDiambil, 10).toString());
        int uangBayar = totalDiambil + kembalian;
        int jumlahRow =  tabelModel.getRowCount();
        
        ArrayList<String[]> detailProduk = new ArrayList<>();
        
        for(int x = rowDiambil; x < jumlahRow; x++) {
            if((Integer) tabel.getValueAt(x, 0) == idDiambil) {
                String[] data = new String[4];
                String kolomNamaProduk = tabel.getValueAt(x, 1).toString();
                String kolomHargaProduk = tabel.getValueAt(x, 2).toString();
                String kolomKuantitas = tabel.getValueAt(x, 4).toString();
                String kolomSubtotal = tabel.getValueAt(x, 5).toString();
                data[0] = kolomNamaProduk;
                data[1] = kolomHargaProduk;
                data[2] = kolomKuantitas;
                data[3] = kolomSubtotal;  
                detailProduk.add(data);
                continue;
            }
            if((Integer) tabel.getValueAt(x, 0) != idDiambil) {
                break;
            }
        }
        
        StrukGenerator strukGenerator = new StrukGenerator(detailProduk, totalDiambil, uangBayar, kembalian, statusTransaksi, idDiambil);
        strukGenerator.print();
        
        
    }
    
}
