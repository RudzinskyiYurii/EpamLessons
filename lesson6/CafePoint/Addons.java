package com.lesson6.CafePoint;



public abstract class Addons {

        abstract public double getPrice();
        abstract public int getBonucePrice();
        abstract public void printInfo();

    }

class Cream extends Addons {

        private int quantity;
        private int bonucePrice;

        public Cream (){
                this(1);
        }
        public Cream(int quantity){
            this.quantity =  quantity;
        }

        public double getPrice() {

            return quantity * 1.5;
        }

        public int getBonucePrice (){
            return quantity * 1500;
        }

        public void printInfo (){
            System.out.println("Add cream x" + quantity);
        }


    }

    class Milk extends Addons {
        private int quantity;

        public Milk (){
            this(1);
        }
        public Milk(int quantity){
            this.quantity =  quantity;
        }

        public double getPrice() {

            return quantity * 1.75;
        }

        public int getBonucePrice (){
            return quantity * 1750;
        }

        public void printInfo (){
            System.out.println("Add milk x" + quantity);
        }


    }

    class Chocolate extends Addons {
        private int quantity;

        public Chocolate (){
            this(1);
        }
        public Chocolate(int quantity){
            this.quantity =  quantity;
        }

        public double getPrice() {

            return quantity * 2.5;
        }

        public int getBonucePrice (){
            return quantity * 2500;
        }

        public void printInfo (){
            System.out.println("Add chocolate x" + quantity);
        }



    }

