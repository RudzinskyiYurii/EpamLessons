package com.lesson3;

import java.util.LinkedHashMap;

public class Route {

    private LinkedHashMap<String, String> route;


    public Route (){

    }

    /**
     * Linked hash map key - location, value - time of arrival and departure
     */

    public Route (LinkedHashMap<String , String > route){
        setRoute(route);
    }






    public LinkedHashMap<String, String> getRoute() {
        return route;
    }

    public void setRoute(LinkedHashMap<String, String> route) {
        this.route = route;
    }
}
