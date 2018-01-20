package com.lesson6.CafePoint;

public class Client {

    private Wallet wallet;



    public Client (Wallet wallet){
        this.wallet = wallet;
    }

    public void paing( Order order){
        if (wallet.getBalance() > order.getOrderPrice()){
            wallet.setBalance(wallet.getBalance() - order.getOrderPrice());
            System.out.println("All good");
        }
        else
            System.out.println("Sorry, but i have not enough!");
    }
    public double getWalletBalance (){
        return wallet.getBalance();
    }
    public void printWalletBalance (){
        System.out.println("Balance is: " + wallet.getBalance());
    }
}
