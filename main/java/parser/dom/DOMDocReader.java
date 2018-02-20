package parser.dom;

import model.Accessory;
import model.Device;
import model.Port;
import model.Type;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMDocReader {
    public List<Device> readDoc(Document doc){
        doc.getDocumentElement().normalize();
        List<Device> devices = new ArrayList<>();

        NodeList nodeList = doc.getElementsByTagName("device");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Device device = new Device();
            Type types;
            List<Accessory> accessories;
            List<Port> ports;


            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;

                device.setDevNO(Integer.parseInt(element.getAttribute("devNO")));
                device.setName(element.getElementsByTagName("name").item(0).getTextContent());
                device.setOrigin(element.getElementsByTagName("origin").item(0).getTextContent());
                device.setPrice(Integer.parseInt(element.getElementsByTagName("price").item(0).getTextContent()));
                device.setCritical(element.getElementsByTagName("critical").item(0).getTextContent());

                accessories = getAccessories(element.getElementsByTagName("accessoriesGroup"));
                ports = getPorts(element.getElementsByTagName("ports"));
                types = getTypes(element.getElementsByTagName("types"));

                types.setAccessories(accessories);
                types.setPorts(ports);
                device.setTypes(types);

                devices.add(device);
            }
        }
        return devices;
    }

    private List<Accessory> getAccessories(NodeList nodes){
        List<Accessory> accessories = new ArrayList<>();
        if(nodes.item(0).getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) nodes.item(0);
            NodeList nodeList = element.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element el = (Element) node;
                    accessories.add(new Accessory(el.getTextContent()));
                }
            }
        }

        return accessories;
    }

    private List<Port> getPorts(NodeList nodes){
        List<Port> ports = new ArrayList<>();
        if(nodes.item(0).getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) nodes.item(0);
            NodeList nodeList = element.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element el = (Element) node;
                    ports.add(new Port(el.getTextContent()));
                }
            }
        }

        return ports;
    }

    private Type getTypes(NodeList nodes){
        Type type = new Type();
        if (nodes.item(0).getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) nodes.item(0);
            type.setPeripheral(element.getElementsByTagName("peripheral").item(0).getTextContent());
            type.setCooler(element.getElementsByTagName("cooler").item(0).getTextContent());
            type.setPower(Integer.parseInt(element.getElementsByTagName("powerWAT").item(0).getTextContent()));
        }

        return type;
    }

}
