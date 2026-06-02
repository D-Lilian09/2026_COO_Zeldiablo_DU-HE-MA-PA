package demoMoteur;

import moteurJeu.Commande;
import moteurJeu.Jeu;
import zeldiablo.Ennemie;
import zeldiablo.Labyrinthe;
import zeldiablo.Personnage;

import java.io.IOException;
import java.util.ArrayList;

public class JeuZeldiablo implements Jeu {
    Personnage perso;
    Labyrinthe l;



    public JeuZeldiablo() {
        try {
            this.l = Labyrinthe.chargerFichier("Ressource/labyrinthe1.txt");
        } catch (IOException e) {
            this.l = new Labyrinthe(1500, 800);
        }
        this.perso = new Personnage(8, 14); //spawn du perso
    }

    public void evoluer (Commande c, Labyrinthe l){
        if (c.gauche)
            this.perso.seDeplacer("gauche",this.l);
        if (c.droite)
            this.perso.seDeplacer("droite",this.l);
        if (c.haut)
            this.perso.seDeplacer("haut",this.l);
        if (c.bas)
            this.perso.seDeplacer("bas",this.l);


        //Liste Ennemie
        ArrayList<Ennemie> ennemies = new ArrayList<Ennemie>();
        //ennemie 1
        Ennemie e1 = new Ennemie(2, 2, 29, 2, 2, 2);
        ennemies.add(e1);

        if (e1.finPaterne()){
            e1.reset();
        }else{
            e1.seDeplacerH();
        }




    }

    @Override
    public boolean etreFini() {
        int[] pos = this.perso.getPosition();
        return this.l.etreCaseFin(pos[0], pos[1]);
    }

    public Labyrinthe getLabyrinthe() {
        return this.l;
    }

}
