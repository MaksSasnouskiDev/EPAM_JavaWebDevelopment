package by.sasnouski.text_handling.entity;

import java.util.List;

public interface TextElementInterface {

    String toString();

    boolean addElement(TextElementInterface element);

    boolean removeElement(TextElementInterface element);

    ComponentsEnum getComponentsEnum();

    List<TextElementInterface> getTextElementsList();
}