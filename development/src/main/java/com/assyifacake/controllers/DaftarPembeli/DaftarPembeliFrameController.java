/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.controllers.DaftarPembeli;

import com.assyifacake.controllers.KontrakFrameTransaksi;
import static com.assyifacake.db.KoneksiDatabase.getConnection;
import com.assyifacake.helpers.validations.NumbersValidation;
import com.assyifacake.utils.OnChangeListener;
import com.assyifacake.views.DaftarPembeli.DaftarPembeliFrameView;
import com.assyifacake.views.Transaksi.BuatTransaksiInternalView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
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
public class DaftarPembeliFrameController implements KontrakFrameTransaksi {
    
    DaftarPembeliFrameView view;
    JTable tabel;
    JTextField search;
    DefaultTableModel tabelModel = new DefaultTableModel();
    SwingWorker<String, Object[]> thread;

    public DaftarPembeliFrameController(DaftarPembeliFrameView view) {
        this.view = view;
        this.tabel = view.getTabel();
        this.search = view.getSearch();
    }
    
    @Override
    public void myComponents() {
        tabel.setModel(tabelModel);
        tabel.setSelectionMode(SINGLE_INTERVAL_SELECTION);
        tabel.getTableHeader().setReorderingAllowed(false);
        tabelModel.addColumn("Nama Pembeli");
        tabelModel.addColumn("Telepon");
        tabelModel.addColumn("Alamat");
        tabel.setModel(tabelModel);
        //register event search
        search();
        
        String sql = "SELECT * FROM pembeli ORDER BY updated_at DESC";
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
                   sql = "SELECT * FROM pembeli WHERE nama LIKE '%"+ketikan+"%' OR id = "+Integer.parseInt(ketikan)+" ORDER BY updated_at DESC";
               } else {
                   sql = "SELECT * FROM pembeli WHERE nama LIKE '%"+ketikan+"%' ORDER BY updated_at DESC";                   
               }
               
               tampilDataTabel(sql);
           }
           
       });
    }
    
    public void tampilDataTabel(String sql) {
        tabelModel.getDataVector().removeAllElements();
        tabelModel.fireTableDataChanged();
        
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
                    return "Canceled";
                }
                Object[] hasil = new Object[3];
                hasil[0] = rs.getString("nama");
                hasil[1] = rs.getString("no_hp");
                hasil[2] = rs.getString("alamat");
                if(isCancelled()) {
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
    }
    
    public void ambilDataTabel(BuatTransaksiInternalView transaksiView) {
        
        int ambilRow = tabel.getSelectedRow();
        String dataPembeli = tabel.getValueAt(ambilRow, 0) + " (" + tabel.getValueAt(ambilRow, 1) +")" + "\n" +
                             tabel.getValueAt(ambilRow, 2);
        
        transaksiView.setNamaPembeli((String) tabel.getValueAt(ambilRow, 0));
        transaksiView.setNomorPembeli((String) tabel.getValueAt(ambilRow, 1));
        transaksiView.setAlamatPembeli((String) tabel.getValueAt(ambilRow, 2));
        transaksiView.getPembeliField().setText(dataPembeli);
       
        view.dispose();
        
    }
}
 