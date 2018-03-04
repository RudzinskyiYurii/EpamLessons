package com.lesson6.CafePoint;



public class PaySystem <T extends  Wallet>{

    public void paing(T walletType, Order order){
        //check if used bonuces
        //if not
        if ((Bonuce) walletType == null) {
            //check that wallet balance is enough to pay
            if (walletType.getBalance() > order.getOrderPrice()) {
                //sub order price from wallet balance
                walletType.setBalance(walletType.getBalance() - order.getOrderPrice());
                //print the result
                System.out.println("Paying by " + (walletType.getWalletName()));
            } else
                System.out.println("Sorry, but I have not enough!");
        }
        //if yes (paing by bomuces)
        else
        {
            //check that bonuces balance is enough to pay
            if (walletType.getBalance() > order.getOrderBonucePrice()){
                //sub order price from bonuces balance
                walletType.setBalance(walletType.getBalance() - order.getOrderBonucePrice());
                //print result
                System.out.println("Paying by " + (walletType.getWalletName()) + ".\n");
            }
            else
                System.out.println("Sorry, but I have not enough!");
        }
    }

}



