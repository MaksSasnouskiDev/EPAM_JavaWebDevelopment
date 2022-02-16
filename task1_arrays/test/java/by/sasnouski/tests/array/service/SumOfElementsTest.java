package by.sasnouski.tests.array.service;

import by.sasnouski.array.entity.ListsOfNumbers;
import by.sasnouski.array.parser.StringParser;
import by.sasnouski.array.service.SumOfElements;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SumOfElementsTest {
    List<Double> arr;

    @BeforeClass
    public void runBefore() {
        ListsOfNumbers list = new ListsOfNumbers(StringParser.createNumbersArray());
        arr = list.getOneListByIndex(1);
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