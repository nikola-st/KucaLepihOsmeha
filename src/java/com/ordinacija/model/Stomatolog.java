/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ordinacija.model;

/**
 *
 * @author HP
 */
public class Stomatolog {
    private int id;
    String username, pass;

    public Stomatolog() {
    }

    public Stomatolog(int id, String username, String pass) {
        this.id = id;
        this.username = username;
        this.pass = pass;
    }

    public Stomatolog(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
