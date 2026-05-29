package zeldiablo;

public class Labyrinthe {

    private boolean[][] murs;

    public Labyrinthe(int largeur, int hauteur) {
        this.murs = new boolean[largeur][hauteur];
    }

    public boolean etreMur(int x, int y) {
        if (x < 0 || x >= murs.length || y < 0 || y >= murs[0].length) {
            return true;
        }
        return this.murs[x][y];
    }




}