import java.util.Random;

/**
 * Uses java.util.Random to generate the eye limit for the game and the individual dice throws of the players.
 */
class Dice {

    private Random random;

    Dice() {
        this.random = new Random();
    }

    /**
     * Simulation of a dice with 6 surfaces
     * @return Returns 1-6
     */
    int throwDice() {
        return random.nextInt(5) + 1;
    }

    /**
     * Initialization of the total limit in the game, which mustn't crossed by a player.
     * @return Returns 30-50
     */
    int initializeEyesTotalLimit() {
        return random.nextInt(20) + 30;
    }
}