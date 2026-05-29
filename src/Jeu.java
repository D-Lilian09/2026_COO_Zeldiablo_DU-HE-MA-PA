
public class Jeu {

    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    private Labyrinthe laby;
    private Personnage perso;

    public Jeu(Labyrinthe laby, Personnage perso) {
        this.laby = laby;
        this.perso = perso;
    }

    public void deplacerPerso(String action) throws ActionInconnueException {
        if (!action.equals(HAUT) && !action.equals(BAS) &&
                !action.equals(GAUCHE) && !action.equals(DROITE)) {
            throw new ActionInconnueException("Action non reconnue : " + action);
        }

        int[] nextP = getSuivant(this.perso.getX(), this.perso.getY(), action);
        int nx = nextP[0];
        int ny = nextP[1];

        if (this.laby.etreMur(nx, ny)) {
            return;
        }
    }

    public Labyrinthe getLaby() { return laby; }
    public Personnage getPerso() { return perso; }

    public char getChar(int x, int y) {
        if (this.laby.etreMur(x, y)) {
            return Labyrinthe.MUR;
        }

        if (this.perso.getX() == x && this.perso.getY() == y) {
            return Labyrinthe.PJ;
        }

        return Labyrinthe.VIDE;
    }

    public static int[] getSuivant(int x, int y, String action) {
        int proX = x;
        int proY = y;

        if (action.equals(HAUT)) {
            proY = y - 1;
        } else if (action.equals(BAS)) {
            proY = y + 1;
        } else if (action.equals(GAUCHE)) {
            proX = x - 1;
        } else if (action.equals(DROITE)) {
            proX = x + 1;
        }

        return new int[]{proX, proY};
    }


}