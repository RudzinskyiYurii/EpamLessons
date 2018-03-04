package com.lesson11_bridgePattern.Engine;

public class DieselEngine implements Engine {

    public DieselEngine(){
        System.out.println("Diesel engine");
    }

    public String start(){
        return  "Diesel engine start";
    }

    public String stop(){
        return "Diesel engine stop";
    }
}
