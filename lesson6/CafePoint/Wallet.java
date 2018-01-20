package com.lesson6.CafePoint;

public abstract class Wallet {

    abstract public double getBalance();
    abstract public void setBalance(double balance);
    abstract public String getWalletName();
    abstract public void printBalance();
}
class Cash extends Wallet {
    private double cashBalance;
    private final String walletName = "cash";

    public Cash (double cashBalance){
        setBalance(cashBalance);
    }

    public double getBalance (){
        return cashBalance;
    }

    public void setBalance (double balance){
        this.cashBalance = balance;
    }

    public String getWalletName(){
        return walletName;
    }

    public void printBalance(){
        System.out.println("Balance is: " + getBalance() + " $.");
    }

}

class Card extends Wallet {
    private double cardBalance;
    private final String walletName = "card";

    public Card (double cardBalance){
        setBalance(cardBalance);
    }

    public double getBalance (){
        return cardBalance;
    }

    public void setBalance (double balance){
        this.cardBalance = balance;
    }

    public String getWalletName(){
        return walletName;
    }

    public void printBalance(){
        System.out.println("Balance is: " + getBalance() + " $.");
    }


}

class Bonuce extends Wallet {
    private int bonuceBalance;
    private final String walletName = "bonuces";

    public Bonuce (int bonuceBalance){
        setBalance(bonuceBalance);
    }

    public double getBalance (){
        return bonuceBalance;
    }

    public void setBalance (double balance){
        this.bonuceBalance = (int) balance;
    }

    public String getWalletName(){
        return walletName;
    }

    public void printBalance(){
        System.out.println("Balance is: " + getBalance() + " bonuces.");
    }


}