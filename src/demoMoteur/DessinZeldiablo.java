package demoMoteur;

import moteurJeu.DessinJeu;
import zeldiablo.Ennemie;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * classe responsable de l'affichage graphique du jeu Zeldiablo
 * elle implémente l'interface DessinJeu
 */
public class DessinZeldiablo implements DessinJeu {

    /** la taille d'une case en pixels sur l'écran */
    public static final int TAILLE = 50;

    /** la taille d'un déplacement */
    public static final int SAUT = 25;

    /** le jeu en cours que l'on doit dessiner */
    JeuZeldiablo jeu;

    /** l'image représentant un mur */
    private BufferedImage imgMur;

    /** l'image représentant la case de fin */
    private BufferedImage imgFin;

    /**
     * constructeur de la classe
     * initialise le jeu et charge les image depuis le dossier "Ressource"
     *
     * @param j le jeu Zeldiablo à afficher
     */
    public DessinZeldiablo(JeuZeldiablo j){
        this.jeu=j;
        try {
            this.imgMur = ImageIO.read(new File("Ressource/mur.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.imgFin = ImageIO.read(new File("Ressource/Fin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * méthode principale qui dessine tous les éléments du jeu sur l'écran
     * elle appelle les autre méthodes pour dessiner le labyrinthe, les ennemis, le héros, le temps et le compteur de morts
     *
     * @param image l'image sur laquelle tout va être dessiné.
     */
    @Override
    public void dessiner(BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();

        dessinerCarte(g);

        // Dessiner les ennemis
        dessinerEnnemis(g);

        // Dessiner le personnage
        int[] pos = jeu.perso.getPosition();
        g.setColor(Color.BLUE);
        g.fillRect(pos[0] * TAILLE, pos[1] * TAILLE, TAILLE, TAILLE);

        //Dessiner le Temps
        dessinerTemps(g);

        //Dessiner les morts
        int m = jeu.getMort();
        String texte = "Morts : " + m;
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        FontMetrics fm = g.getFontMetrics();
        int largeurTexte = fm.stringWidth(texte);
        g.drawString(texte, image.getWidth() - largeurTexte - 10, TAILLE - 15);
    }

    /**
     * dessine le chronomètre en haut à gauche de l'écran.
     *
     * @param g l'outil graphique utilisé pour dessiner.
     */
    private void dessinerTemps(Graphics2D g) {
        long secondes = jeu.getTemps();
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString(secondes + "s", 10, TAILLE - 15);
    }

    /**
     * dessine tous les ennemis présents dans le jeu sous forme de carrés rouges
     *
     * @param g l'outil graphique utilisé pour dessiner
     */
    private void dessinerEnnemis(Graphics g) {
        g.setColor(Color.RED);
        for (Ennemie e : jeu.getEnnemies()) {
            int[] posE = e.getPosition();
            g.fillRect(posE[0] * TAILLE, posE[1] * TAILLE, TAILLE, TAILLE);
        }
    }

    /**
     * dessine le labyrinthe : les murs, la case d'arrivée et les cases vides.
     *
     * @param g l'outil graphique utilisé pour dessiner
     */
    private void dessinerCarte(Graphics g) {
        for (int y = 0; y < jeu.l.getHauteur(); y++) {
            for (int x = 0; x < jeu.l.getLargeur(); x++) {
                if (jeu.l.etreMur(x, y)) {
                    if (imgMur != null) {
                        g.drawImage(imgMur, x * TAILLE, y * TAILLE, TAILLE, TAILLE, null);
                    } else {
                        g.setColor(Color.GRAY);
                        g.fillRect(x * TAILLE, y * TAILLE, TAILLE, TAILLE);
                    }
                } else if (jeu.l.etreCaseFin(x, y)) {
                    if (imgFin != null) {
                        g.drawImage(imgFin, x * TAILLE, y * TAILLE, TAILLE, TAILLE, null);
                    } else {
                        g.setColor(Color.GREEN);
                        g.fillRect(x * TAILLE, y * TAILLE, TAILLE, TAILLE);
                    }
                } else {
                    // Dessiner les cases vides en blanc
                    g.setColor(Color.WHITE);
                    g.fillRect(x * TAILLE, y * TAILLE, TAILLE, TAILLE);
                }
            }
        }
    }
}