package by.sasnouski.tests.array.service;

import by.sasnouski.array.entity.ArraysOfNumbers;
import by.sasnouski.array.parser.StringParser;
import by.sasnouski.array.service.MinMaxValue;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MinMaxValueTest {
    Double[] arr;

    @BeforeClass
    public void runBefore() {
        ArraysOfNumbers array = new ArraysOfNumbers(StringParser.createNumbersArray());
        arr = array.getOneArrayByIndex(1);
    }

    @AfterTest
    public void runAfter() {
        System.out.println("This test ends.");
    }

    @Test(timeOut = 100)
    public void testMaxValue() {
        Assert.assertEquals(MinMaxValue.maxValue(arr), 55.1, 0.001);
    }

    @Test(timeOut = 100)
    public void testMinValue() {
        Assert.assertEquals(MinMaxValue.minValue(arr), -12.7, 0.001);
    }
}