package zeldiablo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Labyrinthe {

    private boolean[][] murs;
    private int largeur;
    private int hauteur;
    private int xFin;
    private int yFin;
   

    public Labyrinthe(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.murs = new boolean[largeur / 50][hauteur / 50];
    }

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

    public boolean etreLimite(int x, int y) {
        return (x >= 0 && x < (this.largeur / 50) && y >= 0 && y < (this.hauteur / 50));
    }

    public boolean etreMur(int x, int y) {
        if (x >= 0 && x < murs.length && y >= 0 && y < murs[0].length) {
            return murs[x][y];
        }
        return false;
    }

    public int getLargeur() {
        return this.largeur / 50;
    }

    public int getHauteur() {
        return this.hauteur / 50;
    }

    public boolean etreCaseFin(int x, int y) {
        return (x == this.xFin && y == this.yFin);
    }




}