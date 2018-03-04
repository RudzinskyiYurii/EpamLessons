package com.lesson11_bridgePattern.transmission;

public class MechanicTransmission implements Transmission{
    public MechanicTransmission(){
        System.out.println("Mechanic transmission");
    }

    public String putLowerTransmission(){
        return "Change to lower transmission";
    }

    public String putUpperTransmission(){
        return "Change to upper transmission";
    }
}
