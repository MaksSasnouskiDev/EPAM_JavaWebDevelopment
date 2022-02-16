package by.sasnouski.array.service;

import java.util.List;

public class MinMaxValue {

    public static double maxValue(List<Double> srcList) {
        double maxVal = Double.MIN_VALUE;
        for (int i = 0; i < srcList.size() - 1; i++) {
            double tempNmb = Math.max(srcList.get(i), srcList.get(i + 1));

            if (maxVal < tempNmb) {
                maxVal = tempNmb;
            }
        }
        return maxVal;
    }

    public static double minValue(List<Double> srcList) {
        double minVal = Double.MAX_VALUE;
        for (int i = 0; i < srcList.size() - 1; i++) {
            double tempNmb = Math.min(srcList.get(i), srcList.get(i + 1));

            if (minVal > tempNmb) {
                minVal = tempNmb;
            }
        }
        return minVal;
    }
}