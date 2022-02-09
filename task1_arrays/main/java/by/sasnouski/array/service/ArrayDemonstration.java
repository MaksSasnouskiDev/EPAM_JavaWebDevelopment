package by.sasnouski.array.service;

import by.sasnouski.array.entity.ArraysOfNumbers;
import by.sasnouski.array.parser.StringParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class ArrayDemonstration {
    static Logger logger = LogManager.getLogger(ArrayDemonstration.class);

    public static void printAllValidArrays() {
        ArraysOfNumbers allValidArrays = new ArraysOfNumbers(StringParser.createNumbersArray());
        Double[][] arraysOfNumbers = allValidArrays.get2DArray();

        for (Double[] arr : arraysOfNumbers) {
            logger.log(Level.INFO, Arrays.toString(arr));
        }
    }

    public static void printOneArray(int index) {
        ArraysOfNumbers allValidArrays = new ArraysOfNumbers(StringParser.createNumbersArray());
        Double[] oneArray = allValidArrays.getOneArrayByIndex(index);

        logger.log(Level.INFO, Arrays.toString(oneArray));
    }
}