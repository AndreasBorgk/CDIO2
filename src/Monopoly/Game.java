package Monopoly;

import java.util.Scanner;

class Main {

    private static Player p1;
    private static Player p2;
    private static Player currentPlayer;
    private static Board b = new Board();
    static Scanner sc = new Scanner(System.in);

    private static void updateBalance(Player currentPlayer) // function to update the current
            // Players balance given the vectors field value.
    {
        Field f = b.getField(currentPlayer.getLocation());
        currentPlayer.updateBalance(f.value);
    }

    private static String fieldName(Player currentPlayer) // prints out the given locations
            // fieldname for the current player
    {
        Field f = b.getField(currentPlayer.getLocation());
        return f.name;
    }

    private static int fieldValue(Player currentPlayer)
            // prints out the fieldValue for the current location.
    {
        Field f = b.getField(currentPlayer.getLocation());
        return f.value;
    }

    private static void inputPlayerNames() { // this field is used from CDIO 1.
        System.out.println("rules for DiceGame: \n" +
                "1. You start with 1000 points, when you hit 3000 points, you will win the game\n" +
                "2. If you land on the Werewall, you'll get an extra turn \n");


        System.out.println("Player 1, type in your name: ");
        p1 = new Player(sc.next()); // First player chooses name and saves it in p1.
        System.out.println("Welcome " + p1.getName());
        System.out.println("Player 2, type in your name: ");
        p2 = new Player(sc.next()); // Second player chooses name, and saves it in p2.
        System.out.println("Welcome " + p2.getName());
        System.out.println("Are you ready to start the game? '(y/n)'");
        sc.next(); // Asks if youre ready to start the game, by pressing it starts.
    }


    private static void doTurn() { // used from CDIO1, with changes.
        do {
            System.out.println(currentPlayer.getName() + " press 'K' if you're ready to throw");
            sc.next(); // asks if theyre ready to throw, by pressing K they Throw.

            currentPlayer.roll(); // player rolls the dices.
            updateBalance(currentPlayer); // the balance for the player updates
            fieldName(currentPlayer); // fieldName gets saved.
            System.out.println(currentPlayer.getName() + " rolls: " + currentPlayer.getFaceValue1() + ", "
                    + currentPlayer.getFaceValue2() + " sums up: " + currentPlayer.sum);

            System.out.println("you landed on field: " + currentPlayer.getLocation() + ", " + (fieldName(currentPlayer)) +
                    ", with the value of: " + fieldValue(currentPlayer));
             System.out.println("your balance is: " + currentPlayer.getBalance());


        } while (currentPlayer.extraTurn() && !currentPlayer.isGameDone()); //the loop goes on if someone gets an extra
        // or the players have hit the estimated value to finish the game.
    }

    private static void playGame() { // used from cdio 1, with changes.
        int round = 1; // sets start round to 1.

        while ((!p1.isGameDone()) && !(p2.isGameDone())) {
            System.out.println("Round: " + round);
            round++; // whenever a new turn starts, the round gets ++.

            currentPlayer = p1;
            doTurn(); // sets current player to p1, and make him do the turn.

            currentPlayer = p2;
            doTurn(); // sets current player to p2, and makes him do his turn.

            System.out.println("current score is: " + p1.getName() + ": " + p1.getBalance() + " and " + p2.getName()
                    + ": " + p2.getBalance()); // prints out the current score.
        }
        if (p1.isGameDone()) { // checks if p1 has won, and if the player has, prints out name and balance.
            System.out.println(p1.getName() + " won with: " + p1.getBalance());

            p1.incGamesWon();
            System.out.println("Games won : " + p1.getGamesWon());
        }

        if (p2.isGameDone()) { // checks if p2 has won, and if the player has, prints out name and balance.
            System.out.println(p2.getName() + " won with: " + p2.getBalance());

            p2.incGamesWon();
            System.out.println(p2.getName() + " games won : " + p2.getGamesWon());
        }
    }

    private static void newGame() { // Used from cdio1, but with changes.
        inputPlayerNames();
        String another = "y";

        while (another.equalsIgnoreCase("y")) { // asks if they want to play again
            // if yes, newgame Method will be called.
            playGame();
            System.out.println();
            System.out.println("would you like to play again? (y/n)");
            another = sc.next();

            p1.newGame();
            p2.newGame();
        }

    }


    public static void main(String[] args) {
        newGame();
    }
}