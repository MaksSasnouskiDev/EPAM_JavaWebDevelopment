package by.sasnouski.tests.array.service;

import by.sasnouski.array.entity.ArraysOfNumbers;
import by.sasnouski.array.parser.StringParser;
import by.sasnouski.array.service.SortArray;
import org.testng.Assert;
import org.testng.annotations.*;

public class SortArrayTest {

    Double[] arr = {-12.7, 3.0, 23.1, 43.6, 55.1};
    Double[] rstArr;

    @BeforeClass
    public void runBefore() {

        ArraysOfNumbers array = new ArraysOfNumbers(StringParser.createNumbersArray());
        rstArr = SortArray.sortArray1(array.getOneArrayByIndex(1));
    }

    @AfterTest
    public void runAfter() {
        System.out.println("This test ends.");
    }

    @Test(timeOut = 100)
    public void testSortArray1() {
        Assert.assertEquals(rstArr, arr);
    }
}