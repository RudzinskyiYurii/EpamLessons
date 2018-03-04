package com.lesson3;

import java.awt.image.AreaAveragingScaleFilter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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


    /**
     * Create instances of the trains and routes
     */

    private void createrMethod (){

        LinkedHashMap<String, String> Lviv_Odessa_route = new LinkedHashMap<>();
        Lviv_Odessa_route.put("Lviv","2018-01-06 01:30");
        Lviv_Odessa_route.put("Kyiv", "2018-01-06 07:15*2018-01-06 07:30");
        Lviv_Odessa_route.put("Odessa", "2018-01-06 16:23");

        LinkedHashMap<String, String> IvanoFr_Kyiv_route = new LinkedHashMap<>();
        IvanoFr_Kyiv_route.put("Ivano-Frankivsk", "2018-01-06 17:01");
        IvanoFr_Kyiv_route.put("Lviv", "2018-01-06 19:40-2018-01-06 20:05");
        IvanoFr_Kyiv_route.put("Kyiv", "2018-01-07 01:12");

        LinkedHashMap<String, String> Kyiv_IvanoFr_route = new LinkedHashMap<>();
        Kyiv_IvanoFr_route.put("Kyiv", "2018-01-06 07:13");
        Kyiv_IvanoFr_route.put("Lviv", "2018-01-06 12:45*2018-01-06 13:15");
        Kyiv_IvanoFr_route.put("Ivano-Frankivsk", "2018-01-06 16:50");

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


    /**
     * return array list of all the trains which are sent from .. to ..
     */
    public ArrayList<Train> locationsSearch (String from, String where){

        ArrayList<Train> searchedListOfTrains = new ArrayList<>();


        for (Train t : listOfTrains){

            if (t.getRoute().isInCorrectOrder(from, where))
                searchedListOfTrains.add(t);
        }

        return searchedListOfTrains;
    }

    /**
     * return array list of the closest trains which are passed the set station by first letter
     */

    public ArrayList<Train> searchByLocation (char firstLetter){

        ArrayList<Train> searchedListOfTrains = new ArrayList<>();

        for (Train t : listOfTrains){
            for (char ch : t.getRoute().listOfTheFirstLettersOfTheStations()){
                if (ch == firstLetter){
                    searchedListOfTrains.add(t);
                }
            }
        }

        return searchedListOfTrains;
    }
    /**
     * overload method return array list of the trains which are passed the set station by station
     */

    public ArrayList<Train> searchByLocation (String location){

        ArrayList<Train> searchedListOfTrains = new ArrayList<>();

        ArrayList<Train> listOfTrainsClosestToCurrentTime = new ArrayList<>();
        listOfTrainsClosestToCurrentTime = afterSetTimeTrains("2018-01-06 12:00"); // current date

        for (Train t : listOfTrainsClosestToCurrentTime){
                if (t.getRoute().getRoute().containsKey(location)){
                    searchedListOfTrains.add(t);
                }

        }

        return searchedListOfTrains;
    }

    /**
     * Return list of closest trains in order of the free seats
     * @param location
     * @return
     */

    public ArrayList<Train> listOfClosestTrainsByFreeSeats (String location){

        ArrayList<Train> searchedListOfTrains = new ArrayList<>();
        Train tempTrain;

        searchedListOfTrains = afterSetTimeTrains("2018-01-06 12:00"); // current date

        for (Train t : searchedListOfTrains) {
            for (int i = 0; i < searchedListOfTrains.size() - 1; i++) {
                if (searchedListOfTrains.get(i).getFreeSeats() < searchedListOfTrains.get(i + 1).getFreeSeats()) {
                    tempTrain = searchedListOfTrains.get(i);
                    searchedListOfTrains.set(i, searchedListOfTrains.get(i + 1));
                    searchedListOfTrains.set(i + 1, tempTrain);
                }
            }
        }


        return searchedListOfTrains;
    }

    /**
     * return array list of the train which are sent after transmitted time
     */
    public ArrayList<Train> afterSetTimeTrains (String time){

        ArrayList<Train> listOfAfterSetTimeTrains = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("yyyy-MM-DD HH:mm");
        Date date = null;
        try{
            date = format.parse(time);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        for (Train t : listOfTrains){
            Set set = t.getRoute().getRoute().entrySet();

            Iterator itr1 = set.iterator();
            while (itr1.hasNext()){
                Map.Entry me = (Map.Entry)itr1.next();
                if (t.getRoute().getDepartureTime((String)me.getKey()).getTime() > date.getTime()){
                    listOfAfterSetTimeTrains.add(t);
                    break;
                }
            }
        }

        return listOfAfterSetTimeTrains;
    }





}
