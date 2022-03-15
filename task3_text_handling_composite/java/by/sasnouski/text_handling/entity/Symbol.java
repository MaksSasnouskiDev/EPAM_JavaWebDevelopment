package by.sasnouski.text_handling.entity;

import java.util.List;

public class Symbol implements TextElementInterface {

    private final ElementsEnum elementsEnum;
    private final char value;

    public Symbol(char value, ElementsEnum elementsEnum) {
        this.value = value;
        this.elementsEnum = elementsEnum;
    }

    @Override
    public boolean addElement(TextElementInterface component) {
        throw new UnsupportedOperationException("Can't add the component");
    }

    @Override
    public boolean removeElement(TextElementInterface component) {
        throw new UnsupportedOperationException("Can't remove the component");
    }

    @Override
    public ElementsEnum getElementsEnum() {
        return elementsEnum;
    }

    @Override
    public List<TextElementInterface> getTextElementsList() {
        throw new UnsupportedOperationException("Can't get the Symbol List elements");
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}