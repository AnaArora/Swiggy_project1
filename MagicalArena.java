import java.util.Random;

public class MagicalArena {
    private static final Random dice = new Random();

    static int rollDice() {
        return dice.nextInt(6) + 1;
    }

    public static void fight(Player player1, Player player2) {
        while (player1.isAlive() && player2.isAlive()) {
            Player attacker = player1.getHealth() <= player2.getHealth() ? player1 : player2;
            Player defender = (attacker == player1) ? player2 : player1;

            int attackRoll = rollDice();
            int defenseRoll = rollDice();

            int attackDamage = attacker.getAttack() * attackRoll;
            int defense = defender.getStrength() * defenseRoll;

            int netDamage = Math.max(0, attackDamage - defense);
            defender.reduceHealth(netDamage);

            System.out.printf("%s attacks %s. Roll: %d vs %d. Damage: %d. %s health: %d\n",
                attacker == player1 ? "Player A" : "Player B",
                defender == player1 ? "Player A" : "Player B",
                attackRoll, defenseRoll, netDamage, 
                defender == player1 ? "Player A" : "Player B",
                defender.getHealth()
            );
        }

        System.out.printf("%s wins!\n", player1.isAlive() ? "Player A" : "Player B");
    }
}
