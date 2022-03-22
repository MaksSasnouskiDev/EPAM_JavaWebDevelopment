package by.sasnouski.text_handling.parser;

import by.sasnouski.text_handling.entity.TextElementInterface;
import by.sasnouski.text_handling.entity.TextComposite;
import by.sasnouski.text_handling.entity.ComponentsEnum;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser implements TextParserInterface {

    private static final String WORD_SEPARATOR = "\\s+";

    private static final String MATH_EXPRESSION_PATTERN =
                    "(^[(]*\\d+(\\.\\d+)?" +
                    "[+\\-*/]\\d+(\\.\\d+)?[)]*" +
                    "([+\\-*/]\\d+(\\.\\d+)?[)]*)*)+";

    private final SymbolParser symbolParser = new SymbolParser();

    @Override
    public TextComposite parseText(String text) {

        TextComposite textComposite = new TextComposite(ComponentsEnum.WORD);
        String[] wordsArray = text.strip().split(WORD_SEPARATOR);


        for (int i = 0; i < wordsArray.length; i++) {
            Pattern pattern = Pattern.compile(MATH_EXPRESSION_PATTERN);
            Matcher matcher=pattern.matcher(wordsArray[i]);
            if (matcher.find()) {
                String expression=matcher.group();
                wordsArray[i] = calculate(expression).orElse(wordsArray[i]);
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