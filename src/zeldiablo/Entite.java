package zeldiablo;

public class Entite {
    protected int x;
    protected int y;

    public Entite(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int[] getPosition(){
        int[] position = new int[2];
        position [0] = this.x;
        position [1] = this.y;

        return position;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}


