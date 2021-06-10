package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Sogn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sognekode;
    private String sognenavn;


    @ManyToOne
    @JoinColumn(name = "kommune_id", nullable = false)
    private Kommune kommune;

    public Sogn() {
    }

    public Sogn(int sognekode, String sognenavn, Kommune kommune) {
        this.sognekode = sognekode;
        this.sognenavn = sognenavn;
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
                ", kommune=" + kommune +
                '}';
    }
}
