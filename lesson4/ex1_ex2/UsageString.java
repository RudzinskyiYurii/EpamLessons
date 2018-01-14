package com.lesson4.ex1_ex2;

import java.util.Scanner;
import java.util.StringJoiner;

public class UsageString {

    private static final String FINISH = ".."; //string which end the inputing (Linux can`t add me the chance to use for example Ctrl+C)



    /**
     * changes duplicate characters
     */
    public String changeDuplicates() {
        String changedString;

        int doneChanges = 0;

        StringBuilder inputText = consoleRead();

        for (int j = 0; j < inputText.length(); j++) {//we need to check things below how many times how many characters we have

            //check for the equals characters
            for (int i = 0; i < inputText.length() - 1; i++) {
                if (inputText.charAt(i) == inputText.charAt(i + 1)) {
                   inputText.deleteCharAt(i);
                   doneChanges ++;
                }
            }
        }
        changedString = inputText.toString();
        System.out.println(doneChanges + "changes have been done! See below the result.\n");
        return changedString;
    }

    /**
     * return formated input text by right side
     */
    public String formatStringByRightSide (){
        String formatedText = null;

        StringBuilder inputText = consoleRead();
        StringBuilder tempLine = new StringBuilder();
        StringBuilder formatedLine = new StringBuilder();

        int lineLength = 0; // length of the line
        int tempLength = 0;

        //take maximum length + 1 in the line of imputed text
        for (int i = 0;i < inputText.length(); i++){
            tempLength++;
            /*Check if found the symbol of the next line compare to length*/
            if (inputText.charAt(i) == '\n') {
                if (tempLength > lineLength) {
                    lineLength = tempLength;
                }
                tempLength = 0;
            }
        }

        for (int i = 0;i < inputText.length(); i++){

            tempLine.append(inputText.charAt(i));
                if (inputText.charAt(i) == '\n') {
                    /*If length of the current line is smaller than line length, which we found above
                    * we add ' ' (space) to the beginning of the line, which begin after symbol '\n' (new line),
                    * in quantity if difference between max length of the line and length of the current line*/
                    for (int j = (lineLength - tempLine.length()); j > 0; j--){
                        tempLine.insert(0, ' ');
                    }
                    formatedLine.append(tempLine);//add formatted line
                    tempLine = new StringBuilder();//nullify temp strings

                }
        }
        formatedText = formatedLine.toString();

        return formatedText;
    }


    /**
     * check the entered line not be null and return it
     */

    private String nextLine(Scanner in) {
        String line = in.nextLine();
        if (line != null) {
            line = line.trim();//delete all spaces to take current line
        }
        return line;
    }

    /**
     * return text that was entered from the console in stringbuilder
     */
    private StringBuilder consoleRead (){
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputText = new StringBuilder();

        System.out.println("Please, write text below:\n" +
        "If u finished, entry two dots, like this .. and entry will end.\n");

        while (scanner.hasNext()) {
            String line = nextLine(scanner);
            if (FINISH.equals(line)) {// check if the line is finish string
                break;//end of the inputing
            } else {
                inputText.append(line);
                inputText.append("\n");
            }
        }


        return inputText;
    }
}
