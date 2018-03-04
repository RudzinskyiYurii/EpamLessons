package com.lesson7;

public class PizzaDecorator implements Pizza{
    public final Pizza pizza;

    public PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    public double getPrice(){
        return pizza.getPrice();
    }

    public String getDescription (){
        return pizza.getDescription();
    }

}
