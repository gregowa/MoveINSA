package com.example.moveinsa;

public class Offre {
    private int id;
    private int partenaire_id;
    private String dispositif;
    private String classe;
    private int semestre;

    public Offre(){}
    public Offre(int partenaire_id, String dispositif, String classe, int semestre){
        this.partenaire_id = partenaire_id;
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

    public int getPartenaire_id() {
        return partenaire_id;
    }

    public void setPartenaire_id(int partenaire_id) {
        this.partenaire_id = partenaire_id;
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

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id=" + id +
                ", partenaire_id=" + partenaire_id +
                ", dispositif='" + dispositif + '\'' +
                ", classe='" + classe + '\'' +
                ", semestre='" + semestre + '\'' +
                '}';
    }
}
