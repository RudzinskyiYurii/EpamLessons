package com.lesson7;

public class Pineapple extends PizzaDecorator {
    public Pineapple (Pizza pizza){
        super (pizza);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + pineapple";
    }
}
