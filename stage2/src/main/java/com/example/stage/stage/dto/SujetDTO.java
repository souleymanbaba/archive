package com.example.stage.stage.dto;





public class SujetDTO {
    private Long id;
    private Long idMatiere;
    private MatiereDTO matiere;
    private int annee;
    private byte[] sujet;
    private String type;

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
        this.type = type;
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

    public void setMatiere(MatiereDTO matiere) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
