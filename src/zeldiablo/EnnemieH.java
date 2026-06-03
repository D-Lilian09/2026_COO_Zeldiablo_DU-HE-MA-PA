package zeldiablo;

public class EnnemieH extends Ennemie {

    public EnnemieH(int x, int y, int xf, int yf, int xd, int yd){
        super(x,y,xf,yf,xd,yd);
    }

    public void seDeplacer() {
        int[] pos = getPosition();
        if (allerRetour) {
            setPosition(pos[0] + 1, pos[1]);
        } else {
            setPosition(pos[0] - 1, pos[1]);
        }
    }

    public void finPaterne() {
        int[] pos = getPosition();
        if ((allerRetour && pos[0] >= xFin) || (!allerRetour && pos[0] <= xDeb)) {
            this.allerRetour = !this.allerRetour;
        }
    }
}
