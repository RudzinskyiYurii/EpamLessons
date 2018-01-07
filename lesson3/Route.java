package com.lesson3;

import java.util.*;

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


    public String getTime (String key){
        String listOfTime;
        listOfTime = getRoute().get(key);
        return listOfTime;
    }

    /**
     *  Check if order of locations requets are observed
     */


    public boolean isInCorrectOrder (String firstLocation, String secondLocation){
        boolean isInOrder = false;
        int tempForFrom = 0;
        int tempForWhere = 0;

        Set set = route.entrySet();

        Iterator itr1 = set.iterator();
        while (itr1.hasNext()){
            Map.Entry me = (Map.Entry)itr1.next();
            if (me.getKey() != firstLocation){
                tempForFrom++;
            }
            else
                break;
        }
        Iterator itr2 = set.iterator();
        while (itr2.hasNext()){
            Map.Entry me = (Map.Entry)itr2.next();
            if (me.getKey() != secondLocation){
                tempForWhere++;
            }
            else
                break;
        }

        if (tempForFrom < tempForWhere)
            isInOrder = true;
        else
            isInOrder = false;

        return isInOrder;
    }




    public LinkedHashMap<String, String> getRoute() {
        return route;
    }

    public void setRoute(LinkedHashMap<String, String> route) {
        this.route = route;
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();

        Iterator<Map.Entry<String, String>> itr = route.entrySet().iterator();
        while (itr.hasNext()){
            strB.append(itr.next().getKey());
            strB.append(" - ");
        }
        return strB.toString();
    }
}
