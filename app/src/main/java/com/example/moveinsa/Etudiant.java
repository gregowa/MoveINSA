package com.example.moveinsa;
/**
 * Création de la classe Etudiant
 */
public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String classe;
    private int semestre;
    private String voeu1;
    private String voeu2;
    private String voeu3;
    private String voeu4;
    private String voeu5;

    public Etudiant(){}
    public Etudiant(int id, String nom, String prenom, String classe, int semestre, String voeu1, String voeu2, String voeu3, String voeu4, String voeu5){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.semestre = semestre;
        this.voeu1 = voeu1;
        this.voeu2 = voeu2;
        this.voeu3 = voeu3;
        this.voeu4 = voeu4;
        this.voeu5 = voeu5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getVoeu1() {
        return voeu1;
    }

    public void setVoeu1(String voeu1) {
        this.voeu1 = voeu1;
    }

    public String getVoeu2() {
        return voeu2;
    }

    public void setVoeu2(String voeu2) {
        this.voeu2 = voeu2;
    }

    public String getVoeu3() {
        return voeu3;
    }

    public void setVoeu3(String voeu3) {
        this.voeu3 = voeu3;
    }

    public String getVoeu4() {
        return voeu4;
    }

    public void setVoeu4(String voeu4) {
        this.voeu4 = voeu4;
    }

    public String getVoeu5() {
        return voeu5;
    }

    public void setVoeu5(String voeu5) {
        this.voeu5 = voeu5;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", classe='" + classe + '\'' +
                ", semestre=" + semestre +
                ", voeu1='" + voeu1 + '\'' +
                ", voeu2='" + voeu2 + '\'' +
                ", voeu3='" + voeu3 + '\'' +
                ", voeu4='" + voeu4 + '\'' +
                ", voeu5='" + voeu5 + '\'' +
                '}';
    }
}
