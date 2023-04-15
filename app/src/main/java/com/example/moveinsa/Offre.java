package com.example.moveinsa;

public class Offre {
    private int id;
    private Partenaire partenaire;
    private String dispositif;
    private String classe;
    private String semestre;

    public Offre(){}
    public Offre(int id, Partenaire partenaire, String dispositif, String classe, String semestre){
        this.id = id;
        this.partenaire = partenaire;
        this.dispositif = dispositif;
        this.classe = classe;
        this.semestre = semestre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public String getDispositif() {
        return dispositif;
    }

    public void setDispositif(String dispositif) {
        this.dispositif = dispositif;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id=" + id +
                ", partenaire=" + partenaire +
                ", dispositif='" + dispositif + '\'' +
                ", classe='" + classe + '\'' +
                ", semestre='" + semestre + '\'' +
                '}';
    }
}
