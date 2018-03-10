package com.CarWashStation.washStation;

import com.CarWashStation.Car;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class WashingCar implements Runnable {
    public Car car;

    public WashingCar(Car car) {
        this.car = car;
    }

    ReentrantLock carWashLock = new ReentrantLock();

    @Override
    public void run() {
        carWashLock.lock();
        try {
            sleep(500);
            car.getCarState().onClean();
            if (car.isCleaned())
                System.out.println(car.getName() + " has been cleaned.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        carWashLock.unlock();
    }
}
