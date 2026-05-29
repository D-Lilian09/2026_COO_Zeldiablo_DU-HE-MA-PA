package demoMoteur;

import moteurJeu.DessinJeu;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinZeldiablo implements DessinJeu {

    public static final int TAILLE = 50;
    JeuZeldiablo jeu;

    public DessinZeldiablo(JeuZeldiablo j){
        this.jeu=j;
    }

    @Override
    public void dessiner(BufferedImage image) {
        Graphics g = image.getGraphics();
        g.setColor(Color.BLUE);
        g.fillRect(jeu.x*TAILLE, jeu.y*TAILLE, TAILLE, TAILLE);
        g.setColor(Color.RED);
        g.fillRect(jeu.mx*TAILLE, TAILLE, TAILLE, TAILLE);
    }
}
