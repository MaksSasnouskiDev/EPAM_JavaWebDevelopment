package by.sasnouski.text_handling.parser.impl;

import by.sasnouski.text_handling.entity.Symbol;
import by.sasnouski.text_handling.entity.TextElementInterface;
import by.sasnouski.text_handling.entity.TextComposite;
import by.sasnouski.text_handling.entity.ElementsEnum;
import by.sasnouski.text_handling.parser.TextParserInterface;

public class SymbolParser implements TextParserInterface {

    private static final String ANY_SIGN_SEPARATOR = "";

    private static final String LETTER_PATTERN = "[\\p{Alpha}]";
    private static final String DIGIT_PATTERN = "\\d";
    private static final String PUNCTUATION_PATTERN = "[\\p{Punct}]";

    @Override
    public TextComposite parseText(String text) {
        String[] signsArray = text.trim().split(ANY_SIGN_SEPARATOR);
        TextComposite textComposite = new TextComposite(ElementsEnum.SIGN);

        for (String sign : signsArray) {
            ElementsEnum elementsEnum = null;

            if (sign.matches(LETTER_PATTERN)) {
                elementsEnum = ElementsEnum.LETTER;
            } else if (sign.matches(DIGIT_PATTERN)) {
                elementsEnum = ElementsEnum.DIGIT;
            } else if (sign.matches(PUNCTUATION_PATTERN)) {
                elementsEnum = ElementsEnum.PUNCTUATION;
            }

            if (elementsEnum != null) {
                TextElementInterface element = new Symbol(sign.charAt(0), elementsEnum);
                textComposite.addElement(element);
            }
        }
        return textComposite;
    }
}
