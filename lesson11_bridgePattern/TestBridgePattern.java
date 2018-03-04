package com.lesson11_bridgePattern;

import com.lesson11_bridgePattern.Vehicle.Bus;
import com.lesson11_bridgePattern.Vehicle.Car;
import com.lesson11_bridgePattern.Vehicle.ElectricBus;

public class TestBridgePattern {
    public void testing(){
        Car bus1 = new Bus();
        Car electrBus1 = new ElectricBus();

        bus1.move();
        electrBus1.move();
        electrBus1.stop();
        bus1.stop();

    }
}
