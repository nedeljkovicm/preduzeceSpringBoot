/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class KatalogDto implements Serializable {

    private int katalogId;
    private Date datumOd;
    private Date datumDo;
    private String naziv;
    private String status;

    private List<StavkaKatalogaDto> stavkeKataloga;

    public KatalogDto(int katalogId, Date datumOd, Date datumDo, String naziv, String status) {
        this.katalogId = katalogId;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.naziv = naziv;
        this.status = status;
        this.stavkeKataloga = new ArrayList<>();
    }

    public KatalogDto() {
       
    }

    public int getKatalogId() {
        return katalogId;
    }

    public void setKatalogId(int katalogId) {
        this.katalogId = katalogId;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<StavkaKatalogaDto> getStavkeKataloga() {
        return stavkeKataloga;
    }

    public void setStavkeKataloga(List<StavkaKatalogaDto> stavkeKataloga) {
        this.stavkeKataloga = stavkeKataloga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "KatalogDto{" + "katalogId=" + katalogId + ", datumOd=" + datumOd + ", datumDo=" + datumDo + ", naziv=" + naziv + ", status=" + status + ", stavkeKataloga=" + stavkeKataloga + '}';
    }

}
