package by.sasnouski.array.creator;

import by.sasnouski.array.entity.ArrayOfNumbers;
import by.sasnouski.array.parser.StringParser;
import static by.sasnouski.array.reader.ReadDataFromFile.readData;

public class ArrayCreator {
    ArrayOfNumbers array=new ArrayOfNumbers(StringParser.createNumbersArray());
}
