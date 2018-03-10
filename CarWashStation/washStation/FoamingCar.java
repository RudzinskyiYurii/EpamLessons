package com.CarWashStation.washStation;


import com.CarWashStation.Car;
import static java.lang.Thread.sleep;

public class FoamingCar implements Runnable {

    private Car car;

    public FoamingCar(Car car){
        this.car = car;
    }
    @Override
    public void run() {
        synchronized (this) {
            try {
                sleep(1000); //sleep 1 sec
                car.getCarState().onFoam();
                if (car.isFoamed())
                    System.out.println(car.getName() + " has been foamed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
