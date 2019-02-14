package com.example.schaaktoernooi.app.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Wedstrijd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Schaker speler1;

    @OneToOne
    private Schaker speler2;

    @OneToOne
    private Schaker winnaar;

    private LocalDate datum;

    public Wedstrijd(){

    }

    public Wedstrijd(Schaker speler1, Schaker speler2, LocalDate datum) {
        this.speler1 = speler1;
        this.speler2 = speler2;
        this.datum = datum;
    }

    public long getId() {
        return id;
    }

    public Schaker getSpeler1() {
        return speler1;
    }

    public Schaker getSpeler2() {
        return speler2;
    }

    public Schaker getWinnaar() {
        return winnaar;
    }

    public LocalDate getDatum() {
        return datum;
    }

    @Override
    public String toString() {
        return "Wedstrijd{" +
                "id=" + id +
                ", speler1=" + speler1 +
                ", speler2=" + speler2 +
                ", winnaar=" + winnaar +
                ", datum=" + datum +
                '}';
    }
}

