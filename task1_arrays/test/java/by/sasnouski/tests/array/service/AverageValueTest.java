package by.sasnouski.tests.array.service;

import by.sasnouski.array.entity.ListsOfNumbers;
import by.sasnouski.array.parser.StringParser;
import org.testng.Assert;
import org.testng.annotations.*;
import by.sasnouski.array.service.*;

import java.util.List;

public class AverageValueTest {
    List<Double> list;

    @BeforeClass
    public void runBefore() {
        ListsOfNumbers array = new ListsOfNumbers(StringParser.createNumbersArray());
        list = array.getOneListByIndex(1);
    }

    @AfterTest
    public void runAfter() {
        System.out.println("This test ends.");
    }

    @Test(timeOut = 30)
    public void testAverageValue() {
        Assert.assertEquals(AverageValue.findAverageValue(list), 22.4199, 0.001);
    }
}