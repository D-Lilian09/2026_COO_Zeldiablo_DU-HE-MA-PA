package demoMoteur;

import moteurJeu.Commande;
import moteurJeu.Jeu;
import zeldiablo.Labyrinthe;
import zeldiablo.Personnage;

import java.io.IOException;

public class JeuZeldiablo implements Jeu {
    Personnage perso;
    int mx = 1;
    Labyrinthe l;

    public JeuZeldiablo() {
        try {
            this.l = Labyrinthe.chargerFichier("Ressource/labyrinthe1.txt");
        } catch (IOException e) {
            this.l = new Labyrinthe(1500, 800);
        }
        this.perso = new Personnage(1, 1); //spawn du perso
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

        mx ++;
        if (mx>10)
            mx =0;
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
