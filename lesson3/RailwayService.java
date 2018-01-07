package com.lesson3;

import java.util.*;

public class RailwayService {

    public RailwayService(){
        createrMethod();
    }


    public ArrayList<Train> getListOfTrains() {
        return listOfTrains;
    }

    public void setListOfTrains(ArrayList<Train> listOfTrains) {
        this.listOfTrains = listOfTrains;
    }

    ArrayList<Train> listOfTrains = new ArrayList<>();

    private void createrMethod (){

        LinkedHashMap<String, String> Lviv_Odessa_route = new LinkedHashMap<>();
        Lviv_Odessa_route.put("Lviv","01:30");
        Lviv_Odessa_route.put("Kyiv", "07:15-07:30");
        Lviv_Odessa_route.put("Odessa", "16:23");

        LinkedHashMap<String, String> IvanoFr_Kyiv_route = new LinkedHashMap<>();
        IvanoFr_Kyiv_route.put("Ivano-Frankivsk", "17:01");
        IvanoFr_Kyiv_route.put("Lviv", "19:40-20:05");
        IvanoFr_Kyiv_route.put("Kyiv", "01:12");

        LinkedHashMap<String, String> Kyiv_IvanoFr_route = new LinkedHashMap<>();
        Kyiv_IvanoFr_route.put("Kyiv", "07:13");
        Kyiv_IvanoFr_route.put("Lviv", "12:45-13:15");
        Kyiv_IvanoFr_route.put("Ivano-Frankivsk", "16:50");

        Route Lviv_Odessa = new Route(Lviv_Odessa_route);

        Route IvanoFr_Kyiv = new Route(IvanoFr_Kyiv_route);

        Route Kyiv_IvanoFr = new Route(Kyiv_IvanoFr_route);


        Train train1 = new Train("123", Lviv_Odessa, 123, "");
        Train train2 = new Train("134", IvanoFr_Kyiv, 13, "");
        Train train3 = new Train("568", Kyiv_IvanoFr, 100, "");

        listOfTrains.add(train1);
        listOfTrains.add(train2);
        listOfTrains.add(train3);



    }

    public ArrayList<Train> locationsSearch (String from, String where){

        ArrayList<Train> searchedListOfTrains = new ArrayList<>();


        for (Train t : listOfTrains){

            if (t.getRoute().isInCorrectOrder(from, where))
                searchedListOfTrains.add(t);
        }

        return searchedListOfTrains;
    }





    public ArrayList<Train> afterSetTimeTrains (String time){

        ArrayList<Train> listOfAfterSetTimeTrains = new ArrayList<>();

        for (Train t : listOfTrains){
            Set set = t.getRoute().getRoute().entrySet();

            Iterator itr1 = set.iterator();
            while (itr1.hasNext()){
                Map.Entry me = (Map.Entry)itr1.next();
                if (isTimeMore(t.getRoute().getDepartureTime((String)me.getKey()) , time)){
                    listOfAfterSetTimeTrains.add(t);
                }

            }
        }


        return listOfAfterSetTimeTrains;

    }

    public boolean isTimeMore (String firstTime, String secondTime){
        StringBuilder strOne = new StringBuilder();
        StringBuilder strTwo = new StringBuilder();

        StringBuilder strOneTemp = new StringBuilder();
        StringBuilder strTwoTemp = new StringBuilder();

        boolean checkMinutes = false;
        boolean checkHours = false;

        strOne.append(firstTime);
        strTwo.append(secondTime);

        for(int i = 3; i < 5; i++)
            strOneTemp.append(strOne.charAt(i));
        for(int i = 3; i < 5; i++)
            strTwoTemp.append(strTwo.charAt(i));
        if (Integer.parseInt(strTwoTemp.toString()) > Integer.parseInt(strOneTemp.toString()))
            checkMinutes = true;
        for(int i = 0; i < 2; i++)
            strOneTemp.append(strOne.charAt(i));
        for(int i = 0; i < 2; i++)
            strTwoTemp.append(strTwo.charAt(i));
        if (Integer.parseInt(strTwoTemp.toString()) > Integer.parseInt(strOneTemp.toString()))
            checkHours = true;

        return checkHours & checkMinutes;
    }

}
