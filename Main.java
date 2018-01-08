package com;

import com.lesson3.RailwayService;
import com.lesson3.Station;
import com.lesson3.Train;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

       // UsageClassTrain usageClassTrain = new UsageClassTrain();
       // usageClassTrain.searchedLocationTrain("Lviv", "Kyiv");

        RailwayService rlsv = new RailwayService();
        for (Train t : rlsv.locationsSearch("Lviv", "Kyiv")){
            System.out.println(t);
        }

        System.out.println();

        for (Train t : rlsv.getListOfTrains()){
            System.out.println(t.getRoute().getDepartureTime("Kyiv"));
        }

        System.out.println();

        String dateOne = "2018-01-06 17:02";
        for (Train t : rlsv.afterSetTimeTrains(dateOne)){
            System.out.println(t);
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
