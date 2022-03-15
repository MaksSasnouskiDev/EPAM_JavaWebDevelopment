package by.sasnouski.task2xml.validator;

import by.sasnouski.task2xml.builder.CandyErrorHandler;
import by.sasnouski.task2xml.exception.CandyDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class CandyXMLValidator {

    private static final Logger logger = LogManager.getLogger();
    private static final CandyXMLValidator instance = new CandyXMLValidator();

    private CandyXMLValidator() {
    }

    public static CandyXMLValidator getInstance() {
        return instance;
    }

    public static boolean validateXml(String xmlPath, String schemaName) throws CandyDataException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            CandyErrorHandler errorHandler = new CandyErrorHandler();
            validator.setErrorHandler(errorHandler);
            validator.validate(source);

        } catch (IOException e) {
            logger.error("Error while reading file " + xmlPath, e);
            throw new CandyDataException("Error while reading file " + xmlPath, e);
        } catch (SAXException e) {
            logger.error("Validation error", e);
            return false;
        }
        return true;
    }
}