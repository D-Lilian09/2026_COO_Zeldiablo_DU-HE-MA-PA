package zeldiablo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe qui représente la map du jeu (le labyrinthe)
 * elle gère la position des murs, les limites du terrain et la case de sortie du labyrinthe
 */
public class Labyrinthe {

    /** un tableau à deux dimensions pour savoir où sont les murs (vrai=mur, faux=vide) */
    private boolean[][] murs;

    /** la largeur totale de la fenêtre du jeu */
    private int largeur;

    /** la hauteur totale de la fenêtre du jeu */
    private int hauteur;

    /** la position x horizontale de la case de la sortie du labyrinthe */
    private int xFin;

    /** la position y verticale de la case de la sortie du labyrinthe */
    private int yFin;

    /**
     * construit un labyrinthe vide en préparant la grille en fonction de la taille de la fenêtre
     * la grille est divisée par 50 car chaque case fait 50 pixels
     *
     * @param largeur la largeur de la fenêtre en pixelsl
     * @param hauteur la hauteur de la fenêtre en pixelsl
     */
    public Labyrinthe(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.murs = new boolean[largeur / 50][hauteur / 50];
    }

    /**
     * lit un fichier txt pour construire le niveau case par case
     * dans le fichier texte les '#' sont des murs, et un '@' défini la sortie
     *
     * @param chemin l'emplacement du fichier texte à lire "Ressource/labyrinthe1.txt"
     * @return le labyrinthe prêt à être joué
     * @throws IOException si il y a un problème pour lire le fichier
     */
    public static Labyrinthe chargerFichier(String chemin) throws IOException {
        BufferedReader lecteur = new BufferedReader(new FileReader(chemin));
        List<String> lignes = new ArrayList<>();
        String ligne;

        while ((ligne = lecteur.readLine()) != null) {
            lignes.add(ligne);
        }
        lecteur.close();

        int hauteur = lignes.size();
        int largeur = lignes.get(0).length();

        Labyrinthe laby = new Labyrinthe(largeur * 50, hauteur * 50);


        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                char c = lignes.get(y).charAt(x);
                laby.murs[x][y] = (c == '#'); // true si mur, false sinon
                if (c == '@') {
                    laby.xFin = x;
                    laby.yFin = y;
                }
            }
        }

        return laby;
    }

    /**
     * vérifie si des coordonnées précises se trouvent bien à l'intérieur du labyrinthe
     * cela empêche les personnages de sortir du labyrinthe
     *
     * @param x la position horizontale à vérifier
     * @param y la position verticale à vérifier
     * @return vrai si on est dans les limites du labyrinthe, faux si on sort du jeu
     */
    public boolean etreLimite(int x, int y) {
        return (x >= 0 && x < (this.largeur / 50) && y >= 0 && y < (this.hauteur / 50));
    }

    /**
     * vérifie si il y a un mur à des coordonnées précises
     *
     * @param x la position horizontale à vérifier
     * @param y la position verticale à vérifier
     * @return vrai s'il y a un mur, faux si la case est libre ou en dehors du labyrinthe
     */
    public boolean etreMur(int x, int y) {
        if (x >= 0 && x < murs.length && y >= 0 && y < murs[0].length) {
            return murs[x][y];
        }
        return false;
    }

    /**
     * donne le nbr de cases en largeur dans le labyrinthe
     *
     * @return la largeur de la grille en nbr de cases
     */
    public int getLargeur() {
        return this.largeur / 50;
    }

    /**
     * Donne le nbr de cases en hauteur dans le labyrinthe
     *
     * @return la hauteur de la grille en nbr de cases
     */
    public int getHauteur() {
        return this.hauteur / 50;
    }

    /**
     * vérifie si des coordonnées précises correspondent à la case de sortie
     *
     * @param x la position horizontale à vérifier
     * @param y la position verticale à vérifier
     * @return vrai si c'est la sortie, faux si ça ne l'est pas
     */
    public boolean etreCaseFin(int x, int y) {
        return (x == this.xFin && y == this.yFin);
    }




}