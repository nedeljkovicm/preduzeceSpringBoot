/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fpis.domain.StavkaNarudzbeniceId;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class StavkaNarudzbeniceDto implements Serializable {

    private StavkaNarudzbeniceId stavkaNarudzbeniceId;
    
    private int kolicina;
    private double iznos;
    private String nazivIgracke;
    private String opisIgracke;
    private double cenaIgracke;
    
    @JsonIgnore
    private NarudzbenicaDto narudzbenica;

    
    public StavkaNarudzbeniceDto() {
    }

    public StavkaNarudzbeniceDto(StavkaNarudzbeniceId stavkaNarudzbeniceId, int kolicina, double iznos, String nazivIgracke, String opisIgracke, double cenaIgracke, NarudzbenicaDto narudzbenica) {
        this.stavkaNarudzbeniceId = stavkaNarudzbeniceId;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.nazivIgracke = nazivIgracke;
        this.opisIgracke = opisIgracke;
        this.cenaIgracke = cenaIgracke;
        this.narudzbenica = narudzbenica;
    }

    
    public StavkaNarudzbeniceId getStavkaNarudzbeniceId() {
        return stavkaNarudzbeniceId;
    }

    public void setStavkaNarudzbeniceId(StavkaNarudzbeniceId stavkaNarudzbeniceId) {
        this.stavkaNarudzbeniceId = stavkaNarudzbeniceId;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public NarudzbenicaDto getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(NarudzbenicaDto narudzbenica) {
        this.narudzbenica = narudzbenica;
    }

    public String getNazivIgracke() {
        return nazivIgracke;
    }

    public void setNazivIgracke(String nazivIgracke) {
        this.nazivIgracke = nazivIgracke;
    }


    public String getOpisIgracke() {
        return opisIgracke;
    }

    public void setOpisIgracke(String opisIgracke) {
        this.opisIgracke = opisIgracke;
    }

    public double getCenaIgracke() {
        return cenaIgracke;
    }

    public void setCenaIgracke(double cenaIgracke) {
        this.cenaIgracke = cenaIgracke;
    }

    @Override
    public String toString() {
        return "StavkaNarudzbeniceDto{" + "stavkaNarudzbeniceId=" + stavkaNarudzbeniceId + ", kolicina=" + kolicina + ", iznos=" + iznos + ", nazivIgracke=" + nazivIgracke + ", opisIgracke=" + opisIgracke + ", cenaIgracke=" + cenaIgracke + ", narudzbenica=" + narudzbenica + '}';
    }

    

}
