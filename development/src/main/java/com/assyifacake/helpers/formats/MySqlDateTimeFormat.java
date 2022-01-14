/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.helpers.formats;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author user
 */
public class MySqlDateTimeFormat {
    
    public static String now() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
       LocalDateTime now = LocalDateTime.now();
       
       return dtf.format(now);
    }
}
