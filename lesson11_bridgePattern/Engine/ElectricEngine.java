package com.lesson11_bridgePattern.Engine;

public class ElectricEngine implements Engine {

    public ElectricEngine(){
        System.out.println("Electric engine");
    }

    public String start(){
        return "Electric engine start";
    }
    public String stop(){
        return "Electric engine stop";
    }
}
