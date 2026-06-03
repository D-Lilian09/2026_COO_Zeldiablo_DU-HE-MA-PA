package demoMoteur;

import moteurJeu.DessinJeu;
import zeldiablo.Ennemie;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DessinZeldiablo implements DessinJeu {

    public static final int TAILLE = 50;
    public static final int SAUT = 25;

    JeuZeldiablo jeu;
    private BufferedImage imgMur;
    private BufferedImage imgFin;

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

    private void dessinerTemps(Graphics2D g) {
        long secondes = jeu.getTemps();
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString(secondes + "s", 10, TAILLE - 15);
    }


    private void dessinerEnnemis(Graphics g) {


        g.setColor(Color.RED);
        for (Ennemie e : jeu.getEnnemies()) {
            int[] posE = e.getPosition();
            g.fillRect(posE[0] * TAILLE, posE[1] * TAILLE, TAILLE, TAILLE);
        }
    }

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
