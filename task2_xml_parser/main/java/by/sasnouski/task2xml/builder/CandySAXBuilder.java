package by.sasnouski.task2xml.builder;

import by.sasnouski.task2xml.exception.CandyDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class CandySAXBuilder extends CandyBuilder{

    static Logger logger = LogManager.getLogger();

    private CandyHandler handler = new CandyHandler();
    private XMLReader reader;

    public CandySAXBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            logger.error(e);
        }
        reader.setContentHandler(handler);
    }

    public void buildCandySet(String xmlPath) throws CandyDataException {
        try {
            reader.parse(xmlPath);
        } catch (IOException e) {
            logger.error("Error during work with file " + xmlPath);
            throw new CandyDataException("Exception during work with file, " + xmlPath, e);
        } catch (SAXException e) {
            logger.error("SAX parse Exception");
            throw new CandyDataException("SAX parse Exception", e);
        }
        candiesSet = handler.getCandiesSet();
    }

}
