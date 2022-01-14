/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.models.AturAkun;

import com.assyifacake.db.KoneksiDatabase;
import static com.assyifacake.db.KoneksiDatabase.getConnection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author EZ-Claim
 */
public class AturAkunModel extends KoneksiDatabase{
    private int id;
    private String nama;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

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
    
    public void setPassword(String password) {
        this.password = password;
    }
    public void ubah() {
        String sql =  "UPDATE user SET nama = '"+getNama()+"', username =  '" +getUsername()+"', password = '" +getPassword()+ "' WHERE id = '" +getId()+"'" ;
            try (Statement stat = (Statement) getConnection().createStatement()) {
                stat.execute(sql);
                JOptionPane.showMessageDialog(null,"Akun Berhasil Diubah");
            } catch (SQLException ex) {
                System.err.print("Gagal Mengeksekusi sql" + ex);
                JOptionPane.showMessageDialog(null,"Akun Gagal Diubah " + ex);
            }
    }
}
