package com.lesson3;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RailwayService {


    ArrayList<Train> listOfTrains;

    private void createrMethod (){

        LinkedHashMap<String, String> Lviv_Odessa_route = new LinkedHashMap<>();
        Lviv_Odessa_route.put("Lviv","01:30");
        Lviv_Odessa_route.put("Kyiv", "07:15-07:30");
        Lviv_Odessa_route.put("Odessa", "16:23");

        LinkedHashMap<String, String> IvanoFr_Kyiv_route = new LinkedHashMap<>();
        IvanoFr_Kyiv_route.put("Ivano-Frankivsk", "17:01");
        IvanoFr_Kyiv_route.put("Lviv", "19:40-20:05");
        IvanoFr_Kyiv_route.put("Kyiv", "01:12");

        Route Lviv_Odessa = new Route(Lviv_Odessa_route);

        Route IvanoFr_Kyiv = new Route(IvanoFr_Kyiv_route);


        Train train1 = new Train("123", Lviv_Odessa, 123, "");
        Train train2 = new Train("134", IvanoFr_Kyiv, 13, "");

        listOfTrains.add(train1);
        listOfTrains.add(train2);



    }

    public ArrayList<Train> locationsSearch (String from, String where){

        ArrayList<Train> searchedListOfTrains = new ArrayList<>();

        for (Train t : listOfTrains){
            if (t.getRoute().getRoute().containsKey(from) && t.getRoute().getRoute().containsKey(where)){

            }
        }

        return searchedListOfTrains;
    }

}
