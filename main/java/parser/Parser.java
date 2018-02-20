package parser;

import model.Device;
import parser.dom.DOMParserUser;
import parser.sax.SAXParserUser;
import parser.stax.StAXReader;

import java.io.File;
import java.util.List;

//import filechecker.ExtensionChecker;

public class Parser {

  public static void main(String[] args) {
    File xml = new File("src/main/resources/xml/devices.xml");
    File xsd = new File("src/main/resources/xml/devicesXSD.xsd");

    //if (checkIfXML(xml) && checkIfXSD(xsd)) {
//            SAX
      printList(SAXParserUser.parseDevices(xml, xsd), "SAX");

//            StAX
      printList(StAXReader.parseDevices(xml, xsd), "StAX");

//            DOM
      printList(DOMParserUser.getDeviceList(xml, xsd), "DOM");


  }
  //}

  /*private static boolean checkIfXSD(File xsd) {
    return ExtensionChecker.isXSD(xsd);
  }*/

  /*private static boolean checkIfXML(File xml) {
    return ExtensionChecker.isXML(xml);
  }*/

  private static void printList(List<Device> devices, String parserName) {
    //Collections.sort(devices, new BeerComparator());
    System.out.println("---------------------------------------------------------------------------------------------");
    System.out.println(parserName);
    System.out.println("---------------------------------------------------------------------------------------------");
    for (Device device : devices) {
      System.out.println(device);
    }
  }

}
