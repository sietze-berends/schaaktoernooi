package com.example.schaaktoernooi.app.dto;

public class WedstrijdDTO {
    private String id;
    private String speler1;
    private String speler2;
    private String datum;
    private String winnaar;

    public WedstrijdDTO(String id, String speler1, String speler2, String datum, String winnaar) {
        this.id = id;
        this.speler1 = speler1;
        this.speler2 = speler2;
        this.datum = datum;
        this.winnaar = winnaar;
    }

    public String getSpeler1() {
        return speler1;
    }

    public void setSpeler1(String speler1) {
        this.speler1 = speler1;
    }

    public String getSpeler2() {
        return speler2;
    }

    public void setSpeler2(String speler2) {
        this.speler2 = speler2;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getWinnaar() {
        return winnaar;
    }

    public void setWinnaar(String winnaar) {
        this.winnaar = winnaar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WedstrijdDTO{" +
                "speler1='" + speler1 + '\'' +
                ", speler2='" + speler2 + '\'' +
                ", datum='" + datum + '\'' +
                ", winnaar='" + winnaar + '\'' +
                '}';
    }
}
