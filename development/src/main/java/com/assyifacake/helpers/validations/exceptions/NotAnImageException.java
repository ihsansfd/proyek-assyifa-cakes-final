/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.helpers.validations.exceptions;

/**
 *
 * @author user
 */
public class NotAnImageException extends Exception {
    private static String message = "File yang Anda upload bukan gambar!";
    
    public NotAnImageException() {
        super(message);
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
