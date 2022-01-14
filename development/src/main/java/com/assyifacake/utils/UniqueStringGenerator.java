///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.assyifacake.utils;
//
//import java.nio.charset.Charset;
//import java.util.Date;
//import java.util.Random;
//import org.apache.commons.lang3.RandomStringUtils;
//
///**
// *
// * @author user
// */
//public class UniqueStringGenerator {
//    
//    public String generate() {
//    String string = "";
//    long millis = System.currentTimeMillis();
//    String datetime = new Date().toGMTString();
//    datetime = datetime.replace(" ", "");
//    datetime = datetime.replace(":", "");
//    String rndchars = RandomStringUtils.randomAlphanumeric(16);
//    string = rndchars + "_" + datetime + "_" + millis;
//    return string;
//}
//}
