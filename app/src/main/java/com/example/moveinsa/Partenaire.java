package com.example.moveinsa;

public class Partenaire {
    private int id;
    private String ecole;
    private String ville;
    private String pays;

    public Partenaire(){}
    public Partenaire(String ecole, String ville, String pays){
        this.ecole = ecole;
        this.ville = ville;
        this.pays = pays;
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
    public String getPays() {
        return pays;
    }
    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Partenaire{" +
                "id=" + id +
                ", ecole='" + ecole + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
