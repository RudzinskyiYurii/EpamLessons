package com.lesson11_bridgePattern.Engine;

public class PetrolEngine implements Engine {

    public PetrolEngine(){
        System.out.println("Petrol engine");
    }

    public String start(){
        return "Petrol engine start";
    }

    public String stop(){
        return "Petrol engine stop";
    }
}
