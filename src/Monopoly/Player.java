package Monopoly;

public class Player {

    private String name;
    private Dice d1;
    private Dice d2;
    private int location = 0; // keeps track of the given Player's location
    public int sum; // sums up the dice roll, to output the amount of fields the player shall move
    private int gamesWon = 0; // keeps track of number of games won
    private Balance balance;



    Player(String name)
    {
        this.name = name;
        d1 = new Dice();
        d2 = new Dice();
        balance = new Balance();

    }
    String getName()
    {
        return name;
    }

public int getBalance(){
        return this.balance.get();
}

    void roll() { //used from last project with changes.
        d1.roll();

        d2.roll();

        sum = d1.getFaceValue() + d2.getFaceValue();

        location = (sum + location) %40; // makes the location run in a loop of 40 fields.


    }

    boolean extraTurn() {
        return getLocation() == 9;
    }

    boolean isGameDone()
  {
     return balance.get() >= 3000;
    } // checks if a given player hits balance of 3000,
    int getFaceValue1(){
        return d1.getFaceValue();
    }

    int getFaceValue2(){
        return d2.getFaceValue();
    }

    public int getLocation() {
        return location;
    }

    public void updateBalance(int value){
        balance.add(value);
    } // adds field value to current balance


    void incGamesWon() {
        gamesWon++;
    }
    int getGamesWon() {
        return gamesWon;
    }

  void newGame(){
        location = 0;
       this.balance.reset(); // as we use balance.reset, we set value of our balance = 1000.

    }

}
