package by.sasnouski.text_handling.entity;

import java.util.List;

public class Symbol implements TextElementInterface {

    private final ComponentsEnum componentsEnum;
    private final char value;

    public Symbol(char value, ComponentsEnum componentsEnum) {
        this.value = value;
        this.componentsEnum = componentsEnum;
    }

    @Override
    public ComponentsEnum getComponentsEnum() {
        return this.componentsEnum;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean addElement(TextElementInterface element) {
        throw new UnsupportedOperationException("Can't add the component");
    }

    @Override
    public boolean removeElement(TextElementInterface element) {
        throw new UnsupportedOperationException("Can't remove the component");
    }

    @Override
    public List<TextElementInterface> getTextElementsList() {
        throw new UnsupportedOperationException("Can't get the Symbol List elements");
    }
}