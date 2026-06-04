package demoMoteur;

import moteurJeu.Commande;
import moteurJeu.Jeu;
import zeldiablo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

/**
 * Classe principale qui gère la logique du jeu Zeldiablo.
 * Elle contient la carte (le labyrinthe), le joueur, et tous les ennemis.
 */
public class JeuZeldiablo implements Jeu {

    /**
     * Le personnage principal contrôlé par le joueur.
     */
    Personnage perso;

    /**
     * La carte du niveau actuel.
     */
    Labyrinthe l;

    /**
     * La liste regroupant tous les ennemis présents sur la carte.
     */
    ArrayList<Ennemie> ennemies;

    private long tempsDebut;

    private int nbMort;

    /**
     * Constructeur du jeu.
     * Prépare la partie : charge le fichier du labyrinthe, place le personnage
     * à son point de départ, et positionne les différents ennemis.
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

    /**
     * Met à jour le jeu à chaque instant (chaque "tic").
     * Cette méthode déplace le personnage selon les touches appuyées,
     * gère les déplacements automatiques des ennemis, et vérifie si le joueur meurt (collision).
     *
     * @param c Les commandes du joueur (touches directionnelles appuyées).
     * @param l Le labyrinthe actuel (non utilisé directement dans la méthode, mais requis par l'interface).
     */
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

    /**
     * Vérifie si la partie est gagnée.
     *
     * @return true si le personnage a atteint la case de fin, false sinon.
     */
    public boolean etreFini() {
        int[] pos = this.perso.getPosition();
        return (this.l.etreCaseFin(pos[0], pos[1]));

    }

    /**
     * Permet de récupérer la carte du jeu en cours.
     *
     * @return Le labyrinthe actuel.
     */
    public Labyrinthe getLabyrinthe() {
        return this.l;
    }



    /**
     * Permet de récupérer la liste de tous les ennemis.
     *
     * @return La liste des ennemis.
     */
    public ArrayList<Ennemie> getEnnemies() {
        return this.ennemies;
    }

}