package zeldiablo;

import java.util.ArrayList;

public  class Personnage extends Entite{
    private int xd;
    private int yd;


    public Personnage(int x, int y){
        super(x,y);
        this.xd = x;
        this.yd = y;
    }

    public int[] getPositionRespawn(){
        int[] position = new int[2];
        position [0] = this.xd;
        position [1] = this.yd;

        return position;
    }


    public void seDeplacer(String x,Labyrinthe l){
        int[] pos = this.getPosition();
        if(x.equals("haut")){
            pos[1] -= 1;
            if (l.etreLimite(pos[0],pos[1]) && !l.etreMur(pos[0],pos[1])){
                this.setPosition(pos[0] , pos[1]);
            }
        }
        if(x.equals("bas")){
            pos[1] += 1;
            if (l.etreLimite(pos[0],pos[1])&& !l.etreMur(pos[0],pos[1])){
                this.setPosition(pos[0] , pos[1]);
            }
        }
        if(x.equals("droite")){
            pos[0] += 1;
            if (l.etreLimite(pos[0],pos[1])&& !l.etreMur(pos[0],pos[1])){
                this.setPosition(pos[0] , pos[1]);
            }
        }
        if(x.equals("gauche")){
            pos[0] -= 1;
            if (l.etreLimite(pos[0],pos[1])&& !l.etreMur(pos[0],pos[1])){
                this.setPosition(pos[0] , pos[1]);
            }
        }
    }

    public boolean estMort(ArrayList<Ennemie> e) {
        int l = e.size();
        for (int i = 0; i < l; i++) {
            if (e.get(i).getPosition()[0] == this.x && e.get(i).getPosition()[1] == this.y) {
                return true;
            }
        }
        return false;
    }
}
