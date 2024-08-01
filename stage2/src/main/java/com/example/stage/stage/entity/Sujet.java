package com.example.stage.stage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;



@Entity
public class Sujet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    private int annee;

    @Lob
    private byte[] sujet;

    public enum Type {
        DEVOIR,
        EXAMEN,
        RATTRAPAGE_EXAMEN,
        RATTRAPAGE_DEVOIR
    }

    @Enumerated(EnumType.STRING)
    private Type type;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public byte[] getSujet() {
        return sujet;
    }

    public void setSujet(byte[] sujet) {
        this.sujet = sujet;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
