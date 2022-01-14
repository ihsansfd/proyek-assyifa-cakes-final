/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.helpers.validations;

import com.assyifacake.helpers.validations.exceptions.NonAlphanumericException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class AlphanumericValidation {
    
    public static void validate (String input) throws NonAlphanumericException {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");
        Matcher m = p.matcher(input);
        
        if(!m.matches()) {
            throw new NonAlphanumericException();
        }  

}

    
}
