/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.helpers.validations;

import com.assyifacake.helpers.validations.exceptions.NotAnImageException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author user
 */
public class IsImageValidation {
    
    
    public static void validate(String path) throws IOException, NotAnImageException {
    File file=new File(path);


String mimetype = Files.probeContentType(file.toPath());
//mimetype should be something like "image/png"

if (mimetype != null && mimetype.split("/")[0].equals("image")) {
    return;
} else {
    throw new NotAnImageException();
}
    }
}
