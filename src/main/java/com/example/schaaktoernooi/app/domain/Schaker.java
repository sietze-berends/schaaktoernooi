package com.example.schaaktoernooi.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Schaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String voornaam;
    private String achternaam;
    private String tussenvoegsel;
    private LocalDate geboortedatum;
    private int gewonnenPartijen;
    private int remises;
    private int verlorenPartijen;

    public Schaker() {

    }

    public Schaker(String voornaam, String achternaam, String tussenvoegsel, LocalDate geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.tussenvoegsel = tussenvoegsel;
        this.geboortedatum = geboortedatum;
        this.gewonnenPartijen = 0;
        this.remises = 0;
        this.verlorenPartijen = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public int getGewonnenPartijen() {
        return gewonnenPartijen;
    }

    public void setGewonnenPartijen(int gewonnenPartijen) {
        this.gewonnenPartijen = gewonnenPartijen;
    }

    public int getRemises() {
        return remises;
    }

    public void setRemises(int remises) {
        this.remises = remises;
    }

    public int getVerlorenPartijen() {
        return verlorenPartijen;
    }

    public void setVerlorenPartijen(int verlorenPartijen) {
        this.verlorenPartijen = verlorenPartijen;
    }

    public void plus(String type) {
        switch (type) {
            case "gewonnen":
                this.gewonnenPartijen++;
                break;
            case "remise":
                this.remises++;
                break;
            case "verloren":
                this.verlorenPartijen++;
                break;
        }
    }
}
