/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class ByteToIcon {
    public static ImageIcon decode(byte[] input) {
        ImageIcon icon = null;
        
        
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
            
            BufferedImage gambarMotor = ImageIO.read(inputStream);
            icon = new ImageIcon(gambarMotor);
            

            
        } catch (IOException ex) {
            Logger.getLogger(ByteToIcon.class.getName()).log(Level.SEVERE, null, ex);
        }
            return icon;
    }
}
