package by.sasnouski.array.main;

import by.sasnouski.array.entity.ArraysOfNumbers;
import by.sasnouski.array.parser.*;
import org.apache.logging.log4j.*;

public class MainClass {
     static Logger logger = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {
        long bgn = System.currentTimeMillis();

        ArraysOfNumbers allValidArrays = new ArraysOfNumbers(StringParser.createNumbersArray());
        logger.log(Level.INFO, allValidArrays.toString());

        long end = System.currentTimeMillis();
        logger.log(Level.DEBUG, "Program runtime: " + (end - bgn));
    }
}