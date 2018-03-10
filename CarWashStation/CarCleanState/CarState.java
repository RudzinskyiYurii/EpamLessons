package com.CarWashStation.CarCleanState;

import com.CarWashStation.Car;

public abstract class CarState {
    public Car car;

    public CarState (Car car){
        this.car = car;
    }

    public abstract String onClean();
    public abstract String onDirty();
    public abstract String onFoam();
}
