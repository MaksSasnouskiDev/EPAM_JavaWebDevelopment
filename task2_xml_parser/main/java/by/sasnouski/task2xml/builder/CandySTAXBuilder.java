package by.sasnouski.task2xml.builder;

import by.sasnouski.task2xml.entity.Candy;
import by.sasnouski.task2xml.entity.CaramelCandy;
import by.sasnouski.task2xml.entity.ChocolateCandy;
import by.sasnouski.task2xml.exception.CandyDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class CandySTAXBuilder extends CandyBuilder {
    private final Logger logger = LogManager.getLogger();
    private static final String SPACE_SEPARATOR = " ";
    XMLInputFactory inputFactory;

    public CandySTAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildCandy(String xmlPath) throws CandyDataException {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(xmlPath)) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if ((name.equals(CandyXMLTag.CHOCOLATE_CANDY.toString().toLowerCase())) || (name.equals(CandyXMLTag.CARAMEL_CANDY.toString().toLowerCase()))) {
                        Candy candy = buildCandyItem(reader);
                        candiesSet.add(candy);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found " + xmlPath, e);
            throw new CandyDataException("File not found " + xmlPath, e);
        } catch (IOException e) {
            logger.error("STAX parser IO Exception" + xmlPath, e);
            throw new CandyDataException("STAX parser IO Exception" + xmlPath, e);
        } catch (XMLStreamException e) {
            logger.error("XMLStreamException", e);
            throw new CandyDataException("XMLStreamException", e);
        }
    }

    public Candy buildCandyItem(XMLStreamReader reader) throws XMLStreamException {
        Candy currentCandy = reader.getLocalName().equals(CandyXMLTag.CHOCOLATE_CANDY.toString().toLowerCase()) ?
                new ChocolateCandy() : new CaramelCandy();
        String tempString =reader.getAttributeValue(null, CandyXMLTag.ID.toString().toLowerCase());
        currentCandy.setId(Integer.parseInt(tempString));
        String content = reader.getAttributeValue(null, CandyXMLTag.BELARUSIAN_PRODUCING.toString().toLowerCase());
        if (content != null) {
            currentCandy.setBelarusian_producing(Boolean.parseBoolean(content));
        } else {
            currentCandy.setBelarusian_producing(Candy.DEFAULT_BEL_PRODUCTION);
        }
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName().toUpperCase();
                    switch (CandyXMLTag.valueOf(name)) {
                        case CANDY_NAME -> currentCandy.setCandyName(getXMLText(reader));
                        case PRODUCER -> currentCandy.setProducer(getXMLText(reader));
                        case TOTAL -> currentCandy.setTotalEnergy(Double.parseDouble(getXMLText(reader)));
                        case PROTEIN -> currentCandy.setProtein(Double.parseDouble(getXMLText(reader)));
                        case FATS -> currentCandy.setFats(Double.parseDouble(getXMLText(reader)));
                        case CARBS -> currentCandy.setCarbs(Double.parseDouble(getXMLText(reader)));
                        case MANUFACTURING_DATE -> currentCandy.setManufacturingDate(LocalDate.parse(getXMLText(reader)));
                        case EXPIRATION_DATE -> currentCandy.setExpirationDate(LocalDate.parse(getXMLText(reader)));
                        case COCOA ->
                                ((ChocolateCandy) currentCandy).setCocoaAmount(Double.parseDouble(getXMLText(reader)));

                        case TREACLE ->
                                ((CaramelCandy) currentCandy).setCaramelAmount(Double.parseDouble(getXMLText(reader)));
                    }
                    break;

            case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals(CandyXMLTag.CHOCOLATE_CANDY.toString().toLowerCase()) || name.equals(CandyXMLTag.CARAMEL_CANDY.toString().toLowerCase())) {
                        return currentCandy;
                    }
            }
        }
        throw new XMLStreamException("Element tag error while STAX parsing");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}