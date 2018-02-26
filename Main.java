package com;

import com.Exam.Shop;
import com.Exam.ToolsService;
import com.lesson10.serviceStatuses;
import com.lesson11_bridgePattern.TestBridgePattern;
import com.lesson6.CafePoint.CafePointService;
//import com.lesson6.CafePoint.Client;
import com.lesson6.classwork.UsageGeneric;
import com.lesson7.Client;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        Shop shop = new Shop();
        shop.usageAllTHings();

/*
        try {
            new Refactoring().Parse();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

/*
        new TestBridgePattern().testing();*/

/*
        serviceStatuses serviceStatuses = new serviceStatuses();
        serviceStatuses.usageStatus();*/
/*
        Client client = new Client();
        client.makeOrder();
*/

/*
        CafePointService cafeSer = new CafePointService();
        cafeSer.usageCafePoint();
*/

        /*

        List<Integer> listOfIntegers = new LinkedList<>();

        listOfIntegers.add(1);
        listOfIntegers.add(4);
        listOfIntegers.add(7);

        List<String> listOfString = new LinkedList<>();

        listOfString.add("101");
        listOfString.add("sdfds");

        UsageGeneric<Integer> usGenericInteger = new UsageGeneric<>();
        usGenericInteger.getCount(listOfIntegers);

        UsageGeneric<String> usageGenericString = new UsageGeneric<>();
        usageGenericString.getCount(listOfString);
*/

/*
        BurrowsWheelerAlgorithm bwAlgorithm = new BurrowsWheelerAlgorithm();
        System.out.println("Result of the algorithm`s work:\n");

        for(String st : bwAlgorithm.algorithmBurrowsWheeler("java"))
            System.out.println(st);

        System.out.println("Sorted array:\n");

        for(String st : bwAlgorithm.sort("java"))
            System.out.println(st);

        System.out.println("Last characters of the strings in sorted array:\n");

        for (char ch : bwAlgorithm.lastCharacters("java"))
            System.out.println(ch);

*/
        /*UsageString usS = new UsageString();

        //System.out.println(usS.changeDuplicates());
        System.out.println(usS.formatStringByRightSide());
        */

        /*
        RailwayService rlsv = new RailwayService();
        for (Train t : rlsv.locationsSearch("Lviv", "Kyiv")){
            System.out.println(t);
        }

        System.out.println("\ndeparture time of station:\n");

        for (Train t : rlsv.getListOfTrains()){
            System.out.println(t.getRoute().getDepartureTime("Kyiv"));
        }

        System.out.println("\nTime search:\n");

        String dateOne = "2018-01-06 17:02";
        for (Train t : rlsv.afterSetTimeTrains(dateOne)){
            System.out.println(t);
        }

        System.out.println("\nLetter search:\n");

        for (Train t : rlsv.searchByLocation('O')){
            System.out.println(t);
        }

        System.out.println("\nFree seats search:\n");

        for (Train t : rlsv.listOfClosestTrainsByFreeSeats("Lviv"))
            System.out.println(t);
        */


        /*Fibonacci fib = new Fibonacci(10);
        System.out.println(fib);

        Sort sort = new Sort(new int [] {2,45,11,8,3});
        System.out.println(sort);

        CorrectNumbers corrN = new CorrectNumbers(new int[] {11111, 22222, 144588, 8812233});

        SimpleDigits simpD = new SimpleDigits(new int [] {11,45,2,8,3});

        WithoutRemainder withoutR = new WithoutRemainder(new int [] {11111, 22222, 44444, 8812233});*/

        /*Matrix matrix = new Matrix();

        matrix.printMatrix();
        matrix.printSummOfElementsOfMatrix();*/





    }
}
