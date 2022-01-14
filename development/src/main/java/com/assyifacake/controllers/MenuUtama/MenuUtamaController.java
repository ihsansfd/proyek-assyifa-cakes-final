/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.controllers.MenuUtama;

import com.assyifacake.App;
import com.assyifacake.controllers.Login.LoginController;
import com.assyifacake.views.MenuUtama.MenuUtamaView;
import com.assyifacake.views.Produk.LihatProdukInternalView;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author user
 */
public class MenuUtamaController {
    
    private MenuUtamaView view;
    private JDesktopPane panel;
    
    public MenuUtamaController(MenuUtamaView view) {
        this.view = view;
        this.panel = this.view.getPanel();
    }
    
    public void startAwal() {
       // set icon aplikasi
       
       view.setIconImage(new ImageIcon(getClass().getResource("/img/logo_homemade-icon.png")).getImage());
        
       String nama =  (String) LoginController.getInstance().getData()[1];
       view.getUsernameTF().setText(nama.split(" ")[0]);
       LihatProdukInternalView lpiv = new LihatProdukInternalView();
       panel.add(lpiv); 
       Dimension desktopSize = panel.getSize();
       Dimension jInternalFrameSize = lpiv.getSize();
       lpiv.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
       (desktopSize.height- jInternalFrameSize.height)/2);
       lpiv.setVisible(true);
    }
    
    public void tampilKePanel(JInternalFrame frame) {
        JInternalFrame[] framesDisplayed = panel.getAllFrames();     
        for(JInternalFrame frameDisplayed : framesDisplayed) {
            frameDisplayed.dispose();
        }      
        panel.removeAll();
        panel.add(frame); 
        Dimension desktopSize = panel.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height- jInternalFrameSize.height)/2);
        frame.setVisible(true);
    }
    
     public static void tampilKePanel(JInternalFrame frame, JDesktopPane panel) {
        JInternalFrame[] framesDisplayed = panel.getAllFrames();     
        for(JInternalFrame frameDisplayed : framesDisplayed) {
            frameDisplayed.dispose();
        }      
        panel.removeAll();
        panel.add(frame); 
        Dimension desktopSize = panel.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height- jInternalFrameSize.height)/2);
        frame.setVisible(true);
    }
     
     public void logout() {
         view.dispose();
         App.main(null);
     }
}
