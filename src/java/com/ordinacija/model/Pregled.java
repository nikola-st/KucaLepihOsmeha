/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ordinacija.model;

public class Pregled {
    
    private int id;
    private int id_pacijenta, id_lekara;
    String nalaz, datum;

    public Pregled(int id, int id_pacijenta, int id_lekara, String datum, String nalaz) {
        this.id = id;
        this.id_pacijenta = id_pacijenta;
        this.id_lekara = id_lekara;
        this.datum = datum;
        this.nalaz = nalaz;
    }

    public Pregled(int id_pacijenta, int id_lekara, String datum, String nalaz) {
        this.id_pacijenta = id_pacijenta;
        this.id_lekara = id_lekara;
        this.datum = datum;
        this.nalaz = nalaz;
    }

    public Pregled() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pacijenta() {
        return id_pacijenta;
    }

    public void setId_pacijenta(int id_pacijenta) {
        this.id_pacijenta = id_pacijenta;
    }

    public int getId_lekara() {
        return id_lekara;
    }

    public void setId_lekara(int id_lekara) {
        this.id_lekara = id_lekara;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getNalaz() {
        return nalaz;
    }

    public void setNalaz(String nalaz) {
        this.nalaz = nalaz;
    }
}
