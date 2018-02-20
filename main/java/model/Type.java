package model;

import java.util.LinkedList;
import java.util.List;

public class Type {
    private String peripheral;
    private String cooler;
    private int power;
    private List<Accessory> accessories = new LinkedList<>();
    private List<Port> ports = new LinkedList<>();

    public Type(){}

    public Type(String peripheral, String cooler, int power, List<Accessory> accessories, List<Port> ports){
        this.peripheral = peripheral;
        this.cooler = cooler;
        this.power = power;
        this.accessories = accessories;
        this.ports = ports;
    }

    public String getPeripheral() {
        return peripheral;
    }

    public void setPeripheral(String peripheral) {
        this.peripheral = peripheral;
    }

    public String getCooler() {
        return cooler;
    }

    public void setCooler(String cooler) {
        this.cooler = cooler;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

    @Override
    public String toString(){
        return "\ttypes: \n" +
        "\t\t\tperipheral: " + peripheral + ";\n" +
                "\t\t\tcooler: " + cooler + ";\n" +
                "\t\t\tpower: " + power + " WAT;\n " +
                "\t\t\taccessories: " + accessories + ";\n" +
                "\t\t\tports: " + ports + ";\n";
    }
}
