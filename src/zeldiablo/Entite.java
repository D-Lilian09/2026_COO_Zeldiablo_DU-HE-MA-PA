package zeldiablo;

/**
 * classe de base pour tous les éléments qui ont une position sur la carte
 * le personnage principal ou les ennemis utilisent tous cette classe
 * pour savoir où ils se trouvent dans la map
 */
public class Entite {

    /** position horizontale sur la carte */
    protected int x;

    /** position verticale sur la carte */
    protected int y;

    /**
     * construit une nouvelle entité et la place à un endroit précis
     *
     * @param x la position horizontale de départ
     * @param y la position verticale de départ
     */
    public Entite(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * permet de récupérer les coordonnées actuelles de l'entité
     *
     * @return un tableau de deux cases, la première contient le x et la deuxième le y
     */
    public int[] getPosition(){
        int[] position = new int[2];
        position [0] = this.x;
        position [1] = this.y;

        return position;
    }

    /**
     * permet de modifier les coordonnées de l'entité pour la déplacer
     *
     * @param x la nouvelle position horizontale
     * @param y la nouvelle position verticale
     */
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}