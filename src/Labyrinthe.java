public class Labyrinthe {
    public static final char Mur = '#';
    public static final char Vide = ' ';
    public static final char Caisse = '$';
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

    public void setMur(int x, int y, boolean estUnMur) {
        if (x >= 0 && x < murs.length && y >= 0 && y < murs[0].length) {
            this.murs[x][y] = estUnMur;
        }
    }

    public boolean[][] getMur() {
        return murs;
    }
}