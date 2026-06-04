package demoMoteur;

import moteurJeu.Commande;
import moteurJeu.Jeu;
import zeldiablo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

public class JeuZeldiablo implements Jeu {
    Personnage perso;
    Labyrinthe l;
    ArrayList<Ennemie> ennemies;

    private long tempsDebut;

    private int nbMort;

    /**
     * constructeur du jeu
     * ^répare la partie, charge le fichier du labyrinthe et place le personnage au point de spawn défini
     * et positionne les différents ennemis dans le niveau du jeu
     */


    public JeuZeldiablo() {
        try {
            this.l = Labyrinthe.chargerFichier("Ressource/labyrinthe1.txt");
        } catch (IOException e) {
            this.l = new Labyrinthe(1500, 800);
        }
        this.perso = new Personnage(8, 14); //spawn du perso
        this.ennemies = new ArrayList<Ennemie>();

        // Ennemis horizontaux
        EnnemieH e1 = new EnnemieH(1, 1, 28, 1, 1, 1);
        ennemies.add(e1);


        EnnemieH e2 = new EnnemieH(11, 8, 19, 8, 11, 8);
        ennemies.add(e2);

        EnnemieH e3 = new EnnemieH(10, 14, 22, 14, 10, 14);

        ennemies.add(e3);

        // Ennemis verticaux
        EnnemieV e4 = new EnnemieV(4, 3, 4, 10, 4, 3);
        ennemies.add(e4);

        this.tempsDebut = System.currentTimeMillis();
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

        if (perso.estMort(ennemies)) {
            perso.setPosition(perso.getPositionRespawn()[0], perso.getPositionRespawn()[1]);
            nbMort++;
            this.tempsDebut = System.currentTimeMillis();
        }

        for (Ennemie e : this.ennemies) {
            e.finPaterne();
            e.seDeplacer();
        }


        if (perso.estMort(ennemies)) {
            perso.setPosition(perso.getPositionRespawn()[0], perso.getPositionRespawn()[1]);
            nbMort++;
            this.tempsDebut = System.currentTimeMillis();
        }


    }

    public long getTemps() {
        return (System.currentTimeMillis() - tempsDebut) / 1000;
    }

    public int getMort() {
        return nbMort;
    }

    public boolean etreFini() {
        int[] pos = this.perso.getPosition();
        return (this.l.etreCaseFin(pos[0], pos[1]));

    }

    public Labyrinthe getLabyrinthe() {
        return this.l;
    }



    /**
     * permet de récupérer la liste de tous les ennemis du jeu
     *
     * @return la liste des ennemis
     */
    public ArrayList<Ennemie> getEnnemies() {
        return this.ennemies;
    }

}
