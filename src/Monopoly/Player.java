package Monopoly;

public class Player {

    private String name;
    private Dice d1;
    private Dice d2;
    private int location = 0;
    public int sum;
    private int gamesWon = 0;
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

    void roll() {
        d1.roll();

        d2.roll();

        sum = d1.getFaceValue() + d2.getFaceValue();

        location = (sum + location) %40;


    }

    boolean extraTurn() {
        return getLocation() == 9;
    }

    boolean isGameDone()
  {
     return balance.get() >= 3000;
    }
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
    }


    void incGamesWon() {
        gamesWon++;
    }
    int getGamesWon() {
        return gamesWon;
    }

  void newGame(){
        location = 0;
       this.balance.reset();

    }

}
