/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ordinacija.model;

//import java.sql.Date;
//import java.util.Date;

/**
 *
 * @author HP
 */
public class Reklamacija {
    private int id, id_pacijenta;
    
    String opis, status, datum;

    public Reklamacija() {
    }

    public Reklamacija(int id_pacijenta) {
        this.id_pacijenta = id_pacijenta;
    }
    
    

    public Reklamacija(int id, int id_pacijenta, String datum, String opis, String status) {
        this.id = id;
        this.id_pacijenta = id_pacijenta;
        this.datum = datum;
        this.opis = opis;
        this.status = status;
    }

    public Reklamacija(int id_pacijenta, String datum, String opis, String status) {
        this.id_pacijenta = id_pacijenta;
        this.datum = datum;
        this.opis = opis;
        this.status = status;
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

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
