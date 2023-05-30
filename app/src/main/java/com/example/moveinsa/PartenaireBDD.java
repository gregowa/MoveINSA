package com.example.moveinsa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Telephony;

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
    private static final String COL_PAYS = "Pays";
    private static final int NUM_COL_PAYS = 3;

    private static final String CREATE_TABLE_PARTENAIRE = "CREATE TABLE " + TABLE_PARTENAIRE + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_ECOLE + " TEXT NOT NULL, "
            + COL_VILLE + " TEXT NOT NULL, " + COL_PAYS + "TEXT NOT NULL);";
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
        bdd.execSQL("DROP TABLE IF EXISTS "+NOM_BDD);
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
        values.put(COL_PAYS, partenaire.getPays());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_PARTENAIRE, null, values);
    }

    public int updatePartenaire(int id, Partenaire partenaire) {
        //La mise à jour d'un partenaire dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quel partenaire on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_ECOLE, partenaire.getEcole());
        values.put(COL_VILLE, partenaire.getVille());
        values.put(COL_PAYS, partenaire.getPays());
        return bdd.update(TABLE_PARTENAIRE, values, COL_ID + " = " + id, null);
    }

    public int removePartenaireWithID(int id) {
        //Suppression d'un partenaire de la BDD grâce à l'ID
        return bdd.delete(TABLE_PARTENAIRE, COL_ID + " = " + id, null);
    }

    //Cette méthode permet de convertir un cursor en un partenaire
    private Partenaire cursorToPartenaire(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On crée un partenaire
        Partenaire partenaire = new Partenaire();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        partenaire.setId(c.getInt(NUM_COL_ID));
        partenaire.setEcole(c.getString(NUM_COL_ECOLE));
        partenaire.setVille(c.getString(NUM_COL_VILLE));
        partenaire.setPays(c.getString(NUM_COL_PAYS));
        //On ferme le cursor
        c.close();
        //On retourne le partenaire
        return partenaire;
    }
}
