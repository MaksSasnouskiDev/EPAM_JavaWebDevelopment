package by.sasnouski.task2xml.builder;

import by.sasnouski.task2xml.exception.CandyDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CandyBuilderFactory {
    static Logger logger = LogManager.getLogger();

    private enum TypeParser {
        DOM, SAX, STAX
    }
    private CandyBuilderFactory() {}

    public static CandyBuilder createBuilder(String typeParser) throws CandyDataException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());

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

}
