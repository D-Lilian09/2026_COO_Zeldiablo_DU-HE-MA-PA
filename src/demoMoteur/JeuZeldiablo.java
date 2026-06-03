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
    ArrayList<Ennemie> ennemiesH; // Ennemis horizontaux
    ArrayList<Ennemie> ennemiesV; // Ennemis verticaux



    public JeuZeldiablo() {
        try {
            this.l = Labyrinthe.chargerFichier("Ressource/labyrinthe1.txt");
        } catch (IOException e) {
            this.l = new Labyrinthe(1500, 800);
        }
        this.perso = new Personnage(8, 14); //spawn du perso
        this.ennemies = new ArrayList<Ennemie>();
        this.ennemiesH = new ArrayList<Ennemie>();
        this.ennemiesV = new ArrayList<Ennemie>();

        // Ennemis horizontaux
        Ennemie e1 = new Ennemie(1, 1, 28, 1, 1, 1);
        ennemiesH.add(e1);
        ennemies.add(e1);

        Ennemie e2 = new Ennemie(11, 8, 19, 8, 11, 8);
        ennemiesH.add(e2);
        ennemies.add(e2);

        Ennemie e3 = new Ennemie(10, 14, 22, 14, 10, 14);
        ennemiesH.add(e3);
        ennemies.add(e3);

        // Ennemis verticaux
        Ennemie e4 = new Ennemie(4, 3, 4, 10, 4, 3);
        ennemiesV.add(e4);
        ennemies.add(e4);
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

        if (perso.estMort(ennemies))
            perso.setPosition(perso.getPositionRespawn()[0],perso.getPositionRespawn()[1]);
        // Déplacement des ennemis horizontaux
        for (Ennemie e : this.ennemiesH) {
            e.finPaterne();
            e.seDeplacerH();
        }

        // Déplacement des ennemis verticaux
        for (Ennemie e : this.ennemiesV) {
            e.finPaterne();
            e.seDeplacerV();
        }
        if (perso.estMort(ennemies))
            perso.setPosition(perso.getPositionRespawn()[0],perso.getPositionRespawn()[1]);

    }

    public boolean etreFini() {
        int[] pos = this.perso.getPosition();
        return (this.l.etreCaseFin(pos[0], pos[1]));
    }

    public Labyrinthe getLabyrinthe() {
        return this.l;
    }

    public ArrayList<Ennemie> getEnnemies() {
        return this.ennemies;
    }

}
