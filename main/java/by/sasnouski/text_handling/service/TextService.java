package by.sasnouski.text_handling.service;

import by.sasnouski.text_handling.entity.TextElementInterface;
import by.sasnouski.text_handling.entity.TextComposite;
import by.sasnouski.text_handling.entity.ComponentsEnum;
import by.sasnouski.text_handling.exception.ElementException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextService {

    private static final Logger logger = LogManager.getLogger();

    private static final String VOWEL_PATTERN = "[EYUIOAeyuioa]";
    private static final String CONSONANT_PATTERN = "[QWRTPSDFGHJKLZXCVBNMqwrtpsdfghjklzxcvbnm]";

    public void sortParagraphsBySentenceAmount(TextComposite textComposite) throws ElementException {
        if (textComposite.getComponentsEnum() != ComponentsEnum.PARAGRAPH) {
            logger.log(Level.INFO, "This text has no paragraphs: " + textComposite);
        }
        textComposite.getTextElementsList().
                sort(Comparator.comparingInt(paragraph -> paragraph.getTextElementsList().size()));
    }

    public List<TextElementInterface> findSentencesWithLongestWord(TextComposite textComposite) {

        List<TextElementInterface> words = textComposite.getTextElementsList().stream()
                .flatMap(paragraph -> paragraph.getTextElementsList().stream())
                .flatMap(sentence -> sentence.getTextElementsList().stream()).toList();
        long maxLength = 0L;
        for (TextElementInterface word : words) {
            long currentWordLength = word.getTextElementsList().stream()
                    .filter(symbol -> symbol.getComponentsEnum() == ComponentsEnum.LETTER)
                    .count();
            if (currentWordLength > maxLength) {
                maxLength = currentWordLength;
            }
        }

        List<TextElementInterface> sentences = textComposite.getTextElementsList().stream()
                .flatMap(paragraph -> paragraph.getTextElementsList().stream()).toList();
        List<TextElementInterface> result = new ArrayList<>();
        for (TextElementInterface sentence : sentences) {
            for (TextElementInterface word : sentence.getTextElementsList()) {
                long currentWordLength = word.getTextElementsList().stream()
                        .filter(symbol -> symbol.getComponentsEnum() == ComponentsEnum.LETTER).count();
                if (currentWordLength == maxLength) {
                    result.add(sentence);
                }
            }
        }
        return result;
    }

    public void deleteSentencesLessWords(TextComposite textComposite,
                                         int numberOfWords) throws ElementException {
        if (textComposite.getComponentsEnum() != ComponentsEnum.PARAGRAPH) {
            logger.log(Level.INFO, "Input element has no paragraphs: " + textComposite);
        }
        textComposite.getTextElementsList().forEach(paragraph -> paragraph.getTextElementsList().
                removeIf(sentence -> sentence.getTextElementsList().size() < numberOfWords));
    }

    public int countDuplicateWords(TextComposite textComposite) throws ElementException {
        if (textComposite.getComponentsEnum() != ComponentsEnum.PARAGRAPH) {
            logger.log(Level.INFO, "Input element has no paragraphs: " + textComposite);
        }
        return (int) textComposite.getTextElementsList().stream()
                .flatMap(paragraph -> paragraph.getTextElementsList().stream())
                .flatMap(sentence -> sentence.getTextElementsList().stream())
                .map(TextElementInterface::toString).toList()
                .stream().collect(Collectors.groupingBy(k -> k, Collectors.counting()))
                .values().stream().filter(value -> value > 1).count();
    }

    public int countVowels(TextComposite textComposite) throws ElementException {
        return countLetters(textComposite, VOWEL_PATTERN);
    }

    public int countConsonants(TextComposite textComposite) throws ElementException {
        return countLetters(textComposite, CONSONANT_PATTERN);
    }

    private int countLetters(TextComposite textComposite, String pattern) {
        return textComposite.getTextElementsList().stream()
                .flatMap(paragraph -> paragraph.getTextElementsList().stream())
                .flatMap(sentence -> sentence.getTextElementsList().stream())
                .flatMap(word -> word.getTextElementsList().stream())
                .filter(letter -> letter.getComponentsEnum() == ComponentsEnum.LETTER)
                .filter(letter -> letter.toString().matches(pattern))
                .toList().size();
    }
}