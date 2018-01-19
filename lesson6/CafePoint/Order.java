package com.lesson6.CafePoint;

import java.util.LinkedList;
import java.util.List;

public class Order<E extends Addons> {

    private List<E> addonsOrder = new LinkedList<>();
    Coffee coffee;
    //private List<Coffee> coffeeOrder = new LinkedList<>();

    // add some addons
    public void addAddon (E addon){
        addonsOrder.add(addon);
    }

    //add coffee
    public void addCoffee (Coffee coffee){
        this.coffee = coffee;
    }

    public void printOrder(){
        // checking for not null order list
        if (addonsOrder != null){
            //print info
            coffee.printInfo();
            for (Addons add : addonsOrder){
                add.printInfo();
            }
        }
        else
            System.out.println("There are no one addons have been used");
    }

    public double getOrderPrice (){
        double orderPrice = 0;

        return orderPrice;
    }
}
