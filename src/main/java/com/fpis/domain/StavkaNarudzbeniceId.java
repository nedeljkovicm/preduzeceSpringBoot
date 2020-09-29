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
public class StavkaNarudzbeniceId implements Serializable {

    private int narudzbenicaId;
    
    private int redniBroj;

    public StavkaNarudzbeniceId() {
    }

    public StavkaNarudzbeniceId(int narudzbenicaId, int redniBroj) {
        this.narudzbenicaId= narudzbenicaId;
        this.redniBroj = redniBroj;
    }

    public int getNarudzbenicaId() {
        return narudzbenicaId;
    }

    public void setNarudzbenicaId(int narudzbenicaId) {
        this.narudzbenicaId = narudzbenicaId;
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
        final StavkaNarudzbeniceId other = (StavkaNarudzbeniceId) obj;
        if (this.narudzbenicaId != other.narudzbenicaId) {
            return false;
        }
        if (this.redniBroj != other.redniBroj) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StavkaNarudzbeniceId{" + "narudzbenicaId=" + narudzbenicaId + ", redniBroj=" + redniBroj + '}';
    }

 
}
