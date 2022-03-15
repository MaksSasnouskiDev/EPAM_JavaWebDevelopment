package by.sasnouski.task2xml.builder;

import by.sasnouski.task2xml.entity.Candy;
import by.sasnouski.task2xml.entity.CaramelCandy;
import by.sasnouski.task2xml.entity.ChocolateCandy;
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
import java.time.LocalDate;

public class CandyDOMBuilder extends CandyBuilder {
    private final Logger logger = LogManager.getLogger();

    private DocumentBuilder documentBuilder;

    public CandyDOMBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("DOM Builder error ", e);
        }
    }

    @Override
    public void buildCandy(String filePath) throws CandyDataException {
        Document document;

        try {
            document = documentBuilder.parse(filePath);
            Element root = document.getDocumentElement();
            NodeList candyItemList;

            candyItemList = root.getElementsByTagName(CandyXMLTag.CHOCOLATE_CANDY.
                    toString().toLowerCase());
            for (int i = 0; i < candyItemList.getLength(); i++) {
                Element candyElement = (Element) candyItemList.item(i);
                Candy newCandy = this.buildCandiesSet(candyElement);
                candiesSet.add(newCandy);
            }

            candyItemList = root.getElementsByTagName(CandyXMLTag.CARAMEL_CANDY.
                    toString().toLowerCase());
            for (int i = 0; i < candyItemList.getLength(); i++) {
                Element candyElement = (Element) candyItemList.item(i);
                Candy newCandy = this.buildCandiesSet(candyElement);
                candiesSet.add(newCandy);
            }
        } catch (IOException | SAXException e) {
            logger.error(e);
            throw new CandyDataException(e);
        }
    }

    private Candy buildCandiesSet(Element candyElement) {

        boolean isChocCandy = candyElement.getTagName().equals(CandyXMLTag.CHOCOLATE_CANDY.
                toString().toLowerCase());
        Candy currentCandy = isChocCandy ? new ChocolateCandy() : new CaramelCandy();

        String content;

        content = candyElement.getAttribute(CandyXMLTag.ID.toString().toLowerCase());
        currentCandy.setId(Integer.parseInt(content));
        content = candyElement.getAttribute(CandyXMLTag.BELARUSIAN_PRODUCING.
                toString().toLowerCase());
        if (!content.isBlank()) {
            currentCandy.setBelarusian_producing(Boolean.parseBoolean(content));
        } else {
            currentCandy.setBelarusian_producing(Candy.DEFAULT_BEL_PRODUCTION);
        }

        content = getElementTextContent(candyElement, CandyXMLTag.CANDY_NAME.toString().toLowerCase());
        currentCandy.setCandyName(content);

        content = getElementTextContent(candyElement, CandyXMLTag.PRODUCER.toString().toLowerCase());
        currentCandy.setProducer(content);

        content = getElementTextContent(candyElement, CandyXMLTag.TOTAL.toString().toLowerCase());
        currentCandy.setTotalEnergy(Double.parseDouble(content));

        content = getElementTextContent(candyElement, CandyXMLTag.PROTEIN.toString().toLowerCase());
        currentCandy.setProtein(Double.parseDouble(content));

        content = getElementTextContent(candyElement, CandyXMLTag.FATS.toString().toLowerCase());
        currentCandy.setFats(Double.parseDouble(content));

        content = getElementTextContent(candyElement, CandyXMLTag.CARBS.toString().toLowerCase());
        currentCandy.setCarbs(Double.parseDouble(content));

        content = getElementTextContent(candyElement, CandyXMLTag.MANUFACTURING_DATE.toString().toLowerCase());
        currentCandy.setManufacturingDate(LocalDate.parse(content));

        content = getElementTextContent(candyElement, CandyXMLTag.EXPIRATION_DATE.toString().toLowerCase());
        currentCandy.setExpirationDate(LocalDate.parse(content));

        if (currentCandy instanceof ChocolateCandy chocCandy) {

            content = getElementTextContent(candyElement, CandyXMLTag.CHOCOLATE_CANDY.toString().toLowerCase());
            chocCandy.setCocoaAmount(Double.parseDouble(content));

        } else {
            CaramelCandy caramelCandy = (CaramelCandy) currentCandy;
            content = getElementTextContent(candyElement, CandyXMLTag.CARAMEL_CANDY.toString().toLowerCase());
            caramelCandy.setCaramelAmount(Double.parseDouble(content));
        }
        return currentCandy;
    }

    private static String getElementTextContent(Element element, String elementName) {

        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}