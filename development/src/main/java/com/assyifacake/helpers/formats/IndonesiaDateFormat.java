/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.helpers.formats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class IndonesiaDateFormat {
    
    public static String format(String input) {
        
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
        Date date;
        String hasil = null;
        try {
            date = format1.parse(input);
            hasil = format2.format(date);
        } catch (ParseException ex) {
            Logger.getLogger(IndonesiaDateFormat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
    
    public static String formatBack(String input) {
        
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String hasil = null;
        try {
            date = format1.parse(input);
            hasil = format2.format(date);
        } catch (ParseException ex) {
            Logger.getLogger(IndonesiaDateFormat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}
