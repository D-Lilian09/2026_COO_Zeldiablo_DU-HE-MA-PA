package demoMoteur;

import moteurJeu.DessinJeu;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinZeldiablo implements DessinJeu {

    JeuZeldiablo jeu;

    public DessinZeldiablo(JeuZeldiablo j){
        this.jeu=j;
    }

    @Override
    public void dessiner(BufferedImage image) {
        Graphics g = image.getGraphics();
        g.setColor(Color.BLUE);
        g.fillRect(jeu.x, jeu.y,50, 50);
    }
}
