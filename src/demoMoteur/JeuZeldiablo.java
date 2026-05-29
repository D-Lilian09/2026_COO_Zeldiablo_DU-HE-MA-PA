package demoMoteur;

import moteurJeu.Commande;
import moteurJeu.Jeu;
import zeldiablo.Labyrinthe;
import zeldiablo.Personnage;

public class JeuZeldiablo implements Jeu {
    Personnage perso;
    int mx = 1;
    Labyrinthe l;

    public JeuZeldiablo() {
        this.l = new Labyrinthe(1000,700); // À adapter selon les paramètres de votre constructeur Labyrinthe
        this.perso = new Personnage(1, 1); // À adapter selon les paramètres de votre constructeur Personnage (ex: coordonnées x=1, y=1)
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
        return false;
    }

    public Labyrinthe getLabyrinthe() {
        return this.l;
    }

}
