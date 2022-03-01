package by.sasnouski.task2xml.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser {
    public static void main(String[] args) {

        final String filePath = "src/main/resources/data/Candies.xml";
        final Logger logger = LogManager.getLogger();


        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser=null;

        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e1) {
            e1.printStackTrace();
        }
        DefaultHandler handler = new DefaultHandler() {
            boolean bcandyName = false;
            boolean bcandyType = false;
            boolean benergy = false;
            boolean bprotein = false;
            boolean bfats = false;
            boolean bcarbs = false;
            boolean bproducingTime = false;

            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equalsIgnoreCase("candyname")) {
                    bcandyName = true;
                }
                if (qName.equalsIgnoreCase("candyType")) {
                    bcandyType = true;
                }
                if (qName.equalsIgnoreCase("energy")) {
                    benergy = true;
                }
                if (qName.equalsIgnoreCase("protein")) {
                    bprotein = true;
                }
                if (qName.equalsIgnoreCase("fats")) {
                    bfats = true;
                }
                if (qName.equalsIgnoreCase("carbs")) {
                    bcarbs = true;
                }
                if (qName.equalsIgnoreCase("producing-time")) {
                    bproducingTime = true;
                }
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
            }

            public void characters(char ch[], int start, int leght) throws SAXException {
                if (bcandyName) {
                    logger.log(Level.INFO,"candy name: " + new String(ch, start, leght));
                    bcandyName = false;
                }
                if (bcandyType) {
                    logger.log(Level.INFO,"candyType: " + new String(ch, start, leght));
                    bcandyType = false;
                }
                if (benergy) {
                    logger.log(Level.INFO,"energy: " + new String(ch, start, leght));
                    benergy = false;
                }
                if (bprotein) {
                    logger.log(Level.INFO,"protein: " + new String(ch, start, leght));
                    bprotein = false;
                }
                if (bfats) {
                    logger.log(Level.INFO,"fats: " + new String(ch, start, leght));
                    bfats = false;
                }
                if (bcarbs) {
                    logger.log(Level.INFO,"carbs: " + new String(ch, start, leght));
                    bcarbs = false;
                }
                if (bproducingTime) {
                    logger.log(Level.INFO,"producing Time: " + new String(ch, start, leght));
                    bproducingTime = false;
                }
            }
        };

        try {
            saxParser.parse(filePath, handler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
