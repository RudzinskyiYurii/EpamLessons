package com.lesson7;

public class Client {

    public void makeOrder() {

        Pizza pizza = new SimplePizza();

        pizza = new Pineapple(pizza);

        pizza = new Chicken(pizza);

        pizza = new Cheese(pizza);

        System.out.println("Order1: " + pizza.getDescription() +
                ".\nPrice: " + pizza.getPrice() + "\n");

        Pizza pizza1 = new SimplePizza();

        pizza1 = new Cheese(pizza1);

        System.out.println("Order2: " + pizza1.getDescription() +
                ".\nPrice: " + pizza1.getPrice() + "\n");

        Pizza pizza2 = pizza;
        pizza2 = new Cheese(pizza2);
        System.out.println("Order3: " + pizza2.getDescription() +
                ".\nPrice: " + pizza2.getPrice() + "\n");

    }

    public void printOrder (Pizza pizza){
        System.out.println("Order "  + " : " + pizza.getDescription() +
                ".\nPrice: " + pizza.getPrice() + "\n");
    }


}
