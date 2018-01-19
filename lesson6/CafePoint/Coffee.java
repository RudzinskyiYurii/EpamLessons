package com.lesson6.CafePoint;


public class Coffee {

    private int quantity;

    public Coffee (){
        this(1);
    }
    public Coffee(int quantity){
        this.quantity =  quantity;
    }

    public double getPrice() {

        return quantity * 3;
    }

    public void printInfo (){
        System.out.println("U have been ordered x" + quantity + " coffee");
    }
}
