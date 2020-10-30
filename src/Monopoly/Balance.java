package Monopoly;

public class Balance {
    private int value;

    public Balance(){
        reset();
    }

    public void add(int value){
        this.value += value;
        if (this.value < 0) this.value = 0; // if the balance gets below 0, it will return 0.
        // this provides us with the non-negative balance.
    }
    public int get(){
        return value;
    }

    public void reset(){
        value = 1000; // sets start value to 1000.
    }
}
