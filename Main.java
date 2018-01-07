package com;

import com.lesson3.RailwayService;
import com.lesson3.Station;
import com.lesson3.Train;

public class Main {

    public static void main(String[] args) {

       // UsageClassTrain usageClassTrain = new UsageClassTrain();
       // usageClassTrain.searchedLocationTrain("Lviv", "Kyiv");

        RailwayService rlsv = new RailwayService();
        for (Train t : rlsv.locationsSearch("Lviv", "Kyiv")){
            System.out.println(t);
        }

        for (Train t : rlsv.getListOfTrains()){
            System.out.println(t.getRoute().getDepartureTime("Kyiv"));
        }





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
