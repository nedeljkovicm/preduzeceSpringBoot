/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.dto;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class IgrackaDto implements Serializable{
    private int igrackaId;
    private String naziv;
    private double trenutnaCena;
    private int stanjeNaZalihama;
    private String pozicija;
    private String opis;

    public IgrackaDto() {
    }

    public IgrackaDto(int igrackaId, String naziv, double trenutnaCena, int stanjeNaZalihama, String pozicija, String opis) {
        this.igrackaId = igrackaId;
        this.naziv = naziv;
        this.trenutnaCena = trenutnaCena;
        this.stanjeNaZalihama = stanjeNaZalihama;
        this.pozicija = pozicija;
        this.opis = opis;
    }

    public int getIgrackaId() {
        return igrackaId;
    }

    public void setIgrackaId(int igrackaId) {
        this.igrackaId = igrackaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getTrenutnaCena() {
        return trenutnaCena;
    }

    public void setTrenutnaCena(double trenutnaCena) {
        this.trenutnaCena = trenutnaCena;
    }

    public int getStanjeNaZalihama() {
        return stanjeNaZalihama;
    }

    public void setStanjeNaZalihama(int stanjeNaZalihama) {
        this.stanjeNaZalihama = stanjeNaZalihama;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "IgrackaDto{" + "igrackaId=" + igrackaId + ", naziv=" + naziv + ", trenutnaCena=" + trenutnaCena + ", stanjeNaZalihama=" + stanjeNaZalihama + ", pozicija=" + pozicija + ", opis=" + opis + '}';
    }
    
}
