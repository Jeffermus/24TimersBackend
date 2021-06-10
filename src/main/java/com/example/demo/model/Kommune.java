package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
//import java.util.Date;
import java.util.Set;
import java.sql.Date;

@Entity
public class Kommune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String navn;
    private int smittetryk;
    private Date nedlukning;

    @JsonBackReference
    @OneToMany (mappedBy = "kommune")
    private Set<Sogn> sogn;

    public Kommune() {
    }

    public Kommune(String navn, int smittetryk, Date nedlukning, Set<Sogn> sogn) {
        this.navn = navn;
        this.smittetryk = smittetryk;
        this.nedlukning = nedlukning;
        this.sogn = sogn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getSmittetryk() {
        return smittetryk;
    }

    public void setSmittetryk(int smittetryk) {
        this.smittetryk = smittetryk;
    }

    public Date getNedlukning() {
        return nedlukning;
    }

    public void setNedlukning(Date nedlukning) {
        this.nedlukning = nedlukning;
    }

    public Set<Sogn> getSogn() {
        return sogn;
    }

    public void setSogn(Set<Sogn> sogn) {
        this.sogn = sogn;
    }

    @Override
    public String toString() {
        return "Kommune{" +
                "id=" + id +
                ", navn='" + navn + '\'' +
                ", smittetryk=" + smittetryk +
                ", nedlukning=" + nedlukning +
                ", sogn=" + sogn +
                '}';
    }
}
