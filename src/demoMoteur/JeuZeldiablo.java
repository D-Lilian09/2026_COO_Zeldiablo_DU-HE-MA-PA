package demoMoteur;

import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuZeldiablo implements Jeu {
    int x=1, y=1;
    int mx = 1;


    public void evoluer (Commande c){
        if (c.gauche)
            this.seDeplacer("gauche");
        if (c.droite)
            this.seDeplacer("droite");
        if (c.haut)
            this.seDeplacer("haut");
        if (c.bas)
            this.seDeplacer("bas");

        mx ++;
        if (mx>10)
            mx =0;
    }

    @Override
    public boolean etreFini() {
        return false;
    }

}
