package zeldiablo;

import java.util.ArrayList;

/**
 * classe qui représente le personnage principal (le héro)
 * elle hérite de la classe Entite, mais rajoute des règles comme le déplacement
 * commandé par le joueur et la possibilité de mourir
 */
public  class Personnage extends Entite{

    /** position x horizontale de départ, utilisé pour faire réapparaître le joueur si il meurt */
    private int xd;

    /** position y verticale de départ, utilisé pour faire réapparaître le joueur si il meurt */
    private int yd;

    /**
     * crée le personnage et mémorise son point de départ pour le faire réaparraître
     *
     * @param x la position horizontale de départ
     * @param y la position verticale de départ
     */
    public Personnage(int x, int y){
        super(x,y);
        this.xd = x;
        this.yd = y;
    }

    /**
     * permet de récupérer les coordonnées du point d'apparition
     * utile pour renvoyer le joueur à la case départ quand il touche un ennemi et meurt donc
     *
     * @return un tableau de deux cases contenant le x et le y de départ.
     */
    public int[] getPositionRespawn(){
        int[] position = new int[2];
        position [0] = this.xd;
        position [1] = this.yd;

        return position;
    }

    /**
     * céplace le personnage dans le labyrinthe selon la direction demandée par le joueur
     * avant de se déplacer, la méthode vérifie tjrs si la case d'arrivée
     * est bien dans l'écran et si il n'y a pas un mur qui bloque le personnage
     *
     * @param x un texte indiquant la direction du mouvement ("haut", "bas", "droite" ou "gauche").
     * @param l le labyrinthe actuel pour vérifier les limites et les murs
     */
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

    /**
     * vérifie si le personnage s'est fait toucher par un ennemi
     * la méthode compare la position du joueur avec celle de chaque ennemi de la liste
     *
     * @param e la liste de tous les ennemis présents sur la carte
     * @return vrai si le joueur est sur la même case qu'un ennemi, faux si il ne l'est pas
     */
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