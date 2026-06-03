package zeldiablo;

/**
 * classe qui représente un ennemi se déplaçant verticalement
 * c'est le même principe que l'ennemi horizontal, mais en bougeant sur l'axe Y.
 */
public class EnnemieV extends Ennemie {

    /**
     * construit un ennemi vertical en lui donnant ses coordonnées de son parcours
     *
     * @param x position x actuelle au moment de la création
     * @param y position y actuelle au moment de la création
     * @param xf position x de la fin de son parcours (la même que x car il reste sur la même colonne
     * @param yf position y de la fin de son parcours (son maximum vers le bas)
     * @param xd position x de son point de départ
     * @param yd position y de son point de départ (son maximum vers le haut)
     */
    public EnnemieV(int x, int y, int xf, int yf, int xd, int yd){
        super(x,y,xf,yf,xd,yd);
    }

    /**
     * gère le mouvement de l'ennemi sur la carte
     * si il est sur l'aller il descend d'une case (+1 sur l'axe Y)
     * si il est sur le retour il monte d'une case (-1 sur l'axe Y)
     */
    public void seDeplacer() {
        int[] pos = getPosition();
        if (allerRetour) {
            setPosition(pos[0], pos[1] + 1);
        } else {
            setPosition(pos[0], pos[1] - 1);
        }
    }

    /**
     * vérifie si l'ennemi est arrivé tout en bas ou tout en haut de son parcours
     * si il dépasse sa limite il fait demi tour pour repartir dans le sens inverse
     */
    public void finPaterne() {
        int[] pos = getPosition();
        if ((allerRetour && pos[1] >= yFin) || (!allerRetour && pos[1] <= yDeb)) {
            this.allerRetour = !this.allerRetour;
        }
    }
}