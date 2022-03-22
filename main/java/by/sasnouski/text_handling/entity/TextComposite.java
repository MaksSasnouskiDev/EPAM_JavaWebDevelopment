package by.sasnouski.text_handling.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextElementInterface {

    private final ComponentsEnum componentsEnum;
    private final List<TextElementInterface> textElementsList = new ArrayList<>();

    public TextComposite(ComponentsEnum componentsEnum) {
        this.componentsEnum = componentsEnum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TextElementInterface element : textElementsList) {
            sb.append(element).append(componentsEnum.getSplitter());
        }
        return sb.toString();
    }

    @Override
    public ComponentsEnum getComponentsEnum() {
        return componentsEnum;
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