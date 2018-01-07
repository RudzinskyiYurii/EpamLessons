package com.lesson3;

import java.util.ArrayList;

public class UsageClassTrain {

    public UsageClassTrain(){
        listOfTrains = addTrain(new Train());
    }

    private ArrayList<Train> listOfTrains;

    public ArrayList<Train> searchedLocationTrain (String from, String to){

        ArrayList<Train> searchedTrain = new ArrayList<>();


        for (Train train : listOfTrains){
            if (train.getListOfStation().get(0).equals(from) &&
                    train.getListOfStation().get(train.getListOfStation().size()).equals(to)){
                System.out.println(train);
                searchedTrain.add(train);
            }
        }
        return searchedTrain;
    }






    public ArrayList<Train> addTrain (Train train){

        listOfTrains.add(train);

        return listOfTrains;
    }
}
