/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.helpers.validations;

import com.assyifacake.helpers.validations.exceptions.FileSizeExceededException;
import java.io.File;

/**
 *
 * @author user
 */
public class FileSizeValidation {
    
//    private int max = 1024;
    
//    // dalam kilobytes
//    public void setMaxSize(int max) {
//        this.max = max;
//    }
    
    public static void validate(String imagePath) throws FileSizeExceededException {
        int max = 1024;
        File file = new File(imagePath);
        if(!file.exists() || !file.isFile())
            return;
        if(file.length()/1024 > max) {
            throw new FileSizeExceededException();
        };
    }
}
