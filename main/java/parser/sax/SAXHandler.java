package parser.sax;


import model.Accessory;
import model.Device;
import model.Port;
import model.Type;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    private List<Device> devicesList = new ArrayList<>();
    private Device device = null;
    private Type types = null;
    private List<Accessory> accessories = null;
    private List<Port> ports = null;


    private boolean dName = false;
    private boolean dOrigin = false;
    private boolean dPrice = false;
    private boolean dTypes = false;
    private boolean dPeripheral = false;
    private boolean dCooler = false;
    private boolean dPower = false;
    private boolean dAccessoriesGroup = false;
    private boolean dAccessory = false;
    private boolean dPorts = false;
    private boolean dPort = false;
    private boolean dCritical = false;


    public List<Device> getDevicesList(){
        return this.devicesList;
    }

    public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("device")){
            String devNO = attributes.getValue("devNO");
            device = new Device();
            device.setDevNO(Integer.parseInt(devNO));
        }
        else if (qName.equalsIgnoreCase("name")){dName = true;}
        else if (qName.equalsIgnoreCase("origin")){dOrigin = true;}
        else if (qName.equalsIgnoreCase("price")){dPrice = true;}

        //after this step we are not out from this method(unfortunately)
        //and I don`t know why
        else if (qName.equalsIgnoreCase("types")){dTypes = true;}

        else if (qName.equalsIgnoreCase("peripheral")){dPeripheral = true;}
        else if (qName.equalsIgnoreCase("cooler")){dCooler = true;}
        else if (qName.equalsIgnoreCase("powerWAT")){dPower = true;}
        else if (qName.equalsIgnoreCase("accessoriesGroup")){dAccessoriesGroup = true;}
        else if (qName.equalsIgnoreCase("accessory")){dAccessory = true;}
        else if (qName.equalsIgnoreCase("ports")){dPorts = true;}
        else if (qName.equalsIgnoreCase("port")){dPort = true;}
        else if (qName.equalsIgnoreCase("critical")){dCritical = true;}
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("device")){
            devicesList.add(device);
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (dName){
            device.setName(new String(ch, start, length));
            dName = false;
        }
        else if (dOrigin){
            device.setOrigin(new String(ch, start, length));
            dOrigin = false;
        }
        else if(dPrice){
            int price = Integer.parseInt(new String(ch, start, length));
            device.setPrice(price);
            dPrice = false;
        }
        else if (dTypes){
            types = new Type();
            dTypes = false;
        }
        else if (dPeripheral){
            types.setPeripheral(new String(ch, start, length));
            dPeripheral = false;
        }
        else if (dCooler){
            types.setCooler(new String(ch, start, length));
            dCooler = false;
        }
        else if(dPower){
            int power = Integer.parseInt(new String(ch, start, length));
            types.setPower(power);
            dPower = false;
        }
        else if(dAccessoriesGroup){
            accessories = new ArrayList<>();
            dAccessoriesGroup = false;
        }
        else if (dAccessory){
            Accessory accessory = new Accessory();
            accessory.setName(new String(ch, start, length));
            accessories.add(accessory);
            dAccessory = false;
        }
        else if(dPorts){
            ports = new ArrayList<>();
            dPorts = false;
        }
        else if (dPort){
            Port port = new Port();
            port.setName(new String(ch, start, length));
            ports.add(port);
            dPort = false;
        }
        else if (dCritical){
            device.setCritical(new String(ch, start, length));
            types.setPorts(ports);
            types.setAccessories(accessories);
            device.setTypes(types);
            dCooler = false;
        }

    }
}

