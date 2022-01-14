/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.helpers.validations;

/**
 *
 * @author user
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import static com.assyifacake.db.KoneksiDatabase.getConnection;
import com.assyifacake.helpers.validations.exceptions.LoginInvalidException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author EZ-Claim
 */
public class ValidasiLogin {
    private int id;
    private String nama;
    private String username;
    private String password;

    public ValidasiLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public void validasi() throws LoginInvalidException, SQLException {
            PreparedStatement stmt; 
            stmt = getConnection().prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
            stmt.setString(1, this.username);
            stmt.setString(2, this.password);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                id = rs.getInt("id");
                nama = rs.getString("nama");
                username = rs.getString("username");
                return;
            } else {
            throw new LoginInvalidException();
            }
        }
    
    public Object[] getDataUser(){
        Object[] data = {id, nama, username};
        return data;
    }
}

