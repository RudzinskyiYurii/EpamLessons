package com.lesson11_bridgePattern.Vehicle;

import com.lesson11_bridgePattern.Engine.ElectricEngine;
import com.lesson11_bridgePattern.transmission.AutoTransmission;

public class ElectricBus extends Car {

    public ElectricBus(){
        super(new ElectricEngine(), new AutoTransmission());
        System.out.println("Created electric bus.\n");
    }

    public void move(){
        System.out.println("Electric bus is moving ...");
    }

    public void stop(){
        System.out.println("Electric bus has been stopped.");
    }
}
