package by.sasnouski.text_handling.entity;

public enum ElementsEnum {

    PARAGRAPH("\n"),
    SENTENCE(""),
    WORD("\s"),
    LETTER(""),
    PUNCTUATION(""),
    DIGIT(""),
    SIGN(""),
    TEXT("");

    private final String separator;

    ElementsEnum(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}