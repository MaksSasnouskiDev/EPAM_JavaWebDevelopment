package by.sasnouski.text_handling.parser;

import by.sasnouski.text_handling.entity.ComponentsEnum;
import by.sasnouski.text_handling.entity.Symbol;
import by.sasnouski.text_handling.entity.TextElementInterface;
import by.sasnouski.text_handling.entity.TextComposite;

public class SymbolParser implements TextParserInterface {

    private static final String ANY_SIGN_SEPARATOR = "";

    private static final String LETTER_PATTERN = "[\\p{Alpha}]";
    private static final String DIGIT_PATTERN = "\\d";
    private static final String PUNCTUATION_PATTERN = "[\\p{Punct}]";

    @Override
    public TextComposite parseText(String text) {
        String[] signsArray = text.trim().split(ANY_SIGN_SEPARATOR);
        TextComposite textComposite = new TextComposite(ComponentsEnum.SIGN);

        for (String sign : signsArray) {
            ComponentsEnum componentsEnum = null;

            if (sign.matches(LETTER_PATTERN)) {
                componentsEnum = ComponentsEnum.LETTER;
            } else if (sign.matches(DIGIT_PATTERN)) {
                componentsEnum = ComponentsEnum.DIGIT;
            } else if (sign.matches(PUNCTUATION_PATTERN)) {
                componentsEnum = ComponentsEnum.PUNCTUATION;
            }

            if (componentsEnum != null) {
                TextElementInterface element = new Symbol(sign.charAt(0), componentsEnum);
                textComposite.addElement(element);
            }
        }
        return textComposite;
    }
}
