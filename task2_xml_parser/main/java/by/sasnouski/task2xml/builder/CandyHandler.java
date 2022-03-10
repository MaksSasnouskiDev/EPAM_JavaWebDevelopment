package by.sasnouski.task2xml.builder;

import by.sasnouski.task2xml.entity.Candy;
import by.sasnouski.task2xml.entity.CaramelCandy;
import by.sasnouski.task2xml.entity.CocoaCandy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

import static by.sasnouski.task2xml.builder.CandyXMLTag.*;

public class CandyHandler extends DefaultHandler {

    static Logger logger = LogManager.getLogger();

    private Set<Candy> candiesSet;
    private Candy candyItem;
    public EnumSet<CandyXMLTag> textXmlTag;

    private CandyXMLTag currentXmlTag;

    public CandyHandler() {
        candiesSet = new HashSet<Candy>();
        textXmlTag = EnumSet.range(CANDY_NAME, CandyXMLTag.EXPIRATION);
    }

    public Set<Candy> getCandiesSet() {
        return candiesSet;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        String tagCocoa = CandyXMLTag.COCOA.toString();
        String tagTreacle = CandyXMLTag.TREACLE.toString();
        String qNameRst = qName.toLowerCase().replace("_", "");

        tagCocoa = tagCocoa.toLowerCase();
        tagTreacle = tagTreacle.toLowerCase();

        if (tagCocoa.equals(qNameRst) || tagTreacle.equals(qNameRst)) {
            candyItem = tagCocoa.equals(qName) ? new CocoaCandy() : new CaramelCandy();
            defineAttributes(attributes);
        } else {
            CandyXMLTag temp = CandyXMLTag.valueOf(qName.toLowerCase().replace("_", ""));
            if (textXmlTag.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) {
        String tagCocoa = CandyXMLTag.COCOA.toString();
        String tagTreacle = CandyXMLTag.TREACLE.toString();
        String qNameRst = qName.toLowerCase().replace("_", "");

        if (tagCocoa.equals(qNameRst) || tagTreacle.equals(qNameRst)) {
            candiesSet.add(candyItem);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).trim();

        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case CANDY_NAME -> candyItem.setCandyName(data);
                case PRODUCER -> candyItem.setProducer(data);
                case TOTAL -> candyItem.setTotalEnergy(Double.parseDouble(data));
                case PROTEIN -> candyItem.setProtein(Double.parseDouble(data));
                case FATS -> candyItem.setFats(Double.parseDouble(data));
                case CARBS -> candyItem.setCarbs(Double.parseDouble(data));
                case MANUFACTURING_DATE -> candyItem.setManufacturingDate(data);
                case EXPIRATION_DATE -> candyItem.setExpirationDate(data);
                case COCOA -> candyItem.setCocoa(Double.parseDouble(data));
                case TREACLE -> candyItem.setCaramel(Double.parseDouble(data));

                default -> throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }

    private void defineAttributes(Attributes attributes) {
        String candyID = attributes.getValue(CandyXMLTag.ID.toString());
        candyItem.setId(Integer.parseInt(candyID));

        String isBelProduction = attributes.getValue(CandyXMLTag.ID.toString());
        if (isBelProduction != null) {
            candyItem.setBelarusian_producing(Boolean.parseBoolean(isBelProduction));
        } else {
            candyItem.setBelarusian_producing(Candy.DEFAULT_BEL_PRODUCTION);
        }
    }
}
