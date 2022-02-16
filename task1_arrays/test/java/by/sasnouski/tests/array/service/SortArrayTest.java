package by.sasnouski.tests.array.service;

import by.sasnouski.array.entity.ListsOfNumbers;
import by.sasnouski.array.parser.StringParser;
import by.sasnouski.array.service.ArraySorting;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class SortArrayTest {

    List<Double> list = new ArrayList<>(List.of(-12.7, 3.0, 23.1, 43.6, 55.1));
    List<Double> rstList;

    @BeforeClass
    public void runBefore() {

        ListsOfNumbers array = new ListsOfNumbers(StringParser.createNumbersArray());
        rstList = ArraySorting.sortArray1(array.getOneListByIndex(1));
    }

    @AfterTest
    public void runAfter() {
        System.out.println("This test ends.");
    }

    @Test(timeOut = 100)
    public void testSortArray1() {
        Assert.assertEquals(rstList, list);
    }
}