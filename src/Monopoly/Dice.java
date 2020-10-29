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


            dice1ok = (diceSides>= 1) && (diceSides <= 12);
        } while (!dice1ok);
    }
    // }

    public void roll()
    {
        faceValue = (int)(Math.random()* this.diceSides +1); // Ruller et tilfældigt tal mellem 1 og 6
    }
    public int getFaceValue()
    {
        return faceValue;
    }


}
