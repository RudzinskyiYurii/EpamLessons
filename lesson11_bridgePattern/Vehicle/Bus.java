package com.lesson11_bridgePattern.Vehicle;

import com.lesson11_bridgePattern.Engine.DieselEngine;
import com.lesson11_bridgePattern.transmission.MechanicTransmission;

public class Bus extends Car {

    public Bus(){
        super(new DieselEngine(), new MechanicTransmission());
        System.out.println("Created bus.\n");
    }
    public void move(){
        System.out.println("Bus is moving ...");
    }

    public void stop(){
        System.out.println("Bus has been stopped.");
    }
}
