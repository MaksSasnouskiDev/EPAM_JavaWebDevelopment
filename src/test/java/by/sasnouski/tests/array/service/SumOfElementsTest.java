package by.sasnouski.tests.array.service;

import by.sasnouski.array.entity.ArrayOfNumbers;
import by.sasnouski.array.parser.StringParser;
import by.sasnouski.array.service.SumOfElements;
import org.testng.Assert;
import org.testng.annotations.*;

public class SumOfElementsTest {
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
    public void testFindSum() {
        Assert.assertEquals(SumOfElements.findSum(arr), 112.1, 0.001);
    }
}