/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.models.Transaksi;

import static com.assyifacake.db.KoneksiDatabase.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 *
 * @author user
 */
public class BuatTransaksiModel {
    
    // data tabel transaksi
    public int idTransaksi;
    
    public int total;
    public int uangBayar;
    public int totalLaba;
    public LocalDate tenggat;
    public String namaPembeli;
    public String noHpPembeli;
    public String alamatPembeli;
    public String status;
    
    // data tabel transaksi_detail
    ArrayList<Object[]> dataTransaksiDetail = new ArrayList<Object[]>(); 

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getUangBayar() {
        return uangBayar;
    }

    public void setUangBayar(int uangBayar) {
        this.uangBayar = uangBayar;
    }

    public int getTotalLaba() {
        return totalLaba;
    }

    public void setTotalLaba(int totalLaba) {
        this.totalLaba = totalLaba;
    }

    public LocalDate getTenggat() {
        return tenggat;
    }

    public void setTenggat(LocalDate tenggat) {
        this.tenggat = tenggat;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public String getNoHpPembeli() {
        return noHpPembeli;
    }

    public void setNoHpPembeli(String noHpPembeli) {
        this.noHpPembeli = noHpPembeli;
    }

    public String getAlamatPembeli() {
        return alamatPembeli;
    }

    public void setAlamatPembeli(String alamatPembeli) {
        this.alamatPembeli = alamatPembeli;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Object[]> getDataTransaksiDetail() {
        return dataTransaksiDetail;
    }

    public void setDataTransaksiDetail(ArrayList<Object[]> dataTransaksiDetail) {
        this.dataTransaksiDetail = dataTransaksiDetail;
    }
    
    public void simpan() {
        
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        String sql = "";
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            sql = "INSERT INTO transaksi (total,uang_bayar,total_laba,tenggat,nama_pembeli,no_hp_pembeli,alamat,status) VALUES (?,?,?,?,?,?,?,?)";
            stat = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1, total);
            stat.setInt(2, uangBayar);
            stat.setInt(3, totalLaba);
            stat.setString(4, tenggat.toString());
            stat.setString(5, namaPembeli);
            stat.setString(6, noHpPembeli);
            stat.setString(7, alamatPembeli);
            stat.setString(8, status);
            
            stat.executeUpdate();
            rs = stat.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            this.setIdTransaksi(id);
            
            sql = "INSERT INTO transaksi_detail (id_transaksi,nama_produk, harga_produk, laba_produk, kuantitas, subtotal) VALUES (?,?,?,?,?,?)";
            
            for(Object[] data: dataTransaksiDetail) {
                String namaProduk = (String) data[0];
                int hargaProduk = (Integer) data[1];
                int labaProduk = (Integer) data[2];
                int kuantitasProduk = (Integer) data[3];
                int subtotalProduk = (Integer) data[4];
                
                stat = conn.prepareStatement(sql);
                stat.setInt(1, idTransaksi);
                stat.setString(2, namaProduk);
                stat.setInt(3, hargaProduk);
                stat.setInt(4, labaProduk);
                stat.setInt(5, kuantitasProduk);
                stat.setInt(6, subtotalProduk);
                
                stat.executeUpdate();
                
            }
            
            conn.commit();
            
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");    
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(BuatTransaksiModel.class.getName()).log(Level.SEVERE, null, ex1);
            }
            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan: " + ex.getMessage(), "Ada Kesalahan!", WARNING_MESSAGE);
            Logger.getLogger(BuatTransaksiModel.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            try {
                conn.close();
                rs.close();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(BuatTransaksiModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
