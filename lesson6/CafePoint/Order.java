package com.lesson6.CafePoint;

import java.util.LinkedList;
import java.util.List;

public class Order<E extends Addons> {

    private List<E> addonsOrder = new LinkedList<>();
    Coffee coffee;
    //private List<Coffee> coffeeOrder = new LinkedList<>();

    //add coffee
    public void addCoffee (Coffee coffee){
        this.coffee = coffee;
    }

    // add some  addons
    public void addAddon (E addon){
        addonsOrder.add(addon);
    }

//print order like check
    public void printOrder(){
        // checking for not null order list
        if (addonsOrder != null){
            //print info
            coffee.printInfo();
            for (Addons add : addonsOrder){
                add.printInfo();
            }
            System.out.println("-----------------------------------------------");
            System.out.println("sum: " + "\t\t\t\t|\t" + getOrderPrice() + "$\tor\t" +
            getOrderBonucePrice() + " bonuces.\n");
        }
        else
            System.out.println("There are no one addons have been used");
    }

    public double getOrderPrice (){
        double orderPrice = 0;
        //add to order price coffee price
        orderPrice += coffee.getPrice();
        //and add all addons price
            for (E addon : addonsOrder){
                orderPrice += addon.getPrice();
            }
        return orderPrice;
    }

    public double getOrderBonucePrice (){
        int orderBonucePrice = 0;
        //add to order price by bonuces coffee price
        orderBonucePrice += coffee.getBonucePrice();
        //and add all addons price by bonuces
        for (E addon : addonsOrder){
            orderBonucePrice += addon.getBonucePrice();
        }
        return orderBonucePrice;
    }
}
