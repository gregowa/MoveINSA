package com.example.moveinsa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class OffreBDD {
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "Offre.db";
    private static final String TABLE_OFFRE = "table_offre";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_PARTENAIRE = "Partenaire";
    private static final int NUM_COL_PARTENAIRE = 1;
    private static final String COL_DISPOSITIF = "Dispositif";
    private static final int NUM_COL_DISPOSITIF = 2;
    private static final String COL_CLASSE = "Classe";
    private static final int NUM_COL_CLASSE = 3;
    private static final String COL_SEMESTRE = "Semestre";
    private static final int NUM_COL_SEMESTRE = 4;
    private static final String COL_EFFECTIF = "Effectif";
    private static final int NUM_COL_EFFECTIF = 5;

    private static final String CREATE_TABLE_OFFRE = "CREATE TABLE " + TABLE_OFFRE + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_PARTENAIRE + " INTEGER, "
            + COL_DISPOSITIF + " TEXT NOT NULL, " + COL_CLASSE + " TEXT NOT NULL, "
            + COL_EFFECTIF + " INTEGER, " + COL_SEMESTRE + " TEXT NOT NULL, "
            + " FOREIGN KEY ("+COL_PARTENAIRE+") REFERENCES TABLE_PARTENAIRE(COL_ID);";

    private SQLiteDatabase bdd;
    private MaBaseSQLite maBaseSQLite;

    public OffreBDD(Context context) {
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

    public long insertOffre(Offre offre) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_PARTENAIRE, offre.getPartenaire_id());
        values.put(COL_DISPOSITIF, offre.getDispositif());
        values.put(COL_CLASSE, offre.getClasse());
        values.put(COL_SEMESTRE, offre.getSemestre());
        values.put(COL_EFFECTIF, offre.getEffectif());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_OFFRE, null, values);
    }

    public int updateOffre(int id, Offre offre) {
        //La mise à jour d'une offre dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quelle offre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_PARTENAIRE, offre.getPartenaire_id());
        values.put(COL_DISPOSITIF, offre.getDispositif());
        values.put(COL_CLASSE, offre.getClasse());
        values.put(COL_SEMESTRE, offre.getSemestre());
        values.put(COL_EFFECTIF, offre.getEffectif());
        return bdd.update(TABLE_OFFRE, values, COL_ID + " = " + id, null);
    }

    public int removeOffreWithID(int id) {
        //Suppression d'une offre de la BDD grâce à l'ID
        return bdd.delete(TABLE_OFFRE, COL_ID + " = " + id, null);
    }

    //Cette méthode permet de convertir un cursor en une offre
    private Offre cursorToOffre(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On crée une offre
        Offre offre = new Offre();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        offre.setId(c.getInt(NUM_COL_ID));
        offre.setPartenaire_id(c.getInt(NUM_COL_PARTENAIRE));
        offre.setDispositif(c.getString(NUM_COL_DISPOSITIF));
        offre.setClasse(c.getString(NUM_COL_CLASSE));
        offre.setSemestre(c.getInt(NUM_COL_SEMESTRE));
        offre.setEffectif(c.getInt(NUM_COL_EFFECTIF));
        //On ferme le cursor
        c.close();
        //On retourne l'offre
        return offre;
    }
}
