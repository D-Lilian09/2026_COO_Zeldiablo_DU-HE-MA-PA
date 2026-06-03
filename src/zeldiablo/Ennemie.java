package zeldiablo;


public class Ennemie extends Entite {

    protected int xFin;
    protected int yFin;
    protected int xDeb;
    protected int yDeb;
    protected boolean allerRetour;


    public Ennemie(int x, int y, int xf, int yf, int xd, int yd) {
        super(x, y);
        this.xFin = xf;
        this.yFin = yf;
        this.xDeb = xd;
        this.yDeb = yd;
        this.allerRetour = true;
    }

    public void seDeplacer() {}

    public void finPaterne() {}

    public void reset() {
        setPosition(xDeb, yDeb);
        allerRetour = true;
    }
}