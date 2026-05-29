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
        int[] pos = jeu.perso.getPosition();
        g.setColor(Color.BLUE);
        g.fillRect(pos[0] * TAILLE, pos[1] * TAILLE, TAILLE, TAILLE);
        g.setColor(Color.RED);
        g.fillRect(jeu.mx*TAILLE, TAILLE, TAILLE, TAILLE);
    }
}
