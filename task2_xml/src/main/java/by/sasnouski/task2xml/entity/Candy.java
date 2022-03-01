package by.sasnouski.task2xml.entity;

import java.util.Objects;

public class Candy extends CandyFactory {
    private String candyName;
    private String candyType;
    private double energy;
    private double protein;
    private double fats;
    private double carbs;
    private String producingTime;

    public Candy(){}

    public Candy(String factoryName, String candyName,String candyType,double energy, double protein, double fats, double carbs, String producingTime) {
        super(factoryName);
        this.candyName=candyName;
        this.candyType=candyType;
        this.energy = energy;
        this.protein = protein;
        this.fats = fats;
        this.carbs = carbs;
        this.producingTime = producingTime;
    }

    public double getEnergy() {
        return energy;
    }
    public void setEnergy(double energy) {
        this.energy = energy;
    }
    public double getProtein() {
        return protein;
    }
    public void setProtein(double protein) {
        this.protein = protein;
    }
    public double getFats() {
        return fats;
    }
    public void setFats(double fats) {
        this.fats = fats;
    }
    public double getCarbs() {
        return carbs;
    }
    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }
    public String getProducingTime() {
        return producingTime;
    }
    public void setProducingTime(String producingTime) {
        this.producingTime = producingTime;
    }
    public String getCandyName() {
        return candyName;
    }
    public void setCandyName(String candyName) {
        this.candyName = candyName;
    }
    public String getCandyType() {
        return candyType;
    }
    public void setCandyType(String candyType) {
        this.candyType = candyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candy candy = (Candy) o;
        return Double.compare(candy.energy, energy) == 0 && Double.compare(candy.protein, protein) == 0 && Double.compare(candy.fats, fats) == 0 && Double.compare(candy.carbs, carbs) == 0 && Objects.equals(candyName, candy.candyName) && Objects.equals(candyType, candy.candyType) && Objects.equals(producingTime, candy.producingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), candyName, candyType, energy, protein, fats, carbs, producingTime);
    }

    @Override
    public String toString() {
        return "Candy{" +
                "candyName='" + candyName + '\'' +
                ", candyType='" + candyType + '\'' +
                ", energy=" + energy +
                ", protein=" + protein +
                ", fats=" + fats +
                ", carbs=" + carbs +
                ", producingTime='" + producingTime + '\'' +
                '}';
    }
}