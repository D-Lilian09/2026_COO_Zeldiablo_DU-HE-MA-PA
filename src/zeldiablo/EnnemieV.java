package zeldiablo;

public class EnnemieV extends Ennemie {

    public EnnemieV(int x, int y, int xf, int yf, int xd, int yd){
        super(x,y,xf,yf,xd,yd);
    }

    public void seDeplacer() {
        int[] pos = getPosition();
        if (allerRetour) {
            setPosition(pos[0], pos[1] + 1);
        } else {
            setPosition(pos[0], pos[1] - 1);
        }
    }

    public void finPaterne() {
        int[] pos = getPosition();
        if ((allerRetour && pos[1] >= yFin) || (!allerRetour && pos[1] <= yDeb)) {
            this.allerRetour = !this.allerRetour;
        }
    }
}
