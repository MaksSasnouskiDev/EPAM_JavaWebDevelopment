package by.sasnouski.text_handling.parser.impl;

import by.sasnouski.text_handling.entity.TextElementInterface;
import by.sasnouski.text_handling.entity.TextComposite;
import by.sasnouski.text_handling.entity.ElementsEnum;
import by.sasnouski.text_handling.parser.TextParserInterface;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.regex.Pattern;

public class WordParser implements TextParserInterface {

    private static final Logger logger = LogManager.getLogger();

    private static final String WORD_SEPARATOR = "\\s+";
    private static final String MATH_EXPRESSION_PATTERN =
                    "([(]*(-)?\\d+(\\.\\d+)?" +
                    "[+\\-*/]{1}" +
                    "\\d+(\\.\\d+)?[)]*" +
                    "[+\\-*/]?)*";

    private final SymbolParser symbolParser = new SymbolParser();

    @Override
    public TextComposite parseText(String text) {
        TextComposite textComposite = new TextComposite(ElementsEnum.WORD);
        String[] wordsArray = text.strip().split(WORD_SEPARATOR);

        Pattern pattern = Pattern.compile(MATH_EXPRESSION_PATTERN);

        for (int i = 0; i < wordsArray.length; i++) {
            if (pattern.matcher(wordsArray[i]).find()) {
                wordsArray[i] = calculate(wordsArray[i]).orElse(wordsArray[i]);
            }
        }

        for (String word : wordsArray) {
            TextElementInterface element = symbolParser.parseText(word);
            textComposite.addElement(element);
        }
        return textComposite;
    }

    private Optional<String> calculate(String input) {
        Expression expression = new ExpressionBuilder(input).build();
        String result = String.valueOf(expression.evaluate());
        return Optional.of(result);
    }
}