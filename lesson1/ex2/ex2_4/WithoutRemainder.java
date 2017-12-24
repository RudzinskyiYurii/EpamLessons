package com.lesson1.ex2.ex2_4;

/**
 * Class which display that numbers of input array,
 * that divided without remainder into all previous numbers
 */
public class WithoutRemainder {

    /**
     * Default constructor
     */
    public WithoutRemainder() {
        System.out.println("\nResult of working class WithoutRemainder:");
        System.out.println("Empty array!");
    }

    /**
     * Constructor with param
     */
    public WithoutRemainder(int[] arrayOfNumbers) {
        System.out.println("\nResult of working class WithoutRemainder:");
        printAllCorrectNumbers(arrayOfNumbers);
    }

    /**
     * Method which display all correct numbers
     */
    private void printAllCorrectNumbers(int[] inputArray) {
        if (isAppropriated(inputArray) == false) {
            System.out.println("Something wrong... Try it again.\n" + "Input array: ");

        }
        else {

            for (int i = 1; i < inputArray.length; i++) {
                for (int j = 0; j < i; j++) {
                    if ((inputArray[i] % inputArray[j]) == 0) {
                        System.out.print(inputArray[i] + ", ");
                        break;
                    }
                }
            }
        }
    }

    /**
     * Method which checking if input numbers have at least 5 dig
     */
    private boolean isAppropriated(int[] arr) {
        boolean is_correct = false;
        for (int i : arr) {
            if (i > 9999) {
                is_correct = true;
            } else
                is_correct = false;
        }
        return is_correct;
    }
}
