package zeldiablo;

public class Labyrinthe {

    private boolean[][] murs;
    private int largeur;
    private int hauteur;

    public Labyrinthe(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.murs = new boolean[largeur / 50][hauteur / 50];
    }

    public boolean etreLimite(int x, int y) {
        return (x >= 0 && x < (this.largeur / 50) && y >= 0 && y < (this.hauteur / 50));
    }




}