package by.sasnouski.task2xml.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StaxParser {
    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger();

        final String filePath = "src/main/resources/data/Candies.xml";

        boolean bcandyName = false;
        boolean bcandyType = false;
        boolean benergy = false;
        boolean bprotein = false;
        boolean bfats = false;
        boolean bcarbs = false;
        boolean bproducingTime = false;

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(filePath));
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("candyName")) {
                            bcandyName = true;
                        } else if (qName.equalsIgnoreCase("candyType")) {
                            bcandyType = true;
                        } else if
                        (qName.equalsIgnoreCase("energy")) {
                            benergy = true;
                        } else if (qName.equalsIgnoreCase("bprotein")) {
                            bprotein = true;
                        } else if (qName.equalsIgnoreCase("fats")) {
                            bfats = true;
                        } else if (qName.equalsIgnoreCase("carbs")) {
                            bcarbs = true;
                        } else if (qName.equalsIgnoreCase("producing-time")) {
                            bproducingTime = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters chars = event.asCharacters();

                        if (bcandyName) {
                            logger.log(Level.INFO,"candy name: " + chars.getData());
                            bcandyName = false;
                        }
                        if (bcandyType) {
                            logger.log(Level.INFO,"candy Type: " + chars.getData());
                            System.out.println(": " + chars.getData());
                            bcandyType = false;
                        }
                        if (benergy) {
                            logger.log(Level.INFO,"energy: " + chars.getData());
                            benergy = false;
                        }
                        if (bprotein) {
                            logger.log(Level.INFO,"protein: " + chars.getData());
                            bprotein = false;
                        }
                        if (bfats) {
                            logger.log(Level.INFO,"fats: " + chars.getData());
                            bfats = false;
                        }
                        if (bcarbs) {
                            logger.log(Level.INFO,"carbs: " + chars.getData());
                            bcarbs = false;
                        }
                        if (bproducingTime) {
                            logger.log(Level.INFO,"producing Time: " + chars.getData());
                            bproducingTime = false;
                        }
                        break;
                }

            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}