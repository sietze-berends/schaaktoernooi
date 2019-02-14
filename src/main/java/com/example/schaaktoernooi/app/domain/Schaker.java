package com.example.schaaktoernooi.app.domain;

import java.time.LocalDate;

public class Schaker {
    private String voornaam;
    private String achternaam;
    private String tussenvoegsel;
    private LocalDate geboortedatum;
    private int gewonnenPartijen;
    private int remises;
    private int verlorenPartijen;

    public Schaker(String voornaam, String achternaam, String tussenvoegsel, LocalDate geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.tussenvoegsel = tussenvoegsel;
        this.geboortedatum = geboortedatum;
        this.gewonnenPartijen = 0;
        this.remises = 0;
        this.verlorenPartijen = 0;

    }
}
