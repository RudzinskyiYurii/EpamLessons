package model;

public class Device {

    private int devNO;
    private String name;
    private String origin;
    private int price;
    private Type types;
    private String critical;

    public Device(){}

    public Device (int devNO, String name, String origin, int price, Type types, String critical){
        this.devNO = devNO;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.types = types;
        this.critical = critical;
    }

    public int getDevNO() {
        return devNO;
    }

    public void setDevNO(int devNO) {
        this.devNO = devNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Type getTypes() {
        return types;
    }

    public void setTypes(Type types) {
        this.types = types;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    @Override
    public String toString(){
        return "\nDevice " + devNO + ":\n" +
                "\tname: "+ name + ";\n" +
                "\torigin: " + origin + ";\n" +
                "\tprice: " + price + ";\n" +
                types +
                "critical update: " + critical + ".\n";
    }
}
