package com.CarWashStation.CarCleanState;

import com.CarWashStation.Car;

public class CleanCar extends CarState{

    public CleanCar(Car car){
        super (car);
        car.setCleaned(true);
    }

    @Override
    public String onClean() {
        if (!car.isDirtied() & !car.isFoamed()){
            car.changeCarState(new CleanCar(car));
            return "Car is clean!";
        }
        else
            return "Error";
    }

    @Override
    public String onDirty() {
        if (car.isCleaned()){
            car.changeCarState(new DirtyCar(car));
            return "Car is dirty!";
        }
        else
            return "Error!";
    }

    @Override
    public String onFoam() {
        return "Error!";
    }
}
