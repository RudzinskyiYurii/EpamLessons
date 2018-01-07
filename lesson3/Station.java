package com.lesson3;

import java.util.ArrayList;

public class Station {

    private String arrivedDate;
    private String arrivedTime;
    private String dispatchDate;
    private String dispatchTime;
    private ArrayList<String> locations;

    public Station (){
        setArrivedDate("");
        setArrivedTime("");
        setDispatchDate("");
        setDispatchTime("");
        /*locations.add("Lviv");
        locations.add("Kyiv");
        locations.add("Odessa");*/
        setLocations();
    }

    public Station (String arrivedDate, String arrivedTime,
                    String dispatchDate, String dispatchTime,
                    String location){



    }




    public String getArrivedDate() {
        return arrivedDate;
    }

    public void setArrivedDate(String arrivedDate) {
        this.arrivedDate = arrivedDate;
    }

    public String getArrivedTime() {
        return arrivedTime;
    }

    public void setArrivedTime(String arrivedTime) {
        this.arrivedTime = arrivedTime;
    }

    public String getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public String getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(String dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public ArrayList<String> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<String> locations) {
        this.locations = locations;
    }
    public void setLocations() {
        locations.add("Lviv");
        locations.add("Kyiv");
        locations.add("Odessa");
    }
}
