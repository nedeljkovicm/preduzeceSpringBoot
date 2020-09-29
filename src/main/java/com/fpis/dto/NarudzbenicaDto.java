/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class NarudzbenicaDto implements Serializable {
    
    private int narudzbenicaId;
    private Date datum;
    private double ukupanIznos;
    private String status;
    private KupacDto kupac;
    private KatalogDto katalog;
    private List<StavkaNarudzbeniceDto> stavkeNarudzbenice;

    public NarudzbenicaDto(int narudzbenicaId, Date datum, double ukupanIznos, String status, KupacDto kupac, KatalogDto katalog, List<StavkaNarudzbeniceDto> stavkeNarudzbenice) {
        this.narudzbenicaId = narudzbenicaId;
        this.datum = datum;
        this.ukupanIznos = ukupanIznos;
        this.status = status;
        this.kupac = kupac;
        this.katalog = katalog;
        this.stavkeNarudzbenice = new ArrayList<>();
    }

    public NarudzbenicaDto() {
       
    }

    public int getNarudzbenicaId() {
        return narudzbenicaId;
    }

    public void setNarudzbenicaId(int narudzbenicaId) {
        this.narudzbenicaId = narudzbenicaId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public List<StavkaNarudzbeniceDto> getStavkeNarudzbenice() {
        return stavkeNarudzbenice;
    }

    public void setStavkeNarudzbenice(List<StavkaNarudzbeniceDto> stavkeNarudzbenice) {
        this.stavkeNarudzbenice = stavkeNarudzbenice;
    }

    public KupacDto getKupac() {
        return kupac;
    }

    public void setKupac(KupacDto kupac) {
        this.kupac = kupac;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public KatalogDto getKatalog() {
        return katalog;
    }

    public void setKatalog(KatalogDto katalog) {
        this.katalog = katalog;
    }

    @Override
    public String toString() {
        return "NarudzbenicaDto{" + "narudzbenicaId=" + narudzbenicaId + ", datum=" + datum + ", ukupanIznos=" + ukupanIznos + ", status=" + status + ", kupac=" + kupac + ", stavkeNarudzbenice=" + stavkeNarudzbenice + '}';
    }

    
}
