package com.lesson4;

import java.util.Scanner;
import java.util.StringJoiner;

public class UsageString {

    private static final String FINISH = "..";
    //private static final String FINISH = "2";


    /**
     * changes duplicate characters
     */
    public String changeDuplicates() {
        String changedString;

        int doneChanges = 0;

        StringBuilder inputText = consoleRead();

        for (int j = 0; j < inputText.length(); j++) {
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

        //take maximum length + 1 of imputed text
        for (int i = 0;i < inputText.length(); i++){
            tempLength++;
            if (inputText.charAt(i) == '\n') {
                if (tempLength > lineLength) {
                    lineLength = tempLength;
                }
                tempLength = 0;
            }
        }
        //lineLength--;
        for (int i = 0;i < inputText.length(); i++){

            tempLine.append(inputText.charAt(i));
                if (inputText.charAt(i) == '\n') {
                    for (int j = (lineLength - tempLine.length()); j > 0; j--){
                        tempLine.insert(0, ' ');
                    }
                    formatedLine.append(tempLine);
                    tempLine = new StringBuilder();

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
            line = line.trim();
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
            if (FINISH.equals(line)) {
                break;
            } else {
                inputText.append(line);
                inputText.append("\n");
            }
        }
        //inputText.deleteCharAt(inputText.length() - 1);

        return inputText;
    }
}
