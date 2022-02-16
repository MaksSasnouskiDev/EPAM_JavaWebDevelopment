package by.sasnouski.tests.array.service;

import by.sasnouski.array.entity.ListsOfNumbers;
import by.sasnouski.array.parser.StringParser;
import by.sasnouski.array.service.ConversionElementsByCondition;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class ConversionElementsByConditionTest {

    List<Double> list =new ArrayList<>(List.of(62.6, 6.300000000000001, 74.1, 22.0, 42.1));
    List <Double> rstList;

    @BeforeClass
    public void runBefore() {

        ListsOfNumbers actualLIst = new ListsOfNumbers(StringParser.createNumbersArray());
        rstList = ConversionElementsByCondition.addNumber(actualLIst.getOneListByIndex(1),19);
    }

    @AfterTest
    public void runAfter() {
        System.out.println("This test ends.");
    }

    @Test(timeOut = 100)
    public void testAddNumber() {
        Assert.assertEquals(rstList, list);
    }
}