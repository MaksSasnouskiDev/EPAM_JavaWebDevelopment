package by.sasnouski.text_handling.parser.impl;

import by.sasnouski.text_handling.entity.TextElementInterface;
import by.sasnouski.text_handling.entity.TextComposite;
import by.sasnouski.text_handling.entity.ElementsEnum;
import by.sasnouski.text_handling.parser.TextParserInterface;

public class ParagraphParser implements TextParserInterface {

    private static final String PARAGRAPH_PATTERN = "[\\r\\n]+";
    private final SentenceParser sentenceParser = new SentenceParser();

    @Override
    public TextComposite parseText(String text) {
        TextComposite paragraphComposite = new TextComposite(ElementsEnum.PARAGRAPH);
        String[] paragraphs = text.strip().split(PARAGRAPH_PATTERN);

        for (String paragraph : paragraphs) {
            TextElementInterface paragraphComponent = sentenceParser.parseText(paragraph);
            paragraphComposite.addElement(paragraphComponent);
        }
        return paragraphComposite;
    }
}