/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.helpers.validations;

import com.assyifacake.helpers.validations.exceptions.NullException;
import javax.swing.text.JTextComponent;

/**
 *
 * @author user
 */
public class NotNullValidation {
    
    public static void validate(JTextComponent[] input) throws NullException {
        for(JTextComponent label : input) {
            if(label.getText().isBlank() || label.getText().isEmpty() ) {
                throw new NullException();
            }
        }
}
    
}
