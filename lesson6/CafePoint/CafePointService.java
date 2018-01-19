package com.lesson6.CafePoint;

public class CafePointService {

    public void usageCafePoint (){
        Order<Addons> order1 = new Order<>();
        order1.addCoffee(new Coffee());
        order1.addAddon(new Milk());
        order1.addAddon(new Chocolate());
        order1.printOrder();
    }

}
