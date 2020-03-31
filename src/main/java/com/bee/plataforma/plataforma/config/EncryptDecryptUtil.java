/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.config;

import org.springframework.stereotype.Component;

/**
 *
 * @author DEV_CASTLE
 */
@Component
public class EncryptDecryptUtil {

    static String key= "BEE@C0M3rC3";
    
    public static String decryptPhrase(String phrase) throws Exception {
        if (phrase == null) {
            return null;
        }
        EncriptadorPassword encriptadorPassword = new EncriptadorPassword(key);
        String claveDesencripatado;
        try {
            claveDesencripatado = encriptadorPassword.desencriptado(phrase);
        } catch (Exception e) {
            claveDesencripatado = null;
        }
        return claveDesencripatado;
    }

    public static String encryptPhrase(String password) throws Exception {
        String encrypt = null;
        EncriptadorPassword encriptadorPassword = new EncriptadorPassword(key);
        encrypt = encriptadorPassword.encriptado(password);
        return encrypt;
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("---------------------------------------------");
            String value="123";
                                           
          //  String value = "8FP4H23FM/odSQghXVgD7A==";
            value=EncryptDecryptUtil.encryptPhrase(value);
           // value=EncryptDecryptUtil.decryptPhrase(value);
            System.out.println(value);            
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
