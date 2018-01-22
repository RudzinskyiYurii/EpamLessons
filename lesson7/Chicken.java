package com.lesson7;

public class Chicken extends PizzaDecorator {

    public Chicken (Pizza pizza){
        super (pizza);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 2;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + chicken";
    }

}
