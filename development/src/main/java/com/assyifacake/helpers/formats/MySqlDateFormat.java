/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.helpers.formats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField.AbstractFormatter;

/**
 *
 * @author user
 */
public class MySqlDateFormat extends AbstractFormatter {
    
    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
    
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value)  {
        if (value != null) {
            Date cal = (Date) value;
            return dateFormatter.format(cal.getTime());
        }
         
        return "";
    }
    
    
}
