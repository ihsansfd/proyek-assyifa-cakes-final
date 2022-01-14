/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.models.Resep;

import static com.assyifacake.db.KoneksiDatabase.getConnection;
import com.assyifacake.helpers.formats.MySqlDateTimeFormat;
import com.assyifacake.models.KontrakCRUDModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author EZ-Claim
 */
public class AturResepModel implements KontrakCRUDModel{
    private String id = "";
    private String nama  = "";
    private String bahan  = "";
    private String langkah  = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public String getLangkah() {
        return langkah;
    }

    public void setLangkah(String langkah) {
        this.langkah = langkah;
    }

    @Override
    public void simpan() {
        String sql =  "INSERT INTO resep(id_produk, bahan_bahan, cara_pembuatan) VALUES ('"+getId()+"','"+getBahan()+"','"+getLangkah()+"')";
        Connection conn = null;
        Statement stat = null;
        try {
            conn = getConnection();
            stat = (Statement) conn.createStatement();
            stat.execute(sql);
            JOptionPane.showMessageDialog(null,"Resep berhasil disimpan");
        } catch (SQLException ex) {
            System.err.print("Gagal Mengeksekusi sql" + ex);
            JOptionPane.showMessageDialog(null,"Resep gagal disimpan" + ex.getMessage());

        } finally {
            try {
                conn.close();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(AturResepModel.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
    }

    @Override
    public void ubah() {
        String sql =  "UPDATE resep SET bahan_bahan = '"+getBahan()+ "', cara_pembuatan= '"+getLangkah()+"', updated_at = '"+MySqlDateTimeFormat.now()+"' WHERE id_produk = '" +getId()+"'" ;
        Connection conn = null;
        Statement stat = null;
            try {
                conn = getConnection();
                stat = conn.createStatement();
                stat.execute(sql);
                JOptionPane.showMessageDialog(null,"Resep Berhasil Diubah");
            } catch (SQLException ex) {
            Logger.getLogger(AturResepModel.class.getName()).log(Level.SEVERE, null, "UPDATE ERROR");
        } finally {
            try {
                conn.close();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(AturResepModel.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
    }

    @Override
    public void hapus() {
        String sql = "DELETE FROM resep WHERE id_produk = '"+getId()+"'";
        Connection conn = null;
        Statement stat = null;
            try {
                conn = getConnection();
                stat = conn.createStatement();
                stat.execute(sql);
                JOptionPane.showMessageDialog(null,"Resep Berhasil Dihapus");
            } catch (SQLException ex) {
                System.err.print("Gagal Mengeksekusi sql" + ex);
                JOptionPane.showMessageDialog(null,"Resep Gagal Dihapus" + ex);

            } finally {
            try {
                conn.close();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(AturResepModel.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
    }
    
}
