package com.lesson11_bridgePattern.transmission;

public class AutoTransmission implements Transmission {

    public AutoTransmission(){
        System.out.println("Auto transmission");
    }

    public String putLowerTransmission(){
        return "Auto change to lower transmission";
    }

    public String putUpperTransmission(){
        return "Auto change to upper transmission";
    }
}
