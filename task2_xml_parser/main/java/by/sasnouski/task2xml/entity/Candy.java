package by.sasnouski.task2xml.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Candy {
    public static final boolean DEFAULT_BEL_PRODUCTION = false;

    private int id;
    private String candyName;
    private String producer;
    private double totalEnergy;
    private double protein;
    private double fats;
    private double carbs;
    private LocalDate manufacturingDate;
    private LocalDate expirationDate;
    private boolean belarusian_producing;

    public Candy() {
    }

    public Candy(int id, String candyName, String producer,
                 double totalEnergy, double protein, double fats, double carbs,
                 LocalDate manufacturingDate, LocalDate expirationDate, boolean belarusian_producing) {
        this.id = id;
        this.candyName = candyName;
        this.producer = producer;
        this.totalEnergy = totalEnergy;
        this.protein = protein;
        this.fats = fats;
        this.carbs = carbs;
        this.manufacturingDate = manufacturingDate;
        this.expirationDate = expirationDate;
        this.belarusian_producing = belarusian_producing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCandyName() {
        return candyName;
    }

    public void setCandyName(String candyName) {
        this.candyName = candyName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getTotalEnergy() {
        return totalEnergy;
    }

    public void setTotalEnergy(double totalEnergy) {
        this.totalEnergy = totalEnergy;
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

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isBelarusian_producing() {
        return belarusian_producing;
    }

    public void setBelarusian_producing(boolean belarusian_producing) {
        this.belarusian_producing = belarusian_producing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return id == candy.id && Double.compare(candy.totalEnergy, totalEnergy) == 0 &&
                Double.compare(candy.protein, protein) == 0 &&
                Double.compare(candy.fats, fats) == 0 &&
                Double.compare(candy.carbs, carbs) == 0 &&
                Objects.equals(candyName, candy.candyName) &&
                Objects.equals(producer, candy.producer) &&
                Objects.equals(manufacturingDate, candy.manufacturingDate) &&
                Objects.equals(expirationDate, candy.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, candyName, producer, totalEnergy, protein, fats,
                carbs, manufacturingDate, expirationDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Candy{");
        sb.append("id=").append(id).append(", candyName='").append(candyName).
                append('\'').append(", producer='").append(producer).append('\'').
                append(", totalEnergy=").
                append(totalEnergy).append(", protein=").append(protein).append(", fats=").
                append(fats).append(", carbs=").append(", manufacturingDate='").append(carbs).
                append(manufacturingDate).append('\'').append(", expirationDate='").
                append(expirationDate).append('\'').append('}');
        return sb.toString();
    }
}