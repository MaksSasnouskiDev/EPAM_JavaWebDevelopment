package by.sasnouski.task2xml.builder;

import by.sasnouski.task2xml.entity.Candy;
import by.sasnouski.task2xml.entity.CaramelCandy;
import by.sasnouski.task2xml.entity.ChocolateCandy;
import by.sasnouski.task2xml.exception.CandyDataException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CandySAXBuilderTest {

    private final String XML_FILE_PATH = "src/main/resources/data/candies.xml";
    private CandyBuilder builder;
    private ChocolateCandy chocolateCandy;
    private CaramelCandy caramelCandy;

    @BeforeClass
    public void setObjectsInstance() {

        try {
            builder = CandyBuilderFactory.getInstance().
                    createBuilder(String.valueOf(CandyBuilderFactory.TypeParser.SAX));
        } catch (CandyDataException e) {
            fail(e.getMessage(), e);
        }

        chocolateCandy = new ChocolateCandy();
        chocolateCandy.setCandyName("Nut Grillage");
        chocolateCandy.setProducer("Kamunarka");
        chocolateCandy.setTotalEnergy(Double.parseDouble("460"));
        chocolateCandy.setProtein(Double.parseDouble("12.6"));
        chocolateCandy.setFats(Double.parseDouble("43.1"));
        chocolateCandy.setCarbs(Double.parseDouble("23.8"));
        chocolateCandy.setManufacturingDate(LocalDate.parse("2022-02-01"));
        chocolateCandy.setManufacturingDate(LocalDate.parse("2022-08-01"));
        chocolateCandy.setCocoaAmount(Double.parseDouble("19"));

        caramelCandy = new CaramelCandy();
        caramelCandy.setCandyName("Bim-Bom");
        caramelCandy.setProducer("Roshen");
        caramelCandy.setTotalEnergy(Double.parseDouble("200.5"));
        caramelCandy.setProtein(Double.parseDouble("74"));
        caramelCandy.setFats(Double.parseDouble("3.2"));
        caramelCandy.setCarbs(Double.parseDouble("85.5"));
        caramelCandy.setManufacturingDate(LocalDate.parse("2021-12-01"));
        caramelCandy.setManufacturingDate(LocalDate.parse("2022-06-01"));
        caramelCandy.setCaramelAmount(Double.parseDouble("25"));
    }

    @Test
    public void testBuildDeposits() {
        Set<Candy> expected = new HashSet<>();
        expected.add(chocolateCandy);
        expected.add(caramelCandy);

        try {
            builder.buildCandy(XML_FILE_PATH);
        } catch (CandyDataException e) {
            fail(e.getMessage(), e);
        }
        Set<Candy> actual = builder.getCandiesSet();
        assertEquals(actual, expected);
    }
}