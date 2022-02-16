package by.sasnouski.array.repository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Repository {
    private List<Double> customArrays;
    private static Repository instance;

    private Repository() {
        customArrays = new ArrayList<>();
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public boolean add(Double customArray) {
        return customArrays.add(customArray);
    }

    public boolean remove(Object o) {
        return customArrays.remove(o);
    }

    public boolean addAll(Collection<? extends Double> c) {
        return customArrays.addAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return customArrays.removeAll(c);
    }

    public Double get(int index) {
        return customArrays.get(index);
    }

    public Double set(int index, Double element) {
        return customArrays.set(index, element);
    }

}