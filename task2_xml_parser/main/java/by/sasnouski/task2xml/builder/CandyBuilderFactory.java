package by.sasnouski.task2xml.builder;

import by.sasnouski.task2xml.exception.CandyDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CandyBuilderFactory {
    private final Logger logger = LogManager.getLogger();

    private static final CandyBuilderFactory instance = new CandyBuilderFactory();


    public enum TypeParser {
        DOM, SAX, STAX
    }
    private CandyBuilderFactory() {}

    public  CandyBuilder createBuilder(String typeParser) throws CandyDataException {
        TypeParser type = TypeParser.valueOf(typeParser);

        switch (type) {
            case DOM -> {
                return new CandyDOMBuilder();
            }
            case SAX -> {
                return new CandySAXBuilder();
            }
            case STAX -> {
                return new CandySTAXBuilder();
            }
            default -> throw new CandyDataException ();
        }
    }
    public static CandyBuilderFactory getInstance() {
        return instance;
    }

}