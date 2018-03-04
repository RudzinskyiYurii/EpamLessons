package model;


public class Accessory {
    private String name;

    public Accessory(){}

    public Accessory(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name ;
    }
}
