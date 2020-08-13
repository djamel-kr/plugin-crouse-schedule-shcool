package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Emploie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_emploi;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date dateDebut;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;


    public int getId_emploi() {
        return id_emploi;
    }

    public void setId_emploi(int id_emploi) {
        this.id_emploi = id_emploi;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
