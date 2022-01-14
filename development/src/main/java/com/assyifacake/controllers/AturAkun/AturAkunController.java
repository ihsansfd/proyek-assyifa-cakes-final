/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.controllers.AturAkun;

import com.assyifacake.controllers.Login.LoginController;
import com.assyifacake.helpers.validations.NotNullValidation;
import com.assyifacake.helpers.validations.exceptions.NullException;
import com.assyifacake.models.AturAkun.AturAkunModel;
import com.assyifacake.views.AturAkun.AturAkunView;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.text.JTextComponent;

/**
 *
 * @author EZ-Claim
 */
public class AturAkunController {
    
    private AturAkunModel mA;
    private AturAkunView vA;
    private int idUser;
    
    public AturAkunController (AturAkunView vA){
        this.vA = vA;
        Object[] data = LoginController.getInstance().getData();
        idUser = (int) data[0];
        vA.getNamaTF().setText((String) data[1]);
        vA.getUsernameTF().setText((String) data[2]);
    }
    
    public void ubah() {
        
        mA = new AturAkunModel();
        //mA.setId(vA.getIdLB().getText());
        mA.setId(idUser);
        JTextComponent[] cekNull = {vA.getNamaTF(), vA.getUsernameTF(), vA.getPasswordTF()};
        try {
            NotNullValidation.validate(cekNull);
        } catch (NullException ex) {
            JOptionPane.showMessageDialog(vA, ex.getMessage(), "Ada Kesalahan!", WARNING_MESSAGE);
            return;
        }
        
        if(!vA.getPasswordTF().getText().equals(vA.getKonfirmasiPasswordTF().getText())) {
            JOptionPane.showMessageDialog(vA, "Password dan konfirmasi password tidak sama", "Ada Kesalahan!", WARNING_MESSAGE);
            return;
        }
        
        mA.setNama(vA.getNamaTF().getText());
        mA.setUsername(vA.getUsernameTF().getText());
        mA.setPassword(vA.getPasswordTF().getText());
        int opsi = JOptionPane.showConfirmDialog(vA, String.format("Nama : %s \n "
                                                        + "Username: %s \n"
                                                        + "Password : %s \n",
                mA.getNama(), mA.getUsername(), mA.getPassword()),"Apakah sudah benar?",JOptionPane.YES_NO_OPTION);
         if (opsi == JOptionPane.YES_OPTION) {
            mA.ubah();
        } else {
            return;
        }
         
        vA.getNamaTF().setEnabled(false);
        vA.getUsernameTF().setEnabled(false);
        vA.getPasswordTF().setEnabled(false);
        vA.getKonfirmasiPasswordTF().setEnabled(false);
        vA.getAturBT().setEnabled(true);
        vA.getSimpanBT().setEnabled(false);
    }
}
