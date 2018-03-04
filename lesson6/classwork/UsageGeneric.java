package com.lesson6.classwork;

//import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.LinkedList;
import java.util.List;

public class UsageGeneric <T> {

    public void getCount (List<T> inputCollection){
        //int count  = 0;
        outputCountOddIntegers(inputCollection);
        outputCountPrimeNumbers(inputCollection);


    }

    private List<T> oddIntegers (List<T> inputCollection){
        List<T> resultedCollection = new LinkedList<>();

        for (T i : inputCollection){
            try {
                if (((Integer) i % 2) == 1)
                    resultedCollection.add(i);
            }
            catch (Exception e){
                System.out.println("Wrong type!\n");
                break;
            }
        }

        return resultedCollection;
    }

    private void outputCountOddIntegers (List<T> inputCollection){
        if (!isEmpty(oddIntegers(inputCollection)))
            System.out.println("Count of odd numbers: " + oddIntegers(inputCollection).size()
                    + " in collection:\n");
    }

    private List<T> primeNumbers (List<T> inputCollection){
        List<T> resultedCollection = new LinkedList<>();
        int tempCount = 0;
        for (T i : inputCollection){
            try {
                for (int j = 1; j < (Integer)i; j++) {
                    if (((Integer)i % j) == 0){
                        tempCount++;
                    }
                }
                if (tempCount == 2)
                    resultedCollection.add(i);
                tempCount = 0;
            }
            catch (Exception e){
                continue;
            }
        }
        return resultedCollection;
    }

    private void outputCountPrimeNumbers (List<T> inputCollection){
        if (!isEmpty(oddIntegers(inputCollection)))
            System.out.println("Count of prime numbers: " + primeNumbers(inputCollection).size()
                    + " in collection:\n");
    }


    private List<T> palindromes (List<T> inputCollection){
        List<T> resultedCollection = new LinkedList<>();
        int tempCount = 0;

        for (T i : inputCollection){
            try {
                StringBuilder currentString = new StringBuilder();
                StringBuilder halfString = new StringBuilder();
                currentString.append(i);
                for (int j = 1; j < currentString.length(); j++) {
                   // halfString.append(currentString.l);
                   // if (halfString == 0){
                        tempCount++;
                    //}
                }
                if (tempCount == 2)
                    resultedCollection.add(i);
                tempCount = 0;
            }
            catch (Exception e){
                continue;
            }
        }


        return resultedCollection;
    }

    private void outputCountPalindromes (List<T> inputCollection){
        if (!isEmpty(oddIntegers(inputCollection)))
            System.out.println("Count of palindromes: " + palindromes(inputCollection).size()
                    + " in collection:\n");
    }

    private boolean isEmpty (List<T> inputColection){
        if (inputColection.size() == 0)
            return true;
        return false;
    }

}
