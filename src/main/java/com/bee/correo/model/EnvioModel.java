/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.correo.model;

/**
 *
 * @author Lealva
 */
public class EnvioModel {
    private String email;
    private int canalenvio;
    private String adjuntoname;
    private String adjunto64;
    private String  obs;
    private String key;
    private String mail;


    public EnvioModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCanalenvio() {
        return canalenvio;
    }

    public void setCanalenvio(int canalenvio) {
        this.canalenvio = canalenvio;
    }

    public String getAdjuntoname() {
        return adjuntoname;
    }

    public void setAdjuntoname(String adjuntoname) {
        this.adjuntoname = adjuntoname;
    }

    public String getAdjunto64() {
        return adjunto64;
    }

    public void setAdjunto64(String adjunto64) {
        this.adjunto64 = adjunto64;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
