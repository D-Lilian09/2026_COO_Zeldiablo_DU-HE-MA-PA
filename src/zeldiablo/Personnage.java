package zeldiablo;

public  class Personnage {
    private int x;
    private int y;

    public Personnage(int x, int y){
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

    public void seDeplacer(String x,Labyrinthe l){
        int[] pos = this.getPosition();
        if(x.equals("haut")){
            pos[1] -= 1;
            if (l.etreLimite(pos[0],pos[1])){
                this.setPosition(pos[0] , pos[1]);
            }
        }
        if(x.equals("bas")){
            pos[1] += 1;
            if (l.etreLimite(pos[0],pos[1])){
                this.setPosition(pos[0] , pos[1]);
            }
        }
        if(x.equals("droite")){
            pos[0] += 1;
            if (l.etreLimite(pos[0],pos[1])){
                this.setPosition(pos[0] , pos[1]);
            }
        }
        if(x.equals("gauche")){
            pos[0] -= 1;
            if (l.etreLimite(pos[0],pos[1])){
                this.setPosition(pos[0] , pos[1]);
            }
        }
    }
}
