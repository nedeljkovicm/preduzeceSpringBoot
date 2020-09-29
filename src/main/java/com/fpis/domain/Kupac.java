/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author User
 */
@Entity
public class Kupac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kupacId;
    private String PIB;
    private String naziv;
    private String adresa;
    private String kontaktTel;

    public Kupac() {
    }

    public Kupac(int kupacId, String PIB, String naziv, String adresa, String kontaktTel) {
        this.kupacId = kupacId;
        this.naziv = naziv;
        this.PIB = PIB;
        this.adresa = adresa;
        this.kontaktTel = kontaktTel;
    }

    public int getKupacId() {
        return kupacId;
    }

    public void setKupacId(int kupacId) {
        this.kupacId = kupacId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
   
    public String getKontaktTel() {
        return kontaktTel;
    }

    public void setKontaktTel(String kontaktTel) {
        this.kontaktTel = kontaktTel;
    }

    @Override
    public String toString() {
        return "Kupac{" + "kupacId=" + kupacId + ", PIB=" + PIB + ", naziv=" + naziv + ", adresa=" + adresa + ", kontaktTel=" + kontaktTel + '}';
    }
    
    
}
