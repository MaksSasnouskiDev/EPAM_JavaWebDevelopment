package by.sasnouski.array.entity;

public class ArrayProperties {
    private double sum;
    private double maxValue;
    private double minValue;
    private double averageValue;

    public ArrayProperties(double sum, double maxValue, double minValue, double averageValue) {

        this.sum = sum;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.averageValue = averageValue;
    }

    public double getSumElements() {
        return this.sum;
    }

    public void setSumElements(double sumElements) {
        this.sum = sumElements;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.minValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinElement(double minValue) {
        this.minValue = minValue;
    }

    public double getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(double averageValue) {
        this.averageValue = averageValue;
    }

    @Override
    public String toString() {
        return "ArrayProperties{sum=" + sum + ", maxValue=" + maxValue +
                ", minValue=" + minValue + ", averageValue=" + averageValue + '}';
    }
}
