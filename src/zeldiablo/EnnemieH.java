package zeldiablo;

/**
 * classe qui représente un ennemi se déplaçant horizontalement
 * c'est une version spécifique de l'ennemi de base
 */
public class EnnemieH extends Ennemie {

    /**
     * construit un ennemi horizontal en lui donnant ses coordonnées de ronde
     *
     * @param x position x actuelle au moment de la création
     * @param y position y actuelle au moment de la création
     * @param xf position x de la fin de son parcours (son maximum à droite)
     * @param yf position y de la fin de son parcours (la même que y car il reste sur la même ligne)
     * @param xd position x de son point de départ (son maximum à gauche)
     * @param yd position y de son point de départ
     */
    public EnnemieH(int x, int y, int xf, int yf, int xd, int yd){
        super(x,y,xf,yf,xd,yd);
    }

    /**
     * gère les mouvements de l'ennemi sur la carte
     * si il est sur l'aller de son parcours, il avance d'une case vers la droite (+1 sur l'axe X)
     * si il est sur le retour de son parcours, il avance d'une case vers la gauche (-1 sur l'axe X)
     */
    public void seDeplacer() {
        int[] pos = getPosition();
        if (allerRetour) {
            setPosition(pos[0] + 1, pos[1]);
        } else {
            setPosition(pos[0] - 1, pos[1]);
        }
    }

    /**
     * vérifie si l'ennemi est arrivé au bout de sa ligne
     * si il dépasse sa limite à droite (xFin) ou sa limite à gauche (xDeb)
     * il fait tout simplement demi tour pour repartir dans le sens inverse
     */
    public void finPaterne() {
        int[] pos = getPosition();
        if ((allerRetour && pos[0] >= xFin) || (!allerRetour && pos[0] <= xDeb)) {
            this.allerRetour = !this.allerRetour;
        }
    }
}