package Monopoly;

import java.util.Scanner;

public class Dice {

    private int faceValue;
    private int diceSides;
    public Dice(int diceSides)
    {
        this.diceSides = diceSides;
    }
    public Dice() {
        boolean dice1ok;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Write the number of sides on your dice from 1-12");
            diceSides = sc.nextInt();


            dice1ok = (diceSides>= 1) && (diceSides <= 12); // function where you can
            // choose the amount of sides you want on your dice.
        } while (!dice1ok);
    }
    // }

    public void roll() //dices used from cdio1, changed userinput number of sides.
    {
        faceValue = (int)(Math.random()* this.diceSides +1); // rolls the decided amount of sides.
    }
    public int getFaceValue()
    {
        return faceValue;
    }


}
