package zeldiablo;

/**
 * classe de base qui représente un ennemi dans le jeu.
 * un ennemi est une entité qui fait des aller retour
 * entre un point de départ et un point de fin
 */
public class Ennemie extends Entite {

    /** position x (horizontale) où l'ennemi s'arrête pour faire demi tour */
    protected int xFin;

    /** position y (verticale) où l'ennemi s'arrête pour revenir en arrière */
    protected int yFin;

    /** position x (horizontale) de départ de son chemin */
    protected int xDeb;

    /** position y (verticale) de départ de son chemin */
    protected int yDeb;

    /** * un interrupteur (vrai/faux) pour savoir si l'ennemi est en train de faire soit l'aller soit le retour
     */
    protected boolean allerRetour;

    /**
     * construit un ennemi en préparant son parcours
     *
     * @param x position x actuelle au moment de le création
     * @param y position y actuelle au moment de la création
     * @param xf position x de la fin de son parcours là où il fera demi tour
     * @param yf position y de la fin de son parcours
     * @param xd position x de son point de départ
     * @param yd position y de son point de départ
     */
    public Ennemie(int x, int y, int xf, int yf, int xd, int yd) {
        super(x, y);
        this.xFin = xf;
        this.yFin = yf;
        this.xDeb = xd;
        this.yDeb = yd;
        this.allerRetour = true;
    }

    /**
     * méthode prévue pour faire se déplacer l'ennemi d'une case
     * elle est vide ici : ce sont les autres classes (les ennemis horizontaux ou verticaux)
     * qui vont préciser comment ils bougent
     */
    public void seDeplacer() {}

    /**
     * méthode prévue pour vérifier si l'ennemi est arrivé au bout de son chemin
     * permettant de le faire repartir dans le sens inverse
     * elle est vide ici pour la même raison que seDeplacer().
     */
    public void finPaterne() {}

    /**
     * remet l'ennemi exactement à son point de départ
     */
    public void reset() {
        setPosition(xDeb, yDeb);
        allerRetour = true;
    }
}