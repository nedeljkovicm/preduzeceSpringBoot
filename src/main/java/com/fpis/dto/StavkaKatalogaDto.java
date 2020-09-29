/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fpis.domain.StavkaKatalogaId;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class StavkaKatalogaDto implements Serializable {

    private StavkaKatalogaId stavkaKatalogaId;
    private IgrackaDto igracka;
    @JsonIgnore
    private KatalogDto katalog;

    public StavkaKatalogaDto() {
    }

    public StavkaKatalogaDto(StavkaKatalogaId stavkaKatalogaId, IgrackaDto igracka, KatalogDto katalog) {
        this.stavkaKatalogaId = stavkaKatalogaId;
        this.igracka = igracka;
        this.katalog=katalog;
    }

    public StavkaKatalogaId getStavkaKatalogaId() {
        return stavkaKatalogaId;
    }

    public void setStavkaKatalogaId(StavkaKatalogaId stavkaKatalogaId) {
        this.stavkaKatalogaId = stavkaKatalogaId;
    }

    public IgrackaDto getIgracka() {
        return igracka;
    }

    public void setIgracka(IgrackaDto igracka) {
        this.igracka = igracka;
    }

    public KatalogDto getKatalog() {
        return katalog;
    }

    public void setKatalog(KatalogDto katalog) {
        this.katalog = katalog;
    }

    @Override
    public String toString() {
        return "StavkaKatalogaDto{" + "stavkaKatalogaId=" + stavkaKatalogaId + ", igracka=" + igracka + ", katalog=" + katalog + '}';
    }

}
