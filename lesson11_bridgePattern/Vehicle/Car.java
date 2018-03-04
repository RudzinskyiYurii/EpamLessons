package com.lesson11_bridgePattern.Vehicle;

import com.lesson11_bridgePattern.Engine.ElectricEngine;
import com.lesson11_bridgePattern.Engine.Engine;
import com.lesson11_bridgePattern.transmission.AutoTransmission;
import com.lesson11_bridgePattern.transmission.Transmission;

public abstract class Car {
    public Car(Engine engine, Transmission transmission){

    }
    public abstract void move();
    public abstract void stop();
}
