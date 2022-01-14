/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.models.DaftarPembeli;

import static com.assyifacake.db.KoneksiDatabase.getConnection;
import com.assyifacake.helpers.formats.MySqlDateTimeFormat;
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
public class PembeliModel {
    private int id;
    private String nama;
    private String noHP;
    private String alamat;

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

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void simpan() {
        String sql =  "INSERT INTO pembeli(nama, no_hp, alamat) VALUES ('" +getNama()+"','"+getNoHP()+"','"+getAlamat()+"')";   
        
        Connection conn = null;
        Statement stat = null;
        try {
            conn = getConnection();
            stat = conn.createStatement();
            stat.execute(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
        } catch (SQLException ex) {
            System.err.print("Gagal Mengeksekusi sql" + ex);
            JOptionPane.showMessageDialog(null,"Data gagal disimpan" + ex);

        } finally {
            try {
                conn.close();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(PembeliModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void hapus() {
        String sql = "DELETE FROM pembeli WHERE id = '"+getId()+"'";
        Connection conn = null;
        Statement stat = null;
        try {
            conn = getConnection();
            stat = conn.createStatement();
            stat.execute(sql);
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
            } catch (SQLException ex) {
                System.err.print("Gagal Mengeksekusi sql" + ex);
                JOptionPane.showMessageDialog(null,"Data Gagal Dihapus" + ex);

            } finally {
            try {
                conn.close();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(PembeliModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void ubah() {
        String sql =  "UPDATE pembeli SET nama =  '" +getNama()+"', no_hp = '" +getNoHP()+ "', alamat = '"+getAlamat()+ "', updated_at = '"
                +MySqlDateTimeFormat.now()+ "' WHERE id = '" +getId()+"'" ;
        Connection conn = null;
        Statement stat = null;
        try {
            conn = getConnection();
            stat = conn.createStatement();
            stat.execute(sql);
                JOptionPane.showMessageDialog(null,"Data Berhasil Diubah");
            } catch (SQLException ex) {
                System.err.print("Gagal Mengeksekusi sql" + ex);
                JOptionPane.showMessageDialog(null,"Data Gagal Diubah " + ex);

            } finally {
            try {
                conn.close();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(PembeliModel.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
}
