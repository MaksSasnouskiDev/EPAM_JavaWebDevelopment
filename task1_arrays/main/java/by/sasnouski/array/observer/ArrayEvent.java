package by.sasnouski.array.observer;

import by.sasnouski.array.entity.ListsOfNumbers;

import java.util.EventObject;

public class ArrayEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ArrayEvent(ListsOfNumbers source) {
        super(source);
    }
    @Override
    public ListsOfNumbers getSource() {
        return (ListsOfNumbers) super.getSource();
    }

}
