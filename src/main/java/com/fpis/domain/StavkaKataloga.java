/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


/**
 *
 * @author User
 */
@Entity
public class StavkaKataloga implements Serializable{
    @EmbeddedId
    private StavkaKatalogaId stavkaKatalogaId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Igracka igracka;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("katalogId")
    @JoinColumn
    @JsonIgnore
    private Katalog katalog;

    public StavkaKataloga() {
    }

    public StavkaKataloga(StavkaKatalogaId stavkaKatalogaId, Igracka igracka, Katalog katalog) {
        this.stavkaKatalogaId = stavkaKatalogaId;
        this.igracka = igracka;
        this.katalog = katalog;
    }
  
    public Katalog getKatalog() {
        return katalog;
    }

    public void setKatalog(Katalog katalog) {
        this.katalog = katalog;
    }

    public StavkaKatalogaId getStavkaKatalogaId() {
        return stavkaKatalogaId;
    }

    public void setStavkaKatalogaId(StavkaKatalogaId stavkaKatalogaId) {
        this.stavkaKatalogaId = stavkaKatalogaId;
    }

    public Igracka getIgracka() {
        return igracka;
    }

    public void setIgracka(Igracka igracka) {
        this.igracka = igracka;
    }

    @Override
    public String toString() {
        return "StavkaKataloga{" + "stavkaKatalogaId=" + stavkaKatalogaId + ", igracka=" + igracka + ", katalog=" + katalog + '}';
    }

  
    
    
    
}
