package com.lesson6.CafePoint;

public abstract class Wallet {

    abstract public  double getBalance();
    abstract public void setBalance(double balance);
   // abstract public void printPaidInfo();
}
class Cash extends Wallet {
    private double cashBalance;

    public Cash (double cashBalance){
        setBalance(cashBalance);
    }

    public double getBalance (){
        return cashBalance;
    }

    public void setBalance (double balance){
        this.cashBalance = balance;
    }

/*
    public void printPaidInfo (){
        if (checkCash())
            System.out.println("U paid in cash " + order.getOrderPrice());
        else
            System.out.println("There is not enough!!!");
    }
*/

}

class Card extends Wallet {
    private double cardBalance;

    public Card (double cardBalance){
        setBalance(cardBalance);
    }

    public double getBalance (){
        return cardBalance;
    }

    public void setBalance (double balance){
        this.cardBalance = balance;
    }
/*
    public void printPaidInfo (){
        if (checkCash())
            System.out.println("U paid by card " + order.getOrderPrice());
        else
            System.out.println("In the card not enough money!!!");
    }
*/
}

class Bonuce extends Wallet {
    private int bonuceBalance;

    public Bonuce (int bonuceBalance){
        setBalance(bonuceBalance);
    }

    public double getBalance (){
        return bonuceBalance;
    }

    public void setBalance (double balance){
        this.bonuceBalance = (int) balance;
    }
/*
    public void printPaidInfo (){
        if (checkBonuce())
            System.out.println("U paid in bonuces " + order.getOrderPrice());
        else
            System.out.println("In the card not enough money!!!");
    }
*/


}