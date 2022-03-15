package by.sasnouski.task2xml.entity;

import java.time.LocalDate;

public class ChocolateCandy extends Candy{

    private  double cocoaAmount;

    public ChocolateCandy() {}

    public ChocolateCandy(int id, String candyName, String producer, double totalEnergy, double protein,
                          double fats, double carbs, LocalDate manufacturingDate, LocalDate expirationDate,
                          boolean belarusian_producing, double cocoa) {
        super(id, candyName, producer, totalEnergy, protein, fats, carbs, manufacturingDate,
                expirationDate,belarusian_producing);
        this.cocoaAmount = cocoa;
    }

    public double getCocoaAmount() {
        return cocoaAmount;
    }
    public  void setCocoaAmount(double cocoaAmount) {
        this.cocoaAmount = cocoaAmount;
    }
}
