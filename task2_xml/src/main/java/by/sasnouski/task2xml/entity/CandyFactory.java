package by.sasnouski.task2xml.entity;

import java.util.Objects;

public class CandyFactory {

    private String factoryName;


    public CandyFactory() {
    }

    public CandyFactory(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    @Override
    public String toString() {
        return "CandyFactory{" +
                "factoryName='" + factoryName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandyFactory that = (CandyFactory) o;
        return Objects.equals(factoryName, that.factoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factoryName);
    }
}