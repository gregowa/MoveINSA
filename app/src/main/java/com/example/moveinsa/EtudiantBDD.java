package com.example.moveinsa;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class EtudiantBDD {
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "Etudiant.db";
    private static final String TABLE_ETUDIANT = "table_etudiant";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_NOM = "Nom";
    private static final int NUM_COL_NOM = 1;
    private static final String COL_PRENOM = "Prenom";
    private static final int NUM_COL_PRENOM = 2;
    private static final String COL_CLASSE = "Classe";
    private static final int NUM_COL_CLASSE = 3;
    private static final String COL_SEMESTRE = "Semestre";
    private static final int NUM_COL_SEMESTRE = 4;
    private static final String COL_VOEU1 = "Voeu1";
    private static final int NUM_COL_VOEU1 = 5;
    private static final String COL_VOEU2 = "Voeu2";
    private static final int NUM_COL_VOEU2 = 6;
    private static final String COL_VOEU3 = "Voeu3";
    private static final int NUM_COL_VOEU3 = 7;
    private static final String COL_VOEU4 = "Voeu4";
    private static final int NUM_COL_VOEU4 = 8;
    private static final String COL_VOEU5 = "Voeu5";
    private static final int NUM_COL_VOEU5 = 9;

    private SQLiteDatabase bdd;
    private MaBaseSQLite maBaseSQLite;

    public EtudiantBDD(Context context) {
        //On crée la BDD et sa table
        maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open() {
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close() {
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD() {
        return bdd;
    }

    public long insertEtudiant(Etudiant etudiant) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_NOM, etudiant.getNom());
        values.put(COL_PRENOM, etudiant.getPrenom());
        values.put(COL_CLASSE, etudiant.getClasse());
        values.put(COL_SEMESTRE, etudiant.getSemestre());
        values.put(COL_VOEU1, etudiant.getVoeu1());
        values.put(COL_VOEU2, etudiant.getVoeu2());
        values.put(COL_VOEU3, etudiant.getVoeu3());
        values.put(COL_VOEU4, etudiant.getVoeu4());
        values.put(COL_VOEU5, etudiant.getVoeu5());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_ETUDIANT, null, values);
    }

    public int updateEtudiant(int id, Etudiant etudiant) {
        //La mise à jour d'un étudiant dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quel étudiant on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_NOM, etudiant.getNom());
        values.put(COL_PRENOM, etudiant.getPrenom());
        values.put(COL_CLASSE, etudiant.getClasse());
        values.put(COL_SEMESTRE, etudiant.getSemestre());
        values.put(COL_VOEU1, etudiant.getVoeu1());
        values.put(COL_VOEU2, etudiant.getVoeu2());
        values.put(COL_VOEU3, etudiant.getVoeu3());
        values.put(COL_VOEU4, etudiant.getVoeu4());
        values.put(COL_VOEU5, etudiant.getVoeu5());
        return bdd.update(TABLE_ETUDIANT, values, COL_ID + " = " + id, null);
    }

    public int removeEtudiantWithID(int id) {
        //Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(TABLE_ETUDIANT, COL_ID + " = " + id, null);
    }
}
