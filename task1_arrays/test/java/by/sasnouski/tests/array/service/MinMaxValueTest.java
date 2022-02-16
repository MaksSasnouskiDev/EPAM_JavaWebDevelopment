package by.sasnouski.tests.array.service;

import by.sasnouski.array.entity.ListsOfNumbers;
import by.sasnouski.array.parser.StringParser;
import by.sasnouski.array.service.MinMaxValue;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class MinMaxValueTest {
    List<Double>list;

    @BeforeClass
    public void runBefore() {
        ListsOfNumbers array = new ListsOfNumbers(StringParser.createNumbersArray());
        list = array.getOneListByIndex(1);
    }

    @AfterTest
    public void runAfter() {
        System.out.println("This test ends.");
    }

    @Test(timeOut = 100)
    public void testMaxValue() {
        Assert.assertEquals(MinMaxValue.maxValue(list), 55.1, 0.001);
    }

    @Test(timeOut = 100)
    public void testMinValue() {
        Assert.assertEquals(MinMaxValue.minValue(list), -12.7, 0.001);
    }
}