package by.sasnouski.task2xml.entity;

public class CocoaCandy extends Candy{

    private  double cocoa;

    public CocoaCandy() {}

    public CocoaCandy(int id, String candyName, String producer, String candyType, double totalEnergy, double protein, double fats, double carbs, String manufacturingDate, String expirationDate,boolean belarusian_producing, double cocoa) {
        super(id, candyName, producer, candyType, totalEnergy, protein, fats, carbs, manufacturingDate, expirationDate,belarusian_producing);
        this.cocoa = cocoa;
    }

    public double getCocoa() {
        return cocoa;
    }
    public  void setCocoa(double cocoa) {
        this.cocoa = cocoa;
    }
}
