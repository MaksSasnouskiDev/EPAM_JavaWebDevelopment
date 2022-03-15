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
import java.net.URL;

public class CandySAXBuilder extends CandyBuilder {

    private final Logger logger = LogManager.getLogger();

    @Override
    public void buildCandy(String filePath) throws CandyDataException {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();

            CandyHandler handler = new CandyHandler();

            ClassLoader loader = getClass().getClassLoader();
            URL resource = loader.getResource(filePath);

            reader.setContentHandler(handler);
            reader.setErrorHandler(new CandyErrorHandler());
            reader.parse(resource.getFile());

            candiesSet = handler.getCandiesSet();

        } catch (SAXException | IOException | ParserConfigurationException e) {
            logger.error("error during sax parsing", e);
            throw new CandyDataException("error during sax parsing", e);
        }
    }
}