package by.sasnouski.array.service;

import by.sasnouski.array.entity.ListsOfNumbers;
import by.sasnouski.array.parser.StringParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class ArrayDemonstration {
    static Logger logger = LogManager.getLogger(ArrayDemonstration.class);

    public static void printAllValidArrays() {
        ListsOfNumbers allValidArrays = new ListsOfNumbers(StringParser.createNumbersArray());
        List<List<Double>> listsOfNumbers = allValidArrays.get2DArray();

        for (List<Double> list : listsOfNumbers) {
            logger.log(Level.INFO, list.toString());
        }
    }

    public static void printOneList(int index) {
        ListsOfNumbers allValidArrays = new ListsOfNumbers(StringParser.createNumbersArray());
        List<Double> oneList = allValidArrays.getOneListByIndex(index);

        logger.log(Level.INFO, oneList);
    }
}