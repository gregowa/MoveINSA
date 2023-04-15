package com.example.moveinsa;

public class Partenaire {
    private int id;
    private String ecole;
    private String ville;

    public Partenaire(){}
    public Partenaire(int id, String ecole, String ville){
        this.id = id;
        this.ecole = ecole;
        this.ville = ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Partenaire{" +
                "id=" + id +
                ", ecole='" + ecole + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
