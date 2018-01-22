package com.lesson7;

public class Cheese extends PizzaDecorator {


    public Cheese (Pizza pizza){
        super (pizza);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 4;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + cheese";
    }
}
