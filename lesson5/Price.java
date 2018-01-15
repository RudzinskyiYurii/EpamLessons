package com.lesson5;

public abstract class Price {

    abstract public double getCharge(int days);

    public int getFrequentRenterPoints(int daysRented) {

        // add bonus for a two day new release rental
        return 1;
    }
/*
    Points() {

    }
*/
    abstract int getPriceCode();
}

class ChildrensPrice extends Price {
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }


}

class RegularPrice extends Price {
    int getPriceCode() {
        return Movie.REGULAR;
    }

    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }


}

class NewReleasePrice extends Price {
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    public double getCharge(int daysRented) {

        return daysRented * 3;
    }

    public int getFrequentRenterPoints(int daysRented) {

        // add bonus for a two day new release rental
        return (daysRented > 1) ? 2: 1;
    }

}