package by.sasnouski.task2xml.builder;

import by.sasnouski.task2xml.entity.Candy;
import by.sasnouski.task2xml.entity.CaramelCandy;
import by.sasnouski.task2xml.entity.ChocolateCandy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.*;

import static by.sasnouski.task2xml.builder.CandyXMLTag.*;

public class CandyHandler extends DefaultHandler {

    private final Logger logger = LogManager.getLogger();

    private final String UNDERSCORE = "_";

    private final Set<Candy> candiesSet;
    private Candy candyItem;

    public EnumSet<CandyXMLTag> candyInnerTags;
    private CandyXMLTag currentTag;

    public CandyHandler() {
        candiesSet = new HashSet<>();
        candyInnerTags = EnumSet.range(CHOCOLATE_CANDY, TREACLE);
    }

    public Set<Candy> getCandiesSet() {
        return candiesSet;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        String tagChocolateCandy = CHOCOLATE_CANDY.toString();
        String tagCaramelCandy = CARAMEL_CANDY.toString();

        tagChocolateCandy = tagChocolateCandy.toLowerCase();
        tagCaramelCandy = tagCaramelCandy.toLowerCase();
        String localNameRst = localName.replace(UNDERSCORE, "").toLowerCase();


        if (tagChocolateCandy.equals(localNameRst) || tagCaramelCandy.equals(localNameRst)) {
            candyItem = tagChocolateCandy.equals(localNameRst) ? new ChocolateCandy() : new CaramelCandy();
            defineAttributes(attributes);
        } else {
            CandyXMLTag actualTag = CandyXMLTag.valueOf(localName.toUpperCase().trim());
            if (candyInnerTags.contains(actualTag)) {
                currentTag = actualTag;
            }
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) {
        String tagChocolateCandy = CHOCOLATE_CANDY.toString();
        String tagCaramelCandy = CARAMEL_CANDY.toString();
        tagChocolateCandy = tagChocolateCandy.toLowerCase();
        tagCaramelCandy = tagCaramelCandy.toLowerCase();

        if (tagChocolateCandy.equals(localName) || tagCaramelCandy.equals(localName)) {
            candiesSet.add(candyItem);
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) {
        String elemValue = new String(ch, start, length).trim();

        if (currentTag != null) {
            switch (currentTag) {
                case CANDY_NAME -> candyItem.setCandyName(elemValue);
                case PRODUCER -> candyItem.setProducer(elemValue);
                case TOTAL -> candyItem.setTotalEnergy(Double.parseDouble(elemValue));
                case PROTEIN -> candyItem.setProtein(Double.parseDouble(elemValue));
                case FATS -> candyItem.setFats(Double.parseDouble(elemValue));
                case CARBS -> candyItem.setCarbs(Double.parseDouble(elemValue));
                case MANUFACTURING_DATE -> candyItem.setManufacturingDate(LocalDate.parse(elemValue));
                case EXPIRATION_DATE -> candyItem.setExpirationDate(LocalDate.parse(elemValue));
                case COCOA ->
                    ((ChocolateCandy) candyItem).setCocoaAmount(Double.parseDouble(elemValue));

                case TREACLE ->
                        ((CaramelCandy) candyItem).setCaramelAmount(Double.parseDouble(elemValue));
            }
        }
        currentTag = null;
    }

    private void defineAttributes(Attributes attributes) {
        String candyID = attributes.getValue(ID.toString().toLowerCase());
        candyItem.setId(Integer.parseInt(candyID));

        String isBelProduction = attributes.getValue(BELARUSIAN_PRODUCING.toString().toLowerCase());
        if (isBelProduction != null) {
            candyItem.setBelarusian_producing(Boolean.parseBoolean(isBelProduction));
        } else {
            candyItem.setBelarusian_producing(Candy.DEFAULT_BEL_PRODUCTION);
        }
    }
}