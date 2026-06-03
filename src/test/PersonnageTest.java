package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zeldiablo.Ennemie;
import zeldiablo.Labyrinthe;
import zeldiablo.Personnage;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {

    private Personnage perso;
    private Labyrinthe laby;

    @BeforeEach
    void setUp() throws IOException {
        laby = Labyrinthe.chargerFichier("Ressource/labyrinthe1.txt");
        perso = new Personnage(1, 1);
    }

    @Test
    void testPositionRespawnInitiale() {
        int[] respawn = perso.getPositionRespawn();
        assertEquals(1, respawn[0]);
        assertEquals(1, respawn[1]);
    }

    @Test
    void testSetPosition() {
        perso.setPosition(3, 4);
        assertArrayEquals(new int[]{3, 4}, perso.getPosition());
    }


    @Test
    void testDeplacementHaut() {//test pour voir si on peut aller a haut
        perso.seDeplacer("haut", laby);
        assertArrayEquals(new int[]{1, 0}, perso.getPosition());
    }

    @Test
    void testDeplacementBas() { //test pour voir si on peut aller en bas
        perso.seDeplacer("bas", laby);
        assertArrayEquals(new int[]{1, 2}, perso.getPosition());
    }

    @Test
    void testDeplacementDroite() {//test pour voir si on peut aller a Droite
        perso.seDeplacer("droite", laby);
        assertArrayEquals(new int[]{2, 1}, perso.getPosition());
    }

    @Test
    void testDeplacementGauche() {  //test pour voir si on peut aller a Gauche
        perso.seDeplacer("gauche", laby);
        assertArrayEquals(new int[]{0, 1}, perso.getPosition());
    }

    @Test
    void testDeplacementBloqueParMur() { //test pour voir si les deplacements sont bloqués par les murs
        perso.setPosition(2, 3);
        perso.seDeplacer("haut", laby);
        assertArrayEquals(new int[]{2, 3}, perso.getPosition());
    }

    @Test
    void testEstMortEnnemiSurPersonnage() { // test pour voir si le personnage est mort sur un ennemi
        ArrayList<Ennemie> ennemis = new ArrayList<>();
        ennemis.add(new Ennemie(1, 1, 0, 0, 0, 0));
        assertTrue(perso.estMort(ennemis));
    }
}