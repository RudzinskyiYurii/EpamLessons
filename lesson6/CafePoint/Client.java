package com.lesson6.CafePoint;

public class Client {

    private Wallet wallet;



    public Client (Wallet wallet){
        this.wallet = wallet;
    }
    //paying the order
    public void paing(Order order){
        PaySystem<Wallet> paySystem = new PaySystem<>();
        paySystem.paing(wallet, order);
    }

    public void printWalletBalance (){
        wallet.printBalance();
    }
}
