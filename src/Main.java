import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * Main method starts the program. A scanner reads in the amount of players and their names over the commandline and
     * initializes the game.
     * @param args
     */
    public static void main(String[] args) {

        Scanner scannerForNumbers = new Scanner(System.in);
        int amountOfPlayers = 0;
        System.out.println("Welcome to Offside. Please enter the amount of players.");

        do {
            System.out.println("There have to be at least 2 players!");
            while(!scannerForNumbers.hasNextInt()) {
                System.out.println("That is not a number!");
                scannerForNumbers.next();
            }
            amountOfPlayers = scannerForNumbers.nextInt();
        } while(amountOfPlayers < 2);

        ArrayList<String> playerNames = new ArrayList<>();
        Scanner scannerForStrings = new Scanner(System.in);

        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.format("Please enter the name of player %d%n", i+1);
            while(!scannerForStrings.hasNext("[A-Z][a-z]*")) {
                System.out.println("Enter a valid name!");
                scannerForStrings.next();
            }
            playerNames.add(scannerForStrings.next());
        }

        Game game = new Game(amountOfPlayers, playerNames);
        game.startGame();
    }
}