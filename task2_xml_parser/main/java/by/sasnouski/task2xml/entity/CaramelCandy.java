package by.sasnouski.task2xml.entity;

import java.time.LocalDate;

public class CaramelCandy extends Candy{

    private double caramelAmount;

    public CaramelCandy() {}

    public CaramelCandy(int id, String candyName, String producer, double totalEnergy, double protein, double fats,
                        double carbs, LocalDate manufacturingDate, LocalDate expirationDate,
                        boolean belarusian_producing, double caramel) {
        super(id, candyName, producer, totalEnergy, protein, fats, carbs,
                manufacturingDate, expirationDate,belarusian_producing);
        this.caramelAmount =caramel;
    }

    public double getCaramelAmount() {
        return caramelAmount;
    }
    public void setCaramelAmount(double caramelAmount) {
        this.caramelAmount = caramelAmount;
    }
}
