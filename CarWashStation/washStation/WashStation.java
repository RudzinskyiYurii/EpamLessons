package com.CarWashStation.washStation;

import com.CarWashStation.Car;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class WashStation extends Thread {
    private List<Car> cars;
    private String name;
    public WashStation(List<Car> cars, String name) {
        this.cars = cars;
        this.name = name;
    }

    @Override
    public void run() {

        for (Car car : cars) {
            System.out.println(car.getName() + " has arrived at wash station " + this.getWashstationName());
            Thread foamThread = new Thread(new FoamingCar(car));
            Thread washThread = new Thread(new WashingCar(car));
            //start foaming
            foamThread.start();
            // wait for finished foaming
            try {
                foamThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //start washing
            washThread.start();
            //wait for ending washing current car, before next one
            try {
                washThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getWashstationName() {
        return name;
    }
}
