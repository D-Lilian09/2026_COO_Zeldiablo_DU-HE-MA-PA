package demoMoteur;

import moteurJeu.MoteurGraphique;

/**
 * Classe qui sert tout simplement à lancer le jeu Zeldiablo.
 */
public class MainDemo {

    /**
     * C'est ici que le programme démarre.
     * On crée le jeu, on prépare son affichage, et on ouvre la fenêtre à la bonne taille.
     *
     * @param args Les arguments du terminal (on ne s'en sert pas ici).
     * @throws InterruptedException Si le jeu s'arrête de manière imprévue.
     */
    public static void main(String[] args) throws InterruptedException {
        JeuZeldiablo demo = new JeuZeldiablo();
        DessinZeldiablo dessin = new DessinZeldiablo(demo);

        MoteurGraphique mg = new MoteurGraphique(demo,dessin);
        mg.lancerJeu(1500,800);
    }
}