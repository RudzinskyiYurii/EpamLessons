package com.lesson6.CafePoint;


public abstract class Addons {

    //get price in $
    abstract public double getPrice();

    //get price in bonuces
    abstract public int getBonucePrice();

    abstract public void printInfo();

}
//cream addon
class Cream extends Addons {

    private int quantity;
    private int bonucePrice;

    public Cream() {
        this(1);
    }

    public Cream(int quantity) {
        this.quantity = quantity;
    }
    //get price in $
    public double getPrice() {

        return quantity * 1.5;
    }
    //get price in bonuces
    public int getBonucePrice() {
        return quantity * 1500;
    }

    public void printInfo() {
        System.out.println("cream x" + quantity + "\t\t\t|\t" + getPrice() +
                "$ \tor\t" + getBonucePrice() + " bonuces.");
    }

}
//milk addon
class Milk extends Addons {
    private int quantity;

    public Milk() {
        this(1);
    }

    public Milk(int quantity) {
        this.quantity = quantity;
    }
    //get price in $
    public double getPrice() {

        return quantity * 1.75;
    }
    //get price in bonuces
    public int getBonucePrice() {
        return quantity * 1750;
    }

    public void printInfo() {
        System.out.println("milk x" + quantity + "\t\t\t\t|\t" + getPrice() +
                "$ \tor\t" + getBonucePrice() + " bonuces.");
    }


}
//Chocolate addon
class Chocolate extends Addons {
    private int quantity;

    public Chocolate() {
        this(1);
    }

    public Chocolate(int quantity) {
        this.quantity = quantity;
    }
    //get price in $
    public double getPrice() {

        return quantity * 2.5;
    }
    //get price in bonuces
    public int getBonucePrice() {
        return quantity * 2500;
    }

    public void printInfo() {
        System.out.println("chocolate x" + quantity + "\t\t|\t" + getPrice() +
                "$ \tor\t" + getBonucePrice() + " bonuces.");
    }
//sandwich addon
    class Sandwich extends Addons {
        private int quantity;

        public Sandwich() {
            this(1);
        }

        public Sandwich(int quantity) {
            this.quantity = quantity;
        }
    //get price in $
        public double getPrice() {

            return quantity * 1.05;
        }
    //get price in bonuces
        public int getBonucePrice() {
            return quantity * 1050;
        }

        public void printInfo() {
            System.out.println("sandwich x" + quantity + "\t\t\t\t|\t" + getPrice() +
                    "$ \tor\t" + getBonucePrice() + " bonuces.");
        }
    }
    //hot-dog addon
    class HotDog extends Addons {
        private int quantity;

        public HotDog() {
            this(1);
        }

        public HotDog(int quantity) {
            this.quantity = quantity;
        }
        //get price in $
        public double getPrice() {

            return quantity * 1.05;
        }
        //get price in bonuces
        public int getBonucePrice() {
            return quantity * 1050;
        }

        public void printInfo() {
            System.out.println("hot-dog x" + quantity + "\t\t\t\t|\t" + getPrice() +
                    "$ \tor\t" + getBonucePrice() + " bonuces.");
        }
    }

}

