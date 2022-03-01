package by.sasnouski.task2xml.parser;

import org.apache.logging.log4j.Level;
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

public class DOMParser {
    public static void main(String[] args) {
        final String filePath = "src/main/resources/data/Candies.xml";
        final Logger logger = LogManager.getLogger();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(filePath);

            NodeList candyList = doc.getElementsByTagName("candy");
            for (int i = 0; i < candyList.getLength(); i++) {
                Node node1 = candyList.item(i);
                if (node1.getNodeType() == Node.ELEMENT_NODE) {
                    Element candy = (Element) node1;
                    String id = candy.getAttribute("id");
                    NodeList itemList = candy.getChildNodes();
                    for (int j = 0; j < itemList.getLength(); j++) {
                        Node node2 = itemList.item(j);
                        if (node2.getNodeType() == Node.ELEMENT_NODE) {
                            Element name = (Element) node2;
                            logger.log(Level.INFO,"Candy:"+id + ":" + name.getTagName() +
                                    "="+ name.getTextContent());
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
