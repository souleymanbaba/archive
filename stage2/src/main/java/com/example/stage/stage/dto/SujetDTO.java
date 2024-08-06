package com.example.stage.stage.dto;


import com.example.stage.stage.entity.Matiere;
import com.example.stage.stage.entity.Sujet;
import lombok.Data;

@Data
public class SujetDTO {
    private Long id;
    private Long idMatiere;
    private MatiereDTO matiere;

    private String nom_matiere;
    private int annee;
    private byte[] sujet;
    private Sujet.Type type;
    private byte[] byteimg;

    // Constructeur par défaut
    public SujetDTO() {
    }

    // Constructeur avec paramètres
    public SujetDTO(Long id, Long idMatiere, MatiereDTO matiere, int annee, byte[] sujet, String type) {
        this.id = id;
        this.idMatiere = idMatiere;
        this.matiere = matiere;
        this.annee = annee;
        this.sujet = sujet;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Long idMatiere) {
        this.idMatiere = idMatiere;
    }

    public MatiereDTO getMatiere() {
        return matiere;
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




}
