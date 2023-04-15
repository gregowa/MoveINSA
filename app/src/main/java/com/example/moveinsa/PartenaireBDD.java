package com.example.moveinsa;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class PartenaireBDD {
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "Partenaire.db";
    private static final String TABLE_PARTENAIRE = "table_partenaire";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_ECOLE = "Ecole";
    private static final int NUM_COL_ECOLE = 1;
    private static final String COL_VILLE = "Ville";
    private static final int NUM_COL_VILLE = 2;

    private SQLiteDatabase bdd;
    private MaBaseSQLite maBaseSQLite;

    public PartenaireBDD(Context context) {
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

    public long insertPartenaire(Partenaire partenaire) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_ECOLE, partenaire.getEcole());
        values.put(COL_VILLE, partenaire.getVille());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_PARTENAIRE, null, values);
    }

    public int updatePartenaire(int id, Partenaire partenaire) {
        //La mise à jour d'un partenaire dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quel partenaire on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_ECOLE, partenaire.getEcole());
        values.put(COL_VILLE, partenaire.getVille());
        return bdd.update(TABLE_PARTENAIRE, values, COL_ID + " = " + id, null);
    }

    public int removePartenaireWithID(int id) {
        //Suppression d'un partenaire de la BDD grâce à l'ID
        return bdd.delete(TABLE_PARTENAIRE, COL_ID + " = " + id, null);
    }
}
