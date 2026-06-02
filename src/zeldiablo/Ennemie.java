package zeldiablo;


public class Ennemie extends Personnage {

        private int xFin;
        private int yFin;
        private int xDeb;
        private int yDeb;


    public Ennemie(int x, int y, int xf, int yf, int xd, int yd) {
        super(x, y);
        this.xFin = xf;
        this.yFin = yf;
        this.xDeb = xd;
        this.yDeb = yd;
    }

    public void seDeplacerH() {
        int[] pos = getPosition();
        setPosition(pos[0] + 1, pos[1]);
    }

    public void seDeplacerV() {
        int[] pos = getPosition();
        setPosition(pos[0], pos[1] + 1);
    }

    public boolean finPaterne() {
        int[] pos = getPosition();
        return (pos[0] == xFin && pos[1] == yFin);
    }

    public void reset() {
        setPosition(xDeb, yDeb);
    }
}
