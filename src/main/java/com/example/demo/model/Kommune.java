package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Kommune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String navn;



    @JsonBackReference
    @OneToMany (mappedBy = "kommune")
    private Set<Sogn> sogn;

    public Kommune() {
    }

    public Kommune(String navn, Set<Sogn> sogn) {
        this.navn = navn;
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
                ", sogn=" + sogn +
                '}';
    }
}
