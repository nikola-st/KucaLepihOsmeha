package com.ordinacija.model;

/**
 *
 * @author HP
 */
public class Bolesti {
    private int id;
    private String sifra, naziv, opis;

    public Bolesti(int id, String sifra, String naziv, String opis) {
        this.id = id;
        this.sifra = sifra;
        this.naziv = naziv;
        this.opis = opis;
    }

    public Bolesti(String sifra, String naziv, String opis) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.opis = opis;
    }

    public Bolesti() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
