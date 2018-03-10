package com.CarWashStation;

import com.CarWashStation.CarCleanState.CarState;
import com.CarWashStation.CarCleanState.DirtyCar;

public class Car {
    private boolean cleaned;
    private boolean foamed;
    private boolean dirtied;
    private CarState carState;


    private String name;
    public Car(){
        this.name = "Default car";
        this.carState = new DirtyCar(this);
        setDirtied(true);
    }
    public Car(String name){
        this.name = name;
        this.carState = new DirtyCar(this);
        setDirtied(true);
    }


    public boolean isCleaned() {
        return cleaned;
    }

    public void setCleaned(boolean cleaned) {
        if (cleaned){
            foamed = false;
            dirtied = false;
        }
        this.cleaned = cleaned;
    }

    public boolean isFoamed() {
        return foamed;
    }

    public void setFoamed(boolean foamed) {
        if (foamed){
            dirtied = false;
            cleaned = false;
        }
        this.foamed = foamed;
    }

    public boolean isDirtied() {
        return dirtied;
    }

    public void setDirtied(boolean dirtied) {
        if (dirtied){
            cleaned = false;
            foamed = false;
        }
        this.dirtied = dirtied;
    }

    public CarState getCarState() {
        return carState;
    }

    public void setCarState(CarState carState) {

        this.carState = carState;
    }

    public void changeCarState(CarState carState){
        this.carState = carState;
    }

    public String getName() {
        return name;
    }

}
