package com.lesson3;

import java.util.ArrayList;

public class Train {




    private int freeSeats;
    private String location;
    private ArrayList<Station> listOfStation;


    public Train (){

        setFreeSeats(100);
        listOfStation.add(new Station());
    }

    public Train (int freeSeats, ArrayList<Station> listOfStations){

        setListOfStation(listOfStations);
        setFreeSeats(freeSeats);


    }

    public ArrayList<Station> getListOfStation() {
        return listOfStation;
    }

    public void setListOfStation(ArrayList<Station> listOfStation) {
        this.listOfStation = listOfStation;
    }


    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }



}
