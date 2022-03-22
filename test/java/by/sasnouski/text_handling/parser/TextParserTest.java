package by.sasnouski.text_handling.parser;


import by.sasnouski.text_handling.entity.TextComposite;
import by.sasnouski.text_handling.exception.FileReadingException;
import by.sasnouski.text_handling.reader.TextReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextParserTest {

    static final String TEXT_FILE = "src/main/resources/text.txt";
    TextParserInterface parser;
    String text;

    @BeforeClass
    public void setUp() throws FileReadingException {
        TextReader reader = new TextReader();
        parser = new ParagraphParser();
        text = reader.readText(TEXT_FILE);
    }

    @Test
    public void testParseText() {

        TextComposite textComposite = parser.parseText(text);
        String actual = textComposite.toString();
        String expected = "Multiplication is one of the four elementary mathematical operations of arithmetic, with the other ones being addition, subtraction, and division. The result of a multiplication operation is called a product. The multiplication of whole numbers may be thought of as repeated addition; that is, the multiplication of two numbers is equivalent to adding as many copies of one of them, the multiplicand, as the quantity of the other one, the multiplier. Both numbers can be referred to as factors: 23*12*83.\n" +
                "For example, 4 multiplied by 3 can be calculated by adding 3 copies of 4 together: 4+4+4=12. Here, 3 (the multiplier) and 4 (the multiplicand) are the factors, and 12 is the product.\n" +
                "The inverse operation of multiplication is division. For example, since 4 multiplied by 3 equals 12, 12 divided by 3 equals 4: 12/3=4. Indeed, multiplication by 3, followed by division by 3, yields the original number. The division of a number other than 0 by itself equals 1: 23/23=1.\n" +
                "Multiplication is also defined for other types of numbers, such as complex numbers, and for more abstract constructs, like matrices. For some of these more abstract constructs, the order in which the operands are multiplied together matters. A listing of the many different kinds of products used in mathematics is given in Product (mathematics).\n";

        assertEquals(actual, expected);
    }
}