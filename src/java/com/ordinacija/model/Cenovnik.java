package com.ordinacija.model;


public class Cenovnik {
    private int id;
    private String naziv;
    private float cena;

    public Cenovnik(int id, String naziv, float cena) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
    }

    public Cenovnik(String naziv, float cena) {
        this.naziv = naziv;
        this.cena = cena;
    }

    public Cenovnik() {
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }
}