
public  class Personnage {
    private double hp;
    private int x;
    private int y;
    private double dgt;

    public Personnage(double hp, int x, int y, double dgt){
        this.hp = hp;
        this.x = x;
        this.y = y;
        this.dgt = dgt;
    }

    public void retirerHp(double retirer_hp){
        if(retirer_hp > 0){
            this.hp -= retirer_hp;
        }
    }

    public int getX(){return this.x;}

    public int getY(){return this.y;}

    public double getHp(){return this.hp;}

    public double getDgt(){return this.dgt;}

}
