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
        Graphics g = image.getGraphics();

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
        
        // Dessiner les ennemis
        g.setColor(Color.RED);
        for (Ennemie e : jeu.getEnnemies()) {
            int[] posE = e.getPosition();
            g.fillRect(posE[0] * TAILLE, posE[1] * TAILLE, TAILLE, TAILLE);
        }

        // Dessiner le personnage
        int[] pos = jeu.perso.getPosition();
        g.setColor(Color.BLUE);
        g.fillRect(pos[0] * TAILLE, pos[1] * TAILLE, TAILLE, TAILLE);
    }
}
