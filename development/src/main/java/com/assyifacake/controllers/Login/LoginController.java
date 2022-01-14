/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.controllers.Login;

import com.assyifacake.helpers.validations.ValidasiLogin;
import com.assyifacake.helpers.validations.exceptions.LoginInvalidException;
import com.assyifacake.views.Login.LoginView;
import com.assyifacake.views.MenuUtama.MenuUtamaView;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 *
 * @author EZ-Claim
 */
public class LoginController {
    private Object[] data;
    
    private static LoginController singleInstance = null;
    public static LoginController getInstance(){
        if (singleInstance == null)
            singleInstance = new LoginController();
 
        return singleInstance;
    }

    public Object[] getData() {
        return data;
    }
    
    
    public void cekLogin(LoginView vL) {   
        String username = vL.getUsernameTF().getText() ;
        String password = vL.getPassTF().getText();       
        ValidasiLogin vLO = new ValidasiLogin(username, password);
        
        if(username.isEmpty() || password.isEmpty() ) {
            JOptionPane.showMessageDialog(vL, "Kolom username dan password harus diisi", "Eror Login", WARNING_MESSAGE);
            return;
        }
            try {
                vLO.validasi();                  
               } catch(SQLException ex) {
                    if(ex.getErrorCode() == 0) {
                        JOptionPane.showMessageDialog(vL, "MySQL belum dinyalakan", "Eror Login", ERROR_MESSAGE);
                   } else {
                        JOptionPane.showMessageDialog(vL, ex.getMessage(), "Eror Login", ERROR_MESSAGE);                       
                   }
                    return;
               } catch (LoginInvalidException ex) {
                    JOptionPane.showMessageDialog(vL, ex.getMessage(), "Eror Login", ERROR_MESSAGE);
                    return;
        }
           this.data = vLO.getDataUser();

           MenuUtamaView mU = new MenuUtamaView();
           
           
           
//           LoginController cL = LoginController.getInstance();
//           cL.setHakAkses(vLO.getHakAkses());
//           if(cL.getHakAkses().equals("Admin")) {
//                mU.getUsernameTF().setText("Admin");
//           } else if(cL.getHakAkses().equals("Pengguna")){
//               mU.getUsernameTF().setText("Pengguna");
//           }
           mU.setVisible(true);
           vL.dispose();
        }
}
