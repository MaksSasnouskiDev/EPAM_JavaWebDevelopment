package by.sasnouski.text_handling.parser;

import by.sasnouski.text_handling.entity.TextElementInterface;
import by.sasnouski.text_handling.entity.TextComposite;
import by.sasnouski.text_handling.entity.ComponentsEnum;

public class ParagraphParser implements TextParserInterface {

    private static final String PARAGRAPH_PATTERN = "\\n";
    private final SentenceParser sentenceParser = new SentenceParser();

    @Override
    public TextComposite parseText(String text) {

        TextComposite paragraphComposite = new TextComposite(ComponentsEnum.PARAGRAPH);
        String[] paragraphs = text.split(PARAGRAPH_PATTERN);

        for (String paragraph : paragraphs) {
            TextElementInterface paragraphComponent = sentenceParser.parseText(paragraph);
            paragraphComposite.addElement(paragraphComponent);
        }
        return paragraphComposite;
    }
}