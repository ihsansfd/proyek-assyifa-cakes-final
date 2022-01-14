/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.helpers.validations.exceptions;

/**
 *
 * @author user
 */
public class NonAlphanumericException extends Exception {

    public NonAlphanumericException() {
        super("Anda hanya dapat memasukkan alfanumerik ke dalam kolom input!");
    }
    
}
