package parser.sax;


import model.Device;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXParserUser {
    private static SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

    public static List<Device> parseDevices(File xml, File xsd){
        List<Device> devicesList = new ArrayList<>();
        try {
            saxParserFactory.setSchema(SAXValidator.createSchema(xsd));

            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(xml, saxHandler);

            devicesList = saxHandler.getDevicesList();
        }catch (SAXException | ParserConfigurationException | IOException ex){
            ex.printStackTrace();
        }

        return devicesList;
    }
}
