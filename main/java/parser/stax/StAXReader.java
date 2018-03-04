package parser.stax;

import model.Accessory;
import model.Device;
import model.Port;
import model.Type;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXReader {
    public static List<Device> parseDevices(File xml, File xsd){
        List<Device> devicesList = new ArrayList<>();
        Device device = null;
        Type types = null;
        List<Accessory> accessories = null;
        List<Port> ports = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xml));
            while(xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    String name = startElement.getName().getLocalPart();
                    switch (name) {
                        case "device":
                            device = new Device();

                            Attribute idAttr = startElement.getAttributeByName(new QName("devNO"));
                            if (idAttr != null) {
                                device.setDevNO(Integer.parseInt(idAttr.getValue()));
                            }
                            break;
                        case "name":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert device != null;
                            device.setName(xmlEvent.asCharacters().getData());
                            break;
                        case "origin":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert device != null;
                            device.setOrigin(xmlEvent.asCharacters().getData());
                            break;
                        case "price":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert device != null;
                            device.setPrice(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "types":
                            xmlEvent = xmlEventReader.nextEvent();
                            types = new Type();
                            break;
                        case "peripheral":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert types != null;
                            types.setPeripheral(xmlEvent.asCharacters().getData());
                            break;
                        case "cooler":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert types != null;
                            types.setCooler(xmlEvent.asCharacters().getData());
                            break;
                        case "powerWAT":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert types != null;
                            types.setPower(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "accessoriesGroup":
                            xmlEvent = xmlEventReader.nextEvent();
                            accessories = new ArrayList<>();
                            break;
                        case "accessory":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert accessories != null;
                            accessories.add(new Accessory(xmlEvent.asCharacters().getData()));
                            break;
                        case "ports":
                            xmlEvent = xmlEventReader.nextEvent();
                            ports = new ArrayList<>();
                            break;
                        case "port":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert ports != null;
                            ports.add(new Port(xmlEvent.asCharacters().getData()));
                            break;
                        case "critical":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert device != null;
                            device.setCritical(xmlEvent.asCharacters().getData());
                            assert types != null;
                            types.setAccessories(accessories);
                            types.setPorts(ports);
                            device.setTypes(types);
                            break;
                    }
                }

                if(xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if(endElement.getName().getLocalPart().equals("device")){
                        devicesList.add(device);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return devicesList;
    }
}
