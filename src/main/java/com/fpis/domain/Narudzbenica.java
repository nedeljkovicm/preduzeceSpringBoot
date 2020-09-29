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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Narudzbenica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int narudzbenicaId;
    @Temporal(TemporalType.DATE)
    private Date datum;
    private double ukupanIznos;
    private String status;
    
    @OneToMany(mappedBy = "narudzbenica", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<StavkaNarudzbenice> stavkeNarudzbenice;
    
    @ManyToOne
    @JoinColumn
    private Kupac kupac;
    
    @ManyToOne
    @JoinColumn
    private Katalog katalog;

    public Narudzbenica() {
        
    }

    public Narudzbenica(int narudzbenicaId, Date datum,double ukupanIznos, String status, Kupac kupac,Katalog katalog) {
        this.narudzbenicaId = narudzbenicaId;
        this.datum = datum;
        this.ukupanIznos = ukupanIznos;
        this.status = status;
        this.kupac=kupac;
        this.katalog=katalog;
        this.stavkeNarudzbenice = new ArrayList<>();
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

    public List<StavkaNarudzbenice> getStavkeNarudzbenice() {
        return stavkeNarudzbenice;
    }

    public void setStavkeNarudzbenice(List<StavkaNarudzbenice> stavkeNarudzbenice) {
        this.stavkeNarudzbenice = stavkeNarudzbenice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Katalog getKatalog() {
        return katalog;
    }

    public void setKatalog(Katalog katalog) {
        this.katalog = katalog;
    }

    @Override
    public String toString() {
        return "Narudzbenica{" + "narudzbenicaId=" + narudzbenicaId + ", datum=" + datum + ", ukupanIznos=" + ukupanIznos + ", status=" + status + ", stavkeNarudzbenice=" + stavkeNarudzbenice + ", kupac=" + kupac + '}';
    }

    

}
