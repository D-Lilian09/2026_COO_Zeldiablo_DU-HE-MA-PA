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
    ArrayList<Ennemie> ennemies;



    public JeuZeldiablo() {
        try {
            this.l = Labyrinthe.chargerFichier("Ressource/labyrinthe1.txt");
        } catch (IOException e) {
            this.l = new Labyrinthe(1500, 800);
        }
        this.perso = new Personnage(8, 14); //spawn du perso
        this.ennemies = new ArrayList<Ennemie>();

        //ennemis
        Ennemie e1 = new Ennemie(1, 1, 28, 1, 1, 1);
        ennemies.add(e1);
        Ennemie e2 = new Ennemie(11, 8, 16, 8, 11, 8);
        ennemies.add(e2);
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

        // Déplacement des ennemis
        for (Ennemie e : this.ennemies) {
            if (e.finPaterne()) {
                e.reset();
            } else {
                e.seDeplacerH();
            }
        }
    }

    public boolean etreFini() {
        int[] pos = this.perso.getPosition();
        return this.l.etreCaseFin(pos[0], pos[1]);
    }

    public Labyrinthe getLabyrinthe() {
        return this.l;
    }

    public ArrayList<Ennemie> getEnnemies() {
        return this.ennemies;
    }

}
