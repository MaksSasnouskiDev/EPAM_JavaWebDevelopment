package by.sasnouski.array.entity;

import java.util.Arrays;

public class ArrayOfNumbers {

    private Double[][] arrayOfNumbers;

    public ArrayOfNumbers(Double[][] arrayNmb) {
        this.arrayOfNumbers = arrayNmb;
    }

    public Double[][] get2DArray() {
        return arrayOfNumbers;
    }

    public Double[] getOneArray(int index) {
        return arrayOfNumbers[index];
    }

    public void printArrayOfNumbers() {
        for (Double[] arr : arrayOfNumbers) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

