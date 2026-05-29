package demoMoteur;

import moteurJeu.MoteurGraphique;

public class MainDemo {

    public static void main(String[] args) throws InterruptedException {
        JeuZeldiablo demo = new JeuZeldiablo();
        DessinZeldiablo dessin = new DessinZeldiablo(demo);

        MoteurGraphique mg = new MoteurGraphique(demo,dessin);
        mg.lancerJeu(1000,700);
    }
}
