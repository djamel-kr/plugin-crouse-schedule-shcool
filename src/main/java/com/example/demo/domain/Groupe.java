package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int nombreCours;

    @OneToMany(mappedBy = "groupe", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Emploie> emploieListe = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Emploie> getEmploieListe() {
        return emploieListe;
    }

    public void setEmploieListe(List<Emploie> emploieListe) {
        this.emploieListe = emploieListe;
    }

    public int getNombreCours() {
        return nombreCours;
    }

    public void setNombreCours(int nombreCours) {
        this.nombreCours = nombreCours;
    }
}
