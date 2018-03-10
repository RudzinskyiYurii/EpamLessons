package com.CarWashStation.CarCleanState;

import com.CarWashStation.Car;

public class FoamedCar extends CarState {

    public FoamedCar(Car car){
        super(car);
        car.setFoamed(true);
    }

    @Override
    public String onClean() {
        if (car.isFoamed()){
            car.changeCarState(new CleanCar(car));
            return "Car is clean!";
        }
        else
            return "Error!";
    }

    @Override
    public String onDirty() {
        return "Error!";
    }

    @Override
    public String onFoam() {
        if (!car.isCleaned() & !car.isDirtied()){
            car.changeCarState(new FoamedCar(car));
            return "Car is foam!";
        }
        else
            return "Error!";
    }
}
