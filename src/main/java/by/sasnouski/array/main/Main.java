package by.sasnouski.array.main;

import by.sasnouski.array.entity.ArrayOfNumbers;
import by.sasnouski.array.parser.*;

public class Main {
    public static void main(String[] args) {

        ArrayOfNumbers array=new ArrayOfNumbers(StringParser.createNumbersArray());
        Double[][]allArrays  = array.get2DArray();
    }
}