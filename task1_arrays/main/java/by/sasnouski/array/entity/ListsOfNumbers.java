package by.sasnouski.array.entity;

import by.sasnouski.array.observer.ArrayEvent;
import by.sasnouski.array.observer.Observable;
import by.sasnouski.array.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ListsOfNumbers implements Observable {

    private final List<List<Double>> listsOfNumbers;

    public ListsOfNumbers(List<List<Double>> arrayNmb) {
        this.listsOfNumbers = arrayNmb;
    }

    private List<Observer> observers = new ArrayList<>();


    public List<List<Double>> get2DArray() {
        return listsOfNumbers;
    }

    public List<Double> getOneListByIndex(int index) {
        return listsOfNumbers.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Double> list : listsOfNumbers) {
            sb.append(List.of(list)).append(" ");
        }
        return sb.toString();
    }

    @Override
    public void attach(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        ArrayEvent arrayEvent = new ArrayEvent(this);
        for (Observer observer : observers) {
            observer.parameterChanged(arrayEvent);
        }
    }
}