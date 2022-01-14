/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.models.Produk;

import static com.assyifacake.db.KoneksiDatabase.getConnection;
import com.assyifacake.helpers.formats.MySqlDateTimeFormat;
import com.assyifacake.models.KontrakCRUDModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author user
 */
public class AturProdukModel implements KontrakCRUDModel {

    private int id = 0;
    private String nama  = "";
    private String harga = "";
    private String laba = "";
    private byte[] gambar = null; 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getLaba() {
        return laba;
    }

    public void setLaba(String laba) {
        this.laba = laba;
    }

    public byte[] getGambar() {
        return gambar;
    }

    public void setGambar(byte[] gambar) {
        this.gambar = gambar;
    }
   
    @Override
    public void simpan() {
        String sql =  "INSERT INTO produk (nama, gambar, harga, laba) VALUES (?,?,?,?)";
        PreparedStatement stat = null;
        Connection conn = null;
        try {
            conn = getConnection();
            stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setBytes(2, gambar);
            stat.setInt(3, Integer.parseInt(harga));
            stat.setInt(4, Integer.parseInt(laba));            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
        } catch (SQLException ex) {
            System.err.print("gagal mengeksekusi sql" + ex);
            JOptionPane.showMessageDialog(null,"Data gagal disimpan" + ex);

        } finally {
            try {
                conn.close();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(AturProdukModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void hapus() {
        String sql = "DELETE FROM produk WHERE id = " +id;
        Statement stat = null;
        Connection conn = null;
        try {
            stat = getConnection().createStatement();
            stat.execute(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Data gagal dihapus" + ex, "Ada Kesalahan", ERROR_MESSAGE );
        } finally {
          try {
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(AturProdukModel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        
    }

    @Override
    public void ubah() {
        
        PreparedStatement stat = null;
        Connection conn = null;
        if(gambar == null) {
            String sql =  "UPDATE produk SET nama = ?, harga = ?, laba = ?, updated_at = ? WHERE id = " +id ;
            try {
                conn = getConnection();
                stat = conn.prepareStatement(sql);
                stat.setString(1, nama);
                stat.setInt(2, Integer.parseInt(harga));
                stat.setInt(3, Integer.parseInt(laba));
                stat.setString(4, MySqlDateTimeFormat.now());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data berhasil diubah ");
            } catch (SQLException ex) {
                System.err.print("gagal mengeksekusi sql" + ex);
                JOptionPane.showMessageDialog(null,"Data gagal diubah " + ex);
            } finally {
                try {
                    conn.close();
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AturProdukModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            String sql =  "UPDATE produk SET nama = ?, harga = ?, laba = ?, gambar = ?, updated_at = ? WHERE id = " +id ;
            try {
                conn = getConnection();
                stat = conn.prepareStatement(sql);
                stat.setString(1, nama);
                stat.setInt(2, Integer.parseInt(harga));
                stat.setInt(3, Integer.parseInt(laba));
                stat.setBytes(4, gambar);
                stat.setString(5, MySqlDateTimeFormat.now());
                JOptionPane.showMessageDialog(null,"Data berhasil diubah ");
                stat.executeUpdate();
            } catch (SQLException ex) {
                System.err.print("gagal mengeksekusi sql" + ex);
                JOptionPane.showMessageDialog(null,"Data gagal diubah " + ex);
            } finally {
                try {
                    conn.close();
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AturProdukModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
    
}
