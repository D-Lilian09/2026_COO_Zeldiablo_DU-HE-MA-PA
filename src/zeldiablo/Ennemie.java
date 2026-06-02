package zeldiablo;


public class Ennemie extends Personnage {

    private int xFin;
    private int yFin;
    private int xDeb;
    private int yDeb;
    private boolean allerRetour; // true = aller vers fin, false = retour vers deb


    public Ennemie(int x, int y, int xf, int yf, int xd, int yd) {
        super(x, y);
        this.xFin = xf;
        this.yFin = yf;
        this.xDeb = xd;
        this.yDeb = yd;
        this.allerRetour = true; // commence par aller vers la fin
    }

    public void seDeplacerH() {
        int[] pos = getPosition();
        if (allerRetour) {
            setPosition(pos[0] + 1, pos[1]);
        } else {
            setPosition(pos[0] - 1, pos[1]);
        }
    }

    public void seDeplacerV() {
        int[] pos = getPosition();
        if (allerRetour) {
            setPosition(pos[0], pos[1] + 1);
        } else {
            setPosition(pos[0], pos[1] - 1);
        }
    }

    public boolean finPaterne() {
        int[] pos = getPosition();
        if (allerRetour && pos[0] == xFin && pos[1] == yFin) {
            allerRetour = false; // inverse la direction
            return true;
        } else if (!allerRetour && pos[0] == xDeb && pos[1] == yDeb) {
            allerRetour = true; // inverse la direction
            return true;
        }
        return false;
    }

    public void reset() {
        setPosition(xDeb, yDeb);
        allerRetour = true;
    }
}