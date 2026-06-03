package zeldiablo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LabyrintheTest {

    @Test
    public void testConstructeurEtDimensions() {
        Labyrinthe laby = new Labyrinthe(200, 150);

        assertEquals(4, laby.getLargeur(), "largeur = 4 cases");
        assertEquals(3, laby.getHauteur(), "hauteur = 3 cases");
    }

    @Test
    public void testEtreLimite() {
        Labyrinthe laby = new Labyrinthe(150, 150);

        assertTrue(laby.etreLimite(0, 0), "c'est dans la carte");
        assertTrue(laby.etreLimite(2, 2), "c'est dans la carte");
        assertFalse(laby.etreLimite(-1, 0), "trop à gauche");
        assertFalse(laby.etreLimite(0, -1), "trop en haut");
        assertFalse(laby.etreLimite(3, 0), "trop à droite");
        assertFalse(laby.etreLimite(0, 3), "trop en bas");
    }

    @Test
    public void testChargerFichierEtAnalyseDesCases() throws IOException {
        File tempMap = File.createTempFile("niveau_test", ".txt");
        tempMap.deleteOnExit();

        try (FileWriter writer = new FileWriter(tempMap)) {
            writer.write("###\n");
            writer.write("#@ \n");
            writer.write("###\n");
        }

        Labyrinthe laby = Labyrinthe.chargerFichier(tempMap.getAbsolutePath());

        assertEquals(3, laby.getLargeur(), "3 cases de large");
        assertEquals(3, laby.getHauteur(), "3 cases de haut");

        assertTrue(laby.etreMur(0, 0), "c'est un mur");
        assertTrue(laby.etreMur(2, 2), "c'est un mur");
        assertFalse(laby.etreMur(2, 1), "c'est vide");
        assertFalse(laby.etreMur(1, 1), "c'est la sortie");

        assertTrue(laby.etreCaseFin(1, 1), "sortie trouvée");
        assertFalse(laby.etreCaseFin(2, 1), "pas la sortie");
    }

    @Test
    public void testEtreMurHorsLimites() {
        Labyrinthe laby = new Labyrinthe(100, 100);
        assertFalse(laby.etreMur(-1, -1), "ne plante pas si hors limite");
        assertFalse(laby.etreMur(10, 10), "ne plante pas si hors limite");
    }
}