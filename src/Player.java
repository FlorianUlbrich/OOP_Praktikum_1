import java.util.Scanner;

/**
 * A player with his own dice and name.
 */
class Player {

    /**
     * Name of the player.
     */
    private String name;

    /**
     * The current sum of eyes the player threw the current round.
     */
    private int eyesTotal;

    /**
     * Boolean which shows wether the player is being kicked out or not.
     */
    private boolean isEliminated = false;

    /**
     * The dice of the player.
     */
    private Dice dice = new Dice();

    Player(String name) {
        this.name = name;
        this.eyesTotal = 0;
    }

    String getName() {
        return name;
    }

    int getEyesTotal() {
        return eyesTotal;
    }

    /**
     * Resets the total eyes after a player crossed it.
     */
    void resetEyesTotal() {
        this.eyesTotal = 0;
    }

    boolean getIsEliminated() {
        return isEliminated;
    }

    private void setEliminated() {
        isEliminated = true;
    }

    /**
     * Simulates dice throw for a player, checks, if the player already crossed the limit.
     * Unnecessary enter to continue which is part of the task and I have to live with.
     */
    void makeMove() {
        eyesTotal += dice.throwDice();
        System.out.println("Player: " + this.name + ", did get a: " + eyesTotal);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        if (Game.eyesTotalLimit < eyesTotal) setEliminated();
    }
}