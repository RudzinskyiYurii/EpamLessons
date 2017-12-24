package com.lesson1.ex2.ex2_2;


/**
 * Class which find and display all numbers with sorted digs in the order of growth
 */
public class CorrectNumbers {

    /**
     * Default constructor
     */
    public CorrectNumbers() {

        System.out.println("Empty array!");
    }

    /**
     * Constructor with param
     */
    public CorrectNumbers(int[] arrayOfNumbers) {
        System.out.println("\nAll numbers with sorted digs in the order of growth:");
        printAllCorrectNumbers(arrayOfNumbers);
    }

    /**
     * Method which display all correct numbers
     */
    void printAllCorrectNumbers(int[] inputArray){
        if (isAppropriated(inputArray)) {
            for (int i : inputArray) {
                if (ifCorrect(i)) {
                    System.out.print(i + ", ");
                }
            }
            System.out.println();
        }
        else
            System.out.println("Something wrong... Try it again.\n" + "Input array: ");

    }

    /**
     * Method which checking is the digs of number are sorted digs in the order of growth
     */

    private boolean ifCorrect (int number){
        boolean check_correct = false;
        String temp = Integer.toString(number);
        char [] charArr = temp.toCharArray();
        for (int k = 0; k < temp.length()-1; k++){
            if (charArr[k] <= charArr[k+1]){
                check_correct = true;
            }
            else {
                check_correct = false;
                break;
            }
        }
        return check_correct;
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
