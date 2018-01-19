package com.lesson6.CafePoint;

import java.util.LinkedList;
import java.util.List;

public class Order<E extends Addons> {

    private List<E> currentOrder = new LinkedList<>();

    public void addAddon (E addon){
        currentOrder.add(addon);
    }

    public void printOrder(){
        if (currentOrder != null){
            for (Addons add : currentOrder){
                add.printInfo();
            }
        }
    }
}
