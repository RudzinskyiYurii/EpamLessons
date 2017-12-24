package com.lesson1.ex1;

/**
 * Class Fibonacci release Fibonacci`s numbers
 */
public class Fibonacci {
    private int amountOfNumbers;

    /**
     * Default constructor
     */
    public Fibonacci(){
        new Fibonacci(0);
    }

    /**
     * Constructor with param.
     */
    public Fibonacci(int amountOfNumbers){
        this.amountOfNumbers = amountOfNumbers;
    }

    /**
     * Method which create Fibonacci`s numbers
     */
    private int createFibonacciNumber(int amountOfNumbers) {

        if (amountOfNumbers == 0)
            return 0;
        else if (amountOfNumbers == 1)
            return 1;
        else
            return ( createFibonacciNumber(amountOfNumbers - 1) + createFibonacciNumber(amountOfNumbers - 2));

    }

    /**
     * Override method toString to display Fibonacci`s numbers
     */
    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        for (int i = 1; i < amountOfNumbers; i ++){
           strB.append(createFibonacciNumber(i));
           strB.append( ", " );
        }
        strB.append(createFibonacciNumber(amountOfNumbers));
        strB.append(".");
        return strB.toString();
    }
}
