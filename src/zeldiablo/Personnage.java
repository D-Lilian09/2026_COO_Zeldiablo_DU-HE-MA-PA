package zeldiablo;

public  class Personnage {
    private int x;
    private int y;

    public Personnage(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int[] getPosition(){
        int[] position = new int[3];
        position [1] = this.x;
        position [2] = this.y;

        return position;
    }
}
