package by.sasnouski.text_handling.service;

import by.sasnouski.text_handling.entity.TextComposite;
import by.sasnouski.text_handling.exception.ElementException;
import by.sasnouski.text_handling.parser.TextParserInterface;
import by.sasnouski.text_handling.parser.ParagraphParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TextServiceTest {

    private TextComposite composite;
    private TextParserInterface parser;
    private TextService textService;
    private String expextedString;

    @BeforeClass
    public void setUp() {
        expextedString = "Multiplication is one of the four elementary mathematical operations of arithmetic, with the other ones being addition, subtraction, and division. The result of a multiplication operation is called a product. The multiplication of whole numbers may be thought of as repeated addition; that is, the multiplication of two numbers is equivalent to adding as many copies of one of them, the multiplicand, as the quantity of the other one, the multiplier. Both numbers can be referred to as factors: 23*12*83.\n" +
                "For example, 4 multiplied by 3 can be calculated by adding 3 copies of 4 together: 4+4+4=12. Here, 3 (the multiplier) and 4 (the multiplicand) are the factors, and 12 is the product.\n" +
                "The inverse operation of multiplication is division. For example, since 4 multiplied by 3 equals 12, 12 divided by 3 equals 4: 12/3=4. Indeed, multiplication by 3, followed by division by 3, yields the original number. The division of a number other than 0 by itself equals 1: 23/23=1.\n" +
                "Multiplication is also defined for other types of numbers, such as complex numbers, and for more abstract constructs, like matrices. For some of these more abstract constructs, the order in which the operands are multiplied together matters. A listing of the many different kinds of products used in mathematics is given in Product (mathematics).\n";
    }

    @BeforeMethod
    void beforeMethod() {
        parser = new ParagraphParser();
        textService = new TextService();
        composite = parser.parseText(expextedString);
    }

    @Test
    public void testSortParagraphsBySentenceNumber() {

        try {
            textService.sortParagraphsBySentenceAmount(composite);
        } catch (ElementException e) {
            fail("Sorting paragraphs failed.");
        }

        String actual = composite.toString();

        assertEquals(actual, expextedString);
    }

    @Test
    public void testFindSentencesWithLongestWord() {
        int actual = textService.findSentencesWithLongestWord(composite).size();
        int expected = 7;
        assertEquals(actual, expected);
    }

    @Test
    public void testRemoveSentencesWithWordsLessThan() {

        try {
            textService.deleteSentencesLessWords(composite, 7);
        } catch (ElementException e) {
            fail("Error while delete sentences with the least number of words.");
        }

        String actual = composite.toString();

        assertEquals(actual, expextedString);

    }

    @Test
    public void testCountDuplicateWords() {
        int actual = 0;
        int expected = 39;
        try {
            actual = textService.countDuplicateWords(composite);
        } catch (ElementException e) {
            fail("Error while counting duplicate words.");
        }

        assertEquals(actual, expected);
    }

    @Test
    public void testCountVowels() {
        int actual = 0;
        int expected = 409;
        try {
            actual = textService.countVowels(composite);
        } catch (ElementException e) {
            fail("Error while counting vowels.");
        }
        assertEquals(actual, expected);
    }

    @Test
    public void testCountConsonants() {
        int actual = 0;
        int expected = 604;
        try {
            actual = textService.countConsonants(composite);
        } catch (ElementException e) {
            fail("Error while counting consonants.");
        }
        assertEquals(actual, expected);
    }
}