/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author User
 */
@Entity
public class Katalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int katalogId;
    @Temporal(TemporalType.DATE)
    private Date datumOd;
    @Temporal(TemporalType.DATE)
    private Date datumDo;
    private String naziv;
    private String status;
    @OneToMany(mappedBy = "katalog", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<StavkaKataloga> stavkeKataloga;

    public Katalog() {
        
    }

    public Katalog(int katalogId, Date datumOd, Date datumDo, String naziv, String status) {
        this.katalogId = katalogId;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.naziv = naziv;
        this.status = status;
        this.stavkeKataloga = new ArrayList<>();
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

    public List<StavkaKataloga> getStavkeKataloga() {
        return stavkeKataloga;
    }

    public void setStavkeKataloga(List<StavkaKataloga> stavkeKataloga) {
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
        return "Katalog{" + "katalogId=" + katalogId + ", datumOd=" + datumOd + ", datumDo=" + datumDo + ", naziv=" + naziv + ", status=" + status + ", stavkeKataloga=" + stavkeKataloga + '}';
    }

}
