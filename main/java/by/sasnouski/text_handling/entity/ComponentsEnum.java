package by.sasnouski.text_handling.entity;

public enum ComponentsEnum {

    PARAGRAPH("\n"),
    SENTENCE(" "),
    WORD("\s"),
    LETTER(""),
    PUNCTUATION(" "),
    DIGIT(""),
    SIGN(""),
    TEXT("");

    private final String splitter;

    ComponentsEnum(String splitter) {
        this.splitter = splitter;
    }

    public String getSplitter() {
        return splitter;
    }
}