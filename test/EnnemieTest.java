package zeldiablo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnnemieTest {

    private Ennemie ennemie;

    @BeforeEach
    public void setUp() {
        ennemie = new Ennemie(2, 2, 5, 2, 2, 2);
    }

    @Test
    public void testInitialisation() {
        int[] pos = ennemie.getPosition();
        assertEquals(2, pos[0], "x doit être 2");
        assertEquals(2, pos[1], "y doit être 2");
    }

    @Test
    public void testSeDeplacerH() {
        ennemie.seDeplacerH();
        int[] pos = ennemie.getPosition();
        assertEquals(3, pos[0], "l'ennemi avance en x");
        assertEquals(2, pos[1], "y ne change pas");

        ennemie.setPosition(5, 2);
        assertTrue(ennemie.finPaterne(), "doit faire demi tour");

        ennemie.seDeplacerH();
        pos = ennemie.getPosition();
        assertEquals(4, pos[0], "l'ennemi recule en x");
    }

    @Test
    public void testSeDeplacerV() {
        Ennemie ennemieV = new Ennemie(2, 2, 2, 5, 2, 2);

        ennemieV.seDeplacerV();
        int[] pos = ennemieV.getPosition();
        assertEquals(2, pos[0], "x ne change pas");
        assertEquals(3, pos[1], "ennemi descend en y");

        ennemieV.setPosition(2, 5);
        assertTrue(ennemieV.finPaterne());
        ennemieV.seDeplacerV();
        pos = ennemieV.getPosition();
        assertEquals(4, pos[1], "ennemi remonte en y");
    }

    @Test
    public void testFinPaterne() {
        assertFalse(ennemie.finPaterne());

        ennemie.setPosition(5, 2);
        assertTrue(ennemie.finPaterne(), "fin de l'aller");

        ennemie.setPosition(2, 2);
        assertTrue(ennemie.finPaterne(), "fin du retour");
    }

    @Test
    public void testReset() {
        ennemie.setPosition(4, 4);
        ennemie.finPaterne();

        // Remet à zéro
        ennemie.reset();
        int[] pos = ennemie.getPosition();

        assertEquals(2, pos[0], "retour au x départ");
        assertEquals(2, pos[1], "retour au y départ");

        ennemie.seDeplacerH();
        assertEquals(3, ennemie.getPosition()[0], "repart vers la droite");
    }
}