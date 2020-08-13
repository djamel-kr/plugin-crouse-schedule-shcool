package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    @OneToMany(mappedBy = "salle")
    @JsonIgnore
    private List<Emploie> emploieList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Emploie> getEmploieList() {
        return emploieList;
    }

    public void setEmploieList(List<Emploie> emploieList) {
        this.emploieList = emploieList;
    }
}
