package com.lesson3;

import java.util.ArrayList;

public class Train {


    private String ID;
    private Route route;
    private int freeSeats;
    private String notes;



    public Train (){


    }

    public Train (String ID, Route route, int freeSeats, String notes){

        setID(ID);
        setRoute(route);
        setFreeSeats(freeSeats);
        setNotes(notes);

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



}
