package by.sasnouski.tests.array.service;

import by.sasnouski.array.entity.ArraysOfNumbers;
import by.sasnouski.array.parser.StringParser;
import by.sasnouski.array.service.SumOfElements;
import org.testng.Assert;
import org.testng.annotations.*;

public class SumOfElementsTest {
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
    public void testFindSum() {
        Assert.assertEquals(SumOfElements.findSum(arr), 112.1, 0.001);
    }
}