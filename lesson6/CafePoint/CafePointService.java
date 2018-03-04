package com.lesson6.CafePoint;

public class CafePointService {

    public void usageCafePoint (){

        System.out.println("Hello!! Welcome to our cafepoint.\n");
        //create new order
        Order<Addons> order1 = new Order<>();
        order1.addCoffee(new Coffee());
        order1.addAddon(new Milk());
        order1.addAddon(new Chocolate());
        order1.printOrder();

        Client client1 = new Client(new Bonuce(12500)); //creating client with cash
        client1.paing(order1); // paying by client1 for order 1
        client1.printWalletBalance();

        System.out.println("\nTy for using our service! ;)");
    }

}
