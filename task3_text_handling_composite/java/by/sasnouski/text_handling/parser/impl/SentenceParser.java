package by.sasnouski.text_handling.parser.impl;

import by.sasnouski.text_handling.entity.TextElementInterface;
import by.sasnouski.text_handling.entity.TextComposite;
import by.sasnouski.text_handling.entity.ElementsEnum;
import by.sasnouski.text_handling.parser.TextParserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements TextParserInterface {

    private static final String SENTENCE_PATTERN = "[^.!?]+[.!?]";

    private final WordParser wordParser = new WordParser();

    @Override
    public TextComposite parseText(String text) {

        TextComposite sentenceComposite = new TextComposite(ElementsEnum.SENTENCE);
        Pattern pattern = Pattern.compile(SENTENCE_PATTERN);
        Matcher matcher = pattern.matcher(text);

        List<String> sentences = new ArrayList<>();
        while (matcher.find()) {
            sentences.add(matcher.group());
        }

        for (String sentence : sentences) {
            TextElementInterface wordComponents = wordParser.parseText(sentence);
            sentenceComposite.addElement(wordComponents);
        }
        return sentenceComposite;
    }
}