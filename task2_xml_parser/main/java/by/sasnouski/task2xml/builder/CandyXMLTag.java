package by.sasnouski.task2xml.builder;

public enum CandyXMLTag {
    CANDIES,
    CHOCOLATE_CANDY,
    CARAMEL_CANDY,
    WAFFLE_CANDY,
    CANDY_NAME,
    PRODUCER,
    ENERGY,
    TOTAL,
    PROTEIN,
    FATS,
    CARBS,
    EXPIRATION,
    MANUFACTURING_DATE,
    EXPIRATION_DATE,
    COCOA,
    TREACLE,
    ID,
    BELARUSIAN_PRODUCING;

    private static final char UNDERSCORE = '_';
    private static final char HYPHEN = '-';

    @Override
    public String toString() {
        return this.name().toLowerCase().replace(UNDERSCORE, HYPHEN);
    }

    public static CandyXMLTag valueOfXmlTag(String tag) {
        return CandyXMLTag.valueOf(tag.replace("_", ""));
    }

}
