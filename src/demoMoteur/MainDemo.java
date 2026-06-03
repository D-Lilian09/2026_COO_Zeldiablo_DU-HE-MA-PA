package demoMoteur;

import moteurJeu.MoteurGraphique;

/**
 * classe qui sert à lancer le jeu Zeldiablo
 */
public class MainDemo {

    /**
     * le programme démarre ici
     * on crée le jeu, répare son affichage et on ouvre la fenêtre à la bonne taille
     *
     * @throws InterruptedException si le jeu s'arrête de manière imprévu
     */
    public static void main(String[] args) throws InterruptedException {
        JeuZeldiablo demo = new JeuZeldiablo();
        DessinZeldiablo dessin = new DessinZeldiablo(demo);

        MoteurGraphique mg = new MoteurGraphique(demo,dessin);
        mg.lancerJeu(1500,800);
    }
}