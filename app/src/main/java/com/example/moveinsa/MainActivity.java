package com.example.moveinsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EtudiantBDD etudiantBDD = new EtudiantBDD(this);
        PartenaireBDD partenaireBDD = new PartenaireBDD(this);
        OffreBDD offreBDD = new OffreBDD(this);

        //On ouvre la base de données pour écrire dedans
        etudiantBDD.open();
        partenaireBDD.open();
        offreBDD.open();

        //On insère les etudiants que l'on veut de créer
        etudiantBDD.insertEtudiant(new Etudiant("Grégory", "Waille", "MIQ", 6, "0", "0", "0", "0", "0"));
        etudiantBDD.insertEtudiant(new Etudiant("Valentin", "Girardet", "MIQ", 6, "0", "0", "0", "0", "0"));

        //On crée les écoles partenaires
        partenaireBDD.insertPartenaire(new Partenaire("Universidad de Buenos Aires", "Buenos Aires"));
        partenaireBDD.insertPartenaire(new Partenaire("École de Technologie Supérieure", "Montréal"));
        partenaireBDD.insertPartenaire(new Partenaire("Gwangju Institute of Science and Technology", "Gwangju"));
        partenaireBDD.insertPartenaire(new Partenaire("Universidad de Granada", "Granada"));
        partenaireBDD.insertPartenaire(new Partenaire("Illinois Institute of Technology", "Chicago"));
        partenaireBDD.insertPartenaire(new Partenaire("Politecnico di Milano", "Milano"));

        offreBDD.insertOffre(new Offre(1, "ER", "MIQ", 6));
        offreBDD.insertOffre(new Offre(1, "HR", "GM", 7));
        offreBDD.insertOffre(new Offre(2, "ER", "PL", 8));

        //Pour vérifier que l'on a bien créé notre etudiant dans la BDD
        //on extrait le etudiant de la BDD grâce au titre du etudiant que l'on a créé précédemment
        Etudiant etudiantFromBdd = etudiantBDD.getEtudiantClasse("MIQ");

        //Si un etudiant est retourné (donc si le etudiant à bien été ajouté à la BDD)
        if(etudiantFromBdd != null) {
            System.out.println(etudiantFromBdd);
            //On affiche les infos du etudiant dans un Toast
            Toast.makeText(this, etudiantFromBdd.toString(), Toast.LENGTH_LONG).show();
        }

        etudiantBDD.close();
        partenaireBDD.close();
        offreBDD.close();
    }
}