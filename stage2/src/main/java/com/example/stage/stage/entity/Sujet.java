package com.example.stage.stage.entity;

import com.example.stage.stage.dto.SujetDTO;
import jakarta.persistence.*;


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
    @Column(columnDefinition = "longblob")
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

    public SujetDTO getDto() {
        SujetDTO sujetDTO = new SujetDTO();
        sujetDTO.setAnnee(annee);
        sujetDTO.setByteimg(sujet);
        sujetDTO.setId(id);
        sujetDTO.setType(type);
        sujetDTO.setNom_matiere(matiere.getNom());

        return sujetDTO;
    }
}
