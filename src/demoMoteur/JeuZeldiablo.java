package demoMoteur;

import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuZeldiablo implements Jeu {
    int x=1, y=1;
    int mx = 1;


    public void evoluer (Commande c){
        if (c.gauche)
            x--;
        if (c.droite)
            x++;
        if (c.haut)
            y--;
        if (c.bas)
            y++;

        mx ++;
        if (mx>10)
            mx =0;
    }

    @Override
    public boolean etreFini() {
        return false;
    }

}
