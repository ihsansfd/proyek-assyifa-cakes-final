/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author user
 */
public class PathToByte {
    
    public static byte[] generate(String input) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File(input));
        return fileContent;
    }
}
