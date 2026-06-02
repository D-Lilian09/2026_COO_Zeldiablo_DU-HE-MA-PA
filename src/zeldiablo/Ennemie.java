package zeldiablo;


public class Ennemie extends Personnage {

        private int x;
        private int y;
        private int xFin;
        private int yFin;
        private int xDeb;
        private int yDeb;


    public Ennemie(int x, int y, int xf, int yf, int xd, int yd) {
        super(x, y);
        this.xFin = xf;
        this.yFin = yf;
        this.xFin = xd;
        this.yFin = yd;
    }

    public void seDeplacerH() { x++;}

    public void seDeplacerV() { y++;}

    public boolean finPaterne() { return (x == xFin && y == yFin) ; }

    public void reset() { x = xDeb; y = yDeb;}
}
