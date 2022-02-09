package by.sasnouski.array.entity;

import java.util.Arrays;

public class ArraysOfNumbers {

    private final Double[][] arraysOfNumbers;

    public ArraysOfNumbers(Double[][] arrayNmb) {
        this.arraysOfNumbers = arrayNmb;
    }

    public Double[][] get2DArray() {
        return arraysOfNumbers;
    }

    public Double[] getOneArrayByIndex(int index) {
        return arraysOfNumbers[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Double[] arr : arraysOfNumbers) {
            sb.append(Arrays.toString(arr)).append(" ");
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(arraysOfNumbers);
    }
}