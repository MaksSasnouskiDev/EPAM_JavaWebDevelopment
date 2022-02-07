package by.sasnouski.tests.array.service;

import by.sasnouski.array.entity.ArrayOfNumbers;
import by.sasnouski.array.parser.StringParser;
import org.testng.Assert;
import org.testng.annotations.*;
import by.sasnouski.array.service.*;

public class AverageValueTest {
    Double[] arr;

    @BeforeClass
    public void runBefore() {
        ArrayOfNumbers array = new ArrayOfNumbers(StringParser.createNumbersArray());
        arr = array.getOneArray(1);
    }

    @AfterTest
    public void runAfter() {
        System.out.println("This test ends.");
    }

    @Test(timeOut = 30)
    public void testAverageValue() {
        Assert.assertEquals(AverageValue.findAverageValue(arr), 22.4199, 0.001);
    }
}