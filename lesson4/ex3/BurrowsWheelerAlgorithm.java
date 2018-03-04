package com.lesson4.ex3;

public class BurrowsWheelerAlgorithm {

    /**
     * return string array with strings made by algorithm Burrows-Wheeler
     */

    public String[] algorithmBurrowsWheeler (String inputString){
        String[] resultedArray = new String[inputString.length()];

        StringBuilder tempChangedString = new StringBuilder();
        tempChangedString.append(inputString);//add input string into string builder


        for (int i = 0; i < resultedArray.length; i++){
            tempChangedString.append(tempChangedString.charAt(0)); //add to the end of the string first character
            tempChangedString.deleteCharAt(0);//delete first character
            resultedArray[i] = tempChangedString.toString();//add new string to the array
        }

        return resultedArray;
    }

    /**
     * Return sorted array by ABC with words made by algorithm Burrows-Wheeler
     */

    public String[] sort (String inputString){
        String[] sortedArray;
        String[] tempStringsArray = algorithmBurrowsWheeler(inputString); //
        StringBuilder tempChangedStringCurrent = new StringBuilder();
        StringBuilder tempChangedStringNext = new StringBuilder();
        String tempString;

        for (int p = 0; p < inputString.length(); p++) {
            for (int i = 0; i < inputString.length() - 1; i++) {
                tempChangedStringCurrent.append(tempStringsArray[i]);
                tempChangedStringNext.append(tempStringsArray[i + 1]);

                int temp = 0;
                for (int j = 0; j < inputString.length(); j++) {
                    /* check first character in the two strings.
                    If they are equals, we need to check the other one
                     */
                    if (tempChangedStringNext.charAt(temp) == tempChangedStringCurrent.charAt(temp)) {
                        temp++;
                        /*If character form next string is "smaller" we replace them*/
                    } else if (tempChangedStringNext.charAt(temp) < tempChangedStringCurrent.charAt(temp)) {
                        tempString = tempStringsArray[i];
                        tempStringsArray[i] = tempStringsArray[i + 1];
                        tempStringsArray[i + 1] = tempString;
                        break;// we shouldn`t check the others characters if we already replaced them
                    } else
                        break;//characters are in correct order, shouldn`t check anything
                }

                tempChangedStringCurrent = new StringBuilder();//nullify temp strings
                tempChangedStringNext = new StringBuilder();
            }
        }
        sortedArray = tempStringsArray;

        return sortedArray;
    }

    /**
     * return last characters from sorted array of strings which made by algorithm Burrows-Wheeler
     */
    public char[] lastCharacters(String inputString){
        char[] lastCharactersArray = new char[inputString.length()];
        StringBuilder currentString = new StringBuilder();
        String[] sortedArrayOfTheStrings = sort(inputString);

        for (int i = 0; i < sortedArrayOfTheStrings.length; i++){
            currentString.append(sortedArrayOfTheStrings[i]);//add one string to string builder
            lastCharactersArray[i] = currentString.charAt(currentString.length() - 1);//replace the last character from the string to array of chars
        }
        return lastCharactersArray;
    }

}
