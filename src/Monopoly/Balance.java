package Monopoly;

public class Balance {
    private int value;

    public Balance(){
        reset();
    }

    public void add(int value){
        this.value += value;
        if (this.value < 0) this.value = 0;
    }
    public int get(){
        return value;
    }

    public void reset(){
        value = 1000;
    }
}
