/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake;

import com.assyifacake.views.Login.LoginView;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author user
 */
public class App {
    public static void main(String[] args) {
        try {
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
            
            new LoginView().setVisible(true);
        }
        } catch (Exception e) {
        // If Nimbus is not available, you can set the GUI to another look and feel.
        }
    }
}
