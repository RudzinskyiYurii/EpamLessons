package com.lesson6.CafePoint;



public abstract class PaySystem {
    abstract public void printPaidInfo();
}
class Cash extends PaySystem {
    private Order order;
    private double paidMoney;


    public Cash (Order order, double money){
        this.order = order;
        this.paidMoney = money;
    }

    private boolean checkCash (){
        if (paidMoney == order.getOrderPrice() || paidMoney > order.getOrderPrice()) // take a different like tip
            return true;
        else
            return false;
    }

    public void printPaidInfo (){
        if (checkCash())
            System.out.println("U paid in cash " + order.getOrderPrice());
        else
            System.out.println("There is not enough!!!");
    }


}

class Card extends PaySystem {
    private Order order;
    private double cradBalance;


    public Card (Order order, double cardBalance){
        this.order = order;
        this.cradBalance = cardBalance;
    }
//method to substraction order price from card
  //  private void

    private boolean checkCash (){
        if (cradBalance == order.getOrderPrice())
            return true;
        else
            return false;
    }

    public void printPaidInfo (){
        if (checkCash())
            System.out.println("U paid in cash " + order.getOrderPrice());
        else
            System.out.println("In the card not enough money!!!");
    }

}

class Bonuce extends PaySystem {
    private Order order;
    private double bonuceBalance;


    public Bonuce (Order order, double bonuceBalance){
        this.order = order;
        this.bonuceBalance = bonuceBalance;
    }
//method to substraction order price from bounce balance
    //  private void

    private boolean checkBonuce (){
        if (bonuceBalance == order.getOrderPrice())
            return true;
        else
            return false;
    }

    public void printPaidInfo (){
        if (checkBonuce())
            System.out.println("U paid in cash " + order.getOrderPrice());
        else
            System.out.println("In the card not enough money!!!");
    }



}