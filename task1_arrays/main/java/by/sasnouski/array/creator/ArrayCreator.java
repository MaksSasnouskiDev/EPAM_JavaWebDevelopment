package by.sasnouski.array.creator;

import by.sasnouski.array.entity.ArraysOfNumbers;
import by.sasnouski.array.parser.StringParser;

public class ArrayCreator {

    public static ArraysOfNumbers createArraysObject() {
        return new ArraysOfNumbers(StringParser.createNumbersArray());
    }
}
