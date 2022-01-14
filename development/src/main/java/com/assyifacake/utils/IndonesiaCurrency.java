/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class IndonesiaCurrency {
    
    public static String format (int input) {
        Locale locale = new Locale("in", "ID");      
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        
        return currencyFormatter.format(input);
    }
    
    public static int formatBack (String input) {
       Locale locale = new Locale("in", "ID");  
       NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
       int result = 0; 
       try {
            result = currencyFormatter.parse(input).intValue();
        } catch (ParseException ex) {
            Logger.getLogger(IndonesiaCurrency.class.getName()).log(Level.SEVERE, null, ex);
        }
       return result;
    
}
    
}
