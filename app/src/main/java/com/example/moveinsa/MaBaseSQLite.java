package com.example.moveinsa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class MaBaseSQLite extends SQLiteOpenHelper {
    private static final String TABLE_ETUDIANT = "table_etudiant";
    private static final String TABLE_PARTENAIRE = "table_partenaire";
    private static final String TABLE_OFFRE = "table_offre";
    private static final String COL_ID = "ID";
    private static final String COL_NOM = "Nom";
    private static final String COL_PRENOM = "Prenom";
    private static final String COL_CLASSE = "Classe";
    private static final String COL_SEMESTRE = "Semestre";
    private static final String COL_VOEU1 = "Voeu1";
    private static final String COL_VOEU2 = "Voeu2";
    private static final String COL_VOEU3 = "Voeu3";
    private static final String COL_VOEU4 = "Voeu4";
    private static final String COL_VOEU5 = "Voeu5";
    private static final String COL_ECOLE = "Ecole";
    private static final String COL_VILLE = "Ville";
    private static final String COL_PARTENAIRE = "Partenaire";
    private static final String COL_DISPOSITIF = "Dispositif";

    private static final String CREATE_TABLE_ETUDIANT =
            "CREATE TABLE " + TABLE_ETUDIANT + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOM + " TEXT NOT NULL, "
            + COL_PRENOM + " TEXT NOT NULL, " + COL_CLASSE + " TEXT NOT NULL, "
            + COL_SEMESTRE + " TEXT NOT NULL, " + COL_VOEU1 + " TEXT NOT NULL, "
            + COL_VOEU2 + " TEXT NOT NULL, " + COL_VOEU3 + " TEXTE NOT NULL, "
            + COL_VOEU4 + " TEXT NOT NULL, " + COL_VOEU5 + " TEXT NOT NULL);";

    private static final String CREATE_TABLE_PARTENAIRE =
            "CREATE TABLE " + TABLE_PARTENAIRE + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_ECOLE + " TEXT NOT NULL, "
            + COL_VILLE + " TEXT NOT NULL);";

    private static final String CREATE_TABLE_OFFRE =
            "CREATE TABLE " + TABLE_OFFRE + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_PARTENAIRE + " TEXT NOT NULL, "
            + COL_DISPOSITIF + " TEXT NOT NULL, " + COL_CLASSE + " TEXT NOT NULL, "
            + COL_SEMESTRE + " TEXT NOT NULL);";

    public MaBaseSQLite(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on crée la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_TABLE_ETUDIANT);
        db.execSQL(CREATE_TABLE_PARTENAIRE);
        db.execSQL(CREATE_TABLE_OFFRE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0
        db.execSQL("DROP TABLE " + TABLE_ETUDIANT + ";");
        db.execSQL("DROP TABLE " + TABLE_PARTENAIRE + ";");
        db.execSQL("DROP TABLE " + TABLE_OFFRE + ";");
        onCreate(db);
    }
}