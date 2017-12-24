package com.lesson1.ex2.ex2_3;

/**
 * Class which checking and display numbers,
 * which have all digits as simple digits
 */
public class SimpleDigits {

    /**
     * Default constructor
     */
    public SimpleDigits(){
        System.out.println("\nResult of working class SimpleDigits:");
        System.out.println("Empty input!");
    }

    /**
     * Contructor with param
     */
    public SimpleDigits(int[] arrayOfNumbers){
        System.out.println("\nResult of working class SimpleDigits:");
        printAllNumbersWithSimpleDigits(arrayOfNumbers);
    }

    /**
     * Method which display all numbers,
     * which have all digits as simple digits
     */
    private void printAllNumbersWithSimpleDigits(int [] inputArray){
        for (int i : inputArray){
            if (isCorrect(i)){
                System.out.print(i + ", ");
            }
        }

    }

    /**
     * Method which check is the digit is simple
     */
    private boolean isSimpleDigits(int number){
	
	if (number == 1)
		return true;
        boolean checkCorrect = false;
        int temp = 0;
        for (int i = 1; i <= number; i ++){
            if ((number%i) == 0)
                temp++;
        }

        if (temp == 2)
            checkCorrect = true;
        else
            checkCorrect = false;
        return  checkCorrect;
    }
    /**
     * Method which checking is the digs of number are sorted digs in the order of growth
     */

    private boolean  isCorrect (int number){
        int count = 0;
        int currentDigit = 0;
        boolean check_correct = false;

        String temp = Integer.toString(number);
        // check every digit
        for (int k = 0; k < temp.length(); k++){
            currentDigit = number%10;

            if (isSimpleDigits(currentDigit)){
                count++;
            }
            else
                continue;
            number = (int) number / 10;
        }

        if (count == (temp.length()))
            check_correct = true;
        else
            check_correct = false;
        return check_correct;
    }


}
