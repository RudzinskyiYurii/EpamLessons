package com.CarWashStation.CarCleanState;

import com.CarWashStation.Car;

public class DirtyCar extends CarState{


    public DirtyCar(Car car){
        super(car);
        car.setDirtied(true);
    }

    @Override
    public String onClean() {
        return "Error!";
    }

    @Override
    public String onDirty() {
        if (!car.isCleaned() & !car.isFoamed()){
            car.changeCarState(new DirtyCar(car));
            return "Car is dirty!";
        }
        else
            return "Error!";
    }

    @Override
    public String onFoam() {
        if (car.isDirtied()){
            car.changeCarState(new FoamedCar(car));
            return "Car is foamed!";
        }
        else
            return "Error!";
    }
}
