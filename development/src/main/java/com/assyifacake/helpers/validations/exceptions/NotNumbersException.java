/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.helpers.validations.exceptions;

/**
 *
 * @author user
 */
public class NotNumbersException extends Exception {

    private static String message = "Input yang dimasukkan harus hanya angka!";
    
    public NotNumbersException() {
        super(message);
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
}
