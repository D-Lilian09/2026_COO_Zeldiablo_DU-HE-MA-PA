package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zeldiablo.Ennemie;
import zeldiablo.Labyrinthe;
import zeldiablo.Personnage;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {

    private Personnage perso;
    private Labyrinthe laby;

    @BeforeEach
    void setUp() throws IOException {
        laby = Labyrinthe.chargerFichier("Ressource/labyrinthe1.txt");
        perso = new Personnage(12, 4);
    }

    @Test
    void testPositionRespawnInitiale() {
        int[] respawn = perso.getPositionRespawn();
        assertEquals(12, respawn[0]);
        assertEquals(4, respawn[1]);
    }

    @Test
    void testSetPosition() {
        perso.setPosition(3, 4);
        assertArrayEquals(new int[]{3, 4}, perso.getPosition());
    }

    @Test
    void testDeplacementHaut() { //test pour voir si on peut aller en haut
        perso.seDeplacer("haut", laby);
        assertArrayEquals(new int[]{12, 4}, perso.getPosition());
    }

    @Test
    void testDeplacementBas() { //test pour voir si on peut aller en bas
        perso.seDeplacer("bas", laby);      // (12,4) -> (12,5)
        assertArrayEquals(new int[]{12, 5}, perso.getPosition());
    }

    @Test
    void testDeplacementDroite() { //test pour voir si on peut aller a droite
        perso.seDeplacer("droite", laby);
        assertArrayEquals(new int[]{13, 4}, perso.getPosition());
    }

    @Test
    void testDeplacementGauche() { //test pour voir si on peut aller a gauche
        perso.seDeplacer("gauche", laby); 
        assertArrayEquals(new int[]{11, 4}, perso.getPosition());
    }

    @Test
    void testDeplacementBloqueParMur() { //test pour voir si les deplacements sont bloques par les murs
        perso.setPosition(1, 1);
        perso.seDeplacer("haut", laby);
        assertArrayEquals(new int[]{1, 1}, perso.getPosition());
    }

    @Test
    void testEstMortEnnemiSurPersonnage() { //test pour voir si le personnage meurt sur un ennemi
        ArrayList<Ennemie> ennemis = new ArrayList<>();
        ennemis.add(new Ennemie(12, 4, 0, 0, 0, 0));
        assertTrue(perso.estMort(ennemis));
    }
}