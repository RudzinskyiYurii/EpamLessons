package com.lesson1.ex2.ex2_1;

/**
 * Class which sorted input array of numbers (Bubble method)
 * And checking if input numbers have at least 5 dig
 */
public class Sort {
    private int[] arrayOfNumbers;

    /**
     * Default constructor
     */
    public Sort() {
        this.arrayOfNumbers = new int[]{0};
    }

    /**
     * Constructor with param
     */
    public Sort(int[] arrayOfNumbers) {
        System.out.println("Sorted array:");
        this.arrayOfNumbers = sortMethod(arrayOfNumbers);
    }

    /**
     * Bubble sort method
     */
    private int[] sortMethod(int[] arrOfNumbers) {

        if (isCorrect(arrOfNumbers) == false) {
            System.out.println("Something wrong... Try it again.\n" + "Input array: ");
            return arrOfNumbers;
        }

        else {

            for (int j = 1; j < arrOfNumbers.length; j++) {
                for (int i = 0; i < arrOfNumbers.length - 1; i++) {

                    if (arrOfNumbers[i] > arrOfNumbers[i + 1]) {
                        int temp = 0;
                        temp = arrOfNumbers[i];
                        arrOfNumbers[i] = arrOfNumbers[i + 1];
                        arrOfNumbers[i + 1] = temp;
                    }
                }
            }

            return arrOfNumbers;
        }
    }

    /**
     * Override method toString to display sorted array
     */
    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        for (int i : arrayOfNumbers) {
            strB.append(i).append(", ");
        }
        strB.deleteCharAt(strB.length() - 2);
        strB.deleteCharAt(strB.length() - 1);
        strB.append(".");
        return strB.toString();
    }

    /**
     * Method which checking if input numbers have at least 5 dig
     */
    private boolean isCorrect(int[] arr) {
        boolean is_correct = false;
        for (int i : arr) {
            if (i > 9999) {
                is_correct = true;
            }
            else
                is_correct = false;
        }
        return is_correct;
    }
}
