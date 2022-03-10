package by.sasnouski.task2xml.builder;

import by.sasnouski.task2xml.entity.Candy;
import by.sasnouski.task2xml.entity.CaramelCandy;
import by.sasnouski.task2xml.entity.CocoaCandy;
import by.sasnouski.task2xml.exception.CandyDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CandyDOMBuilder extends CandyBuilder{
    static Logger logger = LogManager.getLogger();

    private DocumentBuilder documentBuilder;

    public CandyDOMBuilder() {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("DOM Builder error ", e);
        }
    }

    @Override
    public void buildCandySet(String xmlPath) throws CandyDataException {
        Document document;

        try {
            document = documentBuilder.parse(xmlPath);
            Element root = document.getDocumentElement();
            NodeList candyItemList;

            candyItemList = root.getElementsByTagName(CandyXMLTag.COCOA.toString());
            for (int i = 0; i < candyItemList.getLength(); i++) {
                Element candyElement = (Element) candyItemList.item(i);
                Candy newCandy = buildCandySet(candyElement);
                candiesSet.add(newCandy);
            }

            candyItemList = root.getElementsByTagName(CandyXMLTag.TREACLE.toString());
            for (int i = 0; i < candyItemList.getLength(); i++) {
                Element candyElement = (Element) candyItemList.item(i);
                Candy newCandy = buildCandySet(candyElement);
                candiesSet.add(newCandy);
            }
        } catch (IOException | SAXException e) {
            logger.error(e);
            throw new CandyDataException(e);
        }
    }

    private Candy buildCandy(Element candyElement) {

            boolean isCocoaCandy = candyElement.getTagName().equals(CandyXMLTag.COCOA.toString());
        Candy currentCandy = isCocoaCandy ? new CocoaCandy() : new CaramelCandy();

        String content;

        content = candyElement.getAttribute(CandyXMLTag.ID.toString());
        currentCandy.setId(Integer.parseInt(content));
        content = candyElement.getAttribute(CandyXMLTag.BELARUSIAN_PRODUCING.toString());
        if (!content.isBlank()) {
            currentCandy.setBelarusian_producing(Boolean.parseBoolean(content));
        } else {
            currentCandy.setBelarusian_producing(currentCandy.isBelarusian_producing());
        }

        content = getElementTextContent(candyElement, CandyXMLTag.CANDY_NAME.toString());
        currentCandy.setCandyName(content);
        content = getElementTextContent(candyElement, CandyXMLTag.ENERGY.toString());
        currentCandy.setTotalEnergy(Double.parseDouble(content));
        content = getElementTextContent(candyElement, CandyXMLTag.PROTEIN.toString());
        currentCandy.setProtein(Double.parseDouble(content));
        content = getElementTextContent(candyElement, CandyXMLTag.CARBS.toString());
        currentCandy.setCarbs(Double.parseDouble(content));
        content = getElementTextContent(candyElement, CandyXMLTag.MANUFACTURING_DATE.toString());
        currentCandy.setManufacturingDate(content);
        content = getElementTextContent(candyElement, CandyXMLTag.EXPIRATION_DATE.toString());
        currentCandy.setExpirationDate(content);


        if(currentCandy instanceof CocoaCandy) {
            CocoaCandy temp = (CocoaCandy) currentCandy;
            content = getElementTextContent(candyElement, CandyXMLTag.COCOA.toString());
            temp.setCocoa(Double.parseDouble(content));

            currentCandy = temp;
        } else {
            CaramelCandy temp = (CaramelCandy) currentCandy;
            content = getElementTextContent(candyElement, CandyXMLTag.TREACLE.toString());
            temp.setCaramel(Double.parseDouble(content));
            currentCandy = temp;
        }
        return currentCandy;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String textContent = node.getTextContent();
        return  textContent;
    }

}
