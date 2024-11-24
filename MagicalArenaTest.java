import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MagicalArenaTest {

    @Test
    public void testPlayerInitialization() {
        Player player = new Player(50, 5, 10);
        assertEquals(50, player.getHealth());
        assertEquals(5, player.getStrength());
        assertEquals(10, player.getAttack());
    }

    @Test
    public void testPlayerHealthReduction() {
        Player player = new Player(50, 5, 10);
        player.reduceHealth(20);
        assertEquals(30, player.getHealth());
    }

    @Test
    public void testDiceRollRange() {
        for (int i = 0; i < 1000; i++) {
            int roll = MagicalArena.rollDice();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }
}
