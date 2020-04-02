/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.config;

/**
 *
 * @author Lealva
 */
public class EncryptKeyMail {

    public String getRandomKey(String categ, String email) throws Exception {
        long time = new java.sql.Timestamp(System.currentTimeMillis()).getTime();
        String random = "" + (int) (Math.random() * 1000000 + 1);
        String emailEncrypt = EncryptDecryptUtil.encryptKeyEnvioCorreo(email);
        String cadena = categ + time + "-" + emailEncrypt + "-" + random;
        return cadena;
    }
}
