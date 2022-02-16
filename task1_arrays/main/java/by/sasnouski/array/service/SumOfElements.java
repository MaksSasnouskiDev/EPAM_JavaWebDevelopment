package by.sasnouski.array.service;

import java.util.List;

public class SumOfElements {

    public static double findSum(List<Double> srcArray) {
        double rsltSum = 0;
        for (Double nmb : srcArray) {
            rsltSum += nmb;
        }
        return rsltSum;
    }
}