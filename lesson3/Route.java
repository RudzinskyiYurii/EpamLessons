package com.lesson3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Route {

    private LinkedHashMap<String, String> route;


    public Route (){

    }

    /**
     * Linked hash map key - location, value - time of arrival and departure
     */

    public Route (LinkedHashMap<String , String> route){
        setRoute(route);
    }

    /**
     * Return date of the arrival
     */

    public Date getArrivalTime (String key){
        String  temp;
        temp = getRoute().get(key);


        int indexOfTheLine = 0;
        StringBuilder strB = new StringBuilder();
        StringBuilder arrivalTime = new StringBuilder();
        strB.append(temp);
        for (int i = 0; i < strB.length(); i++) {
            if (strB.charAt(i) == '*') {
                indexOfTheLine = i;
            }
        }
        if (indexOfTheLine != 0){
            for (int i = 0; i < indexOfTheLine; i++) {
                arrivalTime.append(strB.charAt(i));
            }
        }
        else
            arrivalTime = strB;

        DateFormat format = new SimpleDateFormat("yyyy-MM-DD HH:mm");
        Date date = null;
        try{
            date = format.parse(arrivalTime.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return date;
    }

    /**
     * Return date of the depatrure
     */
    public Date getDepartureTime (String key){

        String  temp;
        temp = getRoute().get(key);
        int indexOfTheLine = 0;

        StringBuilder strB = new StringBuilder();
        StringBuilder departureTime = new StringBuilder();
        strB.append(temp);

        for (int i = 0; i < strB.length(); i++) {
            if (strB.charAt(i) == '*') {
                indexOfTheLine = i;
            }
        }
        if (indexOfTheLine != 0){
            for (int i = indexOfTheLine + 1; i < strB.length(); i++) {
                departureTime.append(strB.charAt(i));
            }
        }
        else
            departureTime = strB;

        DateFormat format = new SimpleDateFormat("yyyy-MM-DD HH:mm");
        Date date = null;
        try{
            date = format.parse(departureTime.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return date;
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
