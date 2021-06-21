package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Sogn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sognekode;
    private String sognenavn;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date nedlukning;
    private int lukket;
    private int smittetryk;


    @ManyToOne
    @JoinColumn(name = "kommune_id", nullable = false)
    private Kommune kommune;

    public Sogn() {
    }

    public Sogn(int sognekode, String sognenavn, Date nedlukning, int lukket, int smittetryk, Kommune kommune) {
        this.sognekode = sognekode;
        this.sognenavn = sognenavn;
        this.nedlukning = nedlukning;
        this.lukket = lukket;
        this.smittetryk = smittetryk;
        this.kommune = kommune;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSognekode() {
        return sognekode;
    }

    public void setSognekode(int sognekode) {
        this.sognekode = sognekode;
    }

    public String getSognenavn() {
        return sognenavn;
    }

    public void setSognenavn(String sognenavn) {
        this.sognenavn = sognenavn;
    }

    public Date getNedlukning() {
        return nedlukning;
    }

    public void setNedlukning(Date nedlukning) {
        this.nedlukning = nedlukning;
    }

    public int getLukket() {
        return lukket;
    }

    public void setLukket(int lukket) {
        this.lukket = lukket;
    }

    public int getSmittetryk() {
        return smittetryk;
    }

    public void setSmittetryk(int smittetryk) {
        this.smittetryk = smittetryk;
    }

    public Kommune getKommune() {
        return kommune;
    }

    public void setKommune(Kommune kommune) {
        this.kommune = kommune;
    }

    @Override
    public String toString() {
        return "Sogn{" +
                "id=" + id +
                ", sognekode=" + sognekode +
                ", sognenavn='" + sognenavn + '\'' +
                ", nedlukning=" + nedlukning +
                ", lukket=" + lukket +
                ", smittetryk=" + smittetryk +
                ", kommune=" + kommune +
                '}';
    }
}
