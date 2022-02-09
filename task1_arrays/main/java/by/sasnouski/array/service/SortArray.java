package by.sasnouski.array.service;

import java.util.Arrays;

public class SortArray {

    public static Double[] sortArray1(Double[] srcArray) {
        Double[] rstArr = Arrays.copyOf(srcArray, srcArray.length);
        for (int i = 0; i < rstArr.length; i++) {
            int tempIndex = i;
            for (int j = i; j < rstArr.length; j++) {
                if (rstArr[tempIndex] > rstArr[j]) {
                    tempIndex = j;
                }
            }
            double tempNmb = rstArr[i];
            rstArr[i] = rstArr[tempIndex];
            rstArr[tempIndex] = tempNmb;
        }
        return rstArr;
    }

    public static Double[] sortArray2(Double[] srcArray) {
        Double[] rstArr = Arrays.copyOf(srcArray, srcArray.length);
        for (int i = 0; i < rstArr.length; i++) {
            for (int j = i; j < rstArr.length - 1; j++) {
                if (rstArr[j] > rstArr[j + 1]) {
                    double tempNmb = rstArr[j];
                    rstArr[j] = rstArr[j + 1];
                    rstArr[j + 1] = tempNmb;
                }
            }
        }
        return rstArr;
    }

    public static Double[] sortArray3(Double[] srcArray) {
        Double[] rstArr = Arrays.copyOf(srcArray, srcArray.length);
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < rstArr.length - 1; i++) {
                if (rstArr[i] > rstArr[i + 1]) {
                    isSorted = false;

                    double tempNmb = rstArr[i];
                    rstArr[i] = rstArr[i + 1];
                    rstArr[i + 1] = tempNmb;
                }
            }
        }
        return rstArr;
    }
}