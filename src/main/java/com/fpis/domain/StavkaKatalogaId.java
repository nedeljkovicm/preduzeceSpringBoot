/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.domain;

import java.io.Serializable;
import javax.persistence.Column;


import javax.persistence.Embeddable;

/**
 *
 * @author User
 */
@Embeddable
public class StavkaKatalogaId implements Serializable {

    private int katalogId;
    
    private int redniBroj;

    public StavkaKatalogaId() {
    }

    public StavkaKatalogaId(int katalogId, int redniBroj) {
        this.katalogId= katalogId;
        this.redniBroj = redniBroj;
    }

    public int getKatalogId() {
        return katalogId;
    }

    public void setKatalogId(int katalogId) {
        this.katalogId = katalogId;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaKatalogaId other = (StavkaKatalogaId) obj;
        if (this.katalogId != other.katalogId) {
            return false;
        }
        if (this.redniBroj != other.redniBroj) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StavkaKatalogaSlozenKljuc{" + "katalog=" + katalogId + ", redniBroj=" + redniBroj + '}';
    }
    
}
