package by.sasnouski.tests.array.service;

import by.sasnouski.array.entity.ListsOfNumbers;
import by.sasnouski.array.parser.StringParser;
import by.sasnouski.array.service.AmountPositiveNegativeElements;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class AmountPosNegElementsTest {
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

    @Test(timeOut = 30, description = "Amount pos. elements")
    public void testFindAmountPosElements() {
        Assert.assertEquals(AmountPositiveNegativeElements.findAmountPositiveElements(list), 4);
    }

    @Test(timeOut = 30, description = "Amount neg. elements")
    public void testFindAmountNegElements() {
        Assert.assertEquals(AmountPositiveNegativeElements.findAmountNegativeElements(list), 1);
    }
}