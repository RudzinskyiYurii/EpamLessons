package com.lesson6.CafePoint;



public class PaySystem <T extends  Wallet>{

    public void paing(T walletType, Order order){

        if ((Bonuce) walletType == null) {
            if (walletType.getBalance() > order.getOrderPrice()) {
                walletType.setBalance(walletType.getBalance() - order.getOrderPrice());
                System.out.println("Paying by " + (walletType.getWalletName()));
            } else
                System.out.println("Sorry, but I have not enough!");
        }
        else
        {
            if (walletType.getBalance() > order.getOrderBonucePrice()){
                walletType.setBalance(walletType.getBalance() - order.getOrderBonucePrice());
                System.out.println("Paying by " + (walletType.getWalletName()) + ".\n");
            }
            else
                System.out.println("Sorry, but I have not enough!");
        }
    }

}



