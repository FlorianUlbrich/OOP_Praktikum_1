import java.util.ArrayList;

/**
 * Keeps track of the game and implements rules for the players.
 */
class Game {

    /**
     * The limit which mustn't crossed by a player.
     */
    static int eyesTotalLimit;

    /**
     * The current amount of players left.
     */
    private int currentAmountOfPlayers;

    /**
     * Boolean which shows whether the current round (not game) is finished.
     */
    private boolean isRoundFinished = false;

    /**
     * ArrayList of current players. Used as temporary storage to prevent CurrentModificationException.
     */
    private ArrayList<Player> currentPlayers = new ArrayList<>();

    /**
     * ArrayList of players.
     */
    private ArrayList<Player> players = new ArrayList<>();

    Game(int amountOfPlayers, ArrayList<String> playerNames) {
        Dice dice = new Dice();
        eyesTotalLimit = dice.initializeEyesTotalLimit();
        this.currentAmountOfPlayers = amountOfPlayers;
        this.players = generatePlayers(playerNames);
    }

    /**
     * Generates a player for each name entered before.
     * @param playerNames List with the names of the players.
     * @return List of player objects
     */
    private ArrayList<Player> generatePlayers(ArrayList<String> playerNames) {
        playerNames.forEach((name) -> players.add(new Player(name)));
        return players;
    }

    /**
     * Checks whether a player is already over the eye limit and kicks him out of the game if so.
     */
    private void validatePlayerList() {
        Player looser = currentPlayers.stream().filter(Player::getIsEliminated).findAny().orElse(null);
        if (looser != null) {
            printScoreboard(currentPlayers);
            currentPlayers.remove(looser);
            currentPlayers.forEach(Player::resetEyesTotal);
            currentAmountOfPlayers--;
            isRoundFinished = true;
        }
    }

    /**
     * Starts a round. A round ends, if a player crosses the eye limit.
     */
    private void startRound() {
        int counter = 0;
        while(!isRoundFinished) {
            currentPlayers.get(counter).makeMove();
            validatePlayerList();
            if(isRoundFinished) {
                players = currentPlayers;
            }
            counter = (counter+1) % currentAmountOfPlayers;
        }
    }

    /**
     * Starts rounds as long as there are at least 2 players.
     */
    void startGame() {
        while(currentAmountOfPlayers > 1) {
            currentPlayers = players;
            startRound();
            System.out.println("\n");
            isRoundFinished = false;
        }
        System.out.format("The winner is %s !\n", players.get(0).getName());
    }

    /**
     * Prints the scoreboard for the fans.
     * @param players List of players.
     */
    private void printScoreboard(ArrayList<Player> players) {
        players.forEach(player -> System.out.println("limit: " + this.getEyesTotalLimit() + ", player: " + player.getName() + ", score: " + player.getEyesTotal()));
    }

    private int getEyesTotalLimit() {
        return eyesTotalLimit;
    }
}