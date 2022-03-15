package by.sasnouski.text_handling.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextElementInterface {

    private final ElementsEnum elementsEnum;
    private final List<TextElementInterface> textElementsList = new ArrayList<>();

    public TextComposite(ElementsEnum elementsEnum) {
        this.elementsEnum = elementsEnum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TextElementInterface element : textElementsList) {
            sb.append(element).append(elementsEnum.getSeparator());
        }
        return sb.toString();
    }

    @Override
    public ElementsEnum getElementsEnum() {
        return elementsEnum;
    }

    @Override
    public boolean addElement(TextElementInterface element) {
        return textElementsList.add(element);
    }

    @Override
    public boolean removeElement(TextElementInterface element) {
        return textElementsList.remove(element);
    }

    @Override
    public List<TextElementInterface> getTextElementsList() {
        return textElementsList;
    }
}