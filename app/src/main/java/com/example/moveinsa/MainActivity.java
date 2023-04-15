package com.example.moveinsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        EtudiantBDD moveInsaBdd = new EtudiantBDD(this);

        //Création d'un etudiant
        Etudiant etudiant = new Etudiant("Grégory", "Waille", "MIQ", 6, "0", "0", "0", "0", "0");

        //On ouvre la base de données pour écrire dedans
        moveInsaBdd.open();

        //On insère le etudiant que l'on vient de créer
        moveInsaBdd.insertEtudiant(etudiant);
        //Pour vérifier que l'on a bien créé notre etudiant dans la BDD
        //on extrait le etudiant de la BDD grâce au titre du etudiant que l'on a créé précédemment
        Etudiant etudiantFromBdd = moveInsaBdd.getEtudiantClasse("MIQ");

        //Si un etudiant est retourné (donc si le etudiant à bien été ajouté à la BDD)
        if(etudiantFromBdd != null) {
            System.out.println(etudiantFromBdd.toString());
            //On affiche les infos du etudiant dans un Toast
            Toast.makeText(this, etudiantFromBdd.toString(), Toast.LENGTH_LONG).show();
        }

        moveInsaBdd.close();
    }
}