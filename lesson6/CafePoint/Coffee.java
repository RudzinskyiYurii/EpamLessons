package com.lesson6.CafePoint;


public class Coffee {

    private int quantity;

    public Coffee (){
        this(1);
    }
    public Coffee(int quantity){
        this.quantity =  quantity;
    }

    //get coffee price in $
    public double getPrice() {

        return quantity * 3;
    }
    //get coffee price in bonuces
    public int getBonucePrice (){
        return quantity * 3000;
    }

    public void printInfo (){
        System.out.println("U have been ordered:\n" + "coffee x"+ quantity + "\t\t\t|\t" + getPrice() +
                "$ \tor\t" + getBonucePrice() + " bonuces.");
    }
}
