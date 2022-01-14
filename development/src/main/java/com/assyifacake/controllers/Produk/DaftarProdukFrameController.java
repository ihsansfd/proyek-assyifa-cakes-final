/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.controllers.Produk;

import com.assyifacake.controllers.KontrakFrameTransaksi;
import static com.assyifacake.db.KoneksiDatabase.getConnection;
import com.assyifacake.helpers.validations.NumbersValidation;
import com.assyifacake.utils.ByteToIcon;
import com.assyifacake.utils.IndonesiaCurrency;
import com.assyifacake.utils.OnChangeListener;
import com.assyifacake.views.DaftarPembeli.DaftarPembeliFrameView;
import com.assyifacake.views.Produk.DaftarProdukFrameView;
import com.assyifacake.views.Resep.AturResepInternalView;
import com.assyifacake.views.Transaksi.BuatTransaksiInternalView;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import javax.swing.JTextField;
import static javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION;
import javax.swing.SwingWorker;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class DaftarProdukFrameController implements KontrakFrameTransaksi {

    private DaftarProdukFrameView view;
    JTable tabel;
    JTextField search;
    DefaultTableModel tabelModel =  new DefaultTableModel(){
            @Override
        public Class<?> getColumnClass(int column) {
                switch(column) {
                case 4: return ImageIcon.class;
                default: return Object.class;
                }
            }
        };
    
    private SwingWorker<String, Object[]> thread;
    
    public DaftarProdukFrameController(DaftarProdukFrameView view) {
        this.view = view;
        this.tabel = view.getTabel();
        this.search = view.getSearch();
    }
    
    @Override
    public void myComponents() {
        tabel.setModel(tabelModel);
        tabel.setSelectionMode(SINGLE_INTERVAL_SELECTION);
        tabel.getTableHeader().setReorderingAllowed(false);
        tabelModel.addColumn("ID");
        tabelModel.addColumn("Nama Produk");
        tabelModel.addColumn("Harga");
        tabelModel.addColumn("Laba");
        tabelModel.addColumn("Gambar");
        tabel.setAutoResizeMode(AUTO_RESIZE_OFF);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(111);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(111);
        tabel.getColumnModel().getColumn(2).setPreferredWidth(110);
        tabel.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabel.setModel(tabelModel);
        //register event search
        search();
        
        String sql = "SELECT * FROM produk ORDER BY updated_at DESC";
        tampilDataTabel(sql);
    }

    @Override
    public void search() {
        OnChangeListener.addChangeListener(search, new ChangeListener() {
           @Override
           public void stateChanged(ChangeEvent e) {
               String ketikan = search.getText();
               String sql = "";
               if(new NumbersValidation().check(ketikan)) {
                   sql = "SELECT * FROM produk WHERE nama LIKE '%"+ketikan+"%' OR id = "+Integer.parseInt(ketikan)+" ORDER BY updated_at DESC";
               } else {
                   sql = "SELECT * FROM produk WHERE nama LIKE '%"+ketikan+"%' ORDER BY updated_at DESC";                   
               }
               
               tampilDataTabel(sql);
           }
           
       });
    }

    public void tampilDataTabel(String sql) {
        tabelModel.getDataVector().removeAllElements();
        tabelModel.fireTableDataChanged();
        
        // interrupt klo msh jalan
        if(thread != null) {
            thread.cancel(true);            
        }
        thread = new SwingWorker<>() {
            @Override
            protected String doInBackground() throws Exception {
                Connection conn = null;
        ResultSet rs = null;
        Statement stat = null;

        try {
            conn = getConnection();

            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            while(rs.next()) {
                if(isCancelled()) {
//                    System.out.println("canceled");
                    return "Canceled";
                }
                Object[] hasil = new Object[5];
                hasil[0] = rs.getInt("id");
                hasil[1] = rs.getString("nama");
                String hargaDalamIndo = IndonesiaCurrency.format(rs.getInt("harga"));
                String labaDalamIndo = IndonesiaCurrency.format(rs.getInt("laba"));
                hasil[2] = hargaDalamIndo;
                hasil[3] = labaDalamIndo;
                ImageIcon icon = null;
                int width = 80;
                int height = 50;
                if(rs.getBytes("gambar") == null) {
                    icon = new ImageIcon(getClass().getResource("/img/defaultImage.png"));
                } else {
                    icon = ByteToIcon.decode(rs.getBytes("gambar"));
                }
                Image resizedImage = icon.getImage().getScaledInstance(width, height, SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);
                
                hasil[4] = resizedIcon;
                if(isCancelled()) {
//                    System.out.println("canceled");
                    return "Canceled";
                }
                publish(hasil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaftarPembeliFrameView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
                rs.close();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaftarPembeliFrameView.class.getName()).log(Level.SEVERE, null, ex);
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
        
//        tabelModel.getDataVector().removeAllElements();
//        tabelModel.fireTableDataChanged();
//        Connection conn = null;
//        ResultSet rs = null;
//        Statement stat = null;
//
//        try {
//            conn = getConnection();
//
//            stat = conn.createStatement();
//            rs = stat.executeQuery(sql);
//
//            while(rs.next()) {
//                Object[] hasil = new Object[5];
//                hasil[0] = rs.getInt("id");
//                hasil[1] = rs.getString("nama");
//                String hargaDalamIndo = IndonesiaCurrency.format(rs.getInt("harga"));
//                String labaDalamIndo = IndonesiaCurrency.format(rs.getInt("laba"));
//                hasil[2] = hargaDalamIndo;
//                hasil[3] = labaDalamIndo;
//                ImageIcon icon = null;
//                int width = 80;
//                int height = 50;
//                if(rs.getBytes("gambar") == null) {
//                    icon = new ImageIcon(getClass().getResource("/img/defaultImage.png"));
//                } else {
//                    icon = ByteToIcon.decode(rs.getBytes("gambar"));
//                }
//                Image resizedImage = icon.getImage().getScaledInstance(width, height, SCALE_SMOOTH);
//                ImageIcon resizedIcon = new ImageIcon(resizedImage);
//                hasil[4] = resizedIcon;
//
//                tabelModel.addRow(hasil);
//            }
//
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DaftarPembeliFrameView.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                conn.close();
//                rs.close();
//                stat.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(DaftarPembeliFrameView.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }
    
    public void ambilDataTabel(BuatTransaksiInternalView transaksiView) {
       
        int ambilRow = tabel.getSelectedRow();
        String dataProduk = tabel.getValueAt(ambilRow, 1) + " (" + tabel.getValueAt(ambilRow, 2) +")";
        transaksiView.setNamaProduk((String) tabel.getValueAt(ambilRow, 1));
        transaksiView.setHargaProduk(IndonesiaCurrency.formatBack((String) tabel.getValueAt(ambilRow, 2)));
        transaksiView.setLabaProduk(IndonesiaCurrency.formatBack((String) tabel.getValueAt(ambilRow, 3)));
        transaksiView.getProdukField().setText(dataProduk);
        view.dispose();
    }
    
    public void ambilDataTabel(AturResepInternalView resepView) {
       int ambilRow = tabel.getSelectedRow();
        String id = String.valueOf(tabel.getValueAt(ambilRow, 0));
        String produk = String.valueOf(tabel.getValueAt(ambilRow, 1));       
        resepView.setIdProduk(id);
        resepView.getNamaProdukTF().setText(produk);
        view.dispose();
    }
    
}
