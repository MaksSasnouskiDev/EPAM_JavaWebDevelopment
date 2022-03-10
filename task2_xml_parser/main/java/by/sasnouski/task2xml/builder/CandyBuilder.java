package by.sasnouski.task2xml.builder;

import by.sasnouski.task2xml.entity.Candy;
import by.sasnouski.task2xml.exception.CandyDataException;

import java.util.HashSet;
import java.util.Set;

public abstract class CandyBuilder {
    public Set<Candy> candiesSet;

    public CandyBuilder() {
        candiesSet=new HashSet<>();
    }
    public CandyBuilder(Set<Candy> candiesSet) {
        this.candiesSet = candiesSet;
    }

    public Set<Candy> getCandiesSet() {
        return candiesSet;
    }
    public void setCandiesSet(Set<Candy> candiesSet) {
        this.candiesSet = candiesSet;
    }

    public abstract void buildCandySet(String xmlPath)
            throws CandyDataException;
}

