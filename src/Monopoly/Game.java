package Monopoly;

import java.util.Scanner;

class Main {

    private static Player p1;
    private static Player p2;
    private static Player currentPlayer;
    private static Board b = new Board();
    static Scanner sc = new Scanner(System.in);

    private static void updateBalance(Player currentPlayer)
    {
        Field f = b.getField(currentPlayer.getLocation());
        currentPlayer.updateBalance(f.value);
    }

    private static String fieldName(Player currentPlayer)
    {
        Field f = b.getField(currentPlayer.getLocation());
        return f.name;
    }

    private static int fieldValue(Player currentPlayer)
    {
        Field f = b.getField(currentPlayer.getLocation());
        return f.value;
    }

    private static void inputPlayerNames() {
        System.out.println("rules for DiceGame: \n" +
                "1. You start with 1000 points, when you hit 3000 points, you will win the game\n" +
                "2. If you land on the Werewall, you'll get an extra turn \n");


        System.out.println("Player 1, type in your name: ");
        p1 = new Player(sc.next()); // Spiller 1's navn vælges og gemmes i p1
        System.out.println("Welcome " + p1.getName());
        System.out.println("Player 2, type in your name: ");
        p2 = new Player(sc.next()); // Spiller 2's navn vælges og gemmes i p2
        System.out.println("Welcome " + p2.getName());
        System.out.println("Are you ready to start the game? '(y/n)'");
        sc.next(); // spørges om de er klar til at starte spil, ved tast startes det.
    }


    private static void doTurn() {
        do {
            System.out.println(currentPlayer.getName() + " press 'K' if you're ready to throw");
            sc.next();

            currentPlayer.roll();
            updateBalance(currentPlayer);
            fieldName(currentPlayer);
            System.out.println(currentPlayer.getName() + " rolls: " + currentPlayer.getFaceValue1() + ", "
                    + currentPlayer.getFaceValue2() + " sums up: " + currentPlayer.sum);

            System.out.println("you landed on field: " + currentPlayer.getLocation() + ", " + (fieldName(currentPlayer)) +
                    ", with the value of: " + fieldValue(currentPlayer));
            System.out.println("your balance is: " + currentPlayer.getBalance());


        } while (currentPlayer.extraTurn() && !currentPlayer.isGameDone());
    }

    private static void playGame() {
        int round = 1;

        while ((!p1.isGameDone()) && !(p2.isGameDone())) {
            System.out.println("Round: " + round);
            round++;

            currentPlayer = p1;
            doTurn();

            currentPlayer = p2;
            doTurn();

            System.out.println("current score is: " + p1.getName() + ": " + p1.getBalance() + " and " + p2.getName()
                    + ": " + p2.getBalance());
        }
        if (p1.isGameDone()) {
            System.out.println(p1.getName() + " won with: " + p1.getBalance());

            p1.incGamesWon();
            System.out.println("Games won : " + p1.getGamesWon());
        }

        if (p2.isGameDone()) {
            System.out.println(p2.getName() + " won with: " + p2.getBalance());

            p2.incGamesWon();
            System.out.println(p2.getName() + " games won : " + p2.getGamesWon());
        }
    }

    private static void newGame() {
        inputPlayerNames();
        String another = "y";

        while (another.equalsIgnoreCase("y")) {
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