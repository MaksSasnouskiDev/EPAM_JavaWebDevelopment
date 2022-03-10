package by.sasnouski.task2xml.entity;

public class CaramelCandy extends Candy{

    private double caramel;

    public CaramelCandy() {}

    public CaramelCandy(int id, String candyName, String producer, String candyType, double totalEnergy, double protein,
                        double fats, double carbs, String manufacturingDate, String expirationDate,boolean belarusian_producing,
                        double caramel) {
        super(id, candyName, producer, candyType, totalEnergy, protein, fats, carbs,
                manufacturingDate, expirationDate,belarusian_producing);
        this.caramel=caramel;
    }

    public double getCaramel() {
        return caramel;
    }
    public void setCaramel(double caramel) {
        this.caramel = caramel;
    }
}
