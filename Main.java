package com;

import com.lesson4.ex1_ex2.UsageString;

public class Main {

    public static void main(String[] args) {


        UsageString usS = new UsageString();

        //System.out.println(usS.changeDuplicates());
        System.out.println(usS.formatStringByRightSide());

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
