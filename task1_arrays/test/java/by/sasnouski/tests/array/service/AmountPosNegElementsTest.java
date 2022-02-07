package by.sasnouski.tests.array.service;

import by.sasnouski.array.entity.ArrayOfNumbers;
import by.sasnouski.array.parser.StringParser;
import by.sasnouski.array.service.AmountPositiveNegativeElements;
import org.testng.Assert;
import org.testng.annotations.*;

public class AmountPosNegElementsTest {
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

    @Test(timeOut = 30, description = "Amount pos. elements")
    public void testFindAmountPosElements() {
        Assert.assertEquals(AmountPositiveNegativeElements.findAmountPositiveElements(arr), 4);
    }

    @Test(timeOut = 30, description = "Amount neg. elements")
    public void testFindAmountNegElements() {
        Assert.assertEquals(AmountPositiveNegativeElements.findAmountNegativeElements(arr), 1);
    }
}